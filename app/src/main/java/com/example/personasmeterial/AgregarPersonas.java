package com.example.personasmeterial;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Random;

public class AgregarPersonas extends AppCompatActivity {

    private ArrayList<Integer> fotos;
    private EditText nombre,apellidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_personas);

        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);
        nombre = findViewById(R.id.txtNombre);
        apellidos = findViewById(R.id.txtApellido);
    }


    public void guardar(View v){
        String nom, apel,id;
        int foto;
        id = Datos.getId();
        nom = nombre.getText().toString();
        apel = apellidos.getText().toString();
        foto = this.fotoAleatoria();
        Persona p = new Persona(id,foto,nom,apel);
        p.guardar();
        limpiar();

        Snackbar.make(v,"Persona Guardada Exitosamente",Snackbar.LENGTH_SHORT).show();
    }

    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){

        nombre.setText("");
        apellidos.setText("");
        nombre.requestFocus();
    }

    //para las fotos
    public int fotoAleatoria(){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(this.fotos.size());
        return fotos.get(fotoSeleccionada);
    }
}
