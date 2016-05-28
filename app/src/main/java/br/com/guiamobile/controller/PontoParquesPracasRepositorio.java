package br.com.guiamobile.controller;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.guiamobile.model.PontoTuristico;
import br.com.guiamobile.model.PontoTuristicoOpenHelper;

/**
 * Created by Gilberto on 27/04/2016.
 */
public class PontoParquesPracasRepositorio {

    private PontoTuristicoOpenHelper pontoTuristicoOpenHelper;

    public PontoParquesPracasRepositorio(Context context) {
        this.pontoTuristicoOpenHelper = new PontoTuristicoOpenHelper(context);
    }


    /**
     * @param busca Rebe uma String.
     * @return Retorna um LIST<PontoTuristico> referente a String que foi passada como  paramento.
     */
    public List<PontoTuristico> buscarPontoParquesP(String busca) {
        SQLiteDatabase db = pontoTuristicoOpenHelper.getWritableDatabase();

        String selectSQL = "SELECT * FROM tbl_pontoParquesP WHERE titulo LIKE '%" + busca + "%'";
        Cursor cursor = db.rawQuery(selectSQL, null);
        List<PontoTuristico> lista = new ArrayList<>();

        while (cursor.moveToNext()) {

            Integer id = cursor.getInt(cursor.getColumnIndex("id"));
            String titulo = cursor.getString(cursor.getColumnIndex("titulo"));
            String descricao = cursor.getString(cursor.getColumnIndex("descricao"));
            String texto = cursor.getString(cursor.getColumnIndex("texto"));

            Integer idTab=cursor.getInt(cursor.getColumnIndex("idTab"));
            PontoTuristico pontoTuristico=new PontoTuristico(id,titulo,descricao,texto,idTab);
            lista.add(pontoTuristico);
        }
        return lista;
    }
    public List<PontoTuristico> listar(){
        SQLiteDatabase db = this.pontoTuristicoOpenHelper.getWritableDatabase();
        Cursor cursor=db.query(PontoTuristicoOpenHelper.TBL_PONTO_PARQUESPRACAS, new String[]{"id", "titulo", "descricao", "texto","idTab"},
                null, null, null, null, null);

        List<PontoTuristico>listaTuristica=new ArrayList<PontoTuristico>();

        while(cursor.moveToNext()){

            int id=cursor.getInt(cursor.getColumnIndex("id"));
            String titulo=cursor.getString(cursor.getColumnIndex("titulo"));
            String descricao=cursor.getString(cursor.getColumnIndex("descricao"));
            String texto=cursor.getString(cursor.getColumnIndex("texto"));
            Integer idTab=cursor.getInt(cursor.getColumnIndex("idTab"));
            PontoTuristico lugares=new PontoTuristico(id,titulo,descricao,texto,idTab);
            listaTuristica.add(lugares);
        }
        return listaTuristica;
    }
}
