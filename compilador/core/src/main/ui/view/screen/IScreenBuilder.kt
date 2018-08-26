package ui.view.screen

import javafx.scene.Scene
import javafx.stage.Stage

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Interface
 *
 *   Fábio Luiz Fischer & Matheus Felipe Klauberg
 **/

interface IScreenBuilder {
    fun initComponents(primaryStage: Stage)
    fun initScene(): Scene
}