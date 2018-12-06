package gals.action;

import gals.Identifier;
import gals.SymbolTable;
import gals.Token;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Semantico
 *
 *   Fábio Luiz Fischer
 **/

public class PushIdentifierAction extends SemanticAction {
    public PushIdentifierAction(SymbolTable symbolTable) {
        super(symbolTable);
    }

    public String execute(Token token) {
        String lexeme = token.getLexeme();
        Identifier identifier = getSymbolTable().getIdentifiers().get(lexeme);

        if (identifier == null) {
            identifier = new Identifier(lexeme);
        }

        this.getSymbolTable().getStackIdentifiers().push(identifier);
        return null;
    }
}
