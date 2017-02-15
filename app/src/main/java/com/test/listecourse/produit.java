package com.test.listecourse;

import android.util.Log;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Lucas on 01/02/2017.
 */

public class Produit implements Serializable {
    String categorie;
    int quantite;
    String nom;
    int code;
    double prix;
    double promotion;
    String emplacement;

    public Produit(){

    }

    public Produit(String categorie, int quantite, String nom, int code, double prix, double promotion, String emplacement){
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

    public Produit RetrouverProduit(ArrayList<Produit> listeprod, String tostr){
        for(int i=0;i<listeprod.size();i++){
            Log.i("TAG", listeprod.get(i).toString());
            if(listeprod.get(i).toString().equals(tostr))
                return listeprod.get(i);
        }
        return null;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getPromotion() {
        return promotion;
    }

    public void setPromotion(double promotion) {
        this.promotion = promotion;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCategorie() {

        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}
