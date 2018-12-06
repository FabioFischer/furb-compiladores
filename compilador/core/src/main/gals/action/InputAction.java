package gals.action;

import gals.*;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Semantico
 *
 *   Fábio Luiz Fischer
 **/

public class InputAction extends SemanticAction {

    private static final String READ_FUNCTION_SIGNATURE = "call string [mscorlib]System.Console::ReadLine()\n";

    private static final String PARSE_FUNCTION_SIGNATURE = "call %s [mscorlib]System.%s::Parse(string)\n";

    public InputAction(SymbolTable symbolTable) {
        super(symbolTable);
    }

    public String execute(Token token) throws SemanticError {
        StringBuilder objectCode = new StringBuilder();

        while (this.getSymbolTable().getStackIdentifiers().size() > 0) {
            String stackIdentifierName = this.getSymbolTable().getStackIdentifiers().pop().getName();

            if (!this.getSymbolTable().getIdentifiers().containsKey(stackIdentifierName)) {
                throw new SemanticError(stackIdentifierName + " nao declarado", token.getPosition());
            }
            Identifier identifier = this.getSymbolTable().getIdentifiers().get(stackIdentifierName);

            objectCode.append(READ_FUNCTION_SIGNATURE);
            if (identifier.getType() != IdentifierType.LITERAL) {
                objectCode.append(buildParseFunctionCallFor(identifier.getType()));
            }
            objectCode.append("stloc ").append(identifier.getName()).append("\n");
        }
        return objectCode.toString();
    }

    private String buildParseFunctionCallFor(IdentifierType identifierType) {
        return String.format(PARSE_FUNCTION_SIGNATURE, identifierType.getPrimitiveName(), identifierType.getCorrespondingClass());
    }
}
