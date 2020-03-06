package com.javaelementary;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.Random;

public class Ball {
    private static final int DIAMETER = 100;
    private GraphicsContext gc;
    private double x;
    private double y;
    private double xCenter;
    private double yCenter;
    private Random random = new Random();
    private double dx = random.nextInt(3) + 2;
    private double dy = random.nextInt(2) + 1;
    private List<Ball> balls;

    public Ball(List<Ball> balls, GraphicsContext gc, double x, double y) {
        this.balls = balls;
        this.gc = gc;
        this.x = x;
        this.y = y;
        xCenter = x + (DIAMETER / 2);
        yCenter = y + (DIAMETER / 2);
    }

    public double getXCenter() {
        return xCenter;
    }

    public double getYCenter() {
        return yCenter;
    }

    public void move() {
        if (x <= 0) {
            dx = Math.abs(dx);
        } else if (x + DIAMETER >= gc.getCanvas().getWidth()) {
            dx = -Math.abs(dx);
        }
        if (y <= 0) {
            dy = Math.abs(dy);
        } else if (y + DIAMETER >= gc.getCanvas().getHeight()) {
            dy = -Math.abs(dy);
        }
        for (Ball ball : balls) {
            double hypotenuse = Math.hypot(Math.abs(xCenter - ball.getXCenter()), Math.abs(yCenter - ball.getYCenter()));
            if (hypotenuse <= DIAMETER && hypotenuse != 0) {
                    dy = -dy;
                    dx = -dx;
            }
        }
        x += dx;
        y += dy;
        xCenter += dx;
        yCenter += dy;
    }

    public void draw() {
        gc.setFill(Color.RED);
        gc.fillOval(x, y, DIAMETER, DIAMETER);
    }
}