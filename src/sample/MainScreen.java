package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class MainScreen extends BorderPane {


    public static final double width = 1900;
    public static final double height = 1000;

    private GraphicsContext gtx;
    private Color bgColor = Color.rgb(0, 0, 0, 0.1);

    public MainScreen() {
        init();
    }

    private void init() {
        Canvas canvas = new Canvas();
        canvas.setWidth(width);
        canvas.setHeight(height);
        gtx = canvas.getGraphicsContext2D();
        this.setCenter(canvas);
    }

    public void clearScreen() {
        gtx.setFill(bgColor);
        gtx.fillRect(0, 0, width, height);
    }

    public GraphicsContext getGtx() {
        return gtx;
    }
}
