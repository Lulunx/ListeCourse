package com.test.listecourse;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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

public class LancerService extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_lancement_service,container,false);
        final Button Lancer=(Button)view.findViewById(R.id.lancer);
        final TextView Text=(TextView)view.findViewById(R.id.text);

        Lancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startService(new Intent(getActivity(), MyIntentService.class));
                Log.i("OK", "Lancement");
                Text.setText("check");
            }
        });

        return view;
    }

}
