package com.example.harshkeshwala.harshkeshwala_mapd711_practicaltest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class OutputActivity extends AppCompatActivity {

    private TextView result;

    String value;
    String height;
    String weight;
    String age;
    String gender;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        Intent i = getIntent();
        String bmi = i.getStringExtra("BMI");
        Toast.makeText(OutputActivity.this, "P"+bmi, Toast.LENGTH_LONG).show();
        result = (TextView)findViewById(R.id.result);
        result.setText("hhhhhhhhhhhhhh"+bmi);
    }

}
