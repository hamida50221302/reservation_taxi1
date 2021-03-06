package com.example.hamida.taxi;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class AppMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView img_reservation;
    private ImageView img_taxiProche;
    private ImageView img_passager;
    private FragmentManager manager;
    private FragmentTransaction ft;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_main);
        //map
        MapFrag mapFrag = new MapFrag();
        manager = getSupportFragmentManager();
        ft = manager.beginTransaction();
        ft.replace(R.id.main_centent, mapFrag);
        ft.commitAllowingStateLoss();


        img_passager =(ImageView) findViewById(R.id.imag_passager);
        img_reservation =(ImageView) findViewById(R.id.bt_reservation);
        img_reservation =(ImageView) findViewById(R.id.bt_reservation);
        img_taxiProche =(ImageView) view.findViewById(R.id.bt_reservation );
        img_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reservation reserveFrag = new reservation();
                manager = getSupportFragmentManager();
                ft = manager.beginTransaction();
                ft.replace(R.id.main_centent, reserveFrag);
                ft.commitAllowingStateLoss();


            }
        });
        img_taxiProche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taxiProche listTaxi = new taxiProche();
                manager = getSupportFragmentManager();
                ft = manager.beginTransaction();
                ft.replace(R.id.main_centent, listTaxi);
                ft.commitAllowingStateLoss();


            }
        });
        img_passager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passager passagerfrag = new passager();
                manager = getSupportFragmentManager();
                ft = manager.beginTransaction();
                ft.replace(R.id.main_centent, passagerfrag);
                ft.commitAllowingStateLoss();


            }
        });



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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
        getMenuInflater().inflate(R.menu.app_main, menu);
        return true;
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_Home) {
            // Handle the camera action
            MapFrag mapFrag = new MapFrag();
            manager = getSupportFragmentManager();
            ft = manager.beginTransaction();
            ft.replace(R.id.main_centent, mapFrag);
            ft.commitAllowingStateLoss();

        } else if (id == R.id.nav_profile) {
            Profile profilFrag = new Profile();
            manager = getSupportFragmentManager();
            ft = manager.beginTransaction();
            ft.replace(R.id.main_centent, profilFrag);
            ft.commitAllowingStateLoss();
        } else if (id == R.id.nav_Exit) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}

