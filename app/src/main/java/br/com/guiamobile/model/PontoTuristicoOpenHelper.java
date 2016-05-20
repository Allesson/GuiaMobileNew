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
        db.execSQL(MARCO_ZERO);
        db.execSQL(PONTES);
        db.execSQL(ARTESANATOS);
        db.execSQL(PARQUES);
        db.execSQL(PRAIAS);
        db.execSQL(BARES);

        db.execSQL(M_A_M_A_MAGALHAES);
        db.execSQL(M_C_RECIFE);
        db.execSQL(M_H_NORDESTE);
        db.execSQL(M_M_GRECA);
        db.execSQL(M_MILITAR);

        db.execSQL(ME_B_VISTA);
        db.execSQL(ME_MADALENA);
        db.execSQL(ME_S_JOSE);

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

    // ----------------------------------------------------
    //01
    private static final String PONTES=
            "INSERT INTO tbl_pontoPontes (titulo,descricao,texto)" +
                    "values ('PONTES'," +
                    "'Pontes'," +
                    "'Pontesssssss'" +
                    ");";

    // ----------------------------------------------------


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

    //MUSEUS______________________________________________________________________________________________

    private static final String M_H_NORDESTE =
            "INSERT INTO tbl_pontoMuseusT (titulo,descricao,texto, latitude, longitude, idTab)" +
                    "values ('Museu do Homem do Nordeste'," +
                    "'Av. Dezessete de Agosto,2187, Casa Forte.'," +
                    "' É um órgão federal (vinculado à Fundação Joaquim Nabuco/Ministério da Educação), que reúne acervos que revelam a pluralidade das culturas negras, indígenas e brancas desde nossas origens até os diferentes desdobramentos e misturas que formam o que hoje é chamado genericamente de cultura brasileira. Esses acervos servem de suporte para construir narrativas que estão traduzidas em exposições etnográficas e exposições de arte, assim como em ações educativas de mediação cultural e em diferentes eventos que compõem a programação cultural do museu.'," +"-8.030196,"+"-34.925281,"+"1"+
            ");";
    private static final String M_M_GRECA =
            "INSERT INTO tbl_pontoMuseusT (titulo,descricao,texto, latitude, longitude, idTab)" +
                    "values ('Museu Murillo La Greca'," +
                    "'R. Leonardo Bezerra Cavalcante,366, Parnamirim.'," +
                    "' Comportando um acervo de 1.400 desenhos, com técnicas de fusain, crayon, pastel e sanguínea, o museu ainda possui discos, livros e mobiliários expostos em caráter de longa duração em quatro das oito salas de exposição. Há também 160 pinturas, entre paisagens, retratos e impressionistas e cartas, trocadas com Portinari e Giacometti. Foi nesse acervo que La Greca deixou sua marca inconfundível, tendo o seu forte na diversidade de sua obra artística, da aproximação com a arte contemporânea. Esse rico patrimônio está à disposição da população recifense, de forma atualmente mais intensa e orgânica. '," +"-8.037325,"+"-34.909832,"+"1"+
            ");";
    private static final String M_C_RECIFE=
            "INSERT INTO tbl_pontoMuseusT (titulo,descricao,texto, latitude, longitude, idTab)" +
                    "values ('Museu da Cidade do Recife'," +
                    "'Praca das cinco pontas, São José.'," +
                    "' O museu destaca-se por conter em seu acervo documentos iconográficos de extrema importância para preservação da história urbana e social do Recife. A memória cultural da capital pernambucana é representada através de cerca de 150 mil imagens e de peças provenientes de antigas residências e da Igreja do Senhor Bom Jesus dos Martírios, já demolida.'," +"-8.071313,"+"-34.880809,"+"1"+
            ");";
    private static final String M_MILITAR=
            "INSERT INTO tbl_pontoMuseusT (titulo,descricao,texto, latitude, longitude, idTab)" +
                    "values ('Museu Militar'," +
                    "'Av. Militar, s/n, Recife'," +
                    "' Em 1595 existia no local a Bateria Bom Jesus. Em 1629 foram iniciadas as obras de um novo forte. Após a invasão holandesa tomou o nome de Johann de Bruyne. Reconstruído após a Insurreição Pernambucana e concluído em 1690, abriga hoje o Museu Militar, com canhões portugueses/ingleses, armas, fotos e objetos que marcaram a ação da Força Aérea Brasileira na II Guerra Mundial.'," +"-8.052803,"+"-34.871412,"+"1"+
            ");";
    private static final String M_A_M_A_MAGALHAES=
            "INSERT INTO tbl_pontoMuseusT (titulo,descricao,texto, latitude, longitude, idTab)" +
                    "values ('Museu de Arte Moderna Aloísio Magalhães'," +
                    "'Rua da Aurora, 265, Boa Vista'," +
                    "'O MAMAM conta com um acervo de cerca de 1.100 trabalhos, de diversas técnicas, que abrangem um período histórico compreendido entre 1920 e 2008. Deste acervo, fazem parte obras fundamentais para a compreensão da arte moderna e contemporânea brasileira, de renomados artistas, dentre os quais se destacam João Câmara (com a série “Cenas da Vida Brasileira”), Vicente do Rego Monteiro (com um conjunto de telas que representa a maior coleção pública desse importante artista brasileiro), Aloisio Magalhães, Gil Vicente, Lula Cardoso Ayres, Abelardo da Hora, Joaquim do Rego Monteiro, Francisco Brennand, Gilvan Samico, José Patrício, Paulo Bruscky, Nelson Leirner, Alex Flemming, Carlos Fajardo, Marcelo Silveira, Rivane Neuenschwander, Ernesto Neto e Vik Muniz.'," +"-8.061285,"+"-34.881394,"+"1"+
            ");";

    private static final String ME_S_JOSE=
            "INSERT INTO tbl_pontoMercados (titulo,descricao,texto, latitude, longitude, idTab)" +
                    "values ('Mercado de São José'," +
                    "' Praça Dom Vital, s/n - São José, Recife'," +
                    "'O Mercado de São José ocupa uma área coberta de 3.541 metros quadrados. Mede 48,88 m de frente por 75,44 m de fundo. O prédio é formado por dois pavilhões, com 377 compartimentos de diversos produtos; 27 pedras de peixe; 34 barracas internas – para vender comidas e caldo de cana – e outras 70 espalhadas pela calçada do pátio. Atualmente, são 545 boxes no total. Artesanato em barro, corda e palha fazem do mercado polo de atração turística. É, também, ponto tradicional do comércio de pescado. Semanalmente são vendidos, ali, cerca de 1,3 toneladas de peixe e 400 kg de crustáceos.'," +"-8.06806,"+"-34.87775,"+"4"+
            ");";

    private static final String ME_B_VISTA=
            "INSERT INTO tbl_pontoMercados (titulo,descricao,texto, latitude, longitude, idTab)" +
                    "values ('Mercado da Boa Vista'," +
                    "' R. de Santa Cruz, Boa Vista'," +
                    " 'O Mercado da Boa Vista possui 63 boxes, que comercializam cereais, verduras, frutas e legumes, carnes, aves e frios, além de ervas e armarinhos. Há nove bares, que servem comida regional no café da manhã, almoço e jantar. A clientela é formada, principalmente, por sindicalistas e políticos, que se deliciam com o famoso patinho cozido no feijão preto.'," +"-8.063192,"+"-34.888654,"+"4"+
            ");";

    private static final String ME_MADALENA=
            "INSERT INTO tbl_pontoMercados (titulo,descricao,texto, latitude, longitude, idTab)" +
                    "values ('Mercado da Madalena'," +
                    "'Rua Real da Torre, na praça Solange Pinto Melo, Madalena'," +
                    " 'O Bairro da Madalena é local de grande importância histórica. Foi rentável zona açucareira do Recife antigo. A construção do mercado teve início em 6 de fevereiro de 1925, e a inauguração se deu no mesmo ano. No local, se reunía um aglomerado de feirantes, que ali vendiam frutas e verduras, sem qualquer interferência por parte da Prefeitura. Funcionava à noite e, por isso, recebeu o nome de Mercado do Bacurau. Hoje, são 180 compartimentos, que oferecem alimentos variados: frutas, verduras, legumes, cereais, carnes e peixe.'," +"-8.052439,"+"-34.908554,"+"4"+
            ");";






}