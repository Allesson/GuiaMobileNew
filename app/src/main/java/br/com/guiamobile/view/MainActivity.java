package br.com.guiamobile.view;


import android.Manifest;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
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
import br.com.guiamobile.model.Praias;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private MapFragment mMapFragment;
    private FragmentTransaction fragmentTransaction;
    private GoogleApiClient mGoogleApiClient;
    private GoogleMap googleMap;
    private boolean localizacaoAjustada = false;
    private FloatingActionMenu fab;

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

/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
*/
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


        fab = (FloatingActionMenu) findViewById(R.id.fab);
        fab.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() {
            @Override
            public void onMenuToggle(boolean opened) {


            }
        });

        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (googleMap != null) {
                    googleMap.clear();
                    pesquisar("atm");
                    pesquisar("bank");
                }

            }
        });
        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (googleMap != null) {
                    googleMap.clear();
                    pesquisar("police");
                }

            }
        });
        FloatingActionButton fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (googleMap != null) {
                    googleMap.clear();
                    pesquisar("park");
                }

            }
        });
        FloatingActionButton fab4 = (FloatingActionButton) findViewById(R.id.fab4);
        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (googleMap != null) {
                    googleMap.clear();
                    pesquisar("art_gallery");
                }

            }
        });
        FloatingActionButton fab5 = (FloatingActionButton) findViewById(R.id.fab5);
        fab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (googleMap != null) {
                    googleMap.clear();
                    pesquisar("restaurant");
                    pesquisar("bar");
                }

            }
        });

        FloatingActionButton fab6 = (FloatingActionButton) findViewById(R.id.fab6);
        fab6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (googleMap != null) {
                    googleMap.clear();
                    pesquisar("hospital");
                }

            }
        });


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
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 10));
                localizacaoAjustada = true;
            }
        }
        fab.setClosedOnTouchOutside(true);
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
                startActivity(new Intent(this, IgrejasActivity.class));
                break;
            case R.id.museu:
                startActivity(new Intent(this, MuseuActivity.class));
                break;
            case R.id.pontes:
                startActivity(new Intent(this, PontesActivity.class));
                break;
            case R.id.praias:
                startActivity(new Intent(this, PraiasActivity.class));
                break;
            case R.id.share:
                String url = getString(R.string.linkapp);
                String mensagem = getString(R.string.compartilhar_main) + "\n" + url;
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, mensagem);
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent, mensagem));
                break;

            case R.id.avaliar:
                try {
                    PackageInfo pInfo = getApplicationContext().getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), 0);
                    String link = "https://play.google.com/store/apps/details?id=" + pInfo.packageName;
                    Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                    startActivity(it);

                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }

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
        try {


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
        } catch (Exception e) {

        }
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
            sb.append("&radius=10000");
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

            try {
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
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, getString(R.string.erro_sem_internet), Toast.LENGTH_SHORT).show();
            }
        }
    }

}
