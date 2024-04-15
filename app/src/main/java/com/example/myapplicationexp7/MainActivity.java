package com.example.myapplicationexp7;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    EditText etFirstNumber, etSecondNumber;
    TextView tvResult;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnClear;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etFirstNumber = findViewById(R.id.et_first_number);
        etSecondNumber = findViewById(R.id.et_second_number);
        tvResult = findViewById(R.id.tv_result);
        btnAdd = findViewById(R.id.btn_add);
        btnSubtract = findViewById(R.id.btn_subtract);
        btnMultiply = findViewById(R.id.btn_multiply);
        btnDivide = findViewById(R.id.btn_divide);
        btnClear = findViewById(R.id.btn_clear);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstNumber = Integer.parseInt(etFirstNumber.getText().toString());
                int secondNumber =
                        Integer.parseInt(etSecondNumber.getText().toString());
                int result = firstNumber + secondNumber;
                tvResult.setText(result+" ");
            }
        });
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstNumber = Integer.parseInt(etFirstNumber.getText().toString());
                int secondNumber =
                        Integer.parseInt(etSecondNumber.getText().toString());
                int result = firstNumber - secondNumber;
                tvResult.setText(result+" ");
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstNumber = Integer.parseInt(etFirstNumber.getText().toString());
                int secondNumber =
                        Integer.parseInt(etSecondNumber.getText().toString());
                int result = firstNumber * secondNumber;
                tvResult.setText(result+" ");
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstNumber = Integer.parseInt(etFirstNumber.getText().toString());
                int secondNumber =
                        Integer.parseInt(etSecondNumber.getText().toString());
                int result = firstNumber / secondNumber;
                tvResult.setText(result+" ");
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etFirstNumber.setText("");
                etSecondNumber.setText("");
                tvResult.setText("");
            }
        });
    }
}
