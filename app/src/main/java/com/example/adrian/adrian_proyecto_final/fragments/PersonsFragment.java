package com.example.adrian.adrian_proyecto_final.fragments;


import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;

import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adrian.adrian_proyecto_final.R;
import com.example.adrian.adrian_proyecto_final.data.Class_Personas_Desaparecidas;
import com.example.adrian.adrian_proyecto_final.model.Custom_Adapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonsFragment extends Fragment {

    ArrayList<Class_Personas_Desaparecidas> dataModels;
    ListView listView;
    private static Custom_Adapter adapter;
    TextView txtVw;


    public PersonsFragment() {
        // Required empty public constructor

    }




    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
      //  txtVw = (TextView)rootView.findViewById(R.id.textView) ;
        listView =  rootView.findViewById(R.id.list_view_personas_desaparecidas);

        dataModels = new ArrayList<>();

        dataModels.add(new Class_Personas_Desaparecidas("Adrian Chavira","23 años","27 de Mayo del 2018","masculino"));
        dataModels.add(new Class_Personas_Desaparecidas("Jorge Sanchez","22 años","20 de Mayo del 2018","masculino"));
        dataModels.add(new Class_Personas_Desaparecidas("Adrian Chavira","23 años","27 de Mayo del 2018","masculino"));
        dataModels.add(new Class_Personas_Desaparecidas("Jorge Sanchez","22 años","20 de Mayo del 2018","masculino"));
        dataModels.add(new Class_Personas_Desaparecidas("Adrian Chavira","23 años","27 de Mayo del 2018","masculino"));
        dataModels.add(new Class_Personas_Desaparecidas("Jorge Sanchez","22 años","20 de Mayo del 2018","masculino"));
        dataModels.add(new Class_Personas_Desaparecidas("Adrian Chavira","23 años","27 de Mayo del 2018","masculino"));
        dataModels.add(new Class_Personas_Desaparecidas("Jorge Sanchez","22 años","20 de Mayo del 2018","masculino"));
        dataModels.add(new Class_Personas_Desaparecidas("Adrian Chavira","23 años","27 de Mayo del 2018","masculino"));
        dataModels.add(new Class_Personas_Desaparecidas("Jorge Sanchez","22 años","20 de Mayo del 2018","masculino"));
        dataModels.add(new Class_Personas_Desaparecidas("Adrian Chavira","23 años","27 de Mayo del 2018","masculino"));
        dataModels.add(new Class_Personas_Desaparecidas("Nahim Rodriguez","23 años","20 de Mayo del 2018","masculino"));


        adapter = new Custom_Adapter(dataModels, getContext());

        ArrayAdapter<Class_Personas_Desaparecidas> filesList = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, dataModels);
      //  listView.setAdapter(filesList);
       listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Class_Personas_Desaparecidas class_personas_desaparecidas = dataModels.get(position);
            }
        });


        return rootView;
    }
}
