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
        System.out.println("Acao #"+actionId+", Token: "+token);
        SemanticAction action = this.semanticActionFactory.create(actionId);
        String generatedCode = action.execute(token);

        this.objectCode.add(generatedCode);
    }	
}
