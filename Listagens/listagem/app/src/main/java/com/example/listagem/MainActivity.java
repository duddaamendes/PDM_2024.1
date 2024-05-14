package com.example.listagem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] nomes = new String[]{"Jorge", "Maria", "José", "Lolo", "Gabi", "Gaby"};
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.listView);

        //Configruando um adaptador para listagem de dados
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1, //Achar layout pronto
                android.R.id.text1,
                nomes
        );
        //clica no método e aperta Ctrl+Q para mostrar suas regras

        lv.setAdapter(adapter);

        //Para fazer algo quando clicar sobre o elemento da linha
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //mostrar a posição clicada
                Log.d("clickitem", Integer.toString(i));
                //mostrar o nome clicado
                Log.d("clickitem", nomes[i]);

                Bundle b = new Bundle();
                b.putString("nome", nomes[i]);

                Intent intent = new Intent(getApplicationContext(), SegundaActivity.class);
                intent.putExtras(b);
                startActivity(intent);

            }
        });
    }
}