package com.javaelementary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*
1) Нарисовать простую сцену - домик, солнце
*/

public class Task1 extends Application {

    private static final int BOARD_WIDTH = 800;
    private static final int BOARD_HEIGHT = 500;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Home, sweet home...");
        Canvas canvas = new Canvas();
        canvas.setWidth(BOARD_WIDTH);
        canvas.setHeight(BOARD_HEIGHT);
        BorderPane group = new BorderPane(canvas);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();

        GraphicsContext gc = canvas.getGraphicsContext2D();
        test(gc);
    }

    private void test(GraphicsContext gc) {
        gc.setLineWidth(5);
        gc.setFill(Color.LIGHTSKYBLUE);
        gc.fillRoundRect(0, 0, 800, 500, 0, 0);
        gc.setFill(Color.GREEN);
        gc.fillRoundRect(0, 400, 800, 100, 0, 0);
        gc.setFill(Color.WHITE);
        gc.fillRoundRect(300, 200, 200, 200, 0, 0);
        gc.setFill(Color.LIGHTSKYBLUE);
        gc.fillRoundRect(325, 225, 50, 50, 0, 0);
        gc.fillRoundRect(425, 225, 50, 50, 0, 0);
        gc.setFill(Color.BROWN);
        gc.fillRoundRect(375, 325, 50, 75, 0, 0);
        gc.setFill(Color.RED);
        gc.fillPolygon(new double[]{250, 400, 550}, new double[]{200, 150, 200}, 3);
        gc.setFill(Color.WHITE);
        gc.fillOval(650, 60, 70, 70);
        gc.setFill(Color.YELLOW);
        gc.fillOval(700, 50, 80, 80);
        gc.setFill(Color.WHITE);
        gc.fillOval(600, 75, 125, 50);
        gc.fillOval(660, 100, 100, 60);
        gc.setStroke(Color.BROWN);
        gc.strokeLine(100, 400, 100, 410);
        gc.strokeLine(200, 400, 200, 410);
        gc.setFill(Color.GREEN);
        gc.fillOval(75, 150, 50, 250);
        gc.fillOval(175, 150, 50, 250);
    }
}