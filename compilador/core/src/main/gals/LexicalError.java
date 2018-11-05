package gals;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Sintatico
 *
 *   Fábio Luiz Fischer
 **/

public class LexicalError extends AnalysisError {

    public LexicalError(String msg, int position, String lexeme) {
        super(lexeme+msg, position, lexeme);
    }

    public LexicalError(String msg, int position) {
        super(msg, position);
    }

    public LexicalError(String msg) {
        super(msg);
    }
}
