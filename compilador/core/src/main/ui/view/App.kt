package ui.view

import javafx.application.Application
import ui.view.screen.impl.MainScreen

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Interface
 *
 *   Fábio Luiz Fischer
 **/

object App {
    @JvmStatic fun main(args: Array<String>) {
        Application.launch(MainScreen::class.java)
    }
}

// Para gerar arquivo .jar, deve-se utilizar a função 'main' abaixo
//fun main(args: Array<String>) {
//    Application.launch(MainScreen::class.java)
//}