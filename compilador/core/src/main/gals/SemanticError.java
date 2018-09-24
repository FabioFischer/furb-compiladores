package gals;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Interface
 *
 *   Fábio Luiz Fischer
 **/

public class SemanticError extends AnalysisError
{
    public SemanticError(String msg, int position)
	 {
        super(msg, position);
    }

    public SemanticError(String msg)
    {
        super(msg);
    }
}
