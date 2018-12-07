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

public final class RepetitionEndAction extends SemanticAction {
    public RepetitionEndAction(SymbolTable symbolTable) {
        super(symbolTable);
    }

    public String execute(Token token) {
        String lastRotule = this.getSymbolTable().getRotules().pop();
        String firstRotule = this.getSymbolTable().getRotules().pop();
        return "br " + firstRotule + "\n" + lastRotule + ":\n";
    }
}