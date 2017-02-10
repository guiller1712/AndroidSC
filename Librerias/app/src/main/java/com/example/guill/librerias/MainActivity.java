package com.example.guill.librerias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.milibreria.PruebaLibreria;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button btn;
    EditText et;
    Toast t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.textView);
        btn = (Button)findViewById(R.id.button);
        et = (EditText)findViewById(R.id.editText);
        t = Toast.makeText(this,PruebaLibreria.texto,Toast.LENGTH_SHORT);




    }
}
