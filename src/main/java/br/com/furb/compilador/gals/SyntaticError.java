package br.com.furb.compilador.gals;

public class SyntaticError extends AnalysisError {
    public SyntaticError(String msg, int position) {
        super(msg, position);
    }

    public SyntaticError(String msg) {
        super(msg);
    }
}
