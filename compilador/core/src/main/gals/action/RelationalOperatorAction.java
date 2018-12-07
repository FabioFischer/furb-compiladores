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

public final class RelationalOperatorAction extends SemanticAction {
    public RelationalOperatorAction(SymbolTable symbolTable) {
        super(symbolTable);
    }

    public String execute(Token token) throws SemanticError {
        if (this.getSymbolTable().getIdentifierTypes().pop() != this.getSymbolTable().getIdentifierTypes().pop()) {
            throw new SemanticError("tipos incompatíveis em operação relacional", token.getPosition());
        }
        this.getSymbolTable().getIdentifierTypes().push(IdentifierType.LOGICAL);

        switch (this.getSymbolTable().getRelationalOperators().pop()) {
            case "=":
                return "ceq\n";
            case ">":
                return "cgt\n";
            case "<":
                return "clt\n";
            case "!=":
                return ("ceq\n" + "ldc.i4.1\n" + "xor\n");
            case ">=":
                return ("clt\n" + "ldc.i4.1\n" + "xor\n");
            case "<=":
                return ("cgt\n" + "ldc.i4.1\n" + "xor\n");
        }
        return null;
    }
}
