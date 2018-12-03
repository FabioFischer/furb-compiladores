package gals;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Semantico
 *
 *   Fábio Luiz Fischer
 **/

public class TokenKind {
    private int id;
    private TokenClass tokenClass;

    public TokenKind(int id, TokenClass.Class tokenClass) {
        this.setId(id);
        this.setTokenClass(new TokenClass(tokenClass));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TokenClass getTokenClass() {
        return tokenClass;
    }

    public TokenClass.Class getTokenClassType() {
        return tokenClass.getTokenClass();
    }

    public void setTokenClass(TokenClass tokenClass) {
        this.tokenClass = tokenClass;
    }

    public String getDescription() {
        return this.getTokenClass().getDescription();
    }
}
