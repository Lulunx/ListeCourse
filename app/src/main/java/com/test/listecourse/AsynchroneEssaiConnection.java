package com.test.listecourse;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Lucas on 03/03/2017.
 */

public class AsynchroneEssaiConnection extends AsyncTask<String, Void, String> {

    @Override
    public String doInBackground(String... params){
        InputStream reponse;
        try {
            URL url=new URL("http://lucasgancel.ovh/coursandroid.php");
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setUseCaches(false);
            conn.connect();
            reponse= conn.getInputStream();
            return readIt(reponse);
        } catch(IOException e){
            System.out.println(e);
        }
        return null;
    }

    private static String readIt(InputStream is) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = r.readLine()) != null) {
            response.append(line).append('\n');
        }
        return response.toString();
    }
}
