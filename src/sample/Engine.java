package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class Engine {

    private MainScreen mainScreen;
    private Logic logic;

    private Timeline gameLoop;

    public Engine(MainScreen mainScreen, Logic logic) {
        this.mainScreen = mainScreen;
        this.logic = logic;
        run();
    }

    private void run() {
        EventHandler<ActionEvent> gameUpdate = event -> {
            logic.update();
            logic.draw();
        };

        gameLoop = new Timeline(new KeyFrame(Duration.millis(20), gameUpdate));
        gameLoop.setCycleCount(Animation.INDEFINITE);
        gameLoop.play();
    }
}
