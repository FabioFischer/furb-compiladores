package core.analyser.semantic;

import constants.Constants;
import core.model.lexical.Token;
import core.model.semantic.SymbolTable;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Interface
 *
 *   Fábio Luiz Fischer & Matheus Felipe Klauberg
 **/

public class Semantic implements Constants
{
    private final Code code = new Code();
    private final SymbolTable symbolTable = new SymbolTable();

    public void executeAction(int action, Token token)	throws SemanticError
    {
        System.out.println("Ação #"+action+", Token: "+token);
    }

    public String getObjectCode() {
        return this.code.toString();
    }
}
