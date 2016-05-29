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
    private float latitude, longitude;

    public PontoTuristico(Integer pontoTuristicoID, String titulo, String descricao, String pontoTuristico,float latitude,float longitude,Integer idTab) {
        this.pontoTuristicoID = pontoTuristicoID;
        this.titulo = titulo;
        this.descricao = descricao;
        this.pontoTuristico = pontoTuristico;
        this.idTab = idTab;
        this.latitude=latitude;
        this.longitude=longitude;
    }

    public PontoTuristico(String titulo, float latitude, float longitude){
        this.titulo=titulo;
        this.latitude=latitude;
        this.longitude=longitude;
    }

    public PontoTuristico() {
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
    public float getLatitude(){
        return latitude;
    }
    public void setLatitude(float latitude){
        this.latitude=latitude;
    }
    public float getLongitude(){
        return longitude;
    }
    public void setLongitude(float longitude){
        this.longitude=longitude;
    }



    public static void MostrarImagem(View view, Integer id, Integer idTab) {
        ImageView imageView = (ImageView) view.findViewById(R.id.imagem);
        YoYo.with(Techniques.Landing)
                .duration(700)
                .playOn(imageView);
        switch (idTab){
            case 1:
            switch (id) {
                case 1:
                    imageView.setImageResource(R.drawable.i_soledade);
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.i_penha);
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.i_carmo);
                    break;
                case 4:
                    imageView.setImageResource(R.drawable.i_santissimo_santo_antonio);
                    break;
                case 5:
                    imageView.setImageResource(R.drawable.i_madre_deus);
                    break;
                case 6:
                    imageView.setImageResource(R.drawable.i_martirios);
                    break;
                case 7:
                    imageView.setImageResource(R.drawable.i_salinas);
                    break;
                case 8:
                    imageView.setImageResource(R.drawable.i_terco);
                    break;
                case 9:
                    imageView.setImageResource(R.drawable.i_pretos);
                    break;
                case 10:
                    imageView.setImageResource(R.drawable.i_pilar);
                    break;
                case 11:
                    imageView.setImageResource(R.drawable.i_capunga);
                    break;
                case 12:
                    imageView.setImageResource(R.drawable.i_santo_antonio);
                    break;
                case 13:
                    imageView.setImageResource(R.drawable.i_sao_felix);
                    break;
                case 14:
                    imageView.setImageResource(R.drawable.i_dourada);
                    break;
                case 15:
                    imageView.setImageResource(R.drawable.i_clerigos);
                    break;
            }
                break;

            case 2:
                switch (id) {
                    case 1:
                        imageView.setImageResource(R.drawable.m_h_nordeste);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.m_m_greca);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.m_c_recife);
                        break;
                    case 4:
                        imageView.setImageResource(R.drawable.m_militar);
                        break;
                    case 5:
                        imageView.setImageResource(R.drawable.m_a_m_a_magalhaes);
                        break;
                    case 6:
                        imageView.setImageResource(R.drawable.m_f_a_sacra);
                        break;
                    case 7:
                        imageView.setImageResource(R.drawable.m_i_r_brennand);
                        break;
                    case 8:
                        imageView.setImageResource(R.drawable.m_abolicao);
                        break;
                    case 9:
                        imageView.setImageResource(R.drawable.m_a_popular);
                        break;
                    case 10:
                        imageView.setImageResource(R.drawable.m_p_frevo);
                        break;
                    case 11:
                        imageView.setImageResource(R.drawable.m_l_gonzaga);
                        break;
                }
                break;
            case 3:
                switch (id) {
                    case 1:
                        imageView.setImageResource(R.drawable.p_b_vista);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.p_b_macedo);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.p_d_coelho);
                        break;
                    case 4:
                        imageView.setImageResource(R.drawable.p_limoeiro);
                        break;
                    case 5:
                        imageView.setImageResource(R.drawable.p_m_nassau);
                        break;
                    case 6:
                        imageView.setImageResource(R.drawable.p_p_isabel);
                        break;
                }
                break;
            case 4:
                switch (id) {
                    case 1:
                        imageView.setImageResource(R.drawable.t_parque);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.t_b_junior);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.t_s_isabel);
                        break;
                    case 4:
                        imageView.setImageResource(R.drawable.t_apolo);
                        break;
                    case 5:
                        imageView.setImageResource(R.drawable.t_arraial);
                        break;
                    case 6:
                        imageView.setImageResource(R.drawable.t_r_mar);
                        break;
                }
                break;
        }
    }
}
