package core.analyser.syntatic;

import core.analyser.AnalysisError;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Interface
 *
 *   Fábio Luiz Fischer & Matheus Felipe Klauberg
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
