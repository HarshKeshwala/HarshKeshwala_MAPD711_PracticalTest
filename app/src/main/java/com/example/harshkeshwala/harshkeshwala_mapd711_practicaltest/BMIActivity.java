package com.example.harshkeshwala.harshkeshwala_mapd711_practicaltest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class BMIActivity extends AppCompatActivity {

    private Spinner genderSpinner;
    private Button calculateBMI;

    private RadioGroup measurmentType;
    private RadioButton rbMetric,rbStandard;
    private int choosenMeasurmentType;
    private RadioButton radioButton;

    private EditText height;
    private EditText weight;



    private String heightStr;
    private String weightStr;

    private String bmiLabel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        genderSpinner = (Spinner) findViewById(R.id.genderSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(adapter);


        height = (EditText)findViewById(R.id.editTextHeight);
        weight = (EditText)findViewById(R.id.editTextWeight);

        calculateBMI = (Button) findViewById(R.id.calculateBMI);
        calculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                measurmentType = findViewById(R.id.radioGroup);
                choosenMeasurmentType = measurmentType.getCheckedRadioButtonId();
                radioButton = findViewById(choosenMeasurmentType);


                heightStr = height.getText().toString();
                weightStr = weight.getText().toString();


                if (heightStr != null && !"".equals(heightStr) && weightStr != null  &&  !"".equals(weightStr))
                {
                     if (radioButton.getText().toString().contains("Metric"))
                     {
                         //   Toast.makeText(BMIActivity.this, "Metric", Toast.LENGTH_LONG).show();
                        float heightValue = Float.parseFloat(heightStr) / 100;
                        float weightValue = Float.parseFloat(weightStr);

                         float calculatedBMI = weightValue / (heightValue * heightValue);

                        displayMessage(calculatedBMI);
                       Toast.makeText(BMIActivity.this, "bmi is: "+calculatedBMI+""+bmiLabel, Toast.LENGTH_LONG).show();

                         Intent intent = new Intent(BMIActivity.this, OutputActivity.class);
                         intent.putExtra("BMI", calculatedBMI);
                         startActivity(intent);
                     }
                    else if(radioButton.getText().toString().contains("Standard"))
                     {
                         float heightValue = Float.parseFloat(heightStr);
                         float weightValue = Float.parseFloat(weightStr);

                        float calculatedBMI = ((weightValue / heightValue / heightValue)*703);

                         displayMessage(calculatedBMI);

                        Toast.makeText(BMIActivity.this, "bmi is: "+calculatedBMI+""+bmiLabel, Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(BMIActivity.this, OutputActivity.class);
                        intent.putExtra("BMI", calculatedBMI);
                        startActivity(intent);
                     }
                }
                else {
                    Toast.makeText(BMIActivity.this, "Please provide necessary details", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    private void displayMessage(float bmi) {

        bmiLabel = "";

        if (Float.compare(bmi, 18f) <= 0) {
            bmiLabel = getString(R.string.underweight);
        } else if (Float.compare(bmi, 18f) > 0  &&  Float.compare(bmi, 24f) <= 0) {
            bmiLabel = getString(R.string.normal);
        } else if (Float.compare(bmi, 25f) > 0){
            bmiLabel = getString(R.string.overweight);
        }

        bmiLabel = bmiLabel;
    }
}
