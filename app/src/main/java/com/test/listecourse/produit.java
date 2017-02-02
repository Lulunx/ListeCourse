package com.test.listecourse;

import android.util.Log;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Lucas on 01/02/2017.
 */

public class produit implements Serializable {
    String categorie;
    int quantite;
    String nom;
    int code;
    double prix;
    double promotion;
    String emplacement;

    public produit(){

    }

    public produit(String categorie, int quantite, String nom, int code, double prix, double promotion, String emplacement){
        this.categorie=categorie;
        this.quantite=quantite;
        this.nom=nom;
        this.code=code;
        this.prix=prix;
        this.promotion=promotion;
        this.emplacement=emplacement;
    }

    @Override
    public String toString(){
        return nom+"            "+prix+" €\n"+categorie;
    }

    public produit RetrouverProduit(ArrayList<produit> listeprod, String tostr){
        for(int i=0;i<listeprod.size();i++){
            Log.i("TAG", listeprod.get(i).toString());
            if(listeprod.get(i).toString().equals(tostr))
                return listeprod.get(i);
        }
        return null;
    }
}
