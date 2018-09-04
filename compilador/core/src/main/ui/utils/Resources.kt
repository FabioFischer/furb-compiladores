package ui.utils

import javafx.scene.image.Image
import java.net.URI
import java.nio.file.Paths

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Interface
 *
 *   Fábio Luiz Fischer
 **/

object Resources {
    /*
    val newFile: Image = Image("res/icon/gallery/new.png")
    val openFile: Image = Image("res/icon/gallery/open.png")
    val saveFile: Image = Image("res/icon/gallery/save.png")
    val copyText: Image = Image("res/icon/gallery/copy.png")
    val pasteText: Image = Image("res/icon/gallery/paste.png")
    val cutText: Image = Image("res/icon/gallery/cut.png")
    val buildProject: Image = Image("res/icon/gallery/build.png")
    val appTeam: Image = Image("res/icon/gallery/team.png")

    */
    fun getStyleSheets():List<String> {
        return listOf(Resources::class.java.getResource("style/text-area.css").toExternalForm())
    }
}