package com.test.listecourse;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;

public class EssaisConnexionResau extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container,
                                 Bundle savedInstanceState){

            super.onCreate(savedInstanceState);
            View view = inflater.inflate(R.layout.activity_essais_reseau,container,false);
            final Button Connexion=(Button)view.findViewById(R.id.connexion);
            final Button Retour=(Button)view.findViewById(R.id.retour);
            final TextView Text=(TextView)view.findViewById(R.id.text);

            Connexion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AsynchroneEssaiConnection lancer=new AsynchroneEssaiConnection();
                    lancer.execute();
                    try {
                        Text.setText(lancer.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            });


            Retour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getActivity().onBackPressed();
                }
            });



            return view;
    }

}
