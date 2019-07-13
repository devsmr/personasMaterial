package com.example.personasmeterial;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Datos {

    private static String db = "Personas";

    //conectar con la base de datos remota con la base de datos personas que está en el firebase
    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();


    public static ArrayList<Persona> personas = new ArrayList<>();

    //crear el agregar

    public static void agregar(Persona p){

        databaseReference.child(db).child(p.getId()).setValue(p);
    }

    //editar
    public static void editar (Persona p){

        databaseReference.child(db).child(p.getId()).setValue(p);
    }

    //eliminar
    public static void eliminar (Persona p){

        databaseReference.child(db).child(p.getId()).removeValue();
    }

    //obtener la llave del servidor
    public static String getId(){
            return databaseReference.push().getKey();
    }

    //set
    public static void setPersonas(ArrayList<Persona> personas){

        Datos.personas= personas;
    }

    //get
    public static ArrayList<Persona> obtener(){

        return Datos.personas;
    }


}


