package com.example.parcialsegundocorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Actualizar extends AppCompatActivity {

    PersonaController controller;
    EditText cedula;
    Button actualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);

        actualizar = findViewById(R.id.btnActualizarPersonas);
        cedula = findViewById(R.id.txtCedulaActualizar);

        controller = new PersonaController(getApplicationContext());

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!controller.buscar(cedula.getText().toString())){
                    Toast.makeText(getApplicationContext(),"No se encontro la persona con cedula: "+ cedula.getText().toString(), Toast.LENGTH_SHORT).show();
                }else{
                    Intent cambioV = new Intent(getApplicationContext(), ActualizarPersona.class);
                    cambioV.putExtra("cedulaPersona", cedula.getText().toString());
                    startActivity(cambioV);
                }
            }
        });
    }
}
