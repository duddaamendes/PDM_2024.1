package com.example.listagemaulaiii;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterPersonagem extends ArrayAdapter<Personagem> {

    Object[] mObjects;

    public AdapterPersonagem(Context context, int resource, Personagem[] objects) {
        super(context, resource, objects);
        mObjects = objects;
    }

    public View getView(int position, View conterView, ViewGroup parent){
        View itemlista = LayoutInflater.from(getContext()).inflate(R.layout.item_lista, parent, false);
        TextView tvNome = itemlista.findViewById(R.id.textNomep);
        ImageView ivPers = itemlista.findViewById(R.id.imageView);
        Personagem pesonagem = (Personagem)  mObjects[position];

        tvNome.setText(pesonagem.nome);
        ivPers.setImageResource(pesonagem.image);

        return itemlista;
    }
}
