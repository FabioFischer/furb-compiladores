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

public final class SelectionEndBlockAction extends SemanticAction {
    public SelectionEndBlockAction(SymbolTable symbolTable) {
        super(symbolTable);
    }

    public String execute(Token token) throws SemanticError {
        return ("br " + this.getSymbolTable().createRotule() + "\n" + this.getSymbolTable().getRotules().pop() + ":\n");
    }
}