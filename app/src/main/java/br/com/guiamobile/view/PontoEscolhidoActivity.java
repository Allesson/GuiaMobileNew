package br.com.guiamobile.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import br.com.guiamobile.R;
import br.com.guiamobile.model.PontoTuristico;

public class PontoEscolhidoActivity extends AppCompatActivity {

    private TextView titulo, texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        PontoTuristico pontoTuristico = (PontoTuristico) getIntent().getSerializableExtra("PontoEscolhido");

        View view = (View) this.findViewById(R.id.imagem);

        titulo = (TextView) findViewById(R.id.titulo);
        texto = (TextView) findViewById(R.id.texto);

        titulo.setText(pontoTuristico.getTitulo());
        texto.setText(pontoTuristico.getPontoTuristico());


        pontoTuristico.MostrarImagem(view, pontoTuristico.getPontoTuristicoID(),pontoTuristico.getIdTab());

    }
}
