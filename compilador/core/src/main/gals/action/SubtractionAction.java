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

public class SubtractionAction extends DefaultBinaryAction {

    public SubtractionAction(SymbolTable symbolTable) {
        super(symbolTable );
    }

    @Override
    public String execute(Token token) throws SemanticError {
        super.execute(token);
        return "sub\n";
    }
}
