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
        db.execSQL(SQL_TBL_PONTO_IGREJAS);
        db.execSQL(SQL_TBL_PONTO_MUSEUS);
        db.execSQL(SQL_TBL_PONTO_PONTES);
        db.execSQL(SQL_TBL_PONTO_TEATROS);
        db.execSQL(SQL_TBL_PONTO_MONUMENTOS);
        db.execSQL(SQL_TBL_PONTO_ARTESANATOS);

        //Inserindo os Campos..

        db.execSQL(Igrejas.IGREJA1);
        db.execSQL(Igrejas.IGREJA2);
        db.execSQL(Igrejas.IGREJA3);
        db.execSQL(Igrejas.IGREJA4);
        db.execSQL(Igrejas.IGREJA5);
        db.execSQL(Igrejas.IGREJA6);
        db.execSQL(Igrejas.IGREJA7);
        db.execSQL(Igrejas.IGREJA8);
        db.execSQL(Igrejas.IGREJA9);
        db.execSQL(Igrejas.IGREJA10);
        db.execSQL(Igrejas.IGREJA11);
        db.execSQL(Igrejas.IGREJA12);
        db.execSQL(Igrejas.IGREJA13);
        db.execSQL(Igrejas.IGREJA14);
        db.execSQL(Igrejas.IGREJA15);

        db.execSQL(Museus.MUSEU1);
        db.execSQL(Museus.MUSEU2);
        db.execSQL(Museus.MUSEU3);
        db.execSQL(Museus.MUSEU4);
        db.execSQL(Museus.MUSEU5);
        db.execSQL(Museus.MUSEU6);
        db.execSQL(Museus.MUSEU7);
        db.execSQL(Museus.MUSEU8);
        db.execSQL(Museus.MUSEU9);
        db.execSQL(Museus.MUSEU10);
        db.execSQL(Museus.MUSEU11);

        db.execSQL(Pontes.PONTE1);
        db.execSQL(Pontes.PONTE2);
        db.execSQL(Pontes.PONTE3);
        db.execSQL(Pontes.PONTE4);
        db.execSQL(Pontes.PONTE5);
        db.execSQL(Pontes.PONTE6);

        db.execSQL(Teatros.TEATRO1);
        db.execSQL(Teatros.TEATRO2);
        db.execSQL(Teatros.TEATRO3);
        db.execSQL(Teatros.TEATRO4);
        db.execSQL(Teatros.TEATRO5);
        db.execSQL(Teatros.TEATRO6);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Criação da Tabela Ponto Museus e Teatros.-------------------
    public static String TBL_PONTO_MUSEUS= "tbl_pontoMuseus";
    private static String SQL_TBL_PONTO_MUSEUS =
            "CREATE TABLE tbl_pontoMuseus(" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "titulo TEXT," +
                    "descricao TEXT," +
                    "texto TEXT," +
                    "latitude REAL," +
                    "longitude REAL," +
                    "idTab INTEGER" +
                    ");";
    // ----------------------------------------------------

    //Criação da Tabela Ponto igrejas e Monumentos.-------------------
    public static String TBL_PONTO_IGREJAS= "tbl_pontoIgrejas";
    private static String SQL_TBL_PONTO_IGREJAS =
            "CREATE TABLE tbl_pontoIgrejas(" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "titulo TEXT," +
                    "descricao TEXT," +
                    "texto TEXT," +
                    "latitude REAL," +
                    "longitude REAL," +
                    "idTab INTEGER"+
                    ");";

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

    //Criação da Tabela Ponto Teatros.-------------------
    public static String TBL_PONTO_TEATROS= "tbl_pontoteatros";
    private static String SQL_TBL_PONTO_TEATROS=
            "CREATE TABLE tbl_pontoteatros(" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "titulo TEXT," +
                    "descricao TEXT," +
                    "texto TEXT," +
                    "latitude REAL," +
                    "longitude REAL," +
                    "idTab INTEGER"+
                    ");";

    //-----------------------------------------------------
    public static String TBL_PONTO_MONUMENTOS= "tbl_pontoMonumentos";
    private static String SQL_TBL_PONTO_MONUMENTOS=
            "CREATE TABLE tbl_pontoMonumentos (" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "titulo TEXT," +
                    "descricao TEXT," +
                    "texto TEXT," +
                    "latitude REAL," +
                    "longitude REAL," +
                    "idTab INTEGER"+
                    ");";

    // ----------------------------------------------------
    public static String TBL_PONTO_ARTESANATOS= "tbl_pontoArtesanatos";
    private static String SQL_TBL_PONTO_ARTESANATOS=
            "CREATE TABLE tbl_pontoArtesanatos (" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "titulo TEXT," +
                    "descricao TEXT," +
                    "texto TEXT," +
                    "latitude REAL," +
                    "longitude REAL," +
                    "idTab INTEGER"+
                    ");";

}