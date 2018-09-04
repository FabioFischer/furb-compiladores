package ui.view.listener

import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import javafx.scene.control.TextArea
import ui.view.screen.impl.MainScreen

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Interface
 *
 *   Fábio Luiz Fischer
 **/

class AppListener(var root: MainScreen) : ChangeListener<String> {
    override fun changed(observable: ObservableValue<out String>?, oldValue: String?, newValue: String?) {
        if (oldValue.isNullOrEmpty().not() && oldValue != newValue)
            root.isFileChanged = true

        writeLineCounter(root.lineNumberArea, root.contentArea, newValue!!.lines())
    }

    fun writeLineCounter(lineCounter: TextArea, content: TextArea, textLines: List<String>) {
        var str: String = ""

        for (i in 1..textLines.size) {
            str += "$i\n"
        }

        lineCounter.text = str
        lineCounter.scrollTopProperty().bindBidirectional(content.scrollTopProperty())
    }

    companion object {
        fun listen(root: MainScreen): AppListener = AppListener(root)
    }
}