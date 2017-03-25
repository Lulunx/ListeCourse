package com.test.listecourse;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuAccueil extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_accueil);
        Accueil frag=new Accueil();
        fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransac = fragmentManager.beginTransaction();
        fragmentTransac.replace(R.id.accrochefrag, frag);
        fragmentTransac.commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Menu");
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Base bdd=new Base(this,"BASE",null);
        SQLiteDatabase Base = bdd.getWritableDatabase();
        Cursor c1= Base.query("Magasins", new String[] {"idmagasin as _id"}, "_id=1", null, null, null, null, null);
        if(c1.getCount()==0){
            ContentValues Leclerc=new ContentValues();
            Leclerc.put("idmagasin", "1");
            Leclerc.put("Nom", "Leclerc");
            Base.insert("Magasins", null, Leclerc);
        }

        Cursor c2= Base.query("Magasins", new String[] {"idmagasin as _id"}, "_id=2", null, null, null, null, null);
        if(c2.getCount()==0){
            ContentValues Carrefour=new ContentValues();
            Carrefour.put("idmagasin", "2");
            Carrefour.put("Nom", "Carrefour");
            Base.insert("Magasins", null, Carrefour);
        }

        /*Produit fromage=new Produit("Laitage", 1, "Camembert Président", 1023102, 1.92, 0.0, "F12");
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put("Categorie", fromage.categorie);
        values.put("Code", fromage.code);
        values.put("Nom", fromage.nom);
        Base.insert("Produits", null, values);
        Cursor c= Base.query("Produits", new String[] {"Categorie", "Code", "Nom"}, null, null, null, null, null, null);
        Produit result=bdd.cursorToProduit(c);
        Toast.makeText(this, result.toString(), Toast.LENGTH_SHORT).show();*/

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Hey Dude !", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_accueil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, ActivityParametre.class));
        }

        return super.onOptionsItemSelected(item);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentTransaction fragmenTransac= getFragmentManager().beginTransaction();

        if (id == R.id.listMag) {
            Magasins frag = new Magasins();
            fragmenTransac.replace(R.id.accrochefrag, frag).addToBackStack(null);
            getSupportActionBar().setTitle("Magasins");
        } else if (id == R.id.listProduit) {
            ListeProduit frag = new ListeProduit();
            fragmenTransac.replace(R.id.accrochefrag, frag).addToBackStack(null);
            getSupportActionBar().setTitle("Produits");
        }else if (id == R.id.listListe) {
            //Listes frag = new Listes();
            //fragmenTransac.replace(R.id.content_menu_accueil, frag).addToBackStack(null).commit();;
            Toast.makeText(this, "Liste de liste", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.testConnexion) {
            EssaisConnexionResau frag = new EssaisConnexionResau();
            fragmenTransac.replace(R.id.accrochefrag, frag).addToBackStack(null);
            getSupportActionBar().setTitle("Connexion");
        }
        else if (id == R.id.lancerService) {
            LancerService frag = new LancerService();
            fragmenTransac.replace(R.id.accrochefrag, frag).addToBackStack(null);
            getSupportActionBar().setTitle("Service");
        }


        fragmenTransac.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(this, MyIntentService.class));
    }
}
