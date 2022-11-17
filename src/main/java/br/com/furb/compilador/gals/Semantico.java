package br.com.furb.compilador.gals;

import java.util.Stack;

public class Semantico implements Constants {

    private Stack<String> pilhaTipos = new Stack<String>();
    private StringBuilder codigo = new StringBuilder();
    private final String CFLOAT = "float64";
    private final String CINT = "float64";

    public void executeAction(int action, Token token) throws SemanticError {
        String tipo1 = "";
        String tipo2 = "";
        switch (action) {
            case 1:
                tipo1 = pilhaTipos.pop();
                tipo2 = pilhaTipos.pop();

                if (tipo1.equals(CFLOAT) || tipo2.equals(CFLOAT)) {
                    pilhaTipos.push(CFLOAT);
                } else {
                    pilhaTipos.push(CINT);
                }
                codigo.append("\nadd");
                break;
            case 2:
                tipo1 = pilhaTipos.pop();
                tipo2 = pilhaTipos.pop();

                if (tipo1.equals(CFLOAT) || tipo2.equals(CFLOAT)) {
                    pilhaTipos.push(CFLOAT);
                } else {
                    pilhaTipos.push(CINT);
                }
                codigo.append("\nsub");
                break;
            case 3:
                tipo1 = pilhaTipos.pop();
                tipo2 = pilhaTipos.pop();

                if (tipo1.equals(CFLOAT) || tipo2.equals(CFLOAT)) {
                    pilhaTipos.push(CFLOAT);
                } else {
                    pilhaTipos.push(CINT);
                }
                codigo.append("\nmul");
                break;
            case 4:
                tipo1 = pilhaTipos.pop();
                tipo2 = pilhaTipos.pop();

                if (tipo1.equals(tipo2)) {
                    pilhaTipos.push(tipo1);
                } else {
                    throw new SemanticError("Banana exception");
                    //TODO: implementar mensagem de erro
                }
                codigo.append("\ndiv");
                break;
            case 5:
                pilhaTipos.push("int64");
                codigo.append("\n")
                        .append("ldc.i8")
                        .append("\n")
                        .append(token.getLexeme())
                        .append("\n")
                        .append("conv.r8");
                break;
            case 6:
                pilhaTipos.push("float64");
                codigo.append("\n")
                        .append("ldc.r8")
                        .append("\n")
                        .append(token.getLexeme());
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            case 16:
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
        }
        System.out.println(codigo);
        System.out.println(pilhaTipos);
        //System.out.println("Ação #" + action + ", Token: " + token);
    }
}
