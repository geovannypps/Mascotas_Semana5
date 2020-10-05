package com.example.mascotas1;

public class ConstantesBaseDatos {

    public static final String DATA_BASE_NAME = "mascotas";
    public static final int DATA_BASE_VERSION = 1;

    //Tabla mascotas
    public static final String TABLE_MASCOTA = "mascota";
    public static final String TABLE_MASCOTA_ID = "id";
    public static final String TABLE_MASCOTA_NOMBRE = "nombre";
    public static final String TABLE_MASCOTA_FOTO = "foto";

    //Tabla mascotas
    public static final String TABLE_LIKE_MASCOTA = "mascota_like";
    public static final String TABLE_LIKE_MASCOTA_ID = "id";
    public static final String TABLE_LIKE_MASCOTA_ID_MASCOTA = "mascota";
    public static final String TABLE_LIKE_MASCOTA_NO_LIKES = "numero_likes";
}
