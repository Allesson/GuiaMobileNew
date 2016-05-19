package br.com.guiamobile.view.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.guiamobile.R;

/**
 * Created by Gilberto on 18/05/2016.
 */
public class MapaFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view =  inflater.inflate(R.layout.fragment_mapa, null);




        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
