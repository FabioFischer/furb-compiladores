package core.analyser.semantic;

/**
 * @author fabio.fischer
 */
public class Code {
    private final StringBuilder code = new StringBuilder();

    public Code() {}

    public void add(String otherCode) {
        if (otherCode != null) {
            this.code.append(otherCode);
        }
    }

    @Override
    public String toString() {
        return this.code.toString();
    }
}
