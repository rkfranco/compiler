package br.com.furb.compilador;

import br.com.furb.compilador.gals.*;
import org.fxmisc.richtext.CodeArea;

import static br.com.furb.compilador.gals.ScannerConstants.SCANNER_ERROR;

public class AnalisadorCodigo {

    private Lexico lexico;
    private Sintatico sintatico;
    private Semantico semantico;
    private final String quebraLinha;
    private boolean compiladoComSucesso;

    public AnalisadorCodigo() {
        this.quebraLinha = System.lineSeparator();
    }

    public String analisar(CodeArea entrada) {
        this.compiladoComSucesso = true;
        this.lexico = new Lexico();
        this.sintatico = new Sintatico();
        this.semantico = new Semantico();
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
            this.compiladoComSucesso = false;
        } catch (SyntaticError e) {
            saida = new StringBuilder()
                .append("Erro na linha ")
                .append(obterLinha(entrada, e.getPosition()))
                .append(" - ")
                .append("encontrado ")
                .append(this.sintatico.getCurrentTokenString())
                .append(" ")
                .append(e.getMessage());
            this.compiladoComSucesso = false;
        } catch (SemanticError e) {
            saida = new StringBuilder()
                .append("Erro na linha ")
                .append(obterLinha(entrada, e.getPosition()))
                .append(" - ")
                .append(e.getMessage());
            this.compiladoComSucesso = false;
        }

        return saida.toString().replace("$", "EOF");
    }

    private int obterLinha(CodeArea entrada, int position) {
        try {
            entrada.selectRange(position, position);
        } catch (IndexOutOfBoundsException e) {
            entrada.selectRange(0, 0);
        }
        return entrada.getCaretSelectionBind().getParagraphIndex() + 1;
    }

    private String formatarMensagemErro(LexicalError error, String texto) {
        return SCANNER_ERROR[0].equals(error.getMessage())
                ? texto.charAt(error.getPosition()) + " " + error.getMessage()
                : error.getMessage();
    }

    public boolean programaCompiladoComSucesso() {
        return this.compiladoComSucesso;
    }

    public String getCodigoObjeto() {
        return this.semantico.getCodigoObjeto();
    }
}
