package br.com.guiamobile.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.SupportMapFragment;

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
        implements NavigationView.OnNavigationItemSelectedListener {

    private GoogleMapOptions options;
    private FragmentTransaction ft;
    private SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        options = new GoogleMapOptions();
        options.zOrderOnTop(true);
        mapFragment = SupportMapFragment.newInstance(options);
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, mapFragment).commit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, mapFragment).commit();

                //Snackbar.make(view, "Não Foi implementado esse caralho não", Snackbar.LENGTH_LONG)
                //.setAction("Action", null).show();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
}
