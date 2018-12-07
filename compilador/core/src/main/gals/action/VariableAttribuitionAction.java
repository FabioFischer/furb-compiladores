package gals.action;

import gals.*;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Semantico
 *
 *   Fábio Luiz Fischer
 **/

public class VariableAttribuitionAction extends SemanticAction {
    public VariableAttribuitionAction(SymbolTable symbolTable) {
        super(symbolTable);
    }

    public String execute(Token token) throws SemanticError {
        Identifier identifier = this.getSymbolTable().getStackIdentifiers().pop();

        if (!this.getSymbolTable().getIdentifiers().containsKey(identifier.toString())) {
            throw new SemanticError(identifier.toString() + " nao declarado", token.getPosition());
        }
        IdentifierType expressionType = this.getSymbolTable().getIdentifierTypes().pop();
        IdentifierType IdentifierType = this.getSymbolTable().getIdentifiers().get(identifier.toString()).getType();

        if (IdentifierType != expressionType) {
            throw new SemanticError("tipo incompatível em comando de atribuição", token.getPosition());
        }
        return "stloc " + identifier.toString() + "\n";
    }
}
