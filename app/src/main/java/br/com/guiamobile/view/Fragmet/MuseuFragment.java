package br.com.guiamobile.view.Fragmet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.guiamobile.R;

/**
 * Created by Gilberto on 15/05/2016.
 */
public class MuseuFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // se precisar inicialiar algo, deve ser aqui.. mais deve usar o View onCreante abaixo..
        // se precisar de um CONTEXT ou seja instancia da tela vc usar o metodo getActivity ou getConxtex
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.museu_fragment, null);



        return view;
    }
}
