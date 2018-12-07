package gals.action;

import gals.SymbolTable;
import gals.Token;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Semantico
 *
 *   Fábio Luiz Fischer
 **/

public final class FooterAction extends SemanticAction {
    public FooterAction(SymbolTable symbolTable) {
        super(symbolTable);
    }

    public String execute(Token token) {
        return ("ret\n" + "}\n" + "}");
    }
}
