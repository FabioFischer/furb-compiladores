package gals;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Semantico
 *
 *   Fábio Luiz Fischer
 **/

public class SymbolTable {

    private final Stack<Identifier> stackIdentifiers;
    private final Map<String, Identifier> identifiers;
    private final Stack<IdentifierType> identifierTypes;
    private final Stack<String> relationalOperators;
    private final Stack<String> rotules;

    private IdentifierType declarationIdentifierType;
    private int lastRotule = 1;

    public SymbolTable() {
        this.stackIdentifiers = new Stack<>();
        this.identifiers = new HashMap<>();
        this.identifierTypes = new Stack<>();
        this.relationalOperators = new Stack<>();
        this.rotules = new Stack<>();
    }

    public Stack<Identifier> getStackIdentifiers() {
        return this.stackIdentifiers;
    }

    public Identifier getLastAllocated() {
        return getStackIdentifiers().peek();
    }

    public Map<String, Identifier> getIdentifiers() {
        return this.identifiers;
    }

    public Stack<IdentifierType> getIdentifierTypes() {
        return this.identifierTypes;
    }

    public Stack<String> getRelationalOperators() {
        return this.relationalOperators;
    }

    public Stack<String> getRotules() {
        return this.rotules;
    }

    public IdentifierType getDeclarationIdentifierType() {
        return this.declarationIdentifierType;
    }

    public void setDeclarationIdentifierType(IdentifierType declarationIdentifierType) {
        this.declarationIdentifierType = declarationIdentifierType;
    }

    public String createRotule() {
        String rotule = "label" + this.lastRotule;
        this.rotules.push(rotule);
        lastRotule++;
        return rotule;
    }
}
