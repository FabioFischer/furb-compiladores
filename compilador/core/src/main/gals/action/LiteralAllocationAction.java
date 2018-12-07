package gals.action;

import gals.IdentifierType;
import gals.SemanticError;
import gals.SymbolTable;
import gals.Token;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Semantico
 *
 *   Fábio Luiz Fischer
 **/

public final class LiteralAllocationAction extends SemanticAction {
    public LiteralAllocationAction(SymbolTable symbolTable) {
        super(symbolTable);
    }

    public String execute(Token token) throws SemanticError {
        this.getSymbolTable().getIdentifierTypes().push(IdentifierType.LITERAL);
        return "ldstr " + token.getLexeme() + "\n";
    }
}