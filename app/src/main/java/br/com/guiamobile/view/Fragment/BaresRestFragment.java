package br.com.guiamobile.view.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.guiamobile.R;
import br.com.guiamobile.controller.PontoBaresRRepositorio;
import br.com.guiamobile.model.Adapter.RetornoBusca_Adapter;
import br.com.guiamobile.model.PontoTuristico;
import br.com.guiamobile.view.PontoTuristicoEscolhido;

/**
 * Created by Allesson on 15/05/2016.
 */
public class BaresRestFragment extends Fragment {

    private static final int BUSCAR = 1;
    private ListView lista;
    private PontoBaresRRepositorio pontoBaresRRepositorio;
    private static final int PONTO_TURISTICO = 1;
    private EditText edt_buscar;
    private LayoutInflater menuLayout;
    List<PontoTuristico> listaDeLugares;
    RetornoBusca_Adapter adapter;
    TextView btn_lazer;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // se precisar inicialiar algo, deve ser aqui.. mais deve usar o View onCreante abaixo..
        // se precisar de um CONTEXT ou seja instancia da tela vc usar o metodo getActivity ou getConxtex
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragments, null);

        lista = (ListView) view.findViewById(R.id.lista_lugares);
        lista.setEmptyView(view.findViewById(R.id.msg_lista_vazia));

        listaDeLugares = new ArrayList<>();
        pontoBaresRRepositorio = new PontoBaresRRepositorio(getContext());


        edt_buscar = (EditText) view.findViewById(R.id.edt_buscar);
        edt_buscar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                carregarLugares();
                if (!s.toString().equals("")) {
                    boolean retorno = false;
                    do {
                        retorno = searchItem(s.toString());
                    } while (!retorno);

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        carregarLugares();

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                PontoTuristico pontoEscolhido = listaDeLugares.get(position);


                Intent intent = new Intent(getContext(), PontoTuristicoEscolhido.class);
                intent.putExtra("PontoEscolhido", pontoEscolhido);
                startActivity(intent);
            }
        });
        return view;
    }


    private void carregarLugares() {
        listaDeLugares = pontoBaresRRepositorio.listar();
        adapter = new RetornoBusca_Adapter(getContext(),listaDeLugares);
        this.lista.setAdapter(adapter);
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
}