package gals.action;

import gals.SemanticError;
import gals.SymbolTable;
import gals.Token;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Semantico
 *
 *   Fábio Luiz Fischer
 **/

public final class RepetitionEndBlockAction extends SemanticAction {
    public RepetitionEndBlockAction(SymbolTable symbolTable) {
        super(symbolTable);
    }

    public String execute(Token token) throws SemanticError {
        return "brtrue " + this.getSymbolTable().createRotule() + "\n";
    }
}