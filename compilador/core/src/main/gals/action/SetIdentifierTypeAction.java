package gals.action;

import gals.IdentifierType;
import gals.SymbolTable;
import gals.Token;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Semantico
 *
 *   Fábio Luiz Fischer
 **/

public class SetIdentifierTypeAction extends SemanticAction {
    public SetIdentifierTypeAction(SymbolTable symbolTable) {
        super(symbolTable);
    }

    public String execute(Token token) {
        this.getSymbolTable().setDeclarationIdentifierType(null);

        switch (token.getLexeme()) {
            case "number":
                this.getSymbolTable().setDeclarationIdentifierType(IdentifierType.NUMBER);
                break;
            case "literal":
                this.getSymbolTable().setDeclarationIdentifierType(IdentifierType.LITERAL);
                break;
            case "logical":
                this.getSymbolTable().setDeclarationIdentifierType(IdentifierType.LOGICAL);
                break;
            default:
                this.getSymbolTable().setDeclarationIdentifierType(null);
                break;
        }
        return null;
    }
}
