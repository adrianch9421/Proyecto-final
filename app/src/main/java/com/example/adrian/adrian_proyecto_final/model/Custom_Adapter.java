package com.example.adrian.adrian_proyecto_final.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.adrian.adrian_proyecto_final.R;
import com.example.adrian.adrian_proyecto_final.data.Class_Personas_Desaparecidas;

import java.util.ArrayList;

public class Custom_Adapter extends ArrayAdapter<Class_Personas_Desaparecidas> implements View.OnClickListener {

    private ArrayList<Class_Personas_Desaparecidas> dataSet;
    Context context;

    //View lookup cache
    private static class ViewHolder {
        TextView nombre;
        TextView edad;
        TextView genero;
        TextView fecha;
    }

    public Custom_Adapter(ArrayList<Class_Personas_Desaparecidas> data, Context context) {
        super(context, R.layout.row_item, data);

        this.dataSet = data;
        this.context = context;

    }


    @Override
    public void onClick(View v) {
        int position = (Integer) v.getTag();
        Object object = getItem(position);
        Class_Personas_Desaparecidas dataModel = (Class_Personas_Desaparecidas) object;


    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Class_Personas_Desaparecidas dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.nombre = (TextView) convertView.findViewById(R.id.txtVw_Nombre_PD);
            viewHolder.edad = (TextView) convertView.findViewById(R.id.textView_Edad);
            viewHolder.genero = (TextView) convertView.findViewById(R.id.txtVw_Genero);
            viewHolder.fecha = (TextView) convertView.findViewById(R.id.textView_Fecha_de_desaparicion);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }



        viewHolder.nombre.setText(dataModel.getNombre_persona());
        viewHolder.edad.setText(dataModel.getEdad());
        viewHolder.genero.setText(dataModel.getGenero());
        viewHolder.fecha.setText(dataModel.getFecha_de_desaparicion());
       // viewHolder.info.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }
}

