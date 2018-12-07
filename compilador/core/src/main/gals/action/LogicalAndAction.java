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

public final class LogicalAndAction extends SemanticAction {

    public LogicalAndAction(SymbolTable symbolTable) {
        super(symbolTable);
    }

    public String execute(Token token) throws SemanticError {
        if (this.getSymbolTable().getIdentifierTypes().pop() != IdentifierType.LOGICAL || this.getSymbolTable().getIdentifierTypes().pop() != IdentifierType.LOGICAL) {
            throw new SemanticError("tipos incompatíveis em operação lógica binária", token.getPosition());
        }
        this.getSymbolTable().getIdentifierTypes().push(IdentifierType.LOGICAL);
        return "and\n";
    }
}