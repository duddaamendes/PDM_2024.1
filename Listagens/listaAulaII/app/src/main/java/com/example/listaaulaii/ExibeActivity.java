package com.example.listaaulaii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ExibeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibe);
        int position = getIntent().getExtras().getInt("posicao");

        TextView tv = findViewById(R.id.textView);
        tv.setText(Integer.toString(position));
    }
}