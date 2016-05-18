package br.com.guiamobile.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import br.com.guiamobile.R;
import br.com.guiamobile.model.PontoTuristico;


/**
 * Created by Gilberto on 26/04/2016.
 */
public class PontoTuristicoEscolhido extends Activity {


    private String pontoTuristico;
    private TextView titulo, texto;
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ponto_turistico_layout);

        PontoTuristico pontoTuristico = (PontoTuristico) getIntent().getSerializableExtra("PontoEscolhido");

        View view = (View) this.findViewById(R.id.imagem);

        titulo = (TextView) findViewById(R.id.titulo);
        texto = (TextView) findViewById(R.id.texto);

        titulo.setText(pontoTuristico.getTitulo());
        texto.setText(pontoTuristico.getPontoTuristico());

        //pontoTuristico.MostrarImagem(view, pontoTuristico.getPontoTuristicoID());

    }

}
