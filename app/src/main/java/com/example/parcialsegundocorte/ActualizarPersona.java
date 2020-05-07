package com.example.parcialsegundocorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ActualizarPersona extends AppCompatActivity {

    String estratoPersona [], tituloPersona [];
    EditText cedula, nombre, salario;
    Spinner estrato, titulo;
    ArrayAdapter adapterEstrato, adapterTitulo;
    Button actualizar;
    PersonaController persona;
    String estratoP, tituloP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_persona);


        String cedulaPersona = getIntent().getStringExtra("cedulaPersona");
        persona = new PersonaController(getApplicationContext());

        estrato = findViewById(R.id.spnEstratoActualizado);
        titulo = findViewById(R.id.spnTituloActualizado);
        cedula = findViewById(R.id.txtCedulaActualizada);
        nombre = findViewById(R.id.txtNombreActualizado);
        salario = findViewById(R.id.txtSalarioActualizado);
        actualizar = findViewById(R.id.btnActualizarP);

        Cursor cursor = persona.buscarPersona(cedulaPersona);

        String nombreView = "", estratoView = "", salarioView = "", tituloView = "";
        while (cursor.moveToNext()) {
            nombreView = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
            estratoView = cursor.getString(cursor.getColumnIndexOrThrow("estrato"));
            salarioView = cursor.getString(cursor.getColumnIndexOrThrow("salario"));
            tituloView = cursor.getString(cursor.getColumnIndexOrThrow("titulo"));
        }

        cedula.setText(cedulaPersona);
        nombre.setText(nombreView);
        salario.setText(salarioView);

        estratoPersona = new String[]{estratoView, "1", "2", "3", "4", "5", "6"};
        tituloPersona = new String[]{tituloView, "Bachillerato", "Pregrado", "Maestría", "Doctorado"};
        adapterEstrato = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, estratoPersona);
        adapterTitulo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, tituloPersona);
        titulo.setAdapter(adapterTitulo);
        estrato.setAdapter(adapterEstrato);

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cedula.getText().toString().isEmpty() && !nombre.getText().toString().isEmpty() && !salario.getText().toString().isEmpty() && !estrato.getSelectedItem().toString().isEmpty() && !titulo.getSelectedItem().toString().isEmpty()) {
                    estratoP = (String) estrato.getSelectedItem();
                    tituloP = (String) titulo.getSelectedItem();
                    long id = persona.actualizar(new Persona(cedula.getText().toString(), nombre.getText().toString(), estratoP, salario.getText().toString(), tituloP));
                    Toast.makeText(getApplicationContext(), "Usuario Actualizado.", Toast.LENGTH_SHORT).show();
                    System.out.println(id);
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Campos imcompletos.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
