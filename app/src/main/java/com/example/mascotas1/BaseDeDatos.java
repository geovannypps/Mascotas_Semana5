package com.example.mascotas1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BaseDeDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDeDatos(Context context) {
        super(context, ConstantesBaseDatos.DATA_BASE_NAME, null, ConstantesBaseDatos.DATA_BASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTA + " (" +
                ConstantesBaseDatos.TABLE_MASCOTA_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE   + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO     + " INTEGER" +
                ")";

        String queryCrearTablaLikeMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA + " (" +
                ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID          + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKE_MASCOTA_NO_LIKES    + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTA + " (" + ConstantesBaseDatos.TABLE_MASCOTA_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikeMascota);
        iniPuppies(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA);
        onCreate(db);
    }
    public void iniPuppies(SQLiteDatabase db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Horus");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perro1);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);;

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Anubis");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perro2);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Tyson");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perro3);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);;

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Lala");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perro4);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Goofy");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perro5);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Mijin");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perro6);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);

    }

    public ArrayList<Mascota> obtenerTodasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_NO_LIKES + ") as likes" +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setRaiting(registrosLikes.getInt(0));
            }else{
                mascotaActual.setRaiting(0);
            }

            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKE_MASCOTA, null, contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;

        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_NO_LIKES + ")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA + "=" + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }

    public void eliminarTablasDB(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ConstantesBaseDatos.TABLE_LIKE_MASCOTA,null,null);
        db.delete(ConstantesBaseDatos.TABLE_MASCOTA,null,null);
    }

    public ArrayList<Mascota> obtenerRankingMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "select m."+ ConstantesBaseDatos.TABLE_MASCOTA_ID +
                ", m."+ ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE +
                ", m."+ ConstantesBaseDatos.TABLE_MASCOTA_FOTO +
                ", t1.cant " +
                "from "+ ConstantesBaseDatos.TABLE_MASCOTA +" m" +
                ", (select "+ ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA + ", count("+ ConstantesBaseDatos.TABLE_LIKE_MASCOTA_NO_LIKES +") as cant from "+ ConstantesBaseDatos.TABLE_LIKE_MASCOTA +" group by "+ ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA +" order by 2 desc) t1 " +
                "where m."+ ConstantesBaseDatos.TABLE_MASCOTA_ID +" = t1."+ ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA + " limit 5";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));
            mascotaActual.setRaiting(registros.getInt(3));

            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }
}