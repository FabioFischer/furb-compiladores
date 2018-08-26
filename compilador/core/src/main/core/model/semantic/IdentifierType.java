package core.model.semantic;

/**
 * @author fabio.fischer
 */
public enum IdentifierType {
    INT("int64"),
    FLOAT("float64"),
    STRING("string"),
    BOOLEAN("bool");

    private final String name;
    private final CorrespondingClass cClass;

    private Type(String name) {
        this(name, new CorrespondingClass(name));
    }

    private Type(String name, String cClass) {
        this(name, new CorrespondingClass(cClass));
    }

    private Type(String name, CorrespondingClass cClass) {
        this.name = name;
        this.cClass = cClass;
    }

    public String getName() {
        return this.name;
    }

    public CorrespondingClass getcClass() {
        return this.cClass;
    }
}
