package gals.action;

import gals.*;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Semantico
 *
 *   Fábio Luiz Fischer
 **/

public class MassDeclarationVariablesAction extends SemanticAction {
    public MassDeclarationVariablesAction(SymbolTable symbolTable) {
        super(symbolTable);
    }

    public String execute(Token token) throws SemanticError {
        StringBuilder objectCode = new StringBuilder();
        IdentifierType identifierType = this.getSymbolTable().getDeclarationIdentifierType();

        if (this.getSymbolTable().getStackIdentifiers().size() > 0) {
            objectCode.append(".locals (");

            Identifier identifier = new Identifier(this.getSymbolTable().getStackIdentifiers().pop().getName(), identifierType);
            objectCode.append(addIdentifierToStack(token, identifier));

            while (this.getSymbolTable().getStackIdentifiers().size() > 0) {
                identifier = new Identifier(this.getSymbolTable().getStackIdentifiers().pop().getName(), identifierType);
                objectCode.append(", " + addIdentifierToStack(token, identifier));
            }
            objectCode.append(")\n");
        }
        return objectCode.toString();
    }

    private String addIdentifierToStack(Token token, Identifier identifier) throws SemanticError {
        if (this.getSymbolTable().getIdentifiers().containsKey(identifier.toString())) {
            throw new SemanticError(identifier.toString() + " ja declarado", token.getPosition());
        }
        this.getSymbolTable().getIdentifiers().put(identifier.toString(), identifier);
        return buildDeclarationFor(identifier, identifier.getType());
    }

    private String buildDeclarationFor(Identifier identifier, IdentifierType type) {
        return type.getPrimitiveName() + " " + identifier.toString();
    }
}
