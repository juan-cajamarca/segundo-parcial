package com.example.parcialsegundocorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Buscar extends AppCompatActivity {

    PersonaController controller;
    EditText cedula;
    Button buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        cedula = findViewById(R.id.txtCedulaBuscar);
        buscar = findViewById(R.id.btnBuscarPersona);
        controller = new PersonaController(getApplicationContext());

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!controller.buscar(cedula.getText().toString())){
                    Toast.makeText(getApplicationContext(),"No se encontro la persona con cedula: "+ cedula.getText().toString(), Toast.LENGTH_SHORT).show();
                }else{
                    Intent cambioV = new Intent(getApplicationContext(), PersonaEncontrada.class);
                    cambioV.putExtra("cedulaPersona", cedula.getText().toString());
                    startActivity(cambioV);
                }
            }
        });
    }
}
