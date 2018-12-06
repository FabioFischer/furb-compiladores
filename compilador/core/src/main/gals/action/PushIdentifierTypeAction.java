package gals.action;

import gals.Identifier;
import gals.SemanticError;
import gals.SymbolTable;
import gals.Token;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Semantico
 *
 *   Fábio Luiz Fischer
 **/

public class PushIdentifierTypeAction extends SemanticAction {
    public PushIdentifierTypeAction(SymbolTable symbolTable) {
        super(symbolTable);
    }

    public String execute(Token token) throws SemanticError {
        if (!this.getSymbolTable().getIdentifiers().containsKey(token.getLexeme())) {
            throw new SemanticError(token.getLexeme() + " nao declarado", token.getPosition());
        }
        Identifier identifier = this.getSymbolTable().getIdentifiers().get(token.getLexeme());
        this.getSymbolTable().getIdentifierTypes().push(identifier.getType());

        return "ldloc " + identifier.toString() + "\n";
    }
}
