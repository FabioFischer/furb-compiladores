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

    Action1(1, AdditionAction.class),
    Action2(2, SubtractionAction.class),
    Action3(3, MultiplicationAction.class),
    Action4(4, DivisionAction.class),
    Action6(6, NumberAllocationAction.class),
    Action7(7, UnaryPositiveAction.class),
    Action8(8, UnaryNegativeAction.class),
    Action9(9, PushRelationalOperatorAction.class),
    Action10(10, RelationalOperatorAction.class),
    Action11(11, LogicalTrueAllocationAction.class),
    Action12(12, LogicalFalseAllocationAction.class),
    Action13(13, LogicalNegationAction.class),
    Action15(15, HeaderAction.class),
    Action16(16, FooterAction.class),
    Action17(17, LogicalAndAction.class),
    Action18(18, LogicalOrAction.class),
    Action19(19, null), // TODO
    Action20(20, null), // TODO
    Action101(101, SetIdentifierTypeAction.class),
    Action102(102, PushIdentifierAction.class),
    Action103(103, MassDeclarationVariablesAction.class),
    Action104(104, InputAction.class),
    Action105(105, PushIdentifierTypeAction.class),
    Action106(106, VariableAttribuitionAction.class),
    Action107(107, null), // TODO
    Action108(108, null), // TODO
    Action109(109, null), // TODO
    Action110(110, null), // TODO
    Action111(111, null), // TODO
    Action112(112, null); // TODO

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