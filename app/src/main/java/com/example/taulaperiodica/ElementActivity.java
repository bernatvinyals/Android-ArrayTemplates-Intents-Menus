package com.example.taulaperiodica;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ElementActivity extends AppCompatActivity {

    Button Retorn,wiki,compartir;
    Element e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element);

        Retorn = findViewById(R.id.buttonReturn);
        wiki = findViewById(R.id.buttonWikipedia);
        compartir = findViewById(R.id.button3);

        e=(Element)getIntent().getSerializableExtra("Element");
        ((TextView)findViewById(R.id.textNom)).setText(e.getNom().toString());
        ((TextView)findViewById(R.id.textNumero)).setText(e.getNumero() + "");
        ((TextView)findViewById(R.id.textPes)).setText(e.getPesAtomic() + "");
        ((TextView)findViewById(R.id.textSimbol)).setText(e.getInicials().toString());
        ((TextView)findViewById(R.id.textTipus)).setText(e.getTipus().toString());

        Retorn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                setResult(RESULT_OK,i);
                finish();
            }
        });

        compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_TEXT,"https://ca.wikipedia.org/wiki/"+ e.getNom().toString());
                i.setType("text/plain");
                startActivity(i);
            }
        });

        wiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ca.wikipedia.org/wiki/"+ e.getNom().toString()));
                startActivity(i);
            }
        });
    }

}