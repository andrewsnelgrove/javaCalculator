package com.andrewsnelgrove;

import javax.swing.*;
import java.awt.*;

public class javaCalculatorGUI extends JFrame {
    private JRadioButton decimalOptionButton;
    private JRadioButton octalOptionButton;
    private JRadioButton hexadecimalOptionButton;

    private JTextArea screenArea;

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


        createNumbersPanel();
        createOperationsPanel();







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
        //TODO Start here




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
    }

}
