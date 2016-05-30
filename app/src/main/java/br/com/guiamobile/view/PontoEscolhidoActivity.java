package br.com.guiamobile.view;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;

import android.widget.TextView;
import android.widget.Toast;


import br.com.guiamobile.R;
import br.com.guiamobile.model.PontoTuristico;

public class PontoEscolhidoActivity extends AppCompatActivity {

    private TextView texto;
    private PontoTuristico pontoTuristico;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        mediaPlayer = MediaPlayer.create(this, R.raw.teste);

        pontoTuristico = (PontoTuristico) getIntent().getSerializableExtra("PontoEscolhido");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(pontoTuristico.getTitulo());
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        View view = (View) this.findViewById(R.id.imagem);


        texto = (TextView) findViewById(R.id.texto);


        texto.setText(pontoTuristico.getPontoTuristico());
        pontoTuristico.MostrarImagem(view, pontoTuristico.getPontoTuristicoID(), pontoTuristico.getIdTab());

        Toolbar toolbar_ponto_turistico = (Toolbar) findViewById(R.id.toolbar_ponto_turistico);


        toolbar_ponto_turistico.inflateMenu(R.menu.menu_ponto_historio);
        toolbar_ponto_turistico.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.compartilhar:
                        String msg = "Guia Mobile - Ponto Turistico" + "\n" + "Titulo: " + pontoTuristico.getTitulo() + "\n" + pontoTuristico.getPontoTuristico() + "\n" + getString(R.string.linkapp);
                        Intent it = new Intent();
                        it.setAction(Intent.ACTION_SEND);
                        it.putExtra(Intent.EXTRA_TEXT, msg);
                        it.setType("text/plain");
                        startActivity(Intent.createChooser(it, msg));
                        break;
                    case R.id.como_chegar:
                        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                                Uri.parse("geo:0,0?q=" + pontoTuristico.getLatitude() + "," + pontoTuristico.getLongitude() + "(" + pontoTuristico.getTitulo() + ")"));
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });

        toolbar_ponto_turistico.findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });

        toolbar_ponto_turistico.findViewById(R.id.pausa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });

    }
}
