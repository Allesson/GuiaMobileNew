package br.com.guiamobile.model;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;


import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.io.Serializable;

import br.com.guiamobile.R;

/**
 * Created by Gilberto on 27/04/2016.
 *
 * @author Gilberto Feitosa Junior
 *         "Essa é uma classe modelo do ponto turistico"
 */
public class PontoTuristico extends Activity implements Serializable {

    private Integer pontoTuristicoID;
    private String titulo;
    private String descricao;
    private String pontoTuristico;
    private Integer idTab;

    public PontoTuristico(Integer pontoTuristicoID, String titulo, String descricao, String pontoTuristico, Integer idTab) {
        this.pontoTuristicoID = pontoTuristicoID;
        this.titulo = titulo;
        this.descricao = descricao;
        this.pontoTuristico = pontoTuristico;
        this.idTab = idTab;
    }


    public Integer getPontoTuristicoID() {
        return pontoTuristicoID;
    }

    public Integer getIdTab() {
        return idTab;
    }

    public void setPontoTuristicoID(Integer pontoTuristicoID) {
        this.pontoTuristicoID = pontoTuristicoID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPontoTuristico() {
        return pontoTuristico;
    }

    public void setPontoTuristico(String pontoTuristico) {
        this.pontoTuristico = pontoTuristico;
    }


    public static void MostrarImagem(View view, Integer id, Integer idTab) {
        ImageView imageView = (ImageView) view.findViewById(R.id.imagem);
        YoYo.with(Techniques.Landing)
                .duration(700)
                .playOn(imageView);
        if (idTab == 1) {
            switch (id) {
                case 1:
                    imageView.setImageResource(R.drawable.ic_museu);


                    break;
                case 2:
                    imageView.setImageResource(R.drawable.m_c_recife);
            }
        }
    }
}
