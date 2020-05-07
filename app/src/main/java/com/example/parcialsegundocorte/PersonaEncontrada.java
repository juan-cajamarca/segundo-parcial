package com.example.parcialsegundocorte;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class PersonaEncontrada extends AppCompatActivity {

    PersonaController controller;
    ListView listadoPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona_encontrada);

        String cedula = getIntent().getStringExtra("cedulaPersona");

        listadoPersonas = findViewById(R.id.lstPersonaEncontrada);
        controller = new PersonaController(getApplicationContext());

        Cursor cursor = controller.buscarPersona(cedula);

        PeronaCursorAdapter pca = new PeronaCursorAdapter(this,cursor,0);
        listadoPersonas.setAdapter(pca);
        pca.notifyDataSetChanged();
    }
}
