package gals;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Interface
 *
 *   Fábio Luiz Fischer
 **/

public class Token
{
    private TokenKind tokenKind;
    private String lexeme;
    private String description;
    private int position;

    public Token(TokenKind tokenKind, String lexeme, int position)
    {
        if (tokenKind.getId() == 1) {
            this.Token(tokenKind, lexeme, "EOF", position);
        } else {
            this.Token(tokenKind, lexeme, lexeme, position);
        }
    }

    private void Token(TokenKind tokenKind, String lexeme, String description, int position) {
        this.tokenKind = tokenKind;
        this.lexeme = lexeme;
        this.description = description;
        this.position = position;
    }

    public TokenKind getTokenKind() {
        return tokenKind;
    }

    public final String getLexeme() {
        return lexeme;
    }

    public final String getDescription() {
        return description;
    }

    public final int getPosition() {
        return position;
    }

    public String toString() {
        return tokenKind.getId() + " ( " + description + " ) @ " + position;
    }
}
