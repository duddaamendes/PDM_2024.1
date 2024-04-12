package com.example.listaaulaii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    String[] nomes = new String[] {"Pato", "Ganso", "Cachorro", "Morcego", "Camelo", "Preguiça"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                R.layout.item_lista,
                R.id.txtNome,
                nomes
        );

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(), ExibeActivity.class);

                intent.putExtra("posicao",i);
                startActivity(intent);

            }
        });
    }
}