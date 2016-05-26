package br.com.guiamobile.view;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;

import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import br.com.guiamobile.R;
import br.com.guiamobile.view.Fragment.ArtesanatosFragment;
import br.com.guiamobile.view.Fragment.BaresRestFragment;
import br.com.guiamobile.view.Fragment.IgrejasMonuFragment;
import br.com.guiamobile.view.Fragment.MercadosFragment;
import br.com.guiamobile.view.Fragment.MuseusTeatrosFragment;
import br.com.guiamobile.view.Fragment.ParquesPracasFragment;
import br.com.guiamobile.view.Fragment.PontesFragment;
import br.com.guiamobile.view.Fragment.PraiasFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {

    private MapFragment mMapFragment;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mMapFragment = MapFragment.newInstance();
        mMapFragment.getMapAsync(this);

        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, mMapFragment);
        fragmentTransaction.commit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMapFragment = MapFragment.newInstance();
                mMapFragment.getMapAsync(MainActivity.this);
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.container, mMapFragment);
                fragmentTransaction.commit();
            }
        });

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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        Fragment fragment = null;
        switch (id) {
            case R.id.museu_menu:
                fragment = new MuseusTeatrosFragment();
                break;
            case R.id.igreja_menu:
                fragment = new IgrejasMonuFragment();
                break;
            case R.id.pontes_menu:
                fragment = new PontesFragment();
                break;
            case R.id.mercado_menu:
                fragment = new MercadosFragment();
                break;
            case R.id.artesanatos_menu:
                fragment = new ArtesanatosFragment();
                break;
            case R.id.parques_pracas_menu:
                fragment = new ParquesPracasFragment();
                break;
            case R.id.praias_menu:
                fragment = new PraiasFragment();
                break;
            case R.id.bares_restaurante_menu:
                fragment = new BaresRestFragment();
                break;


        }

        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (googleMap != null) {

           /* LatLng latlng = new LatLng(-8.063198, -34.871217);

            googleMap.addMarker(new MarkerOptions()
                    .position(latlng)
                    .title("Gilberto Feitosa"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));

            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 15.0f));
  */
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                googleMap.setMyLocationEnabled(true);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 9);
            }

        }


    }

     /*  @Override
    public void onMapReady(GoogleMap googleMap) {
        if (googleMap != null) {

            LatLng latlng = new LatLng(-8.054968, -34.890321);

            googleMap.addMarker(new MarkerOptions()
                    .position(latlng)
                    .title("Gilberto Feitosa"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));

         googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 15.0f));

            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                googleMap.setMyLocationEnabled(true);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 9);
            }

        }
    }
        */
}
