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
        db.execSQL(MUSEUS);
        db.execSQL(MARCO_ZERO);
        db.execSQL(PONTES);
        db.execSQL(MERCADOS);
        db.execSQL(ARTESANATOS);
        db.execSQL(PARQUES);
        db.execSQL(PRAIAS);
        db.execSQL(BARES);
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
                    "texto TEXT" +
                    ");";
    // ----------------------------------------------------

    //Criação da Tabela Ponto Igrejas e Monumentos.-------------------
    public static String TBL_PONTO_IGREJASM= "tbl_pontoIgrejasM";
    private static String SQL_TBL_PONTO_IGREJASM =
            "CREATE TABLE tbl_pontoIgrejasM(" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "titulo TEXT," +
                    "descricao TEXT," +
                    "texto TEXT" +
                    ");";
    // ----------------------------------------------------

    //Criação da Tabela Ponto Pontes.-------------------
    public static String TBL_PONTO_PONTES= "tbl_pontoPontes";
    private static String SQL_TBL_PONTO_PONTES =
            "CREATE TABLE tbl_pontoPontes(" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "titulo TEXT," +
                    "descricao TEXT," +
                    "texto TEXT" +
                    ");";
    // ----------------------------------------------------

    //Criação da Tabela Ponto Mercados.-------------------
    public static String TBL_PONTO_MERCADOS= "tbl_pontoMercados";
    private static String SQL_TBL_PONTO_MERCADOS =
            "CREATE TABLE tbl_pontoMercados(" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "titulo TEXT," +
                    "descricao TEXT," +
                    "texto TEXT" +
                    ");";
    // ----------------------------------------------------

    //Criação da Tabela Ponto Artesanatos.-------------------
    public static String TBL_PONTO_ARTESANATOS= "tbl_pontoArtesanatos";
    private static String SQL_TBL_PONTO_ARTESANATOS =
            "CREATE TABLE tbl_pontoArtesanatos(" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "titulo TEXT," +
                    "descricao TEXT," +
                    "texto TEXT" +
                    ");";
    // ----------------------------------------------------


    //Criação da Tabela Ponto Parques e Praças.-------------------
    public static String TBL_PONTO_PARQUESP= "tbl_pontoParquesP";
    private static String SQL_TBL_PONTO_PARQUESP =
            "CREATE TABLE tbl_pontoParquesP(" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "titulo TEXT," +
                    "descricao TEXT," +
                    "texto TEXT" +
                    ");";
    // ----------------------------------------------------

    //Criação da Tabela Ponto Praias.-------------------
    public static String TBL_PONTO_PRAIAS= "tbl_pontoPraias";
    private static String SQL_TBL_PONTO_PRAIAS=
            "CREATE TABLE tbl_pontoPraias(" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "titulo TEXT," +
                    "descricao TEXT," +
                    "texto TEXT" +
                    ");";
    // ----------------------------------------------------

    //Criação da Tabela Ponto Bares e Restaurantes.-------------------
    public static String TBL_PONTO_BARESR= "tbl_pontoBaresR";
    private static String SQL_TBL_PONTO_BARESR =
            "CREATE TABLE tbl_pontoBaresR(" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "titulo TEXT," +
                    "descricao TEXT," +
                    "texto TEXT" +
                    ");";
    // ----------------------------------------------------


    //01
    private static final String MARCO_ZERO =
            "INSERT INTO tbl_pontoIgrejasM (titulo,descricao,texto)" +
                    "values ('Marco Zero'," +
                    "'O Marco zero é o ponto inicial das estradas do estado de Pernambuco....'," +
                    "'Lazer O Recife nasceu neste local: um trecho de terra em meio a um oceano de manguezais de frente para uma barreira de arrecifes de traçado quase perfeito. O local ideal para a construção de um porto." +
                    "Daqui, a cidade começou a se expandir, aterrando aquelas águas que lhe renderiam comparações com Veneza e as terras da Holanda.'" +
                    ");";

    // ----------------------------------------------------
    //01
    private static final String MUSEUS =
            "INSERT INTO tbl_pontoMuseusT (titulo,descricao,texto)" +
                    "values ('MUseus e Teatros'," +
                    "'Museus eeeee'," +
                    "'Museussssssssss'" +
                    ");";

    // ----------------------------------------------------
    //01
    private static final String PONTES=
            "INSERT INTO tbl_pontoPontes (titulo,descricao,texto)" +
                    "values ('PONTES'," +
                    "'Pontes'," +
                    "'Pontesssssss'" +
                    ");";

    // ----------------------------------------------------
    //01
    private static final String MERCADOS =
            "INSERT INTO tbl_pontoMercados (titulo,descricao,texto)" +
                    "values ('MERCADOS'," +
                    "'Mercados'," +
                    "'Mercadossssssssss'" +
                    ");";

    // ----------------------------------------------------
    //01
    private static final String ARTESANATOS =
            "INSERT INTO tbl_pontoArtesanatos (titulo,descricao,texto)" +
                    "values ('ARTESANATOS'," +
                    "'Artesanatos'," +
                    "'Artesanatosssssssssss'" +
                    ");";

    // ----------------------------------------------------
    //01
    private static final String PARQUES =
            "INSERT INTO tbl_pontoParquesP (titulo,descricao,texto)" +
                    "values ('PARQUES'," +
                    "'Parques'," +
                    "'Parquessssssssss'" +
                    ");";

    // ----------------------------------------------------
    //01
    private static final String PRAIAS =
            "INSERT INTO tbl_pontoPraias (titulo,descricao,texto)" +
                    "values ('PRAIAS'," +
                    "'Praias'," +
                    "'Praiassssssssss'" +
                    ");";

    // ----------------------------------------------------
    //01
    private static final String BARES =
            "INSERT INTO tbl_pontoBaresR (titulo,descricao,texto)" +
                    "values ('BARES'," +
                    "'Bares'," +
                    "'Baresssssssssss'" +
                    ");";

    // ----------------------------------------------------

}