package com.test.listecourse;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AjoutMagasin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajoutmagasin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final EditText champ = (EditText) findViewById(R.id.champ);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        if (getIntent().getExtras() != null) {
            String nommag = getIntent().getStringExtra("magasin");
            champ.setText(nommag);
        }
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent retour = new Intent();
                    Base bdd=new Base(getApplicationContext(),"BASE",null);
                    SQLiteDatabase Base = bdd.getWritableDatabase();
                    ContentValues magasin=new ContentValues();
                    magasin.put("Nom", champ.getText().toString());
                    Base.insert("Magasins", null, magasin);
                    setResult(Activity.RESULT_OK, retour);
                    finish();
                }
            });
        }
    }
