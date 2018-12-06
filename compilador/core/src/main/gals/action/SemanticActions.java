package gals.action;

import gals.SymbolTable;

import java.util.Arrays;
import java.util.Optional;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Semantico
 *
 *   Fábio Luiz Fischer
 **/

public enum SemanticActions {

    Number15(15, HeaderAction.class),
    Number16(16, FooterAction.class),
    Number101(101, SetIdentifierTypeAction.class),
    Number102(102, PushIdentifierAction.class),
    Number103(103, MassDeclarationVariablesAction.class),
    Number104(104, InputAction.class),
    Number105(105, PushIdentifierTypeAction.class);

    private final int action;
    private Class<? extends SemanticAction> classe;

    public int getAction() {
        return this.action;
    }

    public SemanticAction build(SymbolTable symbolTable) {
        try {
            return this.classe.getConstructor(SymbolTable.class).newInstance(symbolTable);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    SemanticActions(int action, Class<? extends SemanticAction> clazz) {
        this.action = action;
        this.classe = clazz;
    }

    public static Optional<SemanticActions> find(int action) {
        return Arrays.asList(values()).stream().filter(record -> record.getAction() == action).findAny();
    }
}