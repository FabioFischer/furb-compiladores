package gals;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Semantico
 *
 *   Fábio Luiz Fischer
 **/

public final class Identifier {

    private final String name;
    private final IdentifierType type;

    public Identifier(String name) {
        this.name = name;
        this.type = null;
    }

    public Identifier(String name, IdentifierType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public IdentifierType getType() {
        return this.type;
    }

    public String toString() {
        return this.name;
    }
}
