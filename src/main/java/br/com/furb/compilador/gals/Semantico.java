package br.com.furb.compilador.gals;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Semantico implements Constants {

    private final Stack<String> typeStack = new Stack<>();
    private final LinkedList<String> listaid = new LinkedList<>();
    private final StringBuilder code = new StringBuilder();

    private final HashMap<String, String> TS = new HashMap<>();

    private String operator = "";
    private String tipovar = "";
    private final String CFLOAT = "float64";
    private final String CINT = "int64";
    private final String CBOOL = "bool";

    public void executeAction(int action, Token token) throws SemanticError {
        String tipo1 = "";
        String tipo2 = "";

        switch (action) {
            case 1:
                verifyType(tipo1, tipo2);
                code.append("\nadd");
                break;
            case 2:
                verifyType(tipo1, tipo2);
                code.append("\nsub");
                break;
            case 3:
                verifyType(tipo1, tipo2);
                code.append("\nmul");
                break;
            case 4:
                tipo1 = typeStack.pop();
                tipo2 = typeStack.pop();

                if (tipo1.equals(tipo2)) {
                    typeStack.push(tipo1);
                } else {
                    throw new SemanticError("Banana exception");
                    //TODO: implementar mensagem de erro
                }
                code.append("\ndiv");
                break;
            case 5:
                typeStack.push(CINT);
                code.append("\n")
                        .append("ldc.i8 ")
                        .append(token.getLexeme())
                        .append("\n")
                        .append("conv.r8");
                break;
            case 6:
                typeStack.push(CFLOAT);
                code.append("\n")
                        .append("ldc.r8")
                        .append("\n")
                        .append(token.getLexeme());
                break;
            case 7:
                verifyIsNumType(tipo1);
                break;
            case 8:
                verifyIsNumType(tipo1);
                code.append("\n")
                        .append("ldc.i8 ")
                        .append(-1)
                        .append("\n")
                        .append("conv.r8")
                        .append("\n")
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
                        code.append("\ncgt");
                        break;
                    case "<":
                        code.append("\nclt");
                        break;
                    case "==":
                        code.append("\nceq");
                        break;
                }
                break;
            case 11:
                typeStack.push(CBOOL);
                code.append("\nldc.i4.1");
                break;
            case 12:
                typeStack.push(CBOOL);
                code.append("\nldc.i4.0");
                break;
            case 13:
                tipo1 = typeStack.pop();
                if (tipo1.equals(CBOOL)) {
                    typeStack.push(CBOOL);
                } else {
                    throw new SemanticError("Banana Exception");
                    //TODO: implementar mensagem de erro
                }
                code.append("\n")
                        .append("ldc.i4.1")
                        .append("\n")
                        .append("xor");
                break;
            case 14:
                tipo1 = typeStack.pop();

                if (tipo1.equals(CINT)) {
                    code.append("\nconv.i8");
                }
                code.append("\n")
                        .append("call void ")
                        .append("[mscorlib]")
                        .append("System.Console::Write(")
                        .append(tipo1)
                        .append(")");
                break;
            case 15:
                code.append(".assembly extern mscorlib {}\n")
                        .append(".assembly _codigo_objeto{}\n")
                        .append(".module   _codigo_objeto.exe\n")
                        .append("\n")
                        .append(".class public _UNICA{ \n")
                        .append(".method static public void _principal() {\n")
                        .append(".entrypoint");
                break;
            case 16:
                code.append("\nret")
                        .append("\n}")
                        .append("\n}");
                break;
            case 17:
                break;
            case 18:
                break;
            case 19:
                break;
            case 20:
                break;
            case 21:
                break;
            case 22:
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
                    code.append("\n.locals(").append(tipovar).append(" ").append(id).append(")");
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
                code.append("\nldloc ").append(id);
                if (tipoid.equals(CINT)) {
                    code.append("\nconv.r8");
                }
                break;
            case 34:
                String id2 = listaid.pop();
                String tipoid2 = TS.get(id2);
                typeStack.pop();
                if (tipoid2.equals(CINT)) {
                    code.append("\nconv.r8");
                }
                code.append("\nstloc ")
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
                    code.append("\ncall string [mscorlib]System.Console::ReadLine()")
                            .append("\ncall ")
                            .append(tipoid3)
                            .append(" [mscorlib]System.")
                            .append(classe)
                            .append("::Parse(string)").append("\nstloc ")
                            .append(id3);
                }
                listaid.clear();
                break;
        }
        System.out.println(code);
        System.out.println(typeStack);
        //System.out.println("Ação #" + action + ", Token: " + token);
    }

    private void verifyType(String type1, String type2) {
        type1 = typeStack.pop();
        type2 = typeStack.pop();

        if (type1.equals(CFLOAT) || type2.equals(CFLOAT)) {
            typeStack.push(CFLOAT);
        } else {
            typeStack.push(CINT);
        }
    }

    private void verifyIsNumType(String type) throws SemanticError {
        type = typeStack.pop();

        if (type.equals(CFLOAT) || type.equals(CINT)) {
            typeStack.push(type);
        } else {
            throw new SemanticError("Banana exception");
            //TODO: Implementar mensagem de erro
        }
    }

}
