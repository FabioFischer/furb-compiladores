package ui.view.screen.impl

import javafx.application.Application
import javafx.scene.Node
import javafx.scene.control.*
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.TextAlignment
import javafx.stage.Stage
import ui.utils.ScreenSize
import ui.view.screen.IScreenBuilder

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Interface
 *
 *   Fábio Luiz Fischer
 **/

abstract class AbstractScreen(val screenSize: ScreenSize, var screenName: String) : Application(), IScreenBuilder {
    var stage: Stage? = null

    fun write(textArea: TextArea, content: String, override: Boolean = false) {
        textArea.requestFocus()
        if (override) {
            textArea.text = content
        } else {
            textArea.text = textArea.text + content
        }
        textArea.positionCaret(textArea.text.length)
    }

    fun initTextArea(textArea: TextArea, width: Double, height: Double, isEditable: Boolean = true, isDisable: Boolean = false) {
        textArea.setPrefSize(width, height)
        textArea.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE)
        textArea.isEditable = isEditable
        textArea.isDisable = isDisable
    }

    fun initButton(button: Button, text: String, graphic: Node? = null, height: Double) {
        button.text = text
        button.minHeight = height
        button.contentDisplay = ContentDisplay.TOP
        if (graphic != null) button.graphic = graphic
    }

    fun initHBox(hBox: HBox, spacing: Double, vararg elements: Node) {
        hBox.spacing = spacing
        hBox.children.addAll(elements)
    }

    fun initVBox(vBox: VBox, spacing: Double, vararg elements: Node) {
        vBox.spacing = spacing
        vBox.children.addAll(elements)
    }

    fun initLabel(label: Label, text: String, textAlignment: TextAlignment, width: Double, height: Double) {
        label.text = text
        label.textAlignment = textAlignment
        label.setMinSize(width, height)
    }

    fun showDialogMessage(title: String, headerMessage: String, bodyMessage: String, type: Alert.AlertType) {
        val dialog: Alert = Alert(type)

        dialog.title = title
        dialog.headerText = headerMessage
        dialog.contentText = bodyMessage
        dialog.showAndWait()
    }

    fun showDialogOptions(title: String, headerMessage: String, bodyMessage: String, type: Alert.AlertType): ButtonType? {
        val dialog: Alert = Alert(type)
        var response: ButtonType? = null

        dialog.title = title
        dialog.headerText = headerMessage
        dialog.contentText = bodyMessage
        dialog.buttonTypes.setAll(ButtonType("Sim", ButtonBar.ButtonData.YES), ButtonType("Não", ButtonBar.ButtonData.NO), ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE))

        dialog.showAndWait().ifPresent { b ->
            response = b
        }

        return response
    }
}