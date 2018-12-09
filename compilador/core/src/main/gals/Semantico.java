package gals;

import gals.action.SemanticAction;
import gals.action.SemanticActionFactory;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Semantico
 *
 *   Fábio Luiz Fischer
 **/

public class Semantico implements Constants
{
    private final ObjectCode objectCode = new ObjectCode();
    private final SymbolTable symbolTable = new SymbolTable();
    private final SemanticActionFactory semanticActionFactory = new SemanticActionFactory(this.symbolTable);

    public String getObjectCode() {
        return this.objectCode.toString();
    }

    public void executeAction(int actionId, Token token)	throws SemanticError
    {
        SemanticAction action = this.semanticActionFactory.create(actionId);
        this.objectCode.add(action.execute(token));
    }	
}
