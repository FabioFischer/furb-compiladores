package ui.view.screen.impl

import javafx.geometry.NodeOrientation
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyCodeCombination
import javafx.scene.input.KeyCombination
import javafx.scene.input.KeyEvent
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
import javax.swing.JOptionPane
import java.nio.file.Path

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Sintatico
 *
 *   Fábio Luiz Fischer
 **/

class MainScreen : AbstractScreen(Settings.MIN_SCREEN_SIZE, Settings.APP_NAME) {
    val TOOL_BAR_WIDTH = 145.0
    val TOOL_BAR_HEIGHT = 590.0
    val CONSOLE_HEIGHT = 105.0
    val CONSOLE_WIDTH = 750.0
    val STATUS_BAR_HEIGHT = 25.0
    val STATUS_BAR_WIDTH = 100.0
    val LINE_NUMBER_WIDTH = 42.0
    val MIN_TEXT_CONTENT_WIDTH = 740.0

    private val pane = BorderPane()

    private val toolBox = ButtonBar(TOOL_BAR_HEIGHT, 2.0)
    private val contentBox = HBox()
    private val mainBox = VBox()
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
        primaryStage.minWidth = 900.0

        primaryStage.show()
    }

    @Suppress("NON_EXHAUSTIVE_WHEN")
    override fun initScene(): Scene {
        //pane.top = upperBox
        pane.left = toolBox
        pane.center = mainBox
        pane.bottom = statusBox

        val scene = Scene(pane, screenSize.x, screenSize.y)

        scene.setOnKeyPressed { event ->
            when (event.code) {
                KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_ANY).code -> fileHandler.newFileRequest(this)
                KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_ANY).code -> fileHandler.openFileRequest(this)
                KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_ANY).code -> fileHandler.saveFileRequest(this)
                KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_ANY).code -> fileHandler.copyTextRequest(this)
                KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_ANY).code -> fileHandler.pasteTextRequest(this)
                KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_ANY).code -> fileHandler.cutTextRequest(this)
            }
        }
        scene.addEventFilter(KeyEvent.KEY_PRESSED, { event ->
            when {
                KeyCode.F9 == event.code -> fileHandler.buildProjectRequest(this)
                KeyCode.F1 == event.code -> fileHandler.applicationTeamRequest(this)
            }
        })

        /**
         * Utilizar para build
         *
         */
        for (styleSheet in Resources.getStyleSheets()) {
            scene.stylesheets.add(styleSheet)
        }
        /**
        for (styleSheet in Resources.getStyleSheets()) {
            scene.stylesheets.add(styleSheet.toString())
        }
         *
         */

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
        initTextArea(lineNumberArea, LINE_NUMBER_WIDTH, screenSize.x, false, true)
        initTextArea(consoleArea, CONSOLE_WIDTH, CONSOLE_HEIGHT, false)
        initTextArea(contentArea, screenSize.y, screenSize.x)

        lineNumberArea.maxWidth = LINE_NUMBER_WIDTH
        lineNumberArea.nodeOrientation = NodeOrientation.RIGHT_TO_LEFT

        consoleArea.maxHeight = CONSOLE_HEIGHT
        contentArea.minWidth = MIN_TEXT_CONTENT_WIDTH
    }

    private fun initBoxes() {
        toolBox.addAll(newFileButton, openFileButton, saveFileButton, copyTextButton, pasteTextButton, cutTextButton, buildProjectButton, appTeam)
        initHBox(contentBox, 2.0, lineNumberArea, contentArea)
        contentArea.prefWidth = Double.MAX_VALUE
        contentBox.prefWidth = Double.MAX_VALUE
        initVBox(mainBox, 1.0, contentBox, consoleArea)
        initHBox(statusBox, 5.0, statusLabel, filePathLabel)
    }

    private fun initButtons() {
        try {
            initButton(newFileButton, "new [ctrl-n)", ImageView(Resources.newFile), TOOL_BAR_WIDTH)
            initButton(openFileButton, "open [ctrl-o)", ImageView(Resources.openFile), TOOL_BAR_WIDTH)
            initButton(saveFileButton, "save [ctrl-s)", ImageView(Resources.saveFile), TOOL_BAR_WIDTH)
            initButton(copyTextButton, "copy [ctrl-c)", ImageView(Resources.copyText), TOOL_BAR_WIDTH)
            initButton(pasteTextButton, "paste [ctrl-v)", ImageView(Resources.pasteText), TOOL_BAR_WIDTH)
            initButton(cutTextButton, "cut [ctrl-x]", ImageView(Resources.cutText), TOOL_BAR_WIDTH)
            initButton(buildProjectButton, "compile [F9]", ImageView(Resources.buildProject), TOOL_BAR_WIDTH)
            initButton(appTeam, "about [F1]", ImageView(Resources.appTeam), TOOL_BAR_WIDTH)
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