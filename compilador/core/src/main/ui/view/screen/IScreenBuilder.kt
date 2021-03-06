package ui.view.screen

import javafx.scene.Scene
import javafx.stage.Stage

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Sintatico
 *
 *   Fábio Luiz Fischer
 **/

interface IScreenBuilder {
    fun initComponents(primaryStage: Stage)
    fun initScene(): Scene
}