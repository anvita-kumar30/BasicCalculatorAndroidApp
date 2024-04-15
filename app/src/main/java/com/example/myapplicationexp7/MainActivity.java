package com.example.myapplicationexp7;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    private String input = "";
    private double num1 = 0, num2 = 0;
    private String operator = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize views
        textViewResult = findViewById(R.id.textViewResult);
        // Set click listeners for number buttons
        setNumberButtonClickListeners();
        // Set click listeners for operator buttons
        setOperatorButtonClickListeners();
        // Set click listener for equals button
        setEqualsButtonClickListener();
        // Set click listener for clear button
        setClearButtonClickListener();
    }
    // Set click listeners for number buttons
    private void setNumberButtonClickListeners() {
        int[] numberButtonIds = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
                R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};
        for (int buttonId : numberButtonIds) {
            Button button = findViewById(buttonId);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button clickedButton = (Button) view;
                    input += clickedButton.getText().toString();
                    updateResult();
                }
            });
        }
    }
    // Set click listeners for operator buttons
    private void setOperatorButtonClickListeners() {
        int[] operatorButtonIds = {R.id.buttonAdd, R.id.buttonSubtract, R.id.buttonMultiply, R.id.buttonDivide};
        for (int buttonId : operatorButtonIds) {
            Button button = findViewById(buttonId);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button clickedButton = (Button) view;
                    operator = clickedButton.getText().toString();
                    if (!input.isEmpty()) {
                        num1 = Double.parseDouble(input);
                        input = "";
                    }
                }
            });
        }
    }
    // Set click listener for equals button
    private void setEqualsButtonClickListener() {
        Button equalsButton = findViewById(R.id.buttonEquals);
        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!input.isEmpty()) {
                    num2 = Double.parseDouble(input);
                    calculateResult();
                    operator = "";
                }
            }
        });
    }
    // Set click listener for clear button
    private void setClearButtonClickListener() {
        Button clearButton = findViewById(R.id.buttonClear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearCalculator();
            }
        });
    }
    // Update result display
    private void updateResult() {
        textViewResult.setText(input);
    }
    // Calculate result based on operator
    @SuppressLint("DefaultLocale")
    private void calculateResult() {
        double result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    result = Double.NaN; // Handle division by zero
                }
                break;
        }
        input = String.format("%.2f", result);
        updateResult();
    }
    // Clear calculator
    private void clearCalculator() {
        input = "";
        num1 = 0;
        num2 = 0;
        operator = "";
        updateResult();
    }
}
