package ui.utils

import javafx.scene.control.Button
import javafx.scene.layout.VBox
import javafx.scene.layout.Priority

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Interface
 *
 *   Fábio Luiz Fischer
 **/

class ButtonBar(selfMaxHeight: Double = Double.MAX_VALUE, spacing: Double = 0.0, vararg buttons: Button) : VBox(spacing) {
    init {

        maxHeight = selfMaxHeight

        children.addAll(buttons)
        for (b in buttons) {
            VBox.setVgrow(b, Priority.ALWAYS)
            b.maxHeight = Double.MAX_VALUE
        }
    }

    fun addAll(vararg buttons: Button) {
        for (button in buttons) {
            addButton(button)
        }
    }

    fun addButton(button: Button) {
        VBox.setVgrow(button, Priority.ALWAYS)
        button.maxHeight = Double.MAX_VALUE
        val buttons = children
        if (!buttons.contains(button)) {
            buttons.add(button)
        }
    }

    fun removeButton(button: Button) {
        children.remove(button)
    }

    override fun layoutChildren() {
        val minPrefHeight = calculatePrefChildHeight()

        children.filterIsInstance<Button>()
                .forEach { (it).minHeight = minPrefHeight }

        super.layoutChildren()
    }

    private fun calculatePrefChildHeight(): Double {
        return children
                .map { it.prefHeight(-1.0) }
                .max()
                ?: 0.0
    }
}