package com.example.listagemaulaiii;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listagemaulaiii.R;

public class AdapterPlaneta extends ArrayAdapter<Planet> {

    Object[] mObjects;

    public AdapterPlaneta(Context context, int resource, Planet[] objects) {
        super(context, resource, objects);
        mObjects = objects;
    }

    public View getView(int position, View conterView, ViewGroup parent){
        View itemlista = LayoutInflater.from(getContext()).inflate(R.layout.item_lista_planeta, parent, false);
        TextView tvNome = itemlista.findViewById(R.id.txtNomePlaneta);
        ImageView ivPlanet = itemlista.findViewById(R.id.imageView);
        Planet planeta = (Planet)  mObjects[position];

        tvNome.setText(planeta.nome);
        ivPlanet.setImageResource(planeta.image);

        return itemlista;
    }
}
