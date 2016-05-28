package br.com.guiamobile.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import br.com.guiamobile.R;
import br.com.guiamobile.controller.PontoPraiasRepositorio;
import br.com.guiamobile.model.Adapter.RetornoBusca_Adapter;
import br.com.guiamobile.model.PontoTuristico;

/**
 * Created by Allesson on 27/05/2016.
 */
public class PraiasActivity extends AppCompatActivity {
    private static final int BUSCAR = 1;
    private ListView lista;
    private PontoPraiasRepositorio pontoPraiasRepositorio;
    private static final int PONTO_TURISTICO = 1;
    private LayoutInflater menuLayout;
    List<PontoTuristico> listaDeLugares;
    RetornoBusca_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragments);


        lista = (ListView) findViewById(R.id.lista_lugares);
        lista.setEmptyView(findViewById(R.id.msg_lista_vazia));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaDeLugares = new ArrayList<>();
        pontoPraiasRepositorio = new PontoPraiasRepositorio(this);

        carregarLugares();

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                PontoTuristico pontoEscolhido = listaDeLugares.get(position);


                Intent intent = new Intent(PraiasActivity.this, PontoEscolhidoActivity.class);
                intent.putExtra("PontoEscolhido", pontoEscolhido);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SearchView sv = new SearchView(this);
        sv.setOnQueryTextListener(new SearchFiltro());

        MenuItem pesquisa = menu.add(0, 0, 0, "Pesquisa");
        pesquisa.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        pesquisa.setActionView(sv);

        return super.onCreateOptionsMenu(menu);
    }

    protected class SearchFiltro implements SearchView.OnQueryTextListener {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String s) {
            carregarLugares();
            if (!s.toString().equals("")) {
                boolean retorno = false;
                do {
                    retorno = searchItem(s.toString());
                } while (!retorno);

            }
            return false;
        }
    }

    //localizar
    public boolean searchItem(String textToSearch) {
        for (PontoTuristico item : listaDeLugares) {
            if (!item.getTitulo().toLowerCase().contains(textToSearch.toLowerCase())) {
                listaDeLugares.remove(item);
                adapter.notifyDataSetChanged();
                return false;
            }
        }
        return true;
    }


    private void carregarLugares() {
        listaDeLugares = pontoPraiasRepositorio.listar();
        adapter = new RetornoBusca_Adapter(this, listaDeLugares);
        this.lista.setAdapter(adapter);
    }
}
