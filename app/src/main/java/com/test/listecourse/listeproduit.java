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


public class listeproduit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.produits);
        ListView liste= (ListView) findViewById(R.id.liste1);
        Button retour= (Button) findViewById(R.id.Retour);

        produit fromage=new produit("Laitage", 1, "Camembert Président", 1023102, 1.92, 0.0, "F12");
        produit rillettes=new produit("Charcuterie", 4, "Poulet Roti Bordeaux Chesnel", 11232154, 2.43, 0.0, "C04");
        produit pq=new produit("Beauté-Santé", 2, "Lotus x6", 20314654, 2.80, 0.0, "H08");

        final ArrayList<String> listeprod=new ArrayList<String>();
        listeprod.add(fromage.toString());
        listeprod.add(rillettes.toString());
        listeprod.add(pq.toString());

        final ArrayList<produit> listeprodoff=new ArrayList<produit>();
            listeprodoff.add(fromage);
            listeprodoff.add(rillettes);
            listeprodoff.add(pq);

        //setListAdapter(new MyAdapter(this, listeprod));
        liste.setAdapter(new ArrayAdapter<String>(this ,android.R.layout.simple_list_item_1, listeprod));

        liste.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent,
                                            View view, int position, long id) {
                        Intent vueproduit=new Intent(listeproduit.this, affichageproduit.class);
                        produit inter= new produit();
                        inter=inter.RetrouverProduit(listeprodoff, listeprod.get((int)id));
                        vueproduit.putExtra("produit", inter);
                        startActivity(vueproduit);
                    }});

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(listeproduit.this,accueil.class));
            }
        });
    }
}
