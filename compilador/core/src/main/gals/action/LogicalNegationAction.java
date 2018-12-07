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

public final class LogicalNegationAction extends SemanticAction {
    public LogicalNegationAction(SymbolTable symbolTable) {
        super(symbolTable);
    }

    public String execute(Token token) throws SemanticError {
        IdentifierType identifierType = this.getSymbolTable().getIdentifierTypes().pop();

        if (identifierType != IdentifierType.LOGICAL) {
            throw new SemanticError("tipo incompatível em operação lógica unária", token.getPosition());
        }
        this.getSymbolTable().getIdentifierTypes().push(IdentifierType.LOGICAL);
        return ("ldc.i4.1\n" + "xor\n");
    }
}