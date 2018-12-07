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

public final class NumberAllocationAction extends SemanticAction {
    public NumberAllocationAction(SymbolTable symbolTable) {
        super(symbolTable);
    }

    public String execute(Token token) {
        this.getSymbolTable().getIdentifierTypes().push(IdentifierType.NUMBER);
        return "ldc.r8 " + this.formatLexeme(token.getLexeme()) + "\n";
    }

    private String formatLexeme(String lexeme) {
        return lexeme.replace(",", ".");
    }
}