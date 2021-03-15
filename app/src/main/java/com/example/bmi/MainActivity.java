package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edt_weight;
    private EditText edt_height;
    private TextView view_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
    }

    private void setupViews() {
        edt_weight = findViewById(R.id.txt_weight);
        edt_height = findViewById(R.id.txt_height);
        view_result = findViewById(R.id.view_result);
    }

    public void calculate(View view) {
        float weight = Float.parseFloat(edt_weight.getText().toString());
        float height = Float.parseFloat(edt_height.getText().toString());
        height /= 100;

        float bmi = weight / (height * height);

        String res = Float.toString(bmi);

        view_result.setVisibility(View.VISIBLE);

        if (bmi <= 18.5) {
            view_result.setTextColor(this.getResources().getColor(R.color.yellow));
        } else if (bmi > 18.5 && bmi <= 24.9) {
            view_result.setTextColor(this.getResources().getColor(R.color.green));
        } else {
            view_result.setTextColor(this.getResources().getColor(R.color.red));
        }

        view_result.setText(res);

    }
}