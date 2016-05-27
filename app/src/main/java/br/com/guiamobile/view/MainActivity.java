package br.com.guiamobile.view;


import android.Manifest;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;

import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;

import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;

import android.support.v4.content.ContextCompat;
import android.util.Log;

import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.MenuItem;

import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

import com.google.android.gms.maps.model.LatLng;

import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import br.com.guiamobile.R;
import br.com.guiamobile.controller.ListaMapaRepositorio;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private MapFragment mMapFragment;
    private FragmentTransaction fragmentTransaction;
    private GoogleApiClient mGoogleApiClient;
    private GoogleMap googleMap;
    private boolean localizacaoAjustada = false;

    private ListaMapaRepositorio listaMapaRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaMapaRepositorio = new ListaMapaRepositorio(this);

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

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            callConnection();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 9);
        }
    }


    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            callConnection();
        }
    }

    //pegar localização

    private void callConnection() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addOnConnectionFailedListener(this)
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(MainActivity.this, "O app Necessita de Sua Autorização para continuar", Toast.LENGTH_SHORT).show();
            return;
        }
        Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

        if (location != null) {
            SharedPreferences.Editor editor = getSharedPreferences("SHARED", Context.MODE_PRIVATE).edit();
            editor.putFloat("lat", (float) location.getLatitude());
            editor.putFloat("lng", (float) location.getLongitude());
            editor.commit();

            Log.v("AAT", "location change");
            if (!localizacaoAjustada && googleMap != null) {
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 11));
                localizacaoAjustada = true;
            }
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


    //---------------------------------------------------------------------------------------------
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

            case R.id.igreja:
                startActivity(new Intent(this, Igrejas.class));
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
        this.googleMap = googleMap;

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

        }
        googleMap.setMyLocationEnabled(true);

        SharedPreferences preferences = getSharedPreferences("SHARED", Context.MODE_PRIVATE);
        double latitude = preferences.getFloat("lat", 0);
        double longitude = preferences.getFloat("lng", 0);

        if (latitude != 0 && longitude != 0) {
            localizacaoAjustada = true;
        }

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 11));
    }

    private void pesquisar(String buscar) {
        SharedPreferences preferences = getSharedPreferences("SHARED", Context.MODE_PRIVATE);
        double latitude = preferences.getFloat("lat", 0);
        double longitude = preferences.getFloat("lng", 0);

        if (latitude != 0 && longitude != 0) {
            // locais suportados: https://developers.google.com/places/supported_types?hl=pt-br#table1
            String type = buscar;

            StringBuilder sb = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
            sb.append("location=" + latitude + "," + longitude);
            sb.append("&radius=20000"); // 20km
            sb.append("&types=" + type);
            sb.append("&sensor=false");
            sb.append("&language=pt-BR");
            sb.append("&key=AIzaSyBlDDor-Ra3yS-mhxNmVZbjiVuEVCpQYZw");

            System.out.println(sb.toString());

            PlacesTask placesTask = new PlacesTask();
            placesTask.execute(sb.toString());
        }
    }

    /**
     * Função para fazer o downlaod da url da google e trasnformar em STRING Json
     *
     * @param strUrl
     * @return
     * @throws IOException
     */
    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            iStream = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            data = sb.toString();
            br.close();
        } catch (Exception e) {
            Log.d("Exception", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }

        return data;
    }


    /**
     * Função para descarregar a URL e redirecionar para a próxima tarefa de exibir os ponteiros no mapa
     */
    private class PlacesTask extends AsyncTask<String, Integer, String> {

        String data = null;

        @Override
        protected String doInBackground(String... url) {
            try {
                data = downloadUrl(url[0]);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            MapPlacesTask parserTask = new MapPlacesTask();
            parserTask.execute(result);
        }

    }

    /***
     * Função que realmente exibe os ponteiros no mapa
     */
    private class MapPlacesTask extends AsyncTask<String, Integer, List<HashMap<String, String>>> {

        JSONObject jObject;

        @Override
        protected List<HashMap<String, String>> doInBackground(String... jsonData) {
            List<HashMap<String, String>> places = null;
            MapPlaces placeJsonParser = new MapPlaces();

            try {
                jObject = new JSONObject(jsonData[0]);
                places = placeJsonParser.parse(jObject);

            } catch (Exception e) {
                Log.d("Exception", e.toString());
            }
            return places;
        }

        @Override
        protected void onPostExecute(List<HashMap<String, String>> list) {

            googleMap.clear();

            for (int i = 0; i < list.size(); i++) {
                MarkerOptions markerOptions = new MarkerOptions();
                HashMap<String, String> hmPlace = list.get(i);

                double lat = Double.parseDouble(hmPlace.get("lat"));
                double lng = Double.parseDouble(hmPlace.get("lng"));
                String name = hmPlace.get("place_name");
                String endereco = hmPlace.get("vicinity");

                LatLng latLng = new LatLng(lat, lng);
                markerOptions.position(latLng);
                markerOptions.title(name);
                markerOptions.snippet(endereco);

                googleMap.addMarker(markerOptions);
            }
        }
    }

}
