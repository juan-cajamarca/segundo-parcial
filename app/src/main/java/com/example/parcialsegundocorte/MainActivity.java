package com.example.parcialsegundocorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button eliminar, agregar, listar, buscar, actualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        eliminar = findViewById(R.id.btnEliminar);
        agregar = findViewById(R.id.btnAgregar);
        listar = findViewById(R.id.btnListar);
        actualizar = findViewById(R.id.btnActualizar);
        buscar = findViewById(R.id.btnBuscar);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent envio = new Intent(getApplicationContext(), Agregar.class);
                startActivity(envio);
            }
        });
        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent envio = new Intent(getApplicationContext(), Listar.class);
                startActivity(envio);
            }
        });
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent envio = new Intent(getApplicationContext(), Buscar.class);
                startActivity(envio);
            }
        });
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent envio = new Intent(getApplicationContext(), Eliminar.class);
                startActivity(envio);
            }
        });
        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent envio = new Intent(getApplicationContext(), Actualizar.class);
                startActivity(envio);
            }
        });
    }
}
