package com.example.taulaperiodica;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Element> listaElement;
    ArrayList<Element> listaMostra;
    ListView lstNoms;
    private final int FIRMA1 = 233232323;
    private final int FIRMA2 = 233232323;

    int puntuacio = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CreateDades();
        listaMostra = new ArrayList<Element>();
        lstNoms = findViewById(R.id.IDList);
        AdaptadorElement adapter = new AdaptadorElement(MainActivity.this, R.layout.element_element,listaElement);
        listaMostra = ( ArrayList<Element>) listaElement.clone();
        lstNoms.setAdapter(adapter);
        lstNoms.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, ElementActivity.class);
                intent.putExtra("Element",listaMostra.get(i));
                startActivityForResult(intent,FIRMA1);
            }
        });
    }

    public void CreateDades() {
        listaElement = new  ArrayList<Element>();
        listaElement.add(new Element("H" ,"Hidrogen",1,1.007947f,TipusDeElement.gasos));
        listaElement.add(new Element("He","Heli",2,4.02602f,TipusDeElement.gasos));
        listaElement.add(new Element("Li","Liti",3,6.931f,TipusDeElement.solids));
        listaElement.add(new Element("Be","Beril·li",4,9.012182f,TipusDeElement.solids));
        listaElement.add(new Element("Hg","Mercuri",80,200.59f,TipusDeElement.liquids));
        listaElement.add(new Element("La","Lantani",57,138.90547f,TipusDeElement.sintetic));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuelements, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        listaMostra.clear();
        switch(item.getItemId()){
            case R.id.idJoc:
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra("Element",listaElement);
                intent.putExtra("Puntuacio",puntuacio);
                startActivityForResult(intent,FIRMA1);
                break;
            case R.id.Tots:
                AdaptadorElement adapter = new AdaptadorElement(MainActivity.this, R.layout.element_element,listaElement);
                lstNoms.setAdapter(adapter);
                break;
            case R.id.Gasos:
                showFiltred(TipusDeElement.gasos);
                break;
            case R.id.Liquids:
                showFiltred(TipusDeElement.liquids);
                break;
            case R.id.Sintetic:
                showFiltred(TipusDeElement.sintetic);
                break;
            case R.id.Solids:
                showFiltred(TipusDeElement.solids);
                break;
        }
        return true;
    }
    void showFiltred(TipusDeElement tipus){
        AdaptadorElement adapter;
        for (int i = 0; i <listaElement.size() ; i++) {
            if(listaElement.get(i).getTipus() == tipus){
                listaMostra.add(listaElement.get(i));
            }
        }
        adapter = new AdaptadorElement(MainActivity.this, R.layout.element_element,listaMostra);
        lstNoms.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case FIRMA2:
                puntuacio = data.getIntExtra("Max",-1);
                break;
        }
    }
}