package com.test.listecourse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class AffichageProduit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.affichage_produit);
        final Produit affich = (Produit)getIntent().getSerializableExtra("produit");
        Button retour= (Button) findViewById(R.id.retour);
        TextView nom= (TextView) findViewById(R.id.valeurNom);
        TextView prix= (TextView) findViewById(R.id.valeurPrix);
        TextView categorie= (TextView) findViewById(R.id.valeurCategorie);
        TextView promotion= (TextView) findViewById(R.id.valeurPromotion);
        TextView quantite= (TextView) findViewById(R.id.valeurQuantite);
        TextView position= (TextView) findViewById(R.id.valeurPosition);
        TextView code= (TextView) findViewById(R.id.valeurCode);

        nom.setText(String.valueOf(affich.nom));
        prix.setText(String.valueOf(affich.prix+" €"));
        categorie.setText(String.valueOf(affich.categorie));
        promotion.setText(String.valueOf(affich.promotion));
        quantite.setText(String.valueOf(affich.quantite));
        position.setText(String.valueOf(affich.emplacement));
        code.setText(String.valueOf(affich.code));

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}