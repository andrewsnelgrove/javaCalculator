package com.andrewsnelgrove;

import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class javaCalculatorGUI extends JFrame {
    private static final Map<String, int> letterToIntegerMap = new HashMap<>();
    private JRadioButton decimalOptionButton;
    private JRadioButton octalOptionButton;
    private JRadioButton hexadecimalOptionButton;

    private JTextField screenField;

    JButton[] numberButtonArray;

    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton buttonA;
    private JButton buttonB;
    private JButton buttonC;
    private JButton buttonD;
    private JButton buttonE;
    private JButton buttonF;

    JButton[] operationButtonArray;

    private JButton addButton;
    private JButton subtractButton;
    private JButton multButton;
    private JButton divideButton;
    private JButton equalsButton;
    private JButton resetButton;

    private Container mainPane;
    private JPanel numbersPane;
    private JPanel operationsPane;

    private String currentNumber;
    private String firstNumber;
    private String secondNumber;

    public javaCalculatorGUI(){
        currentNumber = "";
        firstNumber = "";
        secondNumber = "";

        mainPane = getContentPane();
        mainPane.setLayout(new BorderLayout());

        mapLetterToInteger();
        mapIntegerToLetter();

        createScreenPanel();
        createNumbersPanel();
        createOperationsPanel();







    }

    private void mapLetterToInteger(){
        letterToIntegerMap.put("A", 10);
        letterToIntegerMap.put("B", 11);
        letterToIntegerMap.put("C", 12);
        letterToIntegerMap.put("D", 13);
        letterToIntegerMap.put("E", 14);
        letterToIntegerMap.put("F", 15);
    }
    private void createNumbersPanel(){
        numbersPane.setLayout(new GridLayout(4, 4));

        button0.setText("0");
        button1.setText("1");
        button2.setText("2");
        button3.setText("3");
        button4.setText("4");
        button5.setText("5");
        button6.setText("6");
        button7.setText("7");
        //TODO Start here again.
        button8.setText("8");
        button9.setText("9");

        buttonA.setText("A");
        buttonB.setText("B");
        buttonC.setText("C");
        buttonD.setText("D");
        buttonE.setText("E");
        buttonF.setText("F");

        button0.addActionListener(e -> buttonToNumber(button0));
        button1.addActionListener(e -> buttonToNumber(button1));
        button2.addActionListener(e -> buttonToNumber(button2));
        button3.addActionListener(e -> buttonToNumber(button3));
        button4.addActionListener(e -> buttonToNumber(button4));
        button5.addActionListener(e -> buttonToNumber(button5));
        button6.addActionListener(e -> buttonToNumber(button6));
        button7.addActionListener(e -> buttonToNumber(button7));
        button8.addActionListener(e -> buttonToNumber(button8));
        button9.addActionListener(e -> buttonToNumber(button9));

        buttonA.addActionListener(e -> buttonToNumber(buttonA));
        buttonB.addActionListener(e -> buttonToNumber(buttonB));
        buttonC.addActionListener(e -> buttonToNumber(buttonC));
        buttonD.addActionListener(e -> buttonToNumber(buttonD));
        buttonE.addActionListener(e -> buttonToNumber(buttonE));
        buttonF.addActionListener(e -> buttonToNumber(buttonF));

        numberButtonArray = new JButton[16];
        numberButtonArray[0] = button0;
        numberButtonArray[1] = button1;
        numberButtonArray[2] = button2;
        numberButtonArray[3] = button3;
        numberButtonArray[4] = button4;
        numberButtonArray[5] = button5;
        numberButtonArray[6] = button6;
        numberButtonArray[7] = button7;
        numberButtonArray[8] = button8;
        numberButtonArray[9] = button9;
        numberButtonArray[10] = buttonA;
        numberButtonArray[11] = buttonB;
        numberButtonArray[12] = buttonC;
        numberButtonArray[13] = buttonD;
        numberButtonArray[14] = buttonE;
        numberButtonArray[15] = buttonF;

        for (JButton btn : numberButtonArray){
            numbersPane.add(btn);
        }

        mainPane.add(numbersPane, BorderLayout.EAST);
    }

    private void buttonToNumber(JButton aButton){
        currentNumber += aButton.getText();
    }

    private void createOperationsPanel(){
        operationsPane.setLayout(new GridLayout(3, 2));

        addButton.setText("+");
        subtractButton.setText("-");
        multButton.setText("X");
        divideButton.setText("/");
        resetButton.setText("RESET");//THIS OK FOR SYMBOLS C?

        addButton.addActionListener(e -> additionOperation());
        subtractButton.addActionListener(e -> subtractionOperation());
        multButton.addActionListener(e -> multiplicationOperation());
        divideButton.addActionListener(e -> divisionOperation());
        resetButton.addActionListener(e -> resetOperation());

        operationButtonArray = new JButton[5];
        operationButtonArray[0] = addButton;
        operationButtonArray[1] = subtractButton;
        operationButtonArray[2] = multButton;
        operationButtonArray[3] = divideButton;
        operationButtonArray[4] = resetButton;

        for (JButton btn : operationButtonArray){
            operationsPane.add(btn);
        }
        mainPane.add(operationsPane, BorderLayout.WEST);


    }

    private void additionOperation(){

    }

    private void subtractionOperation(){

    }
    private void multiplicationOperation(){

    }
    private void divisionOperation(){

    }

    private void resetOperation(){

    }

    private void createScreenPanel(){
        screenField = new JTextField(20);
        screenField.setText("");

        mainPane.add(screenField, BorderLayout.NORTH);
    }

    private void numberToScreen(String numberToDisplay){
        screenField.setText(numberToDisplay);
    }

    private Integer octalToDecimal(String numberToConvert){
        return Integer.parseInt(numberToConvert);
    }

    private int hexaDecimalToDecimal(String hexNumberToConvert){
        int sumInDecimal = 0;
        int stringLength = hexNumberToConvert.length();
        for (int i=0; i < stringLength; i++){
            sumInDecimal += (Math.pow(16,(stringLength - 1));
        }
    }

}
