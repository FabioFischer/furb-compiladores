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

public final class UnaryNegativeAction extends SemanticAction {
    public UnaryNegativeAction(SymbolTable symbolTable) {
        super(symbolTable);
    }

    public String execute(Token token) throws SemanticError {
        if (this.getSymbolTable().getIdentifierTypes().lastElement() != IdentifierType.NUMBER) {
            throw new SemanticError("tipo incompatível em operação aritmética unária", token.getPosition());
        }
        return ("ldc.i8 -1\n" + "mul\n");
    }
}