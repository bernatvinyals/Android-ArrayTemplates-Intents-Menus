package com.example.taulaperiodica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorElement extends ArrayAdapter<Element> {
    ArrayList<Element> dades;
    int imatge;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item =inflater.inflate(imatge,null);
        TextView txtNumero = item.findViewById(R.id.txtNumero);
        TextView txtSimbolo = item.findViewById(R.id.txtSimbolo);
        TextView txtPesAtomic = item.findViewById(R.id.txtPesAtomic);
        TextView txtNom = item.findViewById(R.id.txtNom);
        LinearLayout CL = item.findViewById(R.id.elementBG);
        Element objecte = dades.get(position);

        txtNumero.setText( objecte.getNumero() + "");
        txtSimbolo.setText( objecte.getInicials() + "");
        txtPesAtomic.setText( objecte.getPesAtomic() + "");
        txtNom.setText( objecte.getNom() + "");

        switch (objecte.getTipus()){
            case liquids:
                CL.setBackgroundColor(getContext().getResources().getColor(R.color.liquids));
                break;
            case gasos:
                CL.setBackgroundColor(getContext().getResources().getColor(R.color.gasos));
                break;
            case solids:
                CL.setBackgroundColor(getContext().getResources().getColor(R.color.solids));
                txtNumero.setTextColor(getContext().getResources().getColor(R.color.white));
                txtSimbolo.setTextColor(getContext().getResources().getColor(R.color.white));
                txtPesAtomic.setTextColor(getContext().getResources().getColor(R.color.white));
                txtNom.setTextColor(getContext().getResources().getColor(R.color.white));
                break;
            case sintetic:
                CL.setBackgroundColor(getContext().getResources().getColor(R.color.sintetic));
                break;
        }
        return item;
    }

    public AdaptadorElement(@NonNull Context context, int resource, @NonNull List<Element> objects) {
        super(context, resource, objects);

        dades = (ArrayList)objects;
        imatge = resource;
    }
}
