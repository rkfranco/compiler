package br.com.furb.compilador;

import br.com.furb.compilador.gals.*;
import org.fxmisc.richtext.CodeArea;

import static br.com.furb.compilador.gals.ScannerConstants.SCANNER_ERROR;

public class AnalisadorCodigo {

    private final Lexico lexico;
    private final Sintatico sintatico;
    private final Semantico semantico;
    private final String quebraLinha;

    public AnalisadorCodigo() {
        this.lexico = new Lexico();
        this.sintatico = new Sintatico();
        this.semantico = new Semantico();
        this.quebraLinha = System.lineSeparator();
    }

    public String analisar(CodeArea entrada) {
        this.lexico.setInput(entrada.getText());
        StringBuilder saida = new StringBuilder().append("programa compilado com sucesso");

        try {
            this.sintatico.parse(this.lexico, this.semantico);
        } catch (LexicalError e) {
            saida = new StringBuilder()
                .append("Erro na linha ")
                .append(obterLinha(entrada, e.getPosition()))
                .append(" - ")
                .append(formatarMensagemErro(e, entrada.getText()))
                .append(this.quebraLinha);
        } catch (SyntaticError e) {
            saida = new StringBuilder()
                .append("Erro na linha ")
                .append(obterLinha(entrada, e.getPosition()))
                .append(" - ")
                .append("encontrado ")
                .append(this.sintatico.getCurrentTokenString())
                .append(" ")
                .append(e.getMessage());
        } catch (SemanticError e) {
            // Tratar erros semânticos
        }

        return saida.toString();
    }

    private int obterLinha(CodeArea entrada, int position) {
        entrada.selectRange(position, position);
        return entrada.getCaretSelectionBind().getParagraphIndex() + 1;
    }

    private String formatarMensagemErro(LexicalError error, String texto) {
        return SCANNER_ERROR[0].equals(error.getMessage())
                ? texto.charAt(error.getPosition()) + " " + error.getMessage()
                : error.getMessage();
    }
}
