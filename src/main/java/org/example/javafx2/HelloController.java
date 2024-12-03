package org.example.javafx2;

import exceptions.InvalidLength;
import exceptions.InvalidRadiusValue;
import geometry2d.Circle;
import geometry2d.Figure;
import geometry2d.Rectangle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HelloController {
    @FXML
    private Canvas canvas = new Canvas();
    private final List<Figure> figures = new ArrayList<>();

    //private  List<String> colors = Arrays.asList("Красный", "Зеленый", "Голубой", "Желтый", "Черный", "Розовый", "Серый");

    @FXML
    private void drawCircle() throws InvalidRadiusValue {
        Random random = new Random();
        double x = random.nextDouble() * canvas.getWidth();
        double y = random.nextDouble() * canvas.getHeight();
        double radius = 20 + random.nextDouble() * 50;
        //String color = colors.get(random.nextInt(colors.size()));
        Color color = Color.color(random.nextDouble(), random.nextDouble(), random.nextDouble());

        //System.out.println(color);
        figures.add(new Circle(radius, x, y, color));
        redraw();
    }
    @FXML
    private void drawRectangle() throws InvalidLength {
        Random random = new Random();
        double x = random.nextDouble() * canvas.getWidth();
        double y = random.nextDouble() * canvas.getHeight();
        double width = 10 + random.nextDouble() * 91;
        double length = 10 + random.nextDouble() * 91;
        Color color = Color.color(random.nextDouble(), random.nextDouble(), random.nextDouble());
        figures.add(new Rectangle(length, width, x,y, color));
        redraw();
    }
    @FXML
    private void clear() {
        figures.clear();
        redraw();
    }

    private void redraw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (Figure figure : figures) {
            System.out.println("redraw");
            figure.draw(gc);
        }
    }
}