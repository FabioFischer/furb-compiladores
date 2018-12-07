package gals.action;

import gals.IdentifierType;
import gals.SemanticError;
import gals.SymbolTable;
import gals.Token;

import java.util.Stack;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Semantico
 *
 *   Fábio Luiz Fischer
 **/

public abstract class DefaultBinaryAction extends SemanticAction {

    public DefaultBinaryAction(SymbolTable symbolTable) {
        super(symbolTable);
    }

    public String execute(Token token) throws SemanticError {
        Stack<IdentifierType> types = this.getSymbolTable().getIdentifierTypes();
        if (!isTypeValid(types.pop()) || !isTypeValid(types.pop())) {
            throw new SemanticError("tipos incompatíveis em operação aritmética binária", token.getPosition());
        }
        types.push(IdentifierType.NUMBER);
        return null;
    }

    private boolean isTypeValid(IdentifierType type) {
        return type == IdentifierType.NUMBER;
    }
}
