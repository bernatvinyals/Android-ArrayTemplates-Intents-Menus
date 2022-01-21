package com.example.taulaperiodica;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    ArrayList<Element>  e;
    int maxP = 0;
    int actP = 0; //Punts actuals
    Button Retorn,submit;
    EditText input;
    Element elPerPreguntar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        e=(ArrayList<Element>)getIntent().getSerializableExtra("Element");
        maxP=getIntent().getIntExtra("Puntuacio",-1);
        Retorn = findViewById(R.id.btnRetornG);
        input = findViewById(R.id.editTextNumber);
        submit = findViewById(R.id.btnSend);
        elPerPreguntar= e.get(new Random().nextInt((e.size()-1)+1)+1);
        Toast.makeText(getApplicationContext(),""+e.size(), Toast.LENGTH_LONG).show();
        ((TextView)findViewById(R.id.txtobjtoask)).setText(elPerPreguntar.getNom().toString());
        ((TextView)findViewById(R.id.txthighscore)).setText(maxP + "");
        ((TextView)findViewById(R.id.txtcurrScore)).setText(actP + "");


        Retorn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("Max", maxP);
                setResult(RESULT_OK,i);
                //Ficar el retorn de maxP
                finish();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(input.getText().toString()) == elPerPreguntar.getNumero()){
                    Toast.makeText(getApplicationContext(),"Correcte", Toast.LENGTH_LONG).show();
                    input.setText("");
                    actP +=1;
                }else {
                    Toast.makeText(getApplicationContext(),"Incorrecte", Toast.LENGTH_LONG).show();
                    input.setText("");
                    actP = 0;
                }
                elPerPreguntar= e.get(new Random().nextInt((e.size()-1)+1)+1);
                if (actP>maxP){maxP = actP;}
                ((TextView)findViewById(R.id.txthighscore)).setText(maxP + "");
                ((TextView)findViewById(R.id.txtcurrScore)).setText(actP + "");
                ((TextView)findViewById(R.id.txtobjtoask)).setText(elPerPreguntar.getNom().toString());
            }
        });
    }
}