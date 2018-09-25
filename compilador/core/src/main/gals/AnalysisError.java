package gals;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Interface
 *
 *   Fábio Luiz Fischer
 **/

public class AnalysisError extends Exception
{
    private int position;
    private String description;

    public AnalysisError(String msg, int position, String description) {
        super(msg);
        this.position = position;
        this.description = description;
    }

    public AnalysisError(String msg, int position)
    {
        super(msg);
        this.position = position;
    }

    public AnalysisError(String msg)
    {
        super(msg);
        this.position = -1;
    }

    public String getDescription() {
        return (description == null || description.isEmpty()) ? "" : description;
    }

    public int getPosition() {
        return position;
    }

    public String toString()
    {
        return super.toString() + ", @ "+position;
    }
}
