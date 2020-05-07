package com.example.parcialsegundocorte;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class PeronaCursorAdapter extends CursorAdapter {
    public PeronaCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.listar_personas, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nombre = (TextView) view.findViewById(R.id.vistaNombre);
        TextView cedula = (TextView) view.findViewById(R.id.vistaCedula);
        TextView estrato = (TextView) view.findViewById(R.id.vistaEstrato);
        TextView salario = (TextView) view.findViewById(R.id.vistaSalario);
        TextView educacion = (TextView) view.findViewById(R.id.vistaTitulo);
        // Extract properties from cursor
        String nombreS = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
        String cedulaS = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
        String estratoS= cursor.getString(cursor.getColumnIndexOrThrow("estrato"));
        String salarioS= cursor.getString(cursor.getColumnIndexOrThrow("salario"));
        String educacionS= cursor.getString(cursor.getColumnIndexOrThrow("titulo"));
        // Populate fields with extracted properties
        nombre.setText(nombreS);
        cedula.setText(cedulaS);
        estrato.setText(estratoS);
        salario.setText(salarioS);
        educacion.setText(educacionS);

    }
}
