package com.example.guill.recursos;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn;
    Boolean band = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Falta validar el botón
        if(band){
            band = false;
            btn.setBackgroundColor(getResources().getColor(R.color.colorUno));
            btn.setText(R.string.colUno);
            return;
        }
        band = true;
        btn.setBackgroundColor(getResources().getColor(R.color.colorDos));
        btn.setText(R.string.colDos);
    }
}
