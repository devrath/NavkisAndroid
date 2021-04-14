package com.demo.code

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.demo.code.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var leftHandSide : Double = 0.0
    var rightHandSide : Double = 0.0

    internal enum class Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }

    private var currentOperation: Operation? = null

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnclickListeners()
    }

    private fun setOnclickListeners() {
        binding.apply {
            plusId.setOnClickListener { selectOperation(Operation.ADD) }
            minusId.setOnClickListener { selectOperation(Operation.SUBTRACT) }
            multiplicationId.setOnClickListener { selectOperation(Operation.MULTIPLY) }
            divisionId.setOnClickListener { selectOperation(Operation.DIVIDE) }
            equalsId.setOnClickListener { performEvaluation() }
            dotId.setOnClickListener { inputFieldId.append(".") }
            clearId.setOnClickListener { resetCalculator() }
            numZeroId.setOnClickListener { inputFieldId.append("0") }
            numOneId.setOnClickListener { inputFieldId.append("1") }
            numTwoId.setOnClickListener { inputFieldId.append("2") }
            numThreeId.setOnClickListener { inputFieldId.append("3") }
            numFourId.setOnClickListener { inputFieldId.append("4") }
            numFiveId.setOnClickListener { inputFieldId.append("5") }
            numSixId.setOnClickListener { inputFieldId.append("6") }
            numSevenId.setOnClickListener { inputFieldId.append("7") }
            numEightId.setOnClickListener { inputFieldId.append("8") }
            numNineId.setOnClickListener { inputFieldId.append("9") }
        }
    }

    private fun resetCalculator() {
        binding.inputFieldId.setText("")
        leftHandSide = 0.0
        rightHandSide = 0.0
    }

    private fun performEvaluation() {
        val input = binding.inputFieldId.text.toString()
        rightHandSide = input.toDouble()
        var result = 0.0
        when (currentOperation) {
            Operation.ADD -> {  result = leftHandSide + rightHandSide }
            Operation.SUBTRACT -> { result = leftHandSide - rightHandSide }
            Operation.MULTIPLY -> { result = leftHandSide * rightHandSide }
            Operation.DIVIDE -> { result = leftHandSide / rightHandSide }
        }
        binding.inputFieldId.setText("")
        binding.inputFieldId.setText(result.toString())
    }

    private fun selectOperation(operation: Operation) {
        currentOperation = operation
        val input = binding.inputFieldId.text.toString()
        leftHandSide = input.toDouble()
        binding.inputFieldId.setText("")
    }
}