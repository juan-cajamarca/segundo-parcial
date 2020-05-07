package com.example.parcialsegundocorte;

public class DefDB {

    public static final String nameDb = "informacionPersonas";
    public static final String tabla_p_est = "persona";
    public static final String col_p_cedula = "cedula";
    public static final String col_p_nombre = "nombre";
    public static final String col_p_estrato = "estrato";
    public static final String col_p_salario = "salario";
    public static final String col_p_titulo = "titulo";


    public static final String create_tabla_p_est = "CREATE TABLE IF NOT EXISTS persona(" +
            "  cedula text ," +
            "  nombre text," +
            "  estrato text," +
            "  salario text," +
            "  titulo text" +
            ");";

}
