package ui.controller.impl

import ui.controller.IFileController
import java.io.BufferedWriter
import java.io.FileNotFoundException
import java.io.FileWriter
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Semantico
 *
 *   Fábio Luiz Fischer
 **/

class FileController : IFileController {
    override fun new(path: String, extension: String, fileContent: String, override: Boolean) {
        val filePath: Path = getPath(path, extension)

        if (override.not())
            if (Files.exists(filePath))
                throw IllegalArgumentException("Arquivo ${filePath.fileName} ja existe. Sobrescrever?")

        BufferedWriter(FileWriter(filePath.toFile())).use {
            writer ->
            writer.write(fileContent)
        }
    }

    override fun save(path: String, extension: String, fileContent: String) {
        val filePath: Path = getPath(path, extension)

        if (!Files.exists(filePath))
            Files.createFile(filePath)

        BufferedWriter(FileWriter(filePath.toFile())).use {
            writer ->
            writer.write(fileContent)
        }
    }

    override fun saveAs(path: String, extension: String, fileContent: String, override: Boolean) {
        val filePath: Path = getPath(path, extension)

        if (override.not())
            if (Files.exists(filePath))
                throw IllegalArgumentException("Arquivo $path ja existe!")

        BufferedWriter(FileWriter(filePath.toFile())).use {
            writer ->
            writer.write(fileContent)
        }
    }

    override fun getPath(path: String, extension: String): Path = Paths.get(if (path.endsWith(extension)) path else "$path$extension")

    override fun getContent(path: String, extension: String, charset: Charset): String {
        val filePath = getPath(path, extension)

        if (Files.exists(filePath).not())
            throw FileNotFoundException("Arquivo ${filePath.fileName} não encontrado!")

        return filePath.toFile().readText(charset = charset)
    }

    override fun getFileName(path: String): String = Paths.get(path).toString().replace(".txt", "")
}