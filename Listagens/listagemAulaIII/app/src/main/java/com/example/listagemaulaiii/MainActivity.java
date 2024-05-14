package com.example.listagemaulaiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] personagens = new String[] {"Daenerys Targaryen", "Cersei Lannister", "Jon Snow", "Ned Stark", "Jaime Lannister", "Tyrion Lannister", "Sansa Stark", "Arya Stark"};
    String[] personagemInfo = new String[] {"Princesa Daenerys Targaryen era a filha de Aegon IV, o Indigno com Naerys Targaryen. Ela se casou com o Príncipe Maron Martell para unificar Dorne aos Sete Reinos. Morreu dando a luz a um natimorto, mas deixou um filho aleijado que continuou a linhagem da Casa Martell.",
            "Cersei Lannister é a filha mais velha de Lorde Tywin Lannister e irmã gêmea de Jaime Lannister. Depois da Rebelião de Robert, ela se casa com o novo rei, Robert Baratheon e se torna a rainha dos Sete Reinos. Somente no 4º livro, O Festim dos Corvos, ela se torna um personagem com ponto de vista.",
            "Jon Snow é o filho bastardo de 14 anos de Ned Stark e meio-irmão de Robb, Sansa, Arya, Bran e Rickon Stark. Ele tem fortes traços dos Stark. Tem o sobrenome Snow, dado costumeiramente às crianças ilegítimas do Norte, e é desprezado pela esposa de Ned e mãe das outras crianças, Catelyn Stark, que o vê como uma lembrança constante da infidelidade do marido.",
            "Eddard Stark, conhecido carinhosamente como Ned, foi chefe da Casa Stark, Senhor de Winterfell, e Protetor do Norte. Portava a histórica espada de aço Valiriano da Casa Stark, Gelo. É amigo do Rei Robert Baratheon, com quem foi criado e a quem ajudou a conquistar o Trono de Ferro, e posteriormente indicado como sua Mão.",
            "Jaime Lannister, conhecido como Regicida, é o primeiro filho homem do Lorde Tywin Lannister de Rochedo Casterly e de sua esposa, Senhora Joanna Lannister. Entrou para a Guarda Real nomeado pelo Rei Louco Aerys II Targaryen com quinze anos, tornando-se o mais jovem membro da ordem na história. Recebeu o depreciativo apelido de Regicida quando traiu seu Rei e o matou, ao final da Rebelião de Robert.",
            "Tyrion Lannister é o terceiro e mais novo filho de Tywin Lannister e Joanna Lannister. Tyrion é um anão, e por causa disso é chamado, zombeteiramente, às vezes, de Duende e Meio Homem. Seu emblema pessoal é uma mão dourada rodeada de leões dourados em um fundo vermelho.",
            "Sansa Stark é a filha mais velha de Catelyn e Eddard Stark. Ela tem três irmãos (Robb, Bran e Rickon), e uma irmã mais nova, Arya, além de um meio-irmão bastardo, Jon Snow. Sansa Stark é uma das personagens PDV principais dos livros.",
            "Arya Stark é a terceira filha de Lorde Eddard Stark e Catelyn Stark. No início do livro A Guerra dos Tronos, Arya tem nove anos de idade. Ela tem um irmão mais velho, Robb e dois irmãos mais novos, Bran e Rickon. Ela também tem uma irmã mais velha, Sansa, e um meio-irmão bastardo, Jon Snow."
    };

    Personagem[] pers = new Personagem[]{
            new Personagem("Daenerys Targaryen", R.drawable.daenerys),
            new Personagem("Cersei Lannister", R.drawable.cersei),
            new Personagem("Jon Snow", R.drawable.snow),
            new Personagem("Ned Stark", R.drawable.ned),
            new Personagem("Jaime Lannister", R.drawable.jaime),
            new Personagem("Tyrion Lannister", R.drawable.tyion),
            new Personagem("Sansa Stark", R.drawable.sansa),
            new Personagem("Arya Stark", R.drawable.arya)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = findViewById(R.id.listView);
        AdapterPersonagem adapter = new AdapterPersonagem(
                this,
                R.layout.item_lista,
                pers
        );
        lv.setAdapter(adapter);



        //adicionando tratamento de evento clique
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                Bundle bundle = new Bundle();
                bundle.putString("planet", personagens[i]);
                bundle.putString("Infos", personagemInfo[i]);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}