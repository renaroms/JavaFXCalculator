package com.renaro;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Calculator calculator = new Calculator();
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(calculator.getScene());
        primaryStage.show();
    }
}
