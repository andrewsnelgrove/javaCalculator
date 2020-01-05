package com.javaCalculatorPackage;

import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JavaCalculatorGUI extends JFrame {
    private static final Map<String, Integer> hexStringToIntegerMap = new HashMap<>();
    private static final Map<Integer, String> integerToHexString = new HashMap<>();

    private ButtonGroup radioButtonGroup;
    private JRadioButton decimalOptionButton;
    private JRadioButton octalOptionButton;
    private JRadioButton hexadecimalOptionButton;
    private JPanel radioButtonPanel;

    private JLabel screenField;

    private JButton[] numberButtonArray;

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

    private JButton[] operationButtonArray;

    private JButton addButton;
    private JButton subtractButton;
    private JButton multButton;
    private JButton divideButton;
    private JButton equalsButton;
    private JButton resetButton;

    private Container mainPane;
    private JPanel numbersPane;
    private JPanel operationsPane;

    private String currentEquation;
    private String firstNumber;
    private String secondNumber;
    private String operationSymbol;
    private String answer;

    private boolean addOp;
    private boolean subOp;
    private boolean multOp;
    private boolean divOp;
    private boolean equalsOp;

    private boolean isDeci;
    private boolean isOct;
    private boolean isHex;


    public JavaCalculatorGUI(){
        super();

        addOp = false;
        subOp = false;
        multOp = false;
        divOp = false;
        equalsOp = false;

        isDeci = false;
        isOct = false;
        isHex = false;

        currentEquation = "";
        firstNumber = "";
        secondNumber = "";
        answer = "";

        mainPane = getContentPane();
        mainPane.setLayout(new BorderLayout());

        setTitle("Calculator");
        setSize(900, 600);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        mapHexStringToInteger();
        mapIntegerToHexString();

        createScreenPanel();
        createNumbersPanel();
        createOperationsPanel();
        createRadioButtons();

        setVisible(true);
    }



    /* --------------------------------------------METHODS----------------------------------*/
    /* ----BUILDING THE GUI----------*/

    private void buttonToNumberAndDisplay(JButton aButton){
        currentEquation += aButton.getText();
        screenField.setText(String.valueOf(currentEquation));
    }
    private void createNumbersPanel(){
        numbersPane = new JPanel();
        numbersPane.setLayout(new GridLayout(4, 4));

        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");

        buttonA = new JButton("A");
        buttonB = new JButton("B");
        buttonC = new JButton("C");
        buttonD = new JButton("D");
        buttonE = new JButton("E");
        buttonF = new JButton("F");

        button0.addActionListener(e -> buttonToNumberAndDisplay(button0));
        button1.addActionListener(e -> buttonToNumberAndDisplay(button1));
        button2.addActionListener(e -> buttonToNumberAndDisplay(button2));
        button3.addActionListener(e -> buttonToNumberAndDisplay(button3));
        button4.addActionListener(e -> buttonToNumberAndDisplay(button4));
        button5.addActionListener(e -> buttonToNumberAndDisplay(button5));
        button6.addActionListener(e -> buttonToNumberAndDisplay(button6));
        button7.addActionListener(e -> buttonToNumberAndDisplay(button7));
        button8.addActionListener(e -> buttonToNumberAndDisplay(button8));
        button9.addActionListener(e -> buttonToNumberAndDisplay(button9));

        buttonA.addActionListener(e -> buttonToNumberAndDisplay(buttonA));
        buttonB.addActionListener(e -> buttonToNumberAndDisplay(buttonB));
        buttonC.addActionListener(e -> buttonToNumberAndDisplay(buttonC));
        buttonD.addActionListener(e -> buttonToNumberAndDisplay(buttonD));
        buttonE.addActionListener(e -> buttonToNumberAndDisplay(buttonE));
        buttonF.addActionListener(e -> buttonToNumberAndDisplay(buttonF));

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

        mainPane.add(numbersPane, BorderLayout.WEST);
    }

    private void createOperationsPanel(){
        operationsPane = new JPanel();
        operationsPane.setLayout(new GridLayout(3, 2));

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multButton = new JButton("X");
        divideButton = new JButton("/");
        equalsButton = new JButton("=");
        resetButton = new JButton("RESET");//THIS OK FOR SYMBOLS C?

        addButton.addActionListener(e -> {buttonToNumberAndDisplay(addButton); addOp = true;});
        subtractButton.addActionListener(e -> {buttonToNumberAndDisplay(subtractButton); subOp = true;});
        multButton.addActionListener(e -> {buttonToNumberAndDisplay(multButton); multOp = true;});
        divideButton.addActionListener(e -> {buttonToNumberAndDisplay(divideButton); divOp = true;});

        equalsButton.addActionListener(e -> {buttonToNumberAndDisplay(equalsButton); mathOperation();});
        resetButton.addActionListener(e -> resetOperation());

        operationButtonArray = new JButton[6];
        operationButtonArray[0] = addButton;
        operationButtonArray[1] = subtractButton;
        operationButtonArray[2] = multButton;
        operationButtonArray[3] = divideButton;
        operationButtonArray[4] = resetButton;
        operationButtonArray[5] = equalsButton;

        for (JButton btn : operationButtonArray){
            operationsPane.add(btn);
        }
        mainPane.add(operationsPane, BorderLayout.EAST);


    }
    private void createRadioButtons(){
        decimalOptionButton = new JRadioButton("Decimal");
        octalOptionButton = new JRadioButton("Octal");
        hexadecimalOptionButton = new JRadioButton("Hexadecimal");

        //TODO Double check if buttons say true if you click them again as radios, or if you click away.
        decimalOptionButton.addActionListener(e -> isDeci = true);
        octalOptionButton.addActionListener(e -> isOct = true);
        decimalOptionButton.addActionListener(e -> isHex = true);

        //TODO Review this part.
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(decimalOptionButton);
        radioButtonGroup.add(octalOptionButton);
        radioButtonGroup.add(hexadecimalOptionButton);

        radioButtonPanel = new JPanel();
        radioButtonPanel.add(decimalOptionButton);
        radioButtonPanel.add(octalOptionButton);
        radioButtonPanel.add(hexadecimalOptionButton);

        mainPane.add(radioButtonPanel, BorderLayout.CENTER);
    }

    private void createScreenPanel(){
        screenField = new JLabel();
        screenField.setText("   ");//So you can actually see it.
        screenField.setSize(400, 200);
        screenField.setOpaque(true);
        screenField.setBackground(Color.lightGray);



        mainPane.add(screenField, BorderLayout.NORTH);
    }
    private void displayAnswer(String theAnswer){
        currentEquation += (" " + theAnswer);
        screenField.setText(String.valueOf(currentEquation));
    }

    private void numberToScreen(String numberToDisplay){
        screenField.setText(numberToDisplay);
    }


    /* ------ MAPPING METHODS -----------*/
    private void mapIntegerToHexString(){
        integerToHexString.put(10, "A");
        integerToHexString.put(11, "B");
        integerToHexString.put(12, "C");
        integerToHexString.put(13, "D");
        integerToHexString.put(14, "E");
        integerToHexString.put(15, "F");
    }

    private void mapHexStringToInteger(){
        hexStringToIntegerMap.put("0", 0);
        hexStringToIntegerMap.put("1", 1);
        hexStringToIntegerMap.put("2", 2);
        hexStringToIntegerMap.put("3", 3);
        hexStringToIntegerMap.put("4", 4);
        hexStringToIntegerMap.put("5", 5);
        hexStringToIntegerMap.put("6", 6);
        hexStringToIntegerMap.put("7", 7);
        hexStringToIntegerMap.put("8", 8);
        hexStringToIntegerMap.put("9", 9);
        hexStringToIntegerMap.put("A", 10);
        hexStringToIntegerMap.put("B", 11);
        hexStringToIntegerMap.put("C", 12);
        hexStringToIntegerMap.put("D", 13);
        hexStringToIntegerMap.put("E", 14);
        hexStringToIntegerMap.put("F", 15);
    }


    /* -------------CONVERSIONS------------*/
    private String decimalToHexadecimal(int decimalNumber){ //Note that this returns the STRING, NOT INTEGER.
        //TODO To reduce code duplication, could make a general method for converting from decimal to any number.
        int numberToDivide = decimalNumber;
        int remainder = 0;
        ArrayList<String> octalNumberArrayBackwards = new ArrayList<String>();
        String stringNumToAdd = "";

        while (numberToDivide != 0) {
            remainder = numberToDivide % 16;
            octalNumberArrayBackwards.add(integerToHexString.get(remainder));
            numberToDivide = Math.floorDiv(numberToDivide, 16);
        }

        //Get octal number going backwards
        for (int i = (octalNumberArrayBackwards.size() - 1); i >= 0; i--) {
            stringNumToAdd += String.valueOf(octalNumberArrayBackwards.get(i));
        }

        return stringNumToAdd;
    }

    private int decimalToOctal(int decimalNumber) { //NOTE THAT THIS RETURNS INTEGER, NOT STRING.
        int numberToDivide = decimalNumber;
        int remainder = 0;
        ArrayList<Integer> octalNumberArrayBackwards = new ArrayList<Integer>();
        String stringNumToAdd = "";

        while (numberToDivide != 0) {
            remainder = numberToDivide % 8;
            octalNumberArrayBackwards.add(remainder);
            numberToDivide = Math.floorDiv(numberToDivide, 8);
        }

        //Get octal number going backwards
        for (int i = (octalNumberArrayBackwards.size() - 1); i >= 0; i--) {
            stringNumToAdd += String.valueOf(octalNumberArrayBackwards.get(i));
        }

        return Integer.parseInt(stringNumToAdd);
    }

    private int hexadecimalToDecimal(String hexNumberToConvert){
        int sumInDecimal = 0;
        int stringLength = hexNumberToConvert.length();
        for (int i=0; i < stringLength; i++){
            int numToMultply;
            String stringToCompare = String.valueOf(hexNumberToConvert.charAt(i));
            numToMultply = hexStringToIntegerMap.get(stringToCompare);
            sumInDecimal += ( numToMultply * (Math.pow(16,(stringLength - 1)) ) );
        }
        return sumInDecimal;
    }

    private int octalToDecimal(String numberToConvert){
        int integerDecimalAnswer = 0;
        int exponent = (numberToConvert.length() - 1);
        for (int i = 0; i < numberToConvert.length(); i++){
            integerDecimalAnswer += (Integer.parseInt(String.valueOf(numberToConvert.charAt(i)))) * (Math.pow(8, exponent));
        }
        return integerDecimalAnswer;
    }


    /* ----------------MATH OPERATIONS -------------------*/
    private void additionOperation(){
        //FIXME These need to return the answer in their original number type, not always decimal!
        int integerDecimalAnswer = 0;
        int answerForDisplay = 0;
        if (isDeci == true){
            //TODO I need to split and get the firstNumber and the secondNumber as integers.
            integerDecimalAnswer = Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
            answerForDisplay = integerDecimalAnswer;
        }
        else{
            if (isOct == true){
                integerDecimalAnswer = octalToDecimal(firstNumber) + octalToDecimal(secondNumber);
                answerForDisplay = decimalToOctal(integerDecimalAnswer);
            }
            else{
                if (isHex == true){
                    integerDecimalAnswer = hexadecimalToDecimal(firstNumber) + hexadecimalToDecimal(secondNumber);
                    answerForDisplay = Integer.parseInt(decimalToHexadecimal(integerDecimalAnswer));
                }
            }
        }
        answer = String.valueOf(answerForDisplay);
        displayAnswer(answer);
    }

    private void floorDivisionOperation(){
        //FIXME These need to return the answer in their original number type, not always decimal!
        int integerDecimalAnswer = 0;
        int answerForDisplay = 0;
        if (isDeci == true){
            integerDecimalAnswer = Math.floorDiv(Integer.parseInt(firstNumber), Integer.parseInt(secondNumber));
            answerForDisplay = integerDecimalAnswer;
        }
        else{
            if (isOct == true){
                integerDecimalAnswer = Math.floorDiv(octalToDecimal(firstNumber), octalToDecimal(secondNumber));
                answerForDisplay = decimalToOctal(integerDecimalAnswer);
            }
            else{
                if (isHex == true){
                    integerDecimalAnswer = Math.floorDiv(hexadecimalToDecimal(firstNumber), hexadecimalToDecimal(secondNumber));
                    answerForDisplay = Integer.valueOf(decimalToHexadecimal(integerDecimalAnswer));
                }
            }
        }
        answer = String.valueOf(answerForDisplay);
        displayAnswer(answer);
    }

    private void mathOperation(){
        //Get first number and second number
        currentEquation.replaceAll("\\s+", ""); //Cut out all potential whitespace in string.
        boolean opSymbolFound = false;
        while (opSymbolFound == false) {//TODO Bit clunky here, fix later.
            for (int i = 0; i < currentEquation.length(); i++) {

                    String stringSymbolToCheck = String.valueOf(currentEquation.charAt(i));
                    if (stringSymbolToCheck.equals("+") || stringSymbolToCheck.equals("-") || stringSymbolToCheck.equals("X") || stringSymbolToCheck.equals("/")) {
                        opSymbolFound = true;
                        firstNumber = currentEquation.substring(0, i);
                        secondNumber = currentEquation.substring((i + 1), (currentEquation.length() - 1));//Don't include the "=" at the end of this!
                }
            }
        }

        if (addOp == true){
            additionOperation();
        }
        else{
            if (subOp == true){
                subtractionOperation();
            }
            else{
                if (multOp == true){
                    multiplicationOperation();
                }
                else{
                    if (divOp == true){
                        floorDivisionOperation();
                    }
                }
            }
        }
    }

    private void multiplicationOperation(){
        int integerAnswer = 0;
        if (isDeci == true){
            integerAnswer = Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber);
        }
        else{
            if (isOct == true){
                integerAnswer = octalToDecimal(firstNumber) * octalToDecimal(secondNumber);
            }
            else{
                if (isHex == true){
                    integerAnswer = hexadecimalToDecimal(firstNumber) * hexadecimalToDecimal(secondNumber);
                }
            }
        }
        answer = String.valueOf(integerAnswer);
        displayAnswer(answer);
    }

    private void subtractionOperation(){
        int integerAnswer = 0;
        if (isDeci == true){
            integerAnswer = Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber);
        }
        else{
            if (isOct == true){
                integerAnswer = octalToDecimal(firstNumber) - octalToDecimal(secondNumber);
            }
            else{
                if (isHex == true){
                    integerAnswer = hexadecimalToDecimal(firstNumber) - hexadecimalToDecimal(secondNumber);
                }
            }
        }
        answer = String.valueOf(integerAnswer);
        displayAnswer(answer);
    }

    /* ----------------RESET OPERATION --------------------*/

    private void resetOperation(){
        //From constructor
        addOp = false;
        subOp = false;
        multOp = false;
        divOp = false;
        equalsOp = false;

        isDeci = false;
        isOct = false;
        isHex = false;

        currentEquation = "";
        firstNumber = "";
        secondNumber = "";
        answer = "";

        // TODO Will need to add clearing radio buttons here too.
        radioButtonGroup.clearSelection();

        screenField.setText(" ");
    }









}
