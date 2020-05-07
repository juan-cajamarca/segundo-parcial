package com.example.parcialsegundocorte;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

public class Listar extends AppCompatActivity {

    PersonaController controller;
    ListView listadoPersonas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        listadoPersonas = findViewById(R.id.lstListarPersonas);
        controller = new PersonaController(getApplicationContext());

        Cursor cursor = controller.personas();

        PeronaCursorAdapter pca = new PeronaCursorAdapter(this,cursor,0);
        listadoPersonas.setAdapter(pca);
        pca.notifyDataSetChanged();
    }
}
