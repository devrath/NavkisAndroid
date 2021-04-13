package com.demo.code;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{

    private EditText inputFieldId;
    private Button numZeroId,numOneId,numTwoId,numThreeId,numFourId,numFiveId,numSixId,numSevenId,numEightId,numNineId;
    private Button plusId,minusId,multiplicationId,divisionId,equalsId,dotId,clearId;

    private double leftHandSide = 0.0;
    private double rightHandSide = 0.0;

    enum Operation { ADD, SUBTRACT, MULTIPLY, DIVIDE }

    private Operation currentOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewsForTheScreen();
        setOnclickListeners();
    }

    private void findViewsForTheScreen() {
        // Numbers
        inputFieldId = findViewById(R.id.inputFieldId);
        numZeroId = findViewById(R.id.numZeroId);
        numOneId = findViewById(R.id.numOneId);
        numTwoId = findViewById(R.id.numTwoId);
        numThreeId = findViewById(R.id.numThreeId);
        numFourId = findViewById(R.id.numFourId);
        numFiveId = findViewById(R.id.numFiveId);
        numSixId = findViewById(R.id.numSixId);
        numSevenId = findViewById(R.id.numSevenId);
        numEightId = findViewById(R.id.numEightId);
        numNineId = findViewById(R.id.numNineId);
        // Operation
        plusId = findViewById(R.id.plusId);
        minusId = findViewById(R.id.minusId);
        multiplicationId = findViewById(R.id.multiplicationId);
        divisionId = findViewById(R.id.divisionId);
        equalsId = findViewById(R.id.equalsId);
        dotId = findViewById(R.id.dotId);
        clearId = findViewById(R.id.clearId);
    }

    private void setOnclickListeners() {

        plusId.setOnClickListener(view -> {
            // Operator Plus Field
            selectOperation(Operation.ADD);
        });

        minusId.setOnClickListener(view -> {
            // Operator Minus Field
            selectOperation(Operation.SUBTRACT);
        });

        multiplicationId.setOnClickListener(view -> {
            // Operator Multiplication Field
            selectOperation(Operation.MULTIPLY);
        });

        divisionId.setOnClickListener(view -> {
            // Operator Division Field
            selectOperation(Operation.DIVIDE);
        });

        equalsId.setOnClickListener(view -> {
            // Operator Equals Field
            performEvaluation();
        });

        dotId.setOnClickListener(view -> {
            // Operator Dot Field
            inputFieldId.append(".");
        });

        clearId.setOnClickListener(view -> {
            // Operator Clear Field
           resetCalculator();
        });

        numZeroId.setOnClickListener(view -> {
            // Button Number Zero
            inputFieldId.append("0");
        });

        numOneId.setOnClickListener(view -> {
            // Button Number One
            inputFieldId.append("1");
        });

        numTwoId.setOnClickListener(view -> {
            // Button Number Two
            inputFieldId.append("2");
        });

        numThreeId.setOnClickListener(view -> {
            // Button Number Three
            inputFieldId.append("3");
        });

        numFourId.setOnClickListener(view -> {
            // Button Number Four
            inputFieldId.append("4");
        });

        numFiveId.setOnClickListener(view -> {
            // Button Number Five
            inputFieldId.append("5");
        });

        numSixId.setOnClickListener(view -> {
            // Button Number Six
            inputFieldId.append("6");
        });

        numSevenId.setOnClickListener(view -> {
            // Button Number Seven
            inputFieldId.append("7");
        });

        numEightId.setOnClickListener(view -> {
            // Button Number Eight
            inputFieldId.append("8");
        });

        numNineId.setOnClickListener(view -> {
            // Button Number Nine
            inputFieldId.append("9");
        });

    }

    private void resetCalculator() {
        inputFieldId.setText("");
        leftHandSide = 0.0;
        rightHandSide = 0.0;
    }

    private void performEvaluation() {

        // Set the value for left hand side of the expression
        String input =  inputFieldId.getText().toString();
        rightHandSide = Double.valueOf(input);

        double result = 0.0;

        if(currentOperation.equals(Operation.ADD)){
            // Addition
            result = leftHandSide + rightHandSide;
        }else if(currentOperation.equals(Operation.SUBTRACT)){
            // Subtraction
            result = leftHandSide - rightHandSide;
        }else if(currentOperation.equals(Operation.MULTIPLY)){
            // Multiplication
            result = leftHandSide * rightHandSide;
        }else if(currentOperation.equals(Operation.DIVIDE)){
            // DIVISION
            result = leftHandSide / rightHandSide;
        }

        inputFieldId.setText("");
        inputFieldId.setText(String.valueOf(result));
    }

    private void selectOperation(Operation operation) {
        // Set the operation
        currentOperation = operation;

        // Set the value for left hand side of the expression
        String input =  inputFieldId.getText().toString();
        leftHandSide = Double.parseDouble(input);

        // Clear the input field so user can enter the right hand side of expression
        inputFieldId.setText("");

    }


}