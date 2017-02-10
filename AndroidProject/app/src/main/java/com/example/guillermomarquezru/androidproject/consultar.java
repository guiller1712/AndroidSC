package com.example.guillermomarquezru.androidproject;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class consultar extends AppCompatActivity {

    BaseDatos Conexion;
    SQLiteDatabase BD;
    TextView consulta;
    AlertDialog Alerta;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        consulta = (TextView)findViewById(R.id.consulta);
        Conexion=new BaseDatos(this, "BDCONTACTOS", null, 1);
        Alerta = new AlertDialog.Builder(this).create();
        if(Conexion==null){
            Alerta.setMessage("La conexión no se realizó con éxito");
            Alerta.show();
            return;
        }

        BD = Conexion.getWritableDatabase();
        if(BD==null){
            Alerta.setMessage("*** no abrio para lectura la BD *****");
            Alerta.show();
            return;
        }
        Cursor c = BD.rawQuery("SELECT * FROM MisContactos ", null);
        int count_dict=c.getCount();
        if(count_dict==0){
            Alerta.setTitle("Consultando");
            Alerta.setMessage("No se encontraron registros");
            Alerta.show();
            return;
        }

        if(c.moveToFirst()) {
            String Todo = MyRandom.PonBlancos(c.getInt(0)+"", 15) + "" + MyRandom.PonBlancos(c.getString(1), 40) + "" + MyRandom.PonBlancos(c.getString(2), 20) + "\n";
            while (c.moveToNext()) {
                Todo = Todo + MyRandom.PonBlancos(c.getInt(0)+"", 15) + "" + MyRandom.PonBlancos(c.getString(1), 40) + "" + MyRandom.PonBlancos(c.getString(2), 20) + "\n";
            }
            consulta.setText(".:Alumnos:.\n" +  MyRandom.PonBlancos("No de Control", 15) + "" + MyRandom.PonBlancos("Nombre", 40) + "" + MyRandom.PonBlancos("Carrera", 20) + "\n\n\n" + Todo);
        }
    }
}
