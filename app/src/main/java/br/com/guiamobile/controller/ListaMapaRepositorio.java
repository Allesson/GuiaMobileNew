package br.com.guiamobile.controller;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.guiamobile.model.PontoTuristico;
import br.com.guiamobile.model.PontoTuristicoOpenHelper;

/**
 * Created by Allesson on 26/05/2016.
 */
public class ListaMapaRepositorio {

    PontoTuristicoOpenHelper pontoTuristicoOpenHelper;

    public ListaMapaRepositorio(Context context) {
        this.pontoTuristicoOpenHelper = new PontoTuristicoOpenHelper(context);
    }

    public List<PontoTuristico> listarMuseus() {
        SQLiteDatabase db = this.pontoTuristicoOpenHelper.getWritableDatabase();
        Cursor cursor = db.query(PontoTuristicoOpenHelper.TBL_PONTO_MUSEUS, new String[]{"titulo", "latitude", "longitude"},
                null, null, null, null, null);

        return listar(cursor);
    }

    public List<PontoTuristico> listarIgrejas() {
        SQLiteDatabase db = this.pontoTuristicoOpenHelper.getWritableDatabase();
        Cursor cursor = db.query(PontoTuristicoOpenHelper.TBL_PONTO_IGREJAS, new String[]{"titulo", "latitude", "longitude"},
                null, null, null, null, null);

        return listar(cursor);
    }

    public List<PontoTuristico> listarParques() {
        SQLiteDatabase db = this.pontoTuristicoOpenHelper.getWritableDatabase();
        Cursor cursor = db.query(PontoTuristicoOpenHelper.TBL_PONTO_PARQUESPRACAS, new String[]{"titulo", "latitude", "longitude"},
                null, null, null, null, null);

        return listar(cursor);
    }

    public List<PontoTuristico> listarPraias() {
        SQLiteDatabase db = this.pontoTuristicoOpenHelper.getWritableDatabase();
        Cursor cursor = db.query(PontoTuristicoOpenHelper.TBL_PONTO_PRAIAS, new String[]{"titulo", "latitude", "longitude"},
                null, null, null, null, null);

        return listar(cursor);
    }

    public List<PontoTuristico> listarBares() {
        SQLiteDatabase db = this.pontoTuristicoOpenHelper.getWritableDatabase();
        Cursor cursor = db.query(PontoTuristicoOpenHelper.TBL_PONTO_BARESREST, new String[]{"titulo", "latitude", "longitude"},
                null, null, null, null, null);

        return listar(cursor);
    }

    public List<PontoTuristico> listar(Cursor cursor) {

        List<PontoTuristico> listaTuristica = new ArrayList<PontoTuristico>();

        while (cursor.moveToNext()) {
            String titulo = cursor.getString(cursor.getColumnIndex("titulo"));
            float latitude = cursor.getFloat(cursor.getColumnIndex("latitude"));
            float longitude = cursor.getFloat(cursor.getColumnIndex("longitude"));
            PontoTuristico lugares = new PontoTuristico(titulo, latitude, longitude);
            listaTuristica.add(lugares);
        }
        return listaTuristica;
    }
}
