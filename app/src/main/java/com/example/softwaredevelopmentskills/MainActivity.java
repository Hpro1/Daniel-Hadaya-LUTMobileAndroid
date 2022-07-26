package com.example.softwaredevelopmentskills;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);

        Button addButton = (Button) findViewById(R.id.addButton);
        Button mainButton = (Button) findViewById(R.id.homeButton);
        addButton.setOnClickListener(this::onClick);

        mainButton.setOnClickListener(v -> {
            Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
            startActivity(startIntent);
        });

        Button shopButton = (Button) findViewById(R.id.listButton);
        shopButton.setOnClickListener(v -> {
            Intent startIntent = new Intent(getApplicationContext(), ListActivity.class);
            startActivity(startIntent);
        });
    }

    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

        Toast.makeText(this, "Selected operator: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }

    private void onClick(View v) {
        EditText firstNumberEditText = findViewById(R.id.firstNumberEditText);
        EditText secondNumberEditText = (EditText) findViewById(R.id.secondNumberEditText);
        TextView resultTextView;
        resultTextView = findViewById(R.id.resultTextView);

        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

        if (radioButton.getText().equals("Add")) {

            float num1 = Float.parseFloat(firstNumberEditText.getText().toString());
            float num2 = Float.parseFloat(secondNumberEditText.getText().toString());
            float result = num1 + num2;

            resultTextView.setText(String.format(Locale.ROOT, "%.2f", result) + "");
        } else if (radioButton.getText().equals("Subtract")) {

            float num1 = Float.parseFloat(firstNumberEditText.getText().toString());
            float num2 = Float.parseFloat(secondNumberEditText.getText().toString());
            float result = num1 - num2;

            resultTextView.setText(String.format(Locale.ROOT, "%.2f", result) + "");
        } else if (radioButton.getText().equals("Multiply")) {

            float num1 = Float.parseFloat(firstNumberEditText.getText().toString());
            float num2 = Float.parseFloat(secondNumberEditText.getText().toString());
            float result = num1 * num2;

            resultTextView.setText(String.format(Locale.ROOT, "%.2f", result) + "");
        } else {

            float num1 = Float.parseFloat(firstNumberEditText.getText().toString());
            float num2 = Float.parseFloat(secondNumberEditText.getText().toString());
            float result = num1 / num2;

            resultTextView.setText(String.format(Locale.ROOT, "%.2f", result) + "");
        }
    }
}