package gals.action;

import gals.SymbolTable;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Semantico
 *
 *   Fábio Luiz Fischer
 **/

public final class SemanticActionFactory {
    private SymbolTable symbolTable;

    public SemanticActionFactory(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    public SemanticAction create(int id) {
        return SemanticActions.find(id)
                .map(action -> action.build(this.symbolTable))
                .orElse(new BlankAction(this.symbolTable));
    }
}
