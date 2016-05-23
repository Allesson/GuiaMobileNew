package br.com.guiamobile.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Gilberto on 27/04/2016.
 */
public class PontoTuristicoOpenHelper extends SQLiteOpenHelper {

    private static String DATABASE_NOME = "db_pontoTuristico";
    private static int DATABASE_VERSAO = 1;

    public PontoTuristicoOpenHelper(Context context) {
        super(context, DATABASE_NOME, null, DATABASE_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Criando a Tabela.
        db.execSQL(SQL_TBL_PONTO_MUSEUST);
        db.execSQL(SQL_TBL_PONTO_IGREJASM);
        db.execSQL(SQL_TBL_PONTO_PONTES);
        db.execSQL(SQL_TBL_PONTO_MERCADOS);
        db.execSQL(SQL_TBL_PONTO_ARTESANATOS);
        db.execSQL(SQL_TBL_PONTO_PARQUESP);
        db.execSQL(SQL_TBL_PONTO_PRAIAS);
        db.execSQL(SQL_TBL_PONTO_BARESR);

        //Inserindo os Campos..

        db.execSQL(Museus.MUSEU1);
        db.execSQL(Museus.MUSEU2);
        db.execSQL(Museus.MUSEU3);
        db.execSQL(Museus.MUSEU4);
        db.execSQL(Museus.MUSEU5);

        db.execSQL(Mercados.MERCADO1);
        db.execSQL(Mercados.MERCADO2);
        db.execSQL(Mercados.MERCADO3);

        /*
        db.execSQL(Igrejas.IGREJA1);
        db.execSQL(Igrejas.IGREJA2);
        db.execSQL(Igrejas.IGREJA3);
        db.execSQL(Igrejas.IGREJA4);
        db.execSQL(Igrejas.IGREJA5);
        db.execSQL(Igrejas.IGREJA6);
        db.execSQL(Igrejas.IGREJA7);

        db.execSQL(Artesanatos.ARTESANATO1);
        db.execSQL(Artesanatos.ARTESANATO2);
        db.execSQL(Artesanatos.ARTESANATO3);
        db.execSQL(Artesanatos.ARTESANATO4);
        db.execSQL(Artesanatos.ARTESANATO5);

        db.execSQL(Praias.PRAIA1);
        db.execSQL(Praias.PRAIA2);
        db.execSQL(Praias.PRAIA3);
        db.execSQL(Praias.PRAIA4);
        db.execSQL(Praias.PRAIA5);
        */

        db.execSQL(Pontes.PONTE1);
        db.execSQL(Pontes.PONTE2);
        db.execSQL(Pontes.PONTE3);
        db.execSQL(Pontes.PONTE4);
        db.execSQL(Pontes.PONTE5);
        db.execSQL(Pontes.PONTE6);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Criação da Tabela Ponto Museus e Teatros.-------------------
    public static String TBL_PONTO_MUSEUST= "tbl_pontoMuseusT";
    private static String SQL_TBL_PONTO_MUSEUST =
            "CREATE TABLE tbl_pontoMuseusT(" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "titulo TEXT," +
                    "descricao TEXT," +
                    "texto TEXT," +
                    "latitude REAL," +
                    "longitude REAL," +
                    "idTab INTEGER" +
                    ");";
    // ----------------------------------------------------

    //Criação da Tabela Ponto Igrejas e Monumentos.-------------------
    public static String TBL_PONTO_IGREJASM= "tbl_pontoIgrejasM";
    private static String SQL_TBL_PONTO_IGREJASM =
            "CREATE TABLE tbl_pontoIgrejasM(" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "titulo TEXT," +
                    "descricao TEXT," +
                    "texto TEXT," +
                    "latitude REAL," +
                    "longitude REAL," +
                    "idTab INTEGER"+
                    ");";
    // ----------------------------------------------------

    //Criação da Tabela Ponto Pontes.-------------------
    public static String TBL_PONTO_PONTES= "tbl_pontoPontes";
    private static String SQL_TBL_PONTO_PONTES =
            "CREATE TABLE tbl_pontoPontes(" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "titulo TEXT," +
                    "descricao TEXT," +
                    "texto TEXT," +
                    "latitude REAL," +
                    "longitude REAL," +
                    "idTab INTEGER"+
                    ");";
    // ----------------------------------------------------

    //Criação da Tabela Ponto Mercados.-------------------
    public static String TBL_PONTO_MERCADOS= "tbl_pontoMercados";
    private static String SQL_TBL_PONTO_MERCADOS =
            "CREATE TABLE tbl_pontoMercados(" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "titulo TEXT," +
                    "descricao TEXT," +
                    "texto TEXT," +
                    "latitude REAL," +
                    "longitude REAL," +
                    "idTab INTEGER" +
                    ");";
    // ----------------------------------------------------

    //Criação da Tabela Ponto Artesanatos.-------------------
    public static String TBL_PONTO_ARTESANATOS= "tbl_pontoArtesanatos";
    private static String SQL_TBL_PONTO_ARTESANATOS =
            "CREATE TABLE tbl_pontoArtesanatos(" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "titulo TEXT," +
                    "descricao TEXT," +
                    "texto TEXT," +
                    "latitude REAL," +
                    "longitude REAL," +
                    "idTab INTEGER"+
                    ");";
    // ----------------------------------------------------


    //Criação da Tabela Ponto Parques e Praças.-------------------
    public static String TBL_PONTO_PARQUESP= "tbl_pontoParquesP";
    private static String SQL_TBL_PONTO_PARQUESP =
            "CREATE TABLE tbl_pontoParquesP(" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "titulo TEXT," +
                    "descricao TEXT," +
                    "texto TEXT," +
                    "latitude REAL," +
                    "longitude REAL," +
                    "idTab INTEGER"+
                    ");";
    // ----------------------------------------------------

    //Criação da Tabela Ponto Praias.-------------------
    public static String TBL_PONTO_PRAIAS= "tbl_pontoPraias";
    private static String SQL_TBL_PONTO_PRAIAS=
            "CREATE TABLE tbl_pontoPraias(" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "titulo TEXT," +
                    "descricao TEXT," +
                    "texto TEXT," +
                    "latitude REAL," +
                    "longitude REAL," +
                    "idTab INTEGER"+
                    ");";
    // ----------------------------------------------------

    //Criação da Tabela Ponto Bares e Restaurantes.-------------------
    public static String TBL_PONTO_BARESR= "tbl_pontoBaresR";
    private static String SQL_TBL_PONTO_BARESR =
            "CREATE TABLE tbl_pontoBaresR(" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "titulo TEXT," +
                    "descricao TEXT," +
                    "texto TEXT," +
                    "latitude REAL," +
                    "longitude REAL," +
                    "idTab INTEGER"+
                    ");";


}