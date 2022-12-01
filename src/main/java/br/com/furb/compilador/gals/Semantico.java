package br.com.furb.compilador.gals;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Semantico implements Constants {

    private final Stack<String> typeStack = new Stack<>();
    private final LinkedList<String> listaid = new LinkedList<>();
    private final StringBuilder code = new StringBuilder();
    private static final String QUEBRA_LINHA = System.lineSeparator();
    private final HashMap<String, String> TS = new HashMap<>();
    private final Stack<String> rotuleStack = new Stack<>();
    private String operator = "";
    private String tipovar = "";
    private final String CFLOAT = "float64";
    private final String CINT = "int64";
    private final String CCHAR = "char";
    private final String CSTRING = "string";
    private final String CBOOL = "bool";

    public void executeAction(int action, Token token) throws SemanticError {
        String tipo1 = "";
        String tipo2 = "";

        switch (action) {
            case 1:
                verifyNumberType();
                code.append(QUEBRA_LINHA).append("add");
                break;
            case 2:
                verifyNumberType();
                code.append(QUEBRA_LINHA).append("sub");
                break;
            case 3:
                verifyNumberType();
                code.append(QUEBRA_LINHA).append("mul");
                break;
            case 4:
                tipo1 = typeStack.pop();
                tipo2 = typeStack.pop();

                verifyDivision(tipo1, tipo2);
                code.append(QUEBRA_LINHA).append("div");
                break;
            case 5:
                typeStack.push(CINT);
                code.append(QUEBRA_LINHA)
                        .append("ldc.i8 ")
                        .append(token.getLexeme()).append(QUEBRA_LINHA)
                        .append("conv.r8");
                break;
            case 6:
                typeStack.push(CFLOAT);
                code.append(QUEBRA_LINHA)
                        .append("ldc.r8").append(QUEBRA_LINHA)
                        .append(token.getLexeme());
                break;
            case 7:
                tipo1 = typeStack.pop();
                verifyIsNumType(tipo1);
                break;
            case 8:
                tipo1 = typeStack.pop();
                verifyIsNumType(tipo1);
                code.append(QUEBRA_LINHA)
                        .append("ldc.i8 ")
                        .append(-1)
                        .append(QUEBRA_LINHA)
                        .append("conv.r8")
                        .append(QUEBRA_LINHA)
                        .append("mul");
                break;
            case 9:
                operator = token.getLexeme();
                break;
            case 10:
                tipo1 = typeStack.pop();
                tipo2 = typeStack.pop();

                if (tipo1.equals(tipo2)) {
                    typeStack.push(CBOOL);
                } else {
                    throw new SemanticError("Banana exception");
                    //TODO: implementar mensagem de erro
                }
                switch (operator) {
                    case ">":
                        code.append(QUEBRA_LINHA).append("cgt");
                        break;
                    case "<":
                        code.append(QUEBRA_LINHA).append("clt");
                        break;
                    case "==":
                        code.append(QUEBRA_LINHA).append("ceq");
                        break;
                }
                break;
            case 11:
                typeStack.push(CBOOL);
                code.append(QUEBRA_LINHA).append("ldc.i4.1");
                break;
            case 12:
                typeStack.push(CBOOL);
                code.append(QUEBRA_LINHA).append("ldc.i4.0");
                break;
            case 13:
                tipo1 = typeStack.pop();
                verifyBool(tipo1);
                code.append(QUEBRA_LINHA)
                        .append("ldc.i4.1")
                        .append(QUEBRA_LINHA)
                        .append("xor");
                break;
            case 14:
                tipo1 = typeStack.pop();

                if (tipo1.equals(CINT)) {
                    code.append(QUEBRA_LINHA).append("conv.i8");
                }
                code.append(QUEBRA_LINHA)
                        .append("call void ")
                        .append("[mscorlib]")
                        .append("System.Console::Write(")
                        .append(tipo1)
                        .append(")");
                break;
            case 15:
                code.append(".assembly extern mscorlib {}")
                        .append(QUEBRA_LINHA)
                        .append(".assembly _codigo_objeto{}")
                        .append(QUEBRA_LINHA)
                        .append(".module   _codigo_objeto.exe")
                        .append(QUEBRA_LINHA)
                        .append(QUEBRA_LINHA)
                        .append(".class public _UNICA{ ")
                        .append(QUEBRA_LINHA)
                        .append(".method static public void _principal() {")
                        .append(QUEBRA_LINHA)
                        .append(".entrypoint");
                break;
            case 16:
                code.append(QUEBRA_LINHA)
                        .append("ret")
                        .append(QUEBRA_LINHA)
                        .append("}")
                        .append(QUEBRA_LINHA)
                        .append("}");
                break;
            case 17:
                code.append("ldstr ")
                        .append(QUEBRA_LINHA)
                        .append("call void ")
                        .append(QUEBRA_LINHA)
                        .append("[mscorlib]System.Console::Write(string)");
                break;
            case 18:
                tipo1 = typeStack.pop();
                tipo2 = typeStack.pop();
                verifyBool(tipo1, tipo2);
                code.append(QUEBRA_LINHA).append("and");
                break;
            case 19:
                tipo1 = typeStack.pop();
                tipo2 = typeStack.pop();
                verifyBool(tipo1, tipo2);
                code.append(QUEBRA_LINHA).append("or");
                break;
            case 20:
                tipo1 = typeStack.pop();
                tipo2 = typeStack.pop();

                verifyDivision(tipo1, tipo2);
                code.append(QUEBRA_LINHA)
                        .append("div")
                        .append(QUEBRA_LINHA)
                        .append("conv.i8");
                break;
            case 21:
                typeStack.push(CCHAR);
                code.append(QUEBRA_LINHA);
                switch (token.getLexeme()) {
                    case "\\n":
                        code.append("\"\\n\"");
                        break;
                    case "\\s":
                        code.append("\" \"");
                        break;
                    case "\\t":
                        code.append("\"\\t\"");
                        break;
                }
                break;
            case 22:
                typeStack.push(CSTRING);
                code.append(QUEBRA_LINHA).append("ldstr ").append("\"").append(token.getLexeme()).append("\"");
                break;
            case 24:
               // code.append(QUEBRA_LINHA).append("brfalse ").append(TS.get());
                break;
            case 25:
                break;
            case 26:
                break;
            case 27:
                break;
            case 28:
                break;
            case 30:
                if (token.getLexeme().equals("int")) {
                    tipovar = CINT;
                } else if (token.getLexeme().equals("real")) {
                    tipovar = CFLOAT;
                }
                break;
            case 31:
                for (String id : listaid) {
                    TS.put(id, tipovar);
                    code.append(QUEBRA_LINHA)
                            .append(".locals(")
                            .append(tipovar)
                            .append(" ")
                            .append(id)
                            .append(")");
                }
                listaid.clear();
                break;
            case 32:
                listaid.add(token.getLexeme());
                break;
            case 33:
                String id = token.getLexeme();
                String tipoid = TS.get(id);
                typeStack.push(tipoid);
                code.append(QUEBRA_LINHA).append("ldloc ").append(id);
                if (tipoid.equals(CINT)) {
                    code.append(QUEBRA_LINHA).append("conv.r8");
                }
                break;
            case 34:
                String id2 = listaid.pop();
                String tipoid2 = TS.get(id2);
                typeStack.pop();
                if (tipoid2.equals(CINT)) {
                    code.append(QUEBRA_LINHA).append("conv.r8");
                }
                code.append(QUEBRA_LINHA).append("stloc ")
                        .append(id2);
                break;
            case 35:
                for (String id3 : listaid) {
                    String tipoid3 = TS.get(id3);
                    String classe = "";
                    if (tipoid3.equals(CINT)) {
                        classe = "Int64";
                    } else if (tipoid3.equals(CFLOAT)) {
                        classe = "Double";
                    }
                    code.append(QUEBRA_LINHA).append("call string [mscorlib]System.Console::ReadLine()").append(QUEBRA_LINHA).append("call ")
                            .append(tipoid3)
                            .append(" [mscorlib]System.")
                            .append(classe)
                            .append("::Parse(string)").append(QUEBRA_LINHA).append("stloc ")
                            .append(id3);
                }
                listaid.clear();
                break;
        }
        System.out.println(code);
        //System.out.println("Ação #" + action + ", Token: " + token);
    }

    private void verifyBool(String tipo1) throws SemanticError {
        if (tipo1.equals(CBOOL)) {
            typeStack.push(CBOOL);
        } else {
            throw new SemanticError("tipo(s) incompatível(is) em expressão lógica");
        }
    }

    private void verifyBool(String tipo1, String tipo2) throws SemanticError {
        if (tipo1.equals(CBOOL) && tipo2.equals(CBOOL)) {
            typeStack.push(CBOOL);
        } else {
            throw new SemanticError("tipo(s) incompatível(is) em expressão lógica");
        }
    }

    private void verifyDivision(String tipo1, String tipo2) throws SemanticError {
        if (tipo1.equals(tipo2)) {
            typeStack.push(tipo1);
        } else {
            throw new SemanticError("tipo(s) incompatível(is) em expressão aritmética");
        }
    }

    private void verifyNumberType() throws SemanticError {
        String type1 = typeStack.pop();
        String type2 = typeStack.pop();

        verifyIsNumType(type1);
        verifyIsNumType(type2);

        if (type1.equals(CFLOAT) || type2.equals(CFLOAT)) {
            typeStack.push(CFLOAT);
        } else {
            typeStack.push(CINT);
        }
    }

    private void verifyIsNumType(String type) throws SemanticError {
        if (type.equals(CFLOAT) || type.equals(CINT)) {
            typeStack.push(type);
        } else {
            throw new SemanticError("tipo(s) incompatível(is) em expressão aritmética");
        }
    }

}
