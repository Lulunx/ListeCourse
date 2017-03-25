package com.test.listecourse;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class Magasins extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                                ViewGroup container,
                                Bundle savedInstanceState){
        Base bdd=new Base(getActivity(),"BASE",null);
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.content_magasins,container,false);

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getActivity(), AjoutMagasin.class),1);

            }
        });

        final ListView liste = (ListView)  view.findViewById(R.id.listemag);
        SQLiteDatabase Base = bdd.getWritableDatabase();
        Cursor c= Base.query("Magasins", new String[] {"Nom","idmagasin as _id"}, null, null, null, null, null, null);

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                getActivity(),
                android.R.layout.simple_list_item_2, //R.layout.un_magasin,
                c,
                new String[]{"Nom","_id"},
                new int[]{android.R.id.text1, android.R.id.text2});
        liste.setAdapter(adapter);
        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,View view, int position, long id) {
                Intent modif = new Intent(getActivity(), AjoutMagasin.class);
                Cursor Curs=(Cursor)liste.getItemAtPosition(position);
                String val=Curs.getString(0);
                modif.putExtra("magasin",val);
                startActivityForResult(modif,2);
            }
        });

        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){

        switch(requestCode){
            case(1):
                switch(resultCode){
                    case(Activity.RESULT_OK):
                        //android.R.layout.simple_list_item_2.notifyDataChanged();
                        Toast.makeText(getActivity(), "Magasin inséré avec succès", Toast.LENGTH_SHORT).show();
                }
            case(2):
                switch(resultCode){
                    case(Activity.RESULT_OK):
                        String mot = data.getStringExtra("NOM_MAGASIN");
                        Toast.makeText(getActivity(), mot, Toast.LENGTH_SHORT).show();
                }
        }
    }
}

