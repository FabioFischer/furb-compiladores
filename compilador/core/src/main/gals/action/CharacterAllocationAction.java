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

public final class CharacterAllocationAction extends SemanticAction {
    public CharacterAllocationAction(SymbolTable symbolTable) {
        super(symbolTable);
    }

    public String execute(Token token) throws SemanticError {
        this.getSymbolTable().getIdentifierTypes().push(IdentifierType.LITERAL);
        return "ldstr " + token.getLexeme() + "\n";
    }
}