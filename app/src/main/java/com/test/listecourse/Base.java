package com.test.listecourse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Lucas on 15/02/2017.
 */

public class Base extends SQLiteOpenHelper {
    private static int VERSIONBASE=5;
    private static final String Listes = "Listes";
    private static final String COL_ID_LISTES = "id";
    private static final String COL_ID_PRODUIT = "id_produit";
    private static final String COL_ID_MAGASIN = "idmagasin";
    private static final String COL_QUANTITE = "quantite";
    private static final String COL_ACHETE = "achete";

    private static final String Vend = "Vend";
    private static final String COL_PRIX = "prix";
    private static final String COL_UNITE = "unite";
    private static final String COL_RAYON = "rayon";
    private static final String COL_PROMOTION = "promotion";

    private static final String Produits = "Produits";
    private static final String COL_CATEGORIE = "Categorie";
    private static final String COL_NOM_PRODUITS = "Nom";
    private static final String COL_CODE = "Code";

    private static final String Magasins = "Magasins";
    private static final String COL_NOM_MAGASINS = "Nom";

    private static final String CREATE_TABLE_LISTES = "CREATE TABLE " + Listes + " ("
            + COL_ID_LISTES + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_ID_PRODUIT + " int NOT NULL, "
            + COL_ID_MAGASIN + " int NOT NULL,"
            + COL_QUANTITE + " FLOAT,"
            + COL_ACHETE + " FLOAT);";

    private static final String CREATE_TABLE_VEND = "CREATE TABLE " + Vend + " ("
            + COL_ID_PRODUIT + " INTEGER, "
            + COL_ID_MAGASIN + " INTEGER, "
            + COL_PRIX + " FLOAT,"
            + COL_UNITE + " FLOAT,"
            + COL_RAYON + " FLOAT,"
            + COL_PROMOTION + " TEXT," +
            "PRIMARY KEY("+COL_ID_PRODUIT+", "+COL_ID_MAGASIN+"));";

    private static final String CREATE_TABLE_PRODUITS = "CREATE TABLE " + Produits + " ("
            + COL_ID_PRODUIT + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_CATEGORIE + " TEXT NOT NULL, "
            + COL_CODE + " TEXT,"
            + COL_NOM_PRODUITS + " TEXT);";

    private static final String CREATE_TABLE_MAGASINS = "CREATE TABLE " + Magasins + " ("
            + COL_ID_MAGASIN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NOM_MAGASINS + " TEXT);";



    public Base(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory, VERSIONBASE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_LISTES);
        db.execSQL(CREATE_TABLE_VEND);
        db.execSQL(CREATE_TABLE_PRODUITS);
        db.execSQL(CREATE_TABLE_MAGASINS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + Listes + ";");
        db.execSQL("DROP TABLE " + Produits + ";");
        db.execSQL("DROP TABLE " + Magasins + ";");
        db.execSQL("DROP TABLE " + Vend + ";");
        onCreate(db);
    }

    public Produit cursorToProduit(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On créé un livre
        Produit produit = new Produit();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        produit.setCode(c.getInt(2));
        produit.setNom(c.getString(0));
        produit.setCategorie(c.getString(1));
        c.close();

        //On retourne le joueur
        return produit;
    }
}
