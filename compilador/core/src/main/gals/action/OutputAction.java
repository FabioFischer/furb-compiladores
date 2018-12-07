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

public final class OutputAction extends SemanticAction {
    public OutputAction(SymbolTable symbolTable) {
        super(symbolTable);
    }

    public String execute(Token token) throws SemanticError {
        IdentifierType type = this.getSymbolTable().getIdentifierTypes().pop();
        return "call void [mscorlib]System.Console::Write(" + type.getPrimitiveName() + ")\n";
    }
}