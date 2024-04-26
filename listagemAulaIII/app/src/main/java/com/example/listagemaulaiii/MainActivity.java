package com.example.listagemaulaiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] planetas = new String[] {"Mercurio", "Venus", "Terra", "Marte", "Jupiter", "Saturno", "Urano", "Netuno"};

    Planet[] planets = new Planet[]{
            new Planet("Mercurio", R.drawable.mercurio),
            new Planet("Venus", R.drawable.venus),
            new Planet("Terra", R.drawable.terra),
            new Planet("Marte", R.drawable.marte),
            new Planet("Jupiter", R.drawable.jupiter),
            new Planet("Saturno", R.drawable.saturno),
            new Planet("Urano", R.drawable.urano),
            new Planet("Netuno", R.drawable.netuno)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = findViewById(R.id.listView);
        AdapterPlaneta adapter = new AdapterPlaneta(
                this,
                R.layout.item_lista_planeta,
                planets
        );
        //ArrayAdapter<String>  adapter = new ArrayAdapter<>(
        //        this,
        //        android.R.layout.simple_list_item_1,
        //        android.R.id.text1,
        //        planetas
        //);
        lv.setAdapter(adapter);



        //adicionando tratamento de evento clique
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                Bundle bundle = new Bundle();
                bundle.putString("planet", planetas[i]);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}