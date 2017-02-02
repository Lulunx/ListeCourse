package com.test.listecourse;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class magasins extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magasins);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ListView liste = (ListView)  findViewById(R.id.listemag);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(magasins.this, ajoutmagasin.class),1);

            }
        });
        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,View view, int position, long id) {
                Intent modif = new Intent(magasins.this, ajoutmagasin.class);
                modif.putExtra("magasin",String.valueOf(liste.getItemAtPosition(position)));
                startActivityForResult(modif,2);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){

        switch(requestCode){
            case(1):
                switch(resultCode){
                    case(Activity.RESULT_OK):
                        String mot = data.getStringExtra("NOM_MAGASIN");;
                }
            case(2):
                switch(resultCode){
                    case(Activity.RESULT_OK):
                        String mot = data.getStringExtra("NOM_MAGASIN");}
        }

    }

}

