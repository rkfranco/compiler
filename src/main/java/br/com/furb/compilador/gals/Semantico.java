package br.com.furb.compilador.gals;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Semantico implements Constants {

    private static final String QUEBRA_LINHA = System.lineSeparator();
    private static final String CFLOAT = "float64";
    private static final String CINT = "int64";
    private static final String CCHAR = "char";
    private static final String CSTRING = "string";
    private static final String CBOOL = "bool";

    private final StringBuilder codigoObjeto = new StringBuilder();
    private final Stack<String> pilhaTipos = new Stack<>();
    private final HashMap<String, String> tabelaSimbolos = new HashMap<>();
    private final LinkedList<String> listaIds = new LinkedList<>();
    private final Stack<String> pilhaRotulos = new Stack<>();
    private int qtdRotulos = 1;
    private String tipoVar = "";
    private String operador = "";
    private Token tokenAtual;

    public void executeAction(int action, Token token) throws SemanticError {
        this.tokenAtual = token;

        String tipo1 = "";
        String tipo2 = "";
        String id = "";
        String tipoId = "";

        switch (action) {
            case 1:
                tipo1 = this.pilhaTipos.pop();
                tipo2 = this.pilhaTipos.pop();
                verifyNumberType(tipo1, tipo2);
                this.codigoObjeto.append(QUEBRA_LINHA).append("add");
                break;
            case 2:
                tipo1 = this.pilhaTipos.pop();
                tipo2 = this.pilhaTipos.pop();
                verifyNumberType(tipo1, tipo2);
                this.codigoObjeto.append(QUEBRA_LINHA).append("sub");
                break;
            case 3:
                tipo1 = this.pilhaTipos.pop();
                tipo2 = this.pilhaTipos.pop();
                verifyNumberType(tipo1, tipo2);
                this.codigoObjeto.append(QUEBRA_LINHA).append("mul");
                break;
            case 4:
                tipo1 = this.pilhaTipos.pop();
                tipo2 = this.pilhaTipos.pop();
                verifyDivision(tipo1, tipo2);
                this.codigoObjeto.append(QUEBRA_LINHA).append("div");
                break;
            case 5:
                this.pilhaTipos.push(CINT);
                String lexemaInt = formatIntLexeme(token.getLexeme());
                this.codigoObjeto.append(QUEBRA_LINHA).append("ldc.i8 ").append(lexemaInt);
                this.codigoObjeto.append(QUEBRA_LINHA).append("conv.r8");
                break;
            case 6:
                this.pilhaTipos.push(CFLOAT);
                String lexemaFloat = formatFloatLexeme(token.getLexeme());
                this.codigoObjeto.append(QUEBRA_LINHA).append("ldc.r8 ").append(lexemaFloat);
                break;
            case 7:
                tipo1 = this.pilhaTipos.pop();
                verifyIsNumberType(tipo1);
                this.pilhaTipos.push(tipo1);
                break;
            case 8:
                tipo1 = this.pilhaTipos.pop();
                verifyIsNumberType(tipo1);
                this.pilhaTipos.push(tipo1);
                this.codigoObjeto.append(QUEBRA_LINHA).append("ldc.i8 ").append(-1);
                this.codigoObjeto.append(QUEBRA_LINHA).append("conv.r8");
                this.codigoObjeto.append(QUEBRA_LINHA).append("mul");
                break;
            case 9:
                this.operador = token.getLexeme();
                break;
            case 10:
                tipo1 = this.pilhaTipos.pop();
                tipo2 = this.pilhaTipos.pop();

                if (tipo1.equals(tipo2)) {
                    this.pilhaTipos.push(CBOOL);
                } else {
                    throw new SemanticError("tipos incompat??veis em express??o relacional", this.tokenAtual.getPosition());
                }

                switch (this.operador) {
                    case ">":
                        this.codigoObjeto.append(QUEBRA_LINHA).append("cgt");
                        break;
                    case "<":
                        this.codigoObjeto.append(QUEBRA_LINHA).append("clt");
                        break;
                    case "==":
                        this.codigoObjeto.append(QUEBRA_LINHA).append("ceq");
                        break;
                }
                break;
            case 11:
                this.pilhaTipos.push(CBOOL);
                this.codigoObjeto.append(QUEBRA_LINHA).append("ldc.i4.1");
                break;
            case 12:
                this.pilhaTipos.push(CBOOL);
                this.codigoObjeto.append(QUEBRA_LINHA).append("ldc.i4.0");
                break;
            case 13:
                tipo1 = this.pilhaTipos.pop();
                verifyBool(tipo1);
                this.codigoObjeto.append(QUEBRA_LINHA).append("ldc.i4.1");
                this.codigoObjeto.append(QUEBRA_LINHA).append("xor");
                break;
            case 14:
                tipo1 = this.pilhaTipos.pop();

                if (tipo1.equals(CINT)) {
                    this.codigoObjeto.append(QUEBRA_LINHA).append("conv.i8");
                }

                this.codigoObjeto.append(QUEBRA_LINHA).append("call void [mscorlib]System.Console::Write(").append(tipo1).append(")");
                break;
            case 15:
                this.codigoObjeto
                        .append(".assembly extern mscorlib {}").append(QUEBRA_LINHA)
                        .append(".assembly _codigo_objeto{}").append(QUEBRA_LINHA)
                        .append(".module   _codigo_objeto.exe").append(QUEBRA_LINHA)
                        .append(QUEBRA_LINHA)
                        .append(".class public _UNICA{ ").append(QUEBRA_LINHA)
                        .append(".method static public void _principal() {").append(QUEBRA_LINHA)
                        .append(".entrypoint");
                break;
            case 16:
                this.codigoObjeto
                        .append(QUEBRA_LINHA).append("ret")
                        .append(QUEBRA_LINHA).append("}")
                        .append(QUEBRA_LINHA).append("}");
                break;
            case 17:
                this.codigoObjeto.append(QUEBRA_LINHA).append("ldstr ").append("\"\\n\"");
                this.codigoObjeto.append(QUEBRA_LINHA).append("call void [mscorlib]System.Console::Write(string)");
                break;
            case 18:
                tipo1 = this.pilhaTipos.pop();
                tipo2 = this.pilhaTipos.pop();
                verifyBool(tipo1, tipo2);
                this.codigoObjeto.append(QUEBRA_LINHA).append("and");
                break;
            case 19:
                tipo1 = this.pilhaTipos.pop();
                tipo2 = this.pilhaTipos.pop();
                verifyBool(tipo1, tipo2);
                this.codigoObjeto.append(QUEBRA_LINHA).append("or");
                break;
            case 20:
                tipo1 = this.pilhaTipos.pop();
                tipo2 = this.pilhaTipos.pop();
                verifyDivision(tipo1, tipo2);
                this.codigoObjeto
                        .append(QUEBRA_LINHA).append("div")
                        .append(QUEBRA_LINHA).append("conv.i8");
                break;
            case 21:
                this.pilhaTipos.push(CCHAR);
                this.codigoObjeto.append(QUEBRA_LINHA).append("ldstr ");

                switch (token.getLexeme()) {
                    case "\\n":
                        this.codigoObjeto.append("\"\\n\"");
                        break;
                    case "\\s":
                        this.codigoObjeto.append("\" \"");
                        break;
                    case "\\t":
                        this.codigoObjeto.append("\"\\t\"");
                        break;
                }
                break;
            case 22:
                this.pilhaTipos.push(CSTRING);
                this.codigoObjeto.append(QUEBRA_LINHA).append("ldstr ").append(token.getLexeme());
                break;
            case 24:
                this.codigoObjeto.append(QUEBRA_LINHA).append("brfalse ").append(this.criarRotulo());
                break;
            case 25:
                String rotuloAtual = this.pilhaRotulos.pop();
                String rotuloNovo = this.criarRotulo();
                this.codigoObjeto.append(QUEBRA_LINHA).append("br ").append(rotuloNovo);
                this.codigoObjeto.append(QUEBRA_LINHA).append(rotuloAtual).append(":");
                break;
            case 26:
                this.codigoObjeto.append(QUEBRA_LINHA).append(this.pilhaRotulos.pop()).append(":");
                break;
            case 27:
                this.codigoObjeto.append(QUEBRA_LINHA).append(this.criarRotulo()).append(":");
                break;
            case 28:
                this.codigoObjeto.append(QUEBRA_LINHA).append("brtrue ").append(this.pilhaRotulos.pop());
                break;
            case 30:
                switch (token.getLexeme()) {
                    case "int":
                        this.tipoVar = CINT;
                        break;
                    case "float":
                        this.tipoVar = CFLOAT;
                        break;
                    case "boolean":
                        this.tipoVar = CBOOL;
                        break;
                    default:
                        this.tipoVar = token.getLexeme();
                        break;
                }
                break;
            case 31:
                for (String listaId : this.listaIds) {
                    this.tabelaSimbolos.put(listaId, this.tipoVar);
                    this.codigoObjeto.append(QUEBRA_LINHA).append(".locals (").append(this.tipoVar).append(" ").append(listaId).append(")");
                }
                this.listaIds.clear();
                break;
            case 32:
                this.listaIds.add(token.getLexeme());
                break;
            case 33:
                id = token.getLexeme();
                tipoId = this.tabelaSimbolos.get(id);

                this.pilhaTipos.push(tipoId);
                this.codigoObjeto.append(QUEBRA_LINHA).append("ldloc ").append(id);

                if (tipoId.equals(CINT)) {
                    this.codigoObjeto.append(QUEBRA_LINHA).append("conv.r8");
                }
                break;
            case 34:
                id = this.listaIds.pop();
                tipoId = this.tabelaSimbolos.get(id);
                this.pilhaTipos.pop();

                if (tipoId.equals(CINT)) {
                    this.codigoObjeto.append(QUEBRA_LINHA).append("conv.i8");
                }
                this.codigoObjeto.append(QUEBRA_LINHA).append("stloc ").append(id);
                break;
            case 35:
                for (String listaId : this.listaIds) {
                    tipoId = this.tabelaSimbolos.get(listaId);
                    String classe = "";
                    switch (tipoId) {
                        case CINT:
                            classe = "Int64";
                            break;
                        case CFLOAT:
                            classe = "Double";
                            break;
                    }
                    this.codigoObjeto.append(QUEBRA_LINHA).append("call string [mscorlib]System.Console::ReadLine()");
                    this.codigoObjeto.append(QUEBRA_LINHA).append("call ").append(tipoId).append(" [mscorlib]System.").append(classe).append("::Parse(string)");
                    this.codigoObjeto.append(QUEBRA_LINHA).append("stloc ").append(listaId);
                }
                this.listaIds.clear();
                break;
        }
        this.tokenAtual = null;
    }

    private void verifyNumberType(String tipo1, String tipo2) throws SemanticError {
        verifyIsNumberType(tipo1);
        verifyIsNumberType(tipo2);

        if (tipo1.equals(CFLOAT) || tipo2.equals(CFLOAT)) {
            this.pilhaTipos.push(CFLOAT);
        } else {
            this.pilhaTipos.push(CINT);
        }
    }

    private void verifyIsNumberType(String tipo1) throws SemanticError {
        if (!tipo1.equals(CFLOAT) && !tipo1.equals(CINT)) {
            throw new SemanticError("tipo(s) incompat??vel(is) em express??o aritm??tica", this.tokenAtual.getPosition());
        }
    }

    private void verifyDivision(String tipo1, String tipo2) throws SemanticError {
        verifyIsNumberType(tipo1);
        verifyIsNumberType(tipo2);

        if (tipo1.equals(tipo2)) {
            this.pilhaTipos.push(tipo1);
        } else {
            throw new SemanticError("tipo(s) incompat??vel(is) em express??o aritm??tica", this.tokenAtual.getPosition());
        }
    }

    private void verifyBool(String tipo1) throws SemanticError {
        if (tipo1.equals(CBOOL)) {
            this.pilhaTipos.push(CBOOL);
        } else {
            throw new SemanticError("tipo(s) incompat??vel(is) em express??o l??gica", this.tokenAtual.getPosition());
        }
    }

    private void verifyBool(String tipo1, String tipo2) throws SemanticError {
        if (tipo1.equals(CBOOL) && tipo2.equals(CBOOL)) {
            this.pilhaTipos.push(CBOOL);
        } else {
            throw new SemanticError("tipo(s) incompat??vel(is) em express??o l??gica", this.tokenAtual.getPosition());
        }
    }

    private String formatIntLexeme(String lexemaInt) {
        String[] partesInt = lexemaInt.split("d");
        if (partesInt.length > 1) {
            int baseMultiplicacao = Integer.parseInt(partesInt[0]);
            int expoente = Integer.parseInt(partesInt[1]);

            int resultado = (int) (baseMultiplicacao * Math.pow(10, expoente));
            lexemaInt = String.valueOf(resultado);
        }

        return lexemaInt;
    }

    private String formatFloatLexeme(String lexemaFloat) {
        if (lexemaFloat.charAt(0) == '.') {
            lexemaFloat = "0" + lexemaFloat;
        }

        String[] partesFloat = lexemaFloat.split("d");
        if (partesFloat.length > 1) {
            double baseMultiplicacao = Double.parseDouble(partesFloat[0]);
            int expoente = Integer.parseInt(partesFloat[1]);

            double resultado = baseMultiplicacao * Math.pow(10, expoente);
            lexemaFloat = String.valueOf(resultado);
        }

        return lexemaFloat;
    }

    private String criarRotulo() {
        String rotulo = "L" + this.qtdRotulos;
        this.pilhaRotulos.push(rotulo);
        this.qtdRotulos++;
        return rotulo;
    }

    public String getCodigoObjeto() {
        return this.codigoObjeto.toString();
    }
}
