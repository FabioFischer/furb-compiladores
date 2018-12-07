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

public final class LogicalFalseAllocationAction extends SemanticAction {
    public LogicalFalseAllocationAction(SymbolTable symbolTable) {
        super(symbolTable);
    }

    public String execute(Token token) {
        this.getSymbolTable().getIdentifierTypes().push(IdentifierType.LOGICAL);
        return "ldc.i4.0\n";
    }
}