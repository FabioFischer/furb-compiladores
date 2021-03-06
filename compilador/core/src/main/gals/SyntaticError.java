package gals;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Semantico
 *
 *   Fábio Luiz Fischer
 **/

public class SyntaticError extends AnalysisError {
    private final static String syntaticErrorPrefix = "encontrado ";

    public SyntaticError(String msg, int position, String description) {
        super(syntaticErrorPrefix+description+msg, position, description);
    }

    public SyntaticError(String msg, int position) {
        super(syntaticErrorPrefix+msg, position);
    }

    public SyntaticError(String msg) {
        super(syntaticErrorPrefix + msg);
    }
}
