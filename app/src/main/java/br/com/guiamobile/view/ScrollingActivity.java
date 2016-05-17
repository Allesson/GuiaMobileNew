package br.com.guiamobile.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.SupportMapFragment;

import br.com.guiamobile.R;
import br.com.guiamobile.model.PontoTuristico;

public class ScrollingActivity extends AppCompatActivity {

    private TextView titulo, texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        PontoTuristico pontoTuristico = (PontoTuristico) getIntent().getSerializableExtra("PontoEscolhido");

        View view = (View) this.findViewById(R.id.imagem);

        titulo = (TextView) findViewById(R.id.titulo);
        texto = (TextView) findViewById(R.id.texto);

        titulo.setText(pontoTuristico.getTitulo());
        texto.setText(pontoTuristico.getPontoTuristico());

        //pontoTuristico.MostrarImagem(view, pontoTuristico.getPontoTuristicoID());

    }
}
