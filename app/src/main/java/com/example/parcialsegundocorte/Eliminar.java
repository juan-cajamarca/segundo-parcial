package com.example.parcialsegundocorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Eliminar extends AppCompatActivity {

    PersonaController controller;
    EditText cedula;
    Button eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        cedula = findViewById(R.id.txtCedulaEliminar);
        eliminar = findViewById(R.id.btnEliminarPersona);
        controller = new PersonaController(getApplicationContext());

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!controller.buscar(cedula.getText().toString())){
                    Toast.makeText(getApplicationContext(),"No se encontro la persona con cedula: "+ cedula.getText().toString(), Toast.LENGTH_SHORT).show();
                }else{
                    boolean cur = controller.eliminar(cedula.getText().toString());
                    if(cur == true){
                        Toast.makeText(getApplicationContext(),"Se Eliminado correctamente la Persona", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(getApplicationContext(),"No se pudo eliminar la Persona", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
