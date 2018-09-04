package ui.utils

import javafx.scene.control.Button
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Interface
 *
 *   Fábio Luiz Fischer
 **/

class ButtonBar(maxWidth: Double = Double.MAX_VALUE, spacing: Double = 0.0, vararg buttons: Button) : HBox(spacing) {
    init {
        setMaxWidth(maxWidth)
        children.addAll(buttons)
        for (b in buttons) {
            HBox.setHgrow(b, Priority.ALWAYS)
            b.maxWidth = Double.MAX_VALUE
        }
    }

    fun addAll(vararg buttons: Button) {
        for (button in buttons) {
            addButton(button)
        }
    }

    fun addButton(button: Button) {
        HBox.setHgrow(button, Priority.ALWAYS)
        button.maxWidth = Double.MAX_VALUE
        val buttons = children
        if (!buttons.contains(button)) {
            buttons.add(button)
        }
    }

    fun removeButton(button: Button) {
        children.remove(button)
    }

    override fun layoutChildren() {
        val minPrefWidth = calculatePrefChildWidth()
        children
                .filterIsInstance<Button>()
                .forEach { (it).minWidth = minPrefWidth }
        super.layoutChildren()
    }

    private fun calculatePrefChildWidth(): Double {
        val minPrefWidth = children
                .map { it.prefWidth(-1.0) }
                .max()
                ?: 0.0
        return minPrefWidth
    }
}