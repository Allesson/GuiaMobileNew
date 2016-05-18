package br.com.guiamobile.controller;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.guiamobile.model.PontoTuristicoOpenHelper;
import br.com.guiamobile.model.PontoTuristico;

/**
 * Created by Gilberto on 27/04/2016.
 */
public class PontoIgrejasMRepositorio {

    private PontoTuristicoOpenHelper pontoTuristicoOpenHelper;

    public PontoIgrejasMRepositorio(Context context) {
        this.pontoTuristicoOpenHelper = new PontoTuristicoOpenHelper(context);
    }


    /**
     * @param busca Rebe uma String.
     * @return Retorna um LIST<PontoTuristico> referente a String que foi passada como  paramento.
     */
    public List<PontoTuristico> buscarPontoIgrejasM(String busca) {
        SQLiteDatabase db = pontoTuristicoOpenHelper.getWritableDatabase();

        String selectSQL = "SELECT * FROM tbl_pontoIgrejasM WHERE titulo LIKE '%" + busca + "%'";
        Cursor cursor = db.rawQuery(selectSQL, null);
        List<PontoTuristico> lista = new ArrayList<>();

        while (cursor.moveToNext()) {

            Integer id = cursor.getInt(cursor.getColumnIndex("id"));
            String titulo = cursor.getString(cursor.getColumnIndex("titulo"));
            String descricao = cursor.getString(cursor.getColumnIndex("descricao"));
            String texto = cursor.getString(cursor.getColumnIndex("texto"));

            PontoTuristico pontoTuristico = new PontoTuristico( id , titulo, descricao, texto);
            lista.add(pontoTuristico);
        }
        return lista;
    }
    public List<PontoTuristico> listar(){
        SQLiteDatabase db = this.pontoTuristicoOpenHelper.getWritableDatabase();
        Cursor cursor=db.query(PontoTuristicoOpenHelper.TBL_PONTO_IGREJASM, new String[]{"id", "titulo", "descricao", "texto"},
                null, null, null, null, null);

        List<PontoTuristico>listaTuristica=new ArrayList<PontoTuristico>();

        while(cursor.moveToNext()){

            int id=cursor.getInt(cursor.getColumnIndex("id"));
            String titulo=cursor.getString(cursor.getColumnIndex("titulo"));
            String descricao=cursor.getString(cursor.getColumnIndex("descricao"));
            String texto=cursor.getString(cursor.getColumnIndex("texto"));
            PontoTuristico lugares=new PontoTuristico(id,titulo,descricao,texto);
            listaTuristica.add(lugares);
        }
        return listaTuristica;
    }
}
