package sample

import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage

class StartUp : Application() {

  @Throws(Exception::class)
  override fun start(primaryStage: Stage) {
    val mainScreen = MainScreen()
    val logic = Logic(mainScreen)
    Engine(mainScreen, logic)

    val scene = Scene(mainScreen, 800.0, 600.0)

    primaryStage.title = "GeneticT1"
    primaryStage.scene = scene
    primaryStage.isMaximized = true
    primaryStage.show()
  }
}
