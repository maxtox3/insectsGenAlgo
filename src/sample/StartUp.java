package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartUp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainScreen mainScreen = new MainScreen();
        Logic logic = new Logic(mainScreen);
        Engine engine = new Engine(mainScreen, logic);

        Scene scene = new Scene(mainScreen, 800, 600);

        primaryStage.setTitle("GeneticT1");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
