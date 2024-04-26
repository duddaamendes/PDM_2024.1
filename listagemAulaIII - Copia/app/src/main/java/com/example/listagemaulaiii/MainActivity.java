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
    String[] planetsInfo = new String[] {"Mercúrio é um dos quatro planetas telúricos do Sistema Solar e seu corpo é rochoso como a Terra. É o menor planeta do sistema solar, com um raio equatorial de 2 439,7 km. Mercúrio é menor até que os dois maiores satélites naturais do sistema solar, as luas Ganimede e Titã, embora seja mais massivo.",
            "O planeta Vênus é o segundo do nosso sistema solar a partir do Sol e o mais próximo da Terra, a apenas 61 milhões de quilômetros de distância. Uma de suas principais características é o fato de, como um planeta rochoso, sua superfície ser composta por vales e altas montanhas, cheias de vulcões.",
            "A Terra é o terceiro planeta mais próximo do Sol, o mais denso e o quinto maior dos oito planetas do Sistema Solar. É também o maior dos quatro planetas telúricos. É por vezes designada como Mundo ou Planeta Azul.",
            "O diâmetro de Marte é de 6.794 quilômetros – quase metade do diâmetro da Terra. A atmosfera, muito rarefeita, é composta por gás carbônico, dióxido de carbono, nitrogênio, argônio, néon e oxigênio. Esse planeta possui dois satélites (luas – Phobos e Deimos) e é visível a olho nu durante a noite.",
            "O dia em Júpiter tem 10 horas de duração. Europa, uma das Luas Galileanas, pode ter um oceano líquido em sua superfície. Ventos de 600 km/hora são comuns em Júpiter. A massa de Júpiter é 2,5 vezes maior do que os outros sete planetas do Sistema Solar juntos.",
            "Trata-se do segundo maior planeta desse sistema, atrás apenas de Júpiter, apresentando um diâmetro de 120 536 km, que é cerca de nove vezes maior que o diâmetro equatorial terrestre. O movimento de rotação do planeta Saturno é bastante acelerado, o que reverbera no achatamento de seus polos.",
            "Urano é o sétimo planeta a partir do Sol e o terceiro maior do Sistema Solar, depois de Júpiter e Saturno. Sua massa é, aproximadamente, 14 vezes a da Terra, e possui quatro vezes o seu tamanho.",
            "Netuno é um planeta gasoso pertencente ao Sistema Solar classificado como um gigante de gelo. Trata-se do oitavo planeta a partir do Sol, sendo, portanto, o planeta mais distante do Sol. Em decorrência disso, o tempo que Netuno leva para dar uma volta completa em torno dessa estrela é muito grande: 165 anos."
    };

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
                bundle.putString("Infos", planetsInfo[i]);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}