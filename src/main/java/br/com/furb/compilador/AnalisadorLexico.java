package br.com.furb.compilador;

import br.com.furb.compilador.gals.LexicalError;
import br.com.furb.compilador.gals.Lexico;
import br.com.furb.compilador.gals.Token;
import org.fxmisc.richtext.CodeArea;

import static br.com.furb.compilador.gals.ScannerConstants.SCANNER_ERROR;

public class AnalisadorLexico {

    private final Lexico lexico;
    private final String quebraLinha;

    public AnalisadorLexico() {
        this.lexico = new Lexico();
        this.quebraLinha = System.lineSeparator();
    }

    public String analisar(CodeArea entrada) {
        this.lexico.setInput(entrada.getText());
        StringBuilder saida = new StringBuilder()
            .append(padRight("linha", 10))
            .append(padRight("classe", 30))
            .append("lexema")
            .append(this.quebraLinha);

        try {
            Token token;
            while ((token = this.lexico.nextToken()) != null) {
                saida
                    .append(padRight(String.valueOf(obterLinha(entrada, token.getPosition())), 10))
                    .append(padRight(obterClasse(token.getId()), 30))
                    .append(token.getLexeme())
                    .append(this.quebraLinha);
            }

            saida
                .append(this.quebraLinha)
                .append("programa compilado com sucesso")
                .append(this.quebraLinha);
        } catch (LexicalError e) {
            saida = new StringBuilder()
                .append("Erro na linha ")
                .append(obterLinha(entrada, e.getPosition()))
                .append(" - ")
                .append(formatarMensagemErro(e, entrada.getText()))
                .append(this.quebraLinha);
        }

        return saida.toString();
    }

    private String padRight(String texto, int quantidade) {
        return String.format("%-" + quantidade + "s", texto);
    }

    private int obterLinha(CodeArea entrada, int position) {
        entrada.selectRange(position, position);
        return entrada.getCaretSelectionBind().getParagraphIndex() + 1;
    }

    private String obterClasse(int id) {
        switch (id) {
            case 2:
                return "identificador";
            case 3:
                return "constante int";
            case 4:
                return "constante float";
            case 5:
                return "constante char";
            case 6:
                return "constante string";
        }
        if (id >= 7 && id <= 26) {
            return "palavra reservada";
        }
        if (id > 26) {
            return "símbolo especial";
        }
        return "Ainda não implementado";
    }

    private String formatarMensagemErro(LexicalError error, String texto) {
        return SCANNER_ERROR[0].equals(error.getMessage())
                ? texto.charAt(error.getPosition()) + " " + error.getMessage()
                : error.getMessage();
    }
}
