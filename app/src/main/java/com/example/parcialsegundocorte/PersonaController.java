package com.example.parcialsegundocorte;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PersonaController {

    private BaseDatos db;

    public PersonaController(Context context) {
        this.db = new BaseDatos(context);
    }

    public long agregar(Persona p){
        long id = 0;
        try{

            SQLiteDatabase database = db.getWritableDatabase();
            ContentValues valores = new ContentValues();
            valores.put(DefDB.col_p_cedula, p.getCedula());
            valores.put(DefDB.col_p_nombre, p.getNombre());
            valores.put(DefDB.col_p_estrato, p.getEstrato());
            valores.put(DefDB.col_p_salario, p.getSalario());
            valores.put(DefDB.col_p_titulo, p.getTitulo());
            id = database.insert(DefDB.tabla_p_est,null, valores);
            return id;
        }
        catch (Exception ex){
            System.out.println("Error al insertar");
            return 0;
        }
    }

    public boolean buscar(String cedulaPersona){
        String[] args = new String[] {cedulaPersona};
        SQLiteDatabase database = db.getReadableDatabase();
        Cursor cursor = database.query(DefDB.tabla_p_est, null, "cedula=?", args, null, null, null);
        if (cursor.getCount()>0) {
            database.close();
            return true;
        }
        else{
            database.close();
            return false;}

    }




    public Cursor personas() {
        try {
            SQLiteDatabase database = db.getWritableDatabase();
            Cursor cursor = database.rawQuery("select cedula as _id, nombre, estrato, salario, titulo from  persona", null);
            return cursor;
        } catch (Exception ex) {
            System.out.println("Error al consultar");
            return null;
        }
    }

    public Cursor buscarPersona(String cedulaPersona) {
        try {
            String[] args = new String[] {cedulaPersona};
            SQLiteDatabase database = db.getReadableDatabase();
            Cursor cursor = database.rawQuery("select cedula as _id , nombre, estrato, salario, titulo from  persona where cedula = ?", args);
            return cursor;
        } catch (Exception ex) {
            System.out.println("Error al consultar");
            return null;
        }
    }

    public boolean eliminar(String cedulaPersona){
        boolean existe = false;
        SQLiteDatabase database = db.getReadableDatabase();
        String args [] = new String [] {cedulaPersona};
        database.delete(DefDB.tabla_p_est,"cedula=?", args);
        if(!buscar(cedulaPersona)){
            existe = true;
        }
        return existe;
    }

    public long actualizar(Persona p){

        try{
            SQLiteDatabase database = db.getWritableDatabase();
            ContentValues personas = new ContentValues();
            String[] args = new String[] {p.getCedula()};
            personas.put(DefDB.col_p_nombre, p.getNombre());
            personas.put(DefDB.col_p_estrato, p.getEstrato());
            personas.put(DefDB.col_p_salario, p.getSalario());
            personas.put(DefDB.col_p_titulo, p.getTitulo());
            long id = database.update(DefDB.tabla_p_est, personas,"cedula=?",args);
            database.close();
            return id;
        }
        catch (Exception ex){
            System.out.println("Error al actualizar");
            return 0;
        }

    }
}