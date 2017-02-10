package com.example.guillermomarquezru.androidproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class actualizar extends AppCompatActivity implements View.OnClickListener{
    String SQL, SQLD;
    BaseDatos Conexion;
    SQLiteDatabase BD;
    AlertDialog Alerta;
    Cursor c;
    Button actualizar, recuperar, sig, ant, limpiar;
    EditText NoControl, Nombre, Carrera;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);

        recuperar = (Button) findViewById(R.id.recuperarA);
        actualizar = (Button) findViewById(R.id.actualizarA);
        sig = (Button) findViewById(R.id.siguienteA);
        ant = (Button) findViewById(R.id.anteriorA);
        limpiar = (Button) findViewById(R.id.limpiarA);
        NoControl = (EditText) findViewById(R.id.txtNoControlA);
        Nombre = (EditText) findViewById(R.id.txtNombreA);
        Carrera = (EditText) findViewById(R.id.txtCarreraA);

        recuperar.setOnClickListener(this);
        actualizar.setOnClickListener(this);
        sig.setOnClickListener(this);
        ant.setOnClickListener(this);
        limpiar.setOnClickListener(this);

        Conexion = new BaseDatos(this, "BDCONTACTOS", null, 1);
        Alerta = new AlertDialog.Builder(this).create();
        if (Conexion == null) {
            Alerta.setMessage("La conexión no se realizó con éxito");
            Alerta.show();
            return;
        }

        sig.setEnabled(false);
        ant.setEnabled(false);
        actualizar.setEnabled(false);
    }

    public void onClick(View v) {
        if (v == recuperar) {
            if (NoControl.getText().toString().length() == 0 && Nombre.getText().toString().length() == 0 && Carrera.getText().toString().length() == 0) {
                Alerta.setTitle("Recuperando");
                Alerta.setMessage("Todos los campos están vacios, teclee en al menos uno");
                Alerta.show();
                return;
            }
            BD = Conexion.getWritableDatabase();
            if (BD == null) {
                Alerta.setTitle("Insertando");
                Alerta.setMessage("No pudo abrir la base de datos para grabar");
                Alerta.show();
                return;
            }

            if (Nombre.getText().toString().length() > 0 && NoControl.getText().toString().length() == 0 && Carrera.getText().toString().length() == 0) {
                SQL = "SELECT * FROM MisContactos where Nombre ='" + Nombre.getText().toString() + "'";
                c = BD.rawQuery(SQL, null);
                if (c.getCount() == 0) {
                    Alerta.setMessage("No existen contactos con ese nombre");
                    Alerta.show();
                    return;
                }
                c.moveToFirst();
                sig.setEnabled(true);
                ant.setEnabled(true);
                actualizar.setEnabled(true);
                recuperar.setEnabled(false);
                if (c.moveToFirst()) {
                    String Todo = "Se recuperó: " + c.getInt(0) + "  " + c.getString(1) + "  " + c.getString(2);
                    NoControl.setText(c.getString(0));
                    Nombre.setText(c.getString(1));
                    Carrera.setText(c.getString(2));
                    Toast msg = Toast.makeText(getBaseContext(), Todo, Toast.LENGTH_SHORT);
                    NoControl.setEnabled(false);
                    //msg.show();
                    return;
                }
            }

            if (Nombre.getText().toString().length() == 0 && NoControl.getText().toString().length() == 0 && Carrera.getText().toString().length() > 0) {
                SQL = "SELECT * FROM MisContactos where Carrera ='" + Carrera.getText().toString() + "'";
                c = BD.rawQuery(SQL, null);
                if (c.getCount() == 0) {
                    Alerta.setMessage("No existen contactos inscritos en esa carrera");
                    Alerta.show();
                    return;
                }
                c.moveToFirst();
                sig.setEnabled(true);
                ant.setEnabled(true);
                actualizar.setEnabled(true);
                recuperar.setEnabled(false);
                if (c.moveToFirst()) {
                    String Todo = "Se recuperó: " + c.getInt(0) + "  " + c.getString(1) + "  " + c.getString(2);
                    NoControl.setText(c.getString(0));
                    Nombre.setText(c.getString(1));
                    Carrera.setText(c.getString(2));
                    Toast msg = Toast.makeText(getBaseContext(), Todo, Toast.LENGTH_SHORT);
                    NoControl.setEnabled(false);
                    //msg.show();
                    return;
                }
            }

            if (Nombre.getText().toString().length() > 0 && NoControl.getText().toString().length() == 0 && Carrera.getText().toString().length() > 0) {
                SQL = "SELECT * FROM MisContactos where Carrera ='" + Carrera.getText().toString() + "' AND Nombre ='" + Nombre.getText().toString() + "'";
                c = BD.rawQuery(SQL, null);
                if (c.getCount() == 0) {
                    Alerta.setMessage("No existen contactos con esas especificaciones");
                    Alerta.show();
                    return;
                }
                c.moveToFirst();
                sig.setEnabled(true);
                ant.setEnabled(true);
                actualizar.setEnabled(true);
                recuperar.setEnabled(false);
                if (c.moveToFirst()) {
                    String Todo = "Se recuperó: " + c.getInt(0) + "  " + c.getString(1) + "  " + c.getString(2);
                    NoControl.setText(c.getString(0));
                    Nombre.setText(c.getString(1));
                    Carrera.setText(c.getString(2));
                    Toast msg = Toast.makeText(getBaseContext(), Todo, Toast.LENGTH_SHORT);
                    NoControl.setEnabled(false);
                    //msg.show();
                    return;
                }
            }
            SQL = "SELECT * FROM MisContactos where NoControl =" + Integer.parseInt(NoControl.getText().toString()) + "";
            c = BD.rawQuery(SQL, null);
            if (c.getCount() == 0) {
                Alerta.setMessage("No existen contactos con esas especificaciones");
                Alerta.show();
                return;
            }
            c.moveToFirst();
            sig.setEnabled(true);
            ant.setEnabled(true);
            actualizar.setEnabled(true);
            recuperar.setEnabled(false);
            if (c.moveToFirst()) {
                String Todo = "Se recuperó: " + c.getInt(0) + "  " + c.getString(1) + "  " + c.getString(2);
                NoControl.setText(c.getString(0));
                Nombre.setText(c.getString(1));
                Carrera.setText(c.getString(2));
                Toast msg = Toast.makeText(getBaseContext(), Todo, Toast.LENGTH_SHORT);
                NoControl.setEnabled(false);
                //msg.show();
                BD.close();
                return;
            }
        }

        if (v == sig) {
            if (c.moveToNext()) {
                String Todo = "Se recuperó: " + c.getInt(0) + "  " + c.getString(1) + "  " + c.getString(2);
                NoControl.setText(c.getString(0));
                Nombre.setText(c.getString(1));
                Carrera.setText(c.getString(2));
                Toast msg = Toast.makeText(getBaseContext(), Todo, Toast.LENGTH_SHORT);
                //msg.show();
                return;
            }
            Toast msg = Toast.makeText(getBaseContext(), "Ya no hay mas adelante", Toast.LENGTH_SHORT);
            msg.show();
            return;
        }
        if (v == ant) {
            if (c.moveToPrevious()) {
                String Todo = "Se recuperó: " + c.getInt(0) + "  " + c.getString(1) + "  " + c.getString(2);
                NoControl.setText(c.getString(0));
                Nombre.setText(c.getString(1));
                Carrera.setText(c.getString(2));
                Toast msg = Toast.makeText(getBaseContext(), Todo, Toast.LENGTH_SHORT);
                //msg.show();
                return;
            }
            Toast msg = Toast.makeText(getBaseContext(), "Ya no hay mas atras", Toast.LENGTH_SHORT);
            msg.show();
            return;
        }

        if (v == limpiar) {
            NoControl.setText("");
            Nombre.setText("");
            Carrera.setText("");
            sig.setEnabled(false);
            ant.setEnabled(false);
            actualizar.setEnabled(false);
            recuperar.setEnabled(true);

            NoControl.setEnabled(true);
            return;
        }

        if(v == actualizar){
            BD = Conexion.getWritableDatabase();
            if (BD == null) {
                Alerta.setTitle("Insertando");
                Alerta.setMessage("No pudo abrir la base de datos para grabar");
                Alerta.show();
                return;
            }
            SQLD = "UPDATE MisContactos set Nombre='"+Nombre.getText().toString()+"', Carrera='"+Carrera.getText().toString() + "' Where NoControl ="+Integer.parseInt(NoControl.getText().toString()) +"";
            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
            dialogo1.setTitle("Importante");
            dialogo1.setMessage("¿Desea actualizar el contacto: " + c.getString(1) + "?");
            dialogo1.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    BD.execSQL(SQLD);
                    Toast msg = Toast.makeText(getBaseContext(), "CONTACTO ACTUALIZADO", Toast.LENGTH_LONG);
                    msg.show();
                    limpiar.callOnClick();

                }
            });
            dialogo1.setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    dialogo1.cancel();
                }
            });
            dialogo1.show();
            return;
        }
    }
}
