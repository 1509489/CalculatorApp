package com.pixelart.calculator;

import android.annotation.SuppressLint;
import android.os.strictmode.Violation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    private TextView tvInput, tvResults,tvDisplay;

    private Button btnClear;

    private int firstValue, secondValue;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding Views
        tvInput = findViewById(R.id.tvInput);
        tvResults = findViewById(R.id.tvResults);
        tvDisplay =findViewById(R.id.tvDisplay);

        btnClear = findViewById(R.id.btnClear);

        tvInput.setText("");
        tvResults.setText("");
        tvDisplay.setText("");

        btnClear.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        //Clear and Answer buttons
        switch (v.getId())
        {
            case R.id.btnClear:
                tvInput.setText("");
                tvResults.setText("");
                tvDisplay.setText("");
                break;
           default:
               break;
        }
    }


    public void onClickNumbers(View v)
    {
        Button button = (Button)v;
        if (tvInput.getText() == null)
            tvInput.setText(button.getText().toString());
        else
            tvInput.setText(tvInput.getText() +""+ button.getText());

        firstValue = Integer.parseInt(tvInput.getText().toString());

    }
    public void onClickOperator(View v)
    {
        Button button = (Button)v;
        operator = button.getText().toString();
        tvResults.setText(String.valueOf(firstValue));
        tvInput.setText("");
        tvDisplay.setText(firstValue +" "+ operator);
    }
    public void calculate(View v)
    {
        String secondVal = tvInput.getText().toString();
        secondValue = Integer.parseInt(secondVal);

        if (operator.equals("+")) {
            firstValue = Integer.parseInt(tvResults.getText().toString());
            tvResults.setText(null);
            tvResults.setText(firstValue + secondValue + "");
            tvDisplay.setText(tvDisplay.getText() + " "+ tvInput.getText());
            tvInput.setText(null);
        }
        else if (operator.equals("-")) {
            firstValue = Integer.parseInt(tvResults.getText().toString());
            tvResults.setText(null);
            tvResults.setText(firstValue - secondValue + "");
            tvDisplay.setText(tvDisplay.getText() + " "+ tvInput.getText());
            tvInput.setText(null);
        }
        else if (operator.equals("/")) {
            firstValue = Integer.parseInt(tvResults.getText().toString());
            tvResults.setText(null);
            tvResults.setText(firstValue / secondValue + "");
            tvDisplay.setText(tvDisplay.getText() + " "+ tvInput.getText());
            tvInput.setText(null);
        }
        else if (operator.equals("*")) {
            firstValue = Integer.parseInt(tvResults.getText().toString());
            tvResults.setText(null);
            tvResults.setText(firstValue * secondValue + "");
            tvDisplay.setText(tvDisplay.getText() + " "+ tvInput.getText());
            tvInput.setText(null);
        }
        else
            tvResults.setText("Invalid");

    }

}
