package com.test.listecourse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);
    }

    public void onClickMagasins(View view){
        startActivity(new Intent(this, magasins.class));
    }

    public void onClickProduits(View view){
        startActivity(new Intent(this,listeproduit.class));
    }

    public void onClickListes(View view){
        Toast.makeText(this, "Liste de listes", Toast.LENGTH_SHORT).show();

    }
}
