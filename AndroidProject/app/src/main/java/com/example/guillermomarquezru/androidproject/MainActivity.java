package com.example.guillermomarquezru.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button registrar, eliminar, actualizar, consultar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registrar = (Button)findViewById(R.id.registrar);
        eliminar = (Button)findViewById(R.id.eliminar);
        actualizar = (Button)findViewById(R.id.actualizar);
        consultar = (Button)findViewById(R.id.consultar);
        registrar.setOnClickListener(this);
        eliminar.setOnClickListener(this);
        actualizar.setOnClickListener(this);
        consultar.setOnClickListener(this);
    }

    public void onClick(View v) {
        if(v == registrar){
            Intent obj = new Intent(this, registro.class);
            startActivity(obj);
        }

        if(v == consultar){
            Intent obj = new Intent(this, consultar.class);
            startActivity(obj);
        }

        if(v == eliminar){
            Intent obj = new Intent(this, borrar.class);
            startActivity(obj);
        }

        if(v == actualizar){
            Intent obj = new Intent(this, actualizar.class);
            startActivity(obj);
        }
    }
}
