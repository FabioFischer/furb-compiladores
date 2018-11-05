package ui.view

import javafx.application.Application
import ui.view.screen.impl.MainScreen
import javax.swing.JOptionPane

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Sintatico
 *
 *   Fábio Luiz Fischer
*/
/*

object App {
    @JvmStatic fun main(args: Array<String>) {
        try {
            Application.launch(MainScreen::class.java)
        } catch(e: Exception) {
            print(e);
            JOptionPane.showMessageDialog(null, e.message + " - " + e.stackTrace);
        }
    }
}
 **/

// Para gerar arquivo .jar, deve-se utilizar a função 'main' abaixo
fun main(args: Array<String>) {
    try {
        Application.launch(MainScreen::class.java)
    } catch(e: Exception) {
        print(e);
        JOptionPane.showMessageDialog(null, e.message + " - " + e.stackTrace);
    }
}