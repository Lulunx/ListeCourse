package com.test.listecourse;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class AffichageProduit extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.affichage_produit,container,false);
        Bundle bundle = this.getArguments();
        Produit affich=new Produit();
        if (bundle != null) {
            affich = (Produit) bundle.getSerializable("produit");
        }
        Button retour= (Button) view.findViewById(R.id.retour);
        TextView nom= (TextView) view.findViewById(R.id.valeurNom);
        TextView prix= (TextView) view.findViewById(R.id.valeurPrix);
        TextView categorie= (TextView) view.findViewById(R.id.valeurCategorie);
        TextView promotion= (TextView) view.findViewById(R.id.valeurPromotion);
        TextView quantite= (TextView) view.findViewById(R.id.valeurQuantite);
        TextView position= (TextView) view.findViewById(R.id.valeurPosition);
        TextView code= (TextView) view.findViewById(R.id.valeurCode);

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
                getActivity().onBackPressed();
            }
        });

        return view;
    }
}