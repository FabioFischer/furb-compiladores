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

public abstract class SemanticAction {

    private SymbolTable symbolTable;

    public SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    public SemanticAction(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    public abstract String execute(Token token) throws SemanticError;
}
