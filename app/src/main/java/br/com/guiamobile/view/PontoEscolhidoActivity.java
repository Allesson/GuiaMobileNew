package br.com.guiamobile.view;

import android.os.Bundle;
;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;

import android.widget.TextView;


import br.com.guiamobile.R;
import br.com.guiamobile.model.PontoTuristico;

public class PontoEscolhidoActivity extends AppCompatActivity {

    private TextView texto;
    private PontoTuristico pontoTuristico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);


        pontoTuristico = (PontoTuristico) getIntent().getSerializableExtra("PontoEscolhido");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(pontoTuristico.getTitulo());
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        View view = (View) this.findViewById(R.id.imagem);


        texto = (TextView) findViewById(R.id.texto);


        texto.setText(pontoTuristico.getPontoTuristico());
        pontoTuristico.MostrarImagem(view, pontoTuristico.getPontoTuristicoID(), pontoTuristico.getIdTab());


    }
}
