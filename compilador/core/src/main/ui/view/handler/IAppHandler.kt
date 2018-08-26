package ui.view.handler

import ui.view.screen.impl.MainScreen

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Interface
 *
 *   Fábio Luiz Fischer & Matheus Felipe Klauberg
 **/

interface IAppHandler {
    fun newFileRequest(root: MainScreen)
    fun openFileRequest(root: MainScreen)
    fun saveFileRequest(root: MainScreen): Boolean
    fun closeAppRequest(root: MainScreen)
    fun copyTextRequest(root: MainScreen)
    fun pasteTextRequest(root: MainScreen)
    fun cutTextRequest(root: MainScreen)
    fun buildProjectRequest(root: MainScreen)
    fun applicationTeamRequest(root: MainScreen)
}