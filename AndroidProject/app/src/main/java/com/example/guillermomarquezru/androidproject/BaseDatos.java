package com.example.guillermomarquezru.androidproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Guillermo Marquez Ru on 31/05/2016.
 */
public class BaseDatos extends SQLiteOpenHelper {
    String sqlCreate = "CREATE TABLE MisContactos (noControl INTEGER PRIMARY KEY, Nombre TEXT,Carrera TEXT)";

    public BaseDatos(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS MisContactos");
        db.execSQL(sqlCreate);
    }
}
