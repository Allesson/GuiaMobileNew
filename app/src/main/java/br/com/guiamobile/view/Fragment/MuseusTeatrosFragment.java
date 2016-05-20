package br.com.guiamobile.view.Fragment;


import android.content.Intent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import br.com.guiamobile.R;
import br.com.guiamobile.controller.PontoMuseusTRepositorio;
import br.com.guiamobile.model.Adapter.RetornoBusca_Adapter;
import br.com.guiamobile.model.PontoTuristico;

/**
 * Created by Allesson on 15/05/2016.
 */
public class MuseusTeatrosFragment extends Fragment {

    private static final int BUSCAR = 1;
    private ListView lista;
    private PontoMuseusTRepositorio pontoMuseusTRepositorio;
    private static final int PONTO_TURISTICO = 1;
    private EditText edt_buscar;
    private LayoutInflater menuLayout;
    List<PontoTuristico> listaDeLugares;
    RetornoBusca_Adapter adapter;
    TextView btn_lazer;
    private Toolbar toolbar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragments, null);


        lista = (ListView) view.findViewById(R.id.lista_lugares);
        lista.setEmptyView(view.findViewById(R.id.msg_lista_vazia));

        listaDeLugares = new ArrayList<>();
        pontoMuseusTRepositorio = new PontoMuseusTRepositorio(getContext());


        carregarLugares();

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                PontoTuristico pontoEscolhido = listaDeLugares.get(position);


                Intent intent = new Intent(getContext(), PontoEscolhidoActivity.class);
                intent.putExtra("PontoEscolhido", pontoEscolhido);
                startActivity(intent);
            }
        });

        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        SearchView sv = new SearchView(getContext());
        sv.setOnQueryTextListener(new SearchFiltro());

        MenuItem pesquisa = menu.add(0, 0, 0, "Pesquisa");
        pesquisa.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        pesquisa.setActionView(sv);

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
        listaDeLugares = pontoMuseusTRepositorio.listar();
        adapter = new RetornoBusca_Adapter(getContext(), listaDeLugares);
        this.lista.setAdapter(adapter);
    }


}