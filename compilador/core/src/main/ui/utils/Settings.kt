package ui.utils

import javafx.stage.FileChooser

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Interface
 *
 *   Fábio Luiz Fischer
 **/

object Settings {
    val APP_NAME = "Compiladores - Léxico"
    val MIN_SCREEN_SIZE = ScreenSize(630.0, 930.0)
    val VALID_EXTENSIONS = listOf(FileChooser.ExtensionFilter("Documentos de Texto (*.txt)", "*.txt"))
    val APP_CHARSET = Charsets.UTF_8
}