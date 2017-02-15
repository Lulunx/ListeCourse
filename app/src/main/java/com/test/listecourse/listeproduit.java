package com.test.listecourse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ListeProduit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.produits);
        final ListView liste= (ListView) findViewById(R.id.liste1);
        Button retour= (Button) findViewById(R.id.retour);

        Produit fromage=new Produit("Laitage", 1, "Camembert Président", 1023102, 1.92, 0.0, "F12");
        Produit rillettes=new Produit("Charcuterie", 4, "Poulet Roti Bordeaux Chesnel", 11232154, 2.43, 0.0, "C04");
        Produit pq=new Produit("Beauté-Santé", 2, "Lotus x6", 20314654, 2.80, 0.0, "H08");

        final ArrayList<String> listeprod=new ArrayList<String>();
        listeprod.add(fromage.toString());
        listeprod.add(rillettes.toString());
        listeprod.add(pq.toString());

        final ArrayList<Produit> listeprodoff=new ArrayList<Produit>();
            listeprodoff.add(fromage);
            listeprodoff.add(rillettes);
            listeprodoff.add(pq);

        liste.setAdapter(new ArrayAdapter<Produit>(this ,android.R.layout.simple_list_item_1, listeprodoff));
        liste.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent vueproduit=new Intent(ListeProduit.this, AffichageProduit.class);
                        Produit inter=listeprodoff.get(position);
                        vueproduit.putExtra("produit", inter);
                        startActivity(vueproduit);
                    }});

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
