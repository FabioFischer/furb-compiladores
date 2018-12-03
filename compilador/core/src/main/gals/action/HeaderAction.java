package gals.action;

import gals.SymbolTable;
import gals.Token;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Semantico
 *
 *   Fábio Luiz Fischer
 **/

public final class HeaderAction extends SemanticAction {
    public HeaderAction(SymbolTable symbolTable) {
        super(symbolTable);
    }

    public String execute(Token token) {
        return (
                ".assembly extern mscorlib {}\n" +
                        ".assembly _codigo_objeto {}\n" +
                        ".module _codigo_objeto.exe\n" +
                        ".class public _UNICA {\n" +
                        ".method static public void _PRINCIPAL() {\n" +
                        ".entrypoint\n"
        );
    }
}