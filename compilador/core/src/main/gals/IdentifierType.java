package gals;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Semantico
 *
 *   Fábio Luiz Fischer
 **/

public enum IdentifierType {
    INT("int64"),
    FLOAT("float64", "Double"),
    STRING("string"),
    BOOLEAN("bool", "Boolean");

    private final String primitiveName;
    private final CorrespondingClass correspondingClass;

    private IdentifierType(String primitiveName) {
        this(primitiveName, new CorrespondingClass(primitiveName));
    }

    private IdentifierType(String primitiveName, String correspondingClass) {
        this(primitiveName, new CorrespondingClass(correspondingClass));
    }

    private IdentifierType(String primitiveName, CorrespondingClass correspondingClass) {
        this.primitiveName = primitiveName;
        this.correspondingClass = correspondingClass;
    }

    public String getPrimitiveName() {
        return this.primitiveName;
    }

    public CorrespondingClass getCorrespondingClass() {
        return this.correspondingClass;
    }
}
