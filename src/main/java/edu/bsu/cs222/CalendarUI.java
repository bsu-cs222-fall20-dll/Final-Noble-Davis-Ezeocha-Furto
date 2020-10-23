package edu.bsu.cs222;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CalendarUI extends Application {

    GridPane calendar = new GridPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox parent = createCalendar();
        parent.setAlignment(Pos.TOP_CENTER);

        primaryStage.setScene(new Scene(parent));
        primaryStage.setHeight(300);
        primaryStage.setWidth(400);
        primaryStage.show();
    }

    private VBox createCalendar() {
        Label month = new Label("July");
        calendar.addColumn(3);
        calendar.addRow(1);
        Button button = createDayButton();
        return new VBox(month,button);
    }

    private Button createDayButton() {
        Button first = new Button("Day 1");
        first.setOnAction(event -> {
        });
        return first;
    }
}
