package com.example.parcialsegundocorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Agregar extends AppCompatActivity {

    String estratoPersona [], tituloPersona [];
    EditText cedula, nombre, salario;
    Spinner estrato, titulo;
    ArrayAdapter adapterEstrato, adapterTitulo;
    Button agregar;
    PersonaController persona;
    String estratoP, tituloP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        persona = new PersonaController(getApplicationContext());

        estratoPersona = new String[] {"Seleccione el estrato","1","2","3","4","5","6"};
        tituloPersona = new String[] {"Seleccione el titulo","Bachillerato","Pregrado","Maestría","Doctorado"};

        cedula = findViewById(R.id.txtCedulaPersona);
        nombre = findViewById(R.id.txtNombrePersona);
        estrato = findViewById(R.id.spnEstratoPersona);
        salario = findViewById(R.id.txtSalarioPersona);
        titulo = findViewById(R.id.spnTituloPersona);
        agregar = findViewById(R.id.btnAgregarPersona);


        adapterEstrato = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, estratoPersona);
        adapterTitulo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, tituloPersona);

        titulo.setAdapter(adapterTitulo);
        estrato.setAdapter(adapterEstrato);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(persona.buscar(cedula.getText().toString())){
                    Toast.makeText(getApplicationContext(),"La cedula ingresada ya se registro, intente con otra.", Toast.LENGTH_SHORT).show();
                }else{
                    if(!cedula.getText().toString().isEmpty() && !nombre.getText().toString().isEmpty() && !salario.getText().toString().isEmpty() && !estrato.getSelectedItem().toString().isEmpty() && !titulo.getSelectedItem().toString().isEmpty()){
                        estratoP = (String) estrato.getSelectedItem();
                        tituloP = (String) titulo.getSelectedItem();
                        persona.agregar(new Persona(cedula.getText().toString(), nombre.getText().toString(), estratoP, salario.getText().toString(), tituloP));
                        Toast.makeText(getApplicationContext(),"Persona agregada.", Toast.LENGTH_SHORT).show();
                        Intent cambioV = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(cambioV);
                    }else{
                        Toast.makeText(getApplicationContext(),"Faltaron Campos.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
