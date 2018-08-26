package ui.view.screen.impl

import javafx.geometry.NodeOrientation
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import javafx.scene.image.ImageView
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyCodeCombination
import javafx.scene.input.KeyCombination
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.TextAlignment
import javafx.stage.Stage
import ui.utils.ButtonBar
import ui.utils.Resources
import ui.utils.Settings
import ui.view.handler.impl.AppHandler
import ui.view.listener.AppListener
import java.nio.file.Path

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Interface
 *
 *   Fábio Luiz Fischer & Matheus Felipe Klauberg
 **/

class MainScreen : AbstractScreen(Settings.MIN_SCREEN_SIZE, Settings.APP_NAME) {
    val UPPER_BAR_WIDTH = 910.0
    val UPPER_BAR_HEIGHT = 65.0
    val CONSOLE_HEIGHT = 100.0
    val STATUS_BAR_HEIGHT = 25.0
    val STATUS_BAR_WIDTH = 100.0
    val LINE_NUMBER_WIDTH = 42.0

    private val pane = BorderPane()

    private val upperBox = ButtonBar(UPPER_BAR_WIDTH, 2.0)
    private val bottomBox = VBox()
    private val statusBox = HBox()

    private val newFileButton = Button()
    private val openFileButton = Button()
    private val saveFileButton = Button()
    private val copyTextButton = Button()
    private val pasteTextButton = Button()
    private val cutTextButton = Button()
    private val buildProjectButton = Button()
    private val appTeam = Button()

    private val statusLabel = Label()
    private val filePathLabel = Label()

    val contentArea = TextArea()
    val lineNumberArea = TextArea("1")
    val consoleArea = TextArea()

    val fileHandler = AppHandler()

    var isFileChanged = false
        set(isChanged) {
            field = isChanged
            statusLabel.text = if (isChanged) "Modificado" else "Não Modificado"
        }
    var actualPath: Path? = null
        set(path) {
            field = path
            filePathLabel.text = if (path != null) "$path" else ""
        }

    fun writeConsole(content: String, override: Boolean = false) {
        write(consoleArea, "\n$content", override)
    }

    override fun start(primaryStage: Stage) {
        stage = primaryStage
        initComponents(primaryStage)

        primaryStage.scene = initScene()
        primaryStage.title = screenName
        primaryStage.minHeight = screenSize.x
        primaryStage.minWidth = screenSize.y

        primaryStage.show()
    }

    @Suppress("NON_EXHAUSTIVE_WHEN")
    override fun initScene(): Scene {
        pane.top = upperBox
        pane.left = lineNumberArea
        pane.center = contentArea
        pane.bottom = bottomBox

        val scene = Scene(pane, screenSize.x, screenSize.y)

        scene.setOnKeyPressed { event ->
            when (event.code) {
                KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_ANY).code -> fileHandler.newFileRequest(this)
                KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_ANY).code -> fileHandler.openFileRequest(this)
                KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_ANY).code -> fileHandler.saveFileRequest(this)
                KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_ANY).code -> fileHandler.copyTextRequest(this)
                KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_ANY).code -> fileHandler.pasteTextRequest(this)
                KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_ANY).code -> fileHandler.cutTextRequest(this)
                KeyCode.F8 -> fileHandler.buildProjectRequest(this)
                KeyCode.F1 -> fileHandler.applicationTeamRequest(this)
            }
        }

        for (styleSheet in Resources.getStyleSheets()) {
            scene.stylesheets.add(styleSheet)
        }

        pane.prefHeightProperty().bind(scene.heightProperty())
        pane.prefWidthProperty().bind(scene.widthProperty())

        return scene
    }

    override fun initComponents(primaryStage: Stage) {
        primaryStage.setOnCloseRequest { fileHandler.closeAppRequest(this) }

        initLabel(statusLabel, "Não modificado", TextAlignment.LEFT, STATUS_BAR_WIDTH, STATUS_BAR_HEIGHT)
        initLabel(filePathLabel, "", TextAlignment.RIGHT, STATUS_BAR_WIDTH, STATUS_BAR_HEIGHT)

        initTextAreas()
        initButtons()
        initBoxes()

        linkListeners()
        linkHandlers()
    }

    private fun initTextAreas() {
        initTextArea(lineNumberArea, LINE_NUMBER_WIDTH, pane.height, false, true)
        initTextArea(consoleArea, pane.width, CONSOLE_HEIGHT, false)
        initTextArea(contentArea, pane.width, pane.height)

        lineNumberArea.nodeOrientation = NodeOrientation.RIGHT_TO_LEFT
    }

    private fun initBoxes() {
        upperBox.addAll(newFileButton, openFileButton, saveFileButton, copyTextButton, pasteTextButton, cutTextButton, buildProjectButton, appTeam)
        initHBox(statusBox, 5.0, statusLabel, filePathLabel)
        initVBox(bottomBox, 1.0, consoleArea, statusBox)
    }

    private fun initButtons() {
        try {
            initButton(newFileButton, "Novo [Ctrl+N)", ImageView(Resources.newFile), UPPER_BAR_HEIGHT)
            initButton(openFileButton, "Abrir [Ctrl+O)", ImageView(Resources.openFile), UPPER_BAR_HEIGHT)
            initButton(saveFileButton, "Salvar [Ctrl+S)", ImageView(Resources.saveFile), UPPER_BAR_HEIGHT)
            initButton(copyTextButton, "Copiar [Ctrl+C)", ImageView(Resources.copyText), UPPER_BAR_HEIGHT)
            initButton(pasteTextButton, "Colar [Ctrl+V)", ImageView(Resources.pasteText), UPPER_BAR_HEIGHT)
            initButton(cutTextButton, "Cortar [Ctrl+X]", ImageView(Resources.cutText), UPPER_BAR_HEIGHT)
            initButton(buildProjectButton, "Compilar [F8]", ImageView(Resources.buildProject), UPPER_BAR_HEIGHT)
            initButton(appTeam, "Equipe [F1]", ImageView(Resources.appTeam), UPPER_BAR_HEIGHT)
        } catch (e: NoSuchFileException) {
            println(e.printStackTrace())
        }
    }

    private fun linkHandlers() {
        newFileButton.setOnAction { fileHandler.newFileRequest(this) }
        openFileButton.setOnAction { fileHandler.openFileRequest(this) }
        saveFileButton.setOnAction { fileHandler.saveFileRequest(this) }
        copyTextButton.setOnAction { fileHandler.copyTextRequest(this) }
        pasteTextButton.setOnAction { fileHandler.pasteTextRequest(this) }
        cutTextButton.setOnAction { fileHandler.cutTextRequest(this) }
        buildProjectButton.setOnAction { fileHandler.buildProjectRequest(this) }
        appTeam.setOnAction { fileHandler.applicationTeamRequest(this) }
    }

    private fun linkListeners() {
        contentArea.textProperty().addListener(AppListener.listen(this))
    }
}