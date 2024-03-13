package com.example.sorteio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TextView txtViewResult;
    EditText edMin, edMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edMin = findViewById(R.id.EdMin);
        edMax = findViewById(R.id.EdMax);
        txtViewResult = findViewById(R.id.textView);
    }

    public void sortear(View v){
        int min = Integer.parseInt(edMin.getText().toString());
        int max = Integer.parseInt(edMax.getText().toString());

        Random random = new Random();
        int result = random.nextInt(max - min + 1) + min;

        txtViewResult.setText(Integer.toString(result));
    }
}