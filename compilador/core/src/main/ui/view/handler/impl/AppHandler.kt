package ui.view.handler.impl

import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.stage.FileChooser
import javafx.stage.WindowEvent
import ui.controller.impl.FileController
import ui.utils.Settings
import ui.view.handler.IAppHandler
import ui.view.screen.impl.MainScreen
import java.awt.Robot
import java.awt.event.KeyEvent
import java.io.StringReader

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Interface
 *
 *   Fábio Luiz Fischer
 **/

class AppHandler : IAppHandler {
    val fileController = FileController()
    val robot = Robot()

    val APPLICATION_TEAM_MESSAGE = "Aplicativo desenvolvido pelos aluno Fábio Luiz Fischer para disciplina de Compiladores."

    override fun newFileRequest(root: MainScreen) {
        try {
            root.actualPath = null
            root.contentArea.text = ""
            root.consoleArea.text = ""
            root.isFileChanged = false

            root.contentArea.requestFocus()
        } catch (e: Exception) {
            root.showDialogMessage(Settings.APP_NAME, "Erro ao criar novo arquivo.", e.message!!, Alert.AlertType.ERROR)
        }
    }

    override fun openFileRequest(root: MainScreen) {
        try {
            val chooser = FileChooser()

            chooser.title = "Open File"
            chooser.extensionFilters.addAll(Settings.VALID_EXTENSIONS)

            val file = chooser.showOpenDialog(root.stage)

            if (file != null) {
                root.actualPath = file.toPath()
                root.contentArea.text = fileController.getContent(fileController.getFileName(file.path.toString()), ".txt", Settings.APP_CHARSET)
                root.isFileChanged = false
                root.consoleArea.text = ""
            }

            root.contentArea.requestFocus()
        } catch (e: Exception) {
            root.showDialogMessage(Settings.APP_NAME, "Erro ao abrir arquivo.", e.message!!, Alert.AlertType.ERROR)
        }
    }

    override fun saveFileRequest(root: MainScreen): Boolean {
        try {
            if (root.actualPath == null) {
                val chooser = FileChooser()

                chooser.title = "Save File"
                chooser.extensionFilters.addAll(Settings.VALID_EXTENSIONS)

                val file = chooser.showSaveDialog(root.stage)

                if (file != null) {
                    fileController.new(fileController.getFileName(file.path.toString()), ".txt", root.contentArea.text, false)
                    root.actualPath = file.toPath()
                    root.isFileChanged = false
                    root.consoleArea.text = ""
                    root.contentArea.requestFocus()
                    return true
                }
            } else {
                fileController.save(fileController.getFileName(root.actualPath.toString()), ".txt", root.contentArea.text)
                root.isFileChanged = false
                root.consoleArea.text = ""
                root.contentArea.requestFocus()
                return true
            }
        } catch (e: Exception) {
            root.showDialogMessage(Settings.APP_NAME, "Erro ao salvar arquivo.", e.message!!, Alert.AlertType.ERROR)
        }
        return false
    }

    override fun copyTextRequest(root: MainScreen) {
        try {
            root.contentArea.requestFocus()
            pressKeyCombination(KeyEvent.VK_CONTROL, KeyEvent.VK_C)
        } catch (e: Exception) {
            root.showDialogMessage(Settings.APP_NAME, "Erro ao copiar texto selecionado.", e.message!!, Alert.AlertType.ERROR)
        }
    }

    override fun pasteTextRequest(root: MainScreen) {
        try {
            root.contentArea.requestFocus()
            pressKeyCombination(KeyEvent.VK_CONTROL, KeyEvent.VK_V)
            root.isFileChanged = true
        } catch (e: Exception) {
            root.showDialogMessage(Settings.APP_NAME, "Erro ao colar texto selecionado.", e.message!!, Alert.AlertType.ERROR)
        }
    }

    override fun cutTextRequest(root: MainScreen) {
        try {
            root.contentArea.requestFocus()
            pressKeyCombination(KeyEvent.VK_CONTROL, KeyEvent.VK_X)
        } catch (e: Exception) {
            root.showDialogMessage(Settings.APP_NAME, "Erro ao cortar texto selecionado.", e.message!!, Alert.AlertType.ERROR)
        }
    }

    override fun buildProjectRequest(root: MainScreen) {
        try {
            root.writeConsole("compilação de programas ainda não foi implementada\n", true)
            /*
            if (root.contentArea.text.isNullOrEmpty()) {
                root.writeConsole("nenhum programa para compilar na área reservada para mensagens.")
            } else {
                root.writeConsole("programa compilado com sucesso\n", true)
            }
            */
        } catch (e: Exception) {
            println(e.printStackTrace())
            root.showDialogMessage(Settings.APP_NAME, "Erro ao compilar programa.", e.message!!, Alert.AlertType.ERROR)
        }
        root.contentArea.requestFocus()
    }

    override fun applicationTeamRequest(root: MainScreen) {
        try {
            root.writeConsole(APPLICATION_TEAM_MESSAGE)
            root.contentArea.requestFocus()
        } catch (e: Exception) {
            root.showDialogMessage(Settings.APP_NAME, "Erro ao cortar texto selecionado.", e.message!!, Alert.AlertType.ERROR)
        }
    }

    override fun closeAppRequest(root: MainScreen) {
        if (root.isFileChanged) {
            when (root.showDialogOptions(Settings.APP_NAME, "Arquivo ${if (root.actualPath != null) root.actualPath.toString() + " " else ""}foi modificado, deseja salvar as alterações?", "Suas mudanças serão perdidas se você não salva-las.", Alert.AlertType.WARNING)) {
                ButtonType.YES -> {
                    if (saveFileRequest(root)) WindowEvent.WINDOW_CLOSE_REQUEST
                }
                ButtonType.NO -> {
                    WindowEvent.WINDOW_CLOSE_REQUEST
                }
            }
        }
    }

    private fun pressKeyCombination(key1: Int, key2: Int) {
        robot.keyPress(key1)
        robot.keyPress(key2)
        robot.keyRelease(key1)
        robot.keyRelease(key2)
    }

    private fun getLine(root: MainScreen, position: Int): Int {
        var aux = position
        var line: Int = 1

        for (c in root.contentArea.text.toCharArray()) {
            if (c.toString() == "\n") line++
            if (aux == 0) return line
            aux--
        }
        return 0
    }
}