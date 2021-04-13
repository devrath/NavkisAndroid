package com.demo.code

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var inputFieldId: EditText
    lateinit var numZeroId: Button
    lateinit var numOneId: Button
    lateinit var numTwoId: Button
    lateinit var numThreeId: Button
    lateinit var numFourId: Button
    lateinit var numFiveId: Button
    lateinit var numSixId: Button
    lateinit var numSevenId: Button
    lateinit var numEightId: Button
    lateinit var numNineId: Button
    lateinit var plusId: Button
    lateinit var minusId: Button
    lateinit var multiplicationId: Button
    lateinit var divisionId: Button
    lateinit var equalsId: Button
    lateinit var dotId: Button
    lateinit var clearId: Button

    var leftHandSide : Double = 0.0
    var rightHandSide : Double = 0.0

    internal enum class Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }

    private var currentOperation: Operation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewsForTheScreen()
        setOnclickListeners()
    }

    private fun findViewsForTheScreen() {
        // Numbers
        inputFieldId = findViewById(R.id.inputFieldId)
        numZeroId = findViewById(R.id.numZeroId)
        numOneId = findViewById(R.id.numOneId)
        numTwoId = findViewById(R.id.numTwoId)
        numThreeId = findViewById(R.id.numThreeId)
        numFourId = findViewById(R.id.numFourId)
        numFiveId = findViewById(R.id.numFiveId)
        numSixId = findViewById(R.id.numSixId)
        numSevenId = findViewById(R.id.numSevenId)
        numEightId = findViewById(R.id.numEightId)
        numNineId = findViewById(R.id.numNineId)
        // Operation
        plusId = findViewById(R.id.plusId)
        minusId = findViewById(R.id.minusId)
        multiplicationId = findViewById(R.id.multiplicationId)
        divisionId = findViewById(R.id.divisionId)
        equalsId = findViewById(R.id.equalsId)
        dotId = findViewById(R.id.dotId)
        clearId = findViewById(R.id.clearId)
    }

    private fun setOnclickListeners() {
        plusId.setOnClickListener {
            // Operator Plus Field
            selectOperation(Operation.ADD)
        }
        minusId.setOnClickListener {
            // Operator Minus Field
            selectOperation(Operation.SUBTRACT)
        }
        multiplicationId.setOnClickListener {
            // Operator Multiplication Field
            selectOperation(Operation.MULTIPLY)
        }
        divisionId.setOnClickListener {
            // Operator Division Field
            selectOperation(Operation.DIVIDE)
        }
        equalsId.setOnClickListener {
            // Operator Equals Field
            performEvaluation()
        }
        dotId.setOnClickListener {
            // Operator Dot Field
            inputFieldId.append(".")
        }
        clearId.setOnClickListener {
            // Operator Clear Field
            resetCalculator()
        }
        numZeroId.setOnClickListener {
            // Button Number Zero
            inputFieldId.append("0")
        }
        numOneId.setOnClickListener {
            // Button Number One
            inputFieldId.append("1")
        }
        numTwoId.setOnClickListener {
            // Button Number Two
            inputFieldId.append("2")
        }
        numThreeId.setOnClickListener {
            // Button Number Three
            inputFieldId.append("3")
        }
        numFourId.setOnClickListener {
            // Button Number Four
            inputFieldId.append("4")
        }
        numFiveId.setOnClickListener {
            // Button Number Five
            inputFieldId.append("5")
        }
        numSixId.setOnClickListener {
            // Button Number Six
            inputFieldId.append("6")
        }
        numSevenId.setOnClickListener {
            // Button Number Seven
            inputFieldId.append("7")
        }
        numEightId.setOnClickListener {
            // Button Number Eight
            inputFieldId.append("8")
        }
        numNineId.setOnClickListener {
            // Button Number Nine
            inputFieldId.append("9")
        }
    }

    private fun resetCalculator() {
        inputFieldId.setText("")
        leftHandSide = 0.0
        rightHandSide = 0.0
    }

    private fun performEvaluation() {

        // Set the value for left hand side of the expression
        val input = inputFieldId.text.toString()
        rightHandSide = input.toDouble()
        var result = 0.0
        if (currentOperation == Operation.ADD) {
            // Addition
            result = leftHandSide + rightHandSide
        } else if (currentOperation == Operation.SUBTRACT) {
            // Subtraction
            result = leftHandSide - rightHandSide
        } else if (currentOperation == Operation.MULTIPLY) {
            // Multiplication
            result = leftHandSide * rightHandSide
        } else if (currentOperation == Operation.DIVIDE) {
            // DIVISION
            result = leftHandSide / rightHandSide
        }
        inputFieldId.setText("")
        inputFieldId.setText(result.toString())
    }

    private fun selectOperation(operation: Operation) {
        // Set the operation
        currentOperation = operation

        // Set the value for left hand side of the expression
        val input = inputFieldId.text.toString()
        input?.let {

        }
        leftHandSide = input.toDouble()

        // Clear the input field so user can enter the right hand side of expression
        inputFieldId.setText("")
    }
}