package com.javaelementary;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/*
2*) нарисовть шар который сам двигается и отбивается от краев экрана
*/

public class Ball extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, 800, 500, Color.WHITE);
        Circle ball = new Circle(50, Color.RED);
        ball.relocate(5, 5);
        canvas.getChildren().add(ball);
        stage.setTitle("Jumping Ball");
        stage.setScene(scene);
        stage.show();

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(30), new EventHandler<>() {
            double dx = 7;
            double dy = 3;

            @Override
            public void handle(ActionEvent actionEvent) {
                ball.setLayoutX(ball.getLayoutX() + dx);
                ball.setLayoutY(ball.getLayoutY() + dy);
                Bounds bounds = canvas.getBoundsInLocal();
                if (ball.getLayoutX() <= bounds.getMinX() + ball.getRadius()
                        || ball.getLayoutX() >= bounds.getMaxX() - ball.getRadius()) {
                    dx = -dx;
                }
                if (ball.getLayoutY() >= bounds.getMaxY() - ball.getRadius()
                        || ball.getLayoutY() <= bounds.getMinY() + ball.getRadius()) {
                    dy = -dy;
                }
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}