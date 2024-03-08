package com.renaro;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Calculator {
    
    private TextField displayField;
    private String currentInput;
    private double memoryValue;
    private char lastOperation;

    public Calculator(){
        this.displayField = new TextField();
        this.displayField.setEditable(false);
        this.displayField.setPrefColumnCount(15);
        this.currentInput = "";
        this.memoryValue = 0.0;
        this.lastOperation = ' ';
    }

    public Scene getScene(){
        
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };
        for(int i = 0; i < buttonLabels.length; i++){
            Button button = new Button(buttonLabels[i]);
            button.setOnAction(event -> handleButtonClick(button.getText()));
            gridPane.add(button, i % 4, i / 4);
        }
        gridPane.add(displayField, 0, 4, 4, 1);
        return new Scene(gridPane);
    }

    private void handleButtonClick(String buttonText){
        if(buttonText.equals("=")){
            calculate();
        }else{
            if(buttonText.matches("[0-9]|\\.")){
                currentInput += buttonText;
                displayField.setText(currentInput);
            }else{
                performOperation(buttonText.charAt(0));
            }
        }
    }

    private void performOperation(char operation){
        if(!currentInput.isEmpty()){
            memoryValue = Double.parseDouble(currentInput);
            currentInput = "";
            lastOperation = operation;
        }
    }

    private void calculate(){
        if(!currentInput.isEmpty()){
            double currentValue = Double.parseDouble(currentInput);
            switch(lastOperation){
                case '+':
                    memoryValue += currentValue;
                    break;
                case '-':
                    memoryValue -= currentValue;
                    break;
                case '*':
                    memoryValue *= currentValue;
                case '/':
                    if(currentValue != 0){
                        memoryValue /= currentValue;
                    }else{
                        displayField.setText("Error: Division by zero.");
                    }
                    break;
                default:
                    memoryValue = currentValue;
            }
            displayField.setText(String.valueOf(memoryValue));
            currentInput = "";
        }
    }
}
