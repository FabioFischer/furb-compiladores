package ui.controller

import java.nio.charset.Charset
import java.nio.file.Path

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Interface
 *
 *   Fábio Luiz Fischer & Matheus Felipe Klauberg
 **/

interface IFileController {
    fun new(path: String, extension: String, fileContent: String, override: Boolean)
    fun save(path: String, extension: String, fileContent: String)
    fun saveAs(path: String, extension: String, fileContent: String, override: Boolean)
    fun getPath(path: String, extension: String): Path
    fun getContent(path: String, extension: String, charset: Charset): String
    fun getFileName(path: String): String
}