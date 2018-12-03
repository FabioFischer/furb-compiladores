package gals;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Semantico
 *
 *   Fábio Luiz Fischer
 **/

public final class Identifier {

    private final String name;
    private Integer size;

    public Identifier(String name) {
        this.name = name;
    }

    public IdentifierType getIdentifierType() {
        switch (this.getDefaultConvention()) {
            case 'i':
                return IdentifierType.INT;
            case 'f':
                return IdentifierType.FLOAT;
            case 's':
                return IdentifierType.STRING;
            case 'b':
                return IdentifierType.BOOLEAN;
            default:
                return null;
        }
    }

    public String getTypeDescription() {
        IdentifierType identifierType = getIdentifierType();
        return identifierType == null ? null : identifierType.getPrimitiveName();
    }

    private char getDefaultConvention() {
        return this.name.toCharArray()[0];
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }

    public boolean isVector() {
        return getSize() != null;
    }

    public String toString() {
        return this.name;
    }
}
