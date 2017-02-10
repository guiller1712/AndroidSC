package com.example.guillermomarquezru.androidproject;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class registro extends AppCompatActivity implements View.OnClickListener{

    Button limpiar, fab;
    EditText NoControl, Nombre, Carrera;

    BaseDatos Conexion;
    SQLiteDatabase BD;
    AlertDialog Alerta;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        fab = (Button) findViewById(R.id.grabar);
        limpiar = (Button)findViewById(R.id.limpiar);
        NoControl = (EditText)findViewById(R.id.noControl);
        Nombre = (EditText)findViewById(R.id.nombre);
        Carrera = (EditText)findViewById(R.id.carrera);
        fab.setOnClickListener(this);
        NoControl.setOnClickListener(this);
        Nombre.setOnClickListener(this);
        Carrera.setOnClickListener(this);
        limpiar.setOnClickListener(this);

        Conexion=new BaseDatos(this, "BDCONTACTOS", null, 1);
        Alerta = new AlertDialog.Builder(this).create();
        if(Conexion==null){
            Alerta.setMessage("La conexión no se realizó con éxito");
            Alerta.show();
            return;
        }
    }
    public void onClick(View v) {

        if(v == fab){
            if(NoControl.getText().length() == 0|| Nombre.getText().length() == 0 || Carrera.getText().length() == 0){
                Alerta.setTitle("Insertando");
                Alerta.setMessage("Alguno de los campos está vacio");
                Alerta.show();
                return;
            }
            BD = Conexion.getWritableDatabase();
            if(BD==null){
                Alerta.setTitle("Insertando");
                Alerta.setMessage("No pudo abrir la base de datos para grabar");
                Alerta.show();
                return;
            }
            Cursor c = BD.rawQuery("SELECT * FROM MisContactos WHERE NoControl = "+ Integer.parseInt(NoControl.getText().toString()) +"", null);
            if(c.getCount()>0){
                c.moveToFirst();
                Alerta.setTitle("Insertando");
                Alerta.setMessage("Número de Control ya se encuentra regsitrado : "+c.getString(1));
                Alerta.show();
                return;
            }
            String SQL="Insert into MISCONTACTOS VALUES("+Integer.parseInt(NoControl.getText().toString())+
                    ",'"+Nombre.getText().toString()+"','"+  Carrera.getText().toString()  +"')";
            try {
                BD.execSQL(SQL);

            } catch (android.database.sqlite.SQLiteConstraintException E){
                Alerta.setTitle("Insertando");
                Alerta.setMessage("Inserción FALLIDA");
                Alerta.show();
                BD.close();
                return;
            }

            Alerta.setTitle("Insertando");
            Alerta.setMessage("Inserción realizada corectmente");
            Alerta.show();
            NoControl.setText("");
            Nombre.setText("");
            Carrera.setText("");
            BD.close();
            return;
        }

        if(v == limpiar){
            NoControl.setText("");
            Nombre.setText("");
            Carrera.setText("");
            return;
        }
    }
}
