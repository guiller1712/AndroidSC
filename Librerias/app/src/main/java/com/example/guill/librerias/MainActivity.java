package com.example.guill.librerias;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.milibreria.PruebaLibreria;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tv;
    Button btn;
    EditText et;
    Toast t;

    int nSuma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.textView);
        btn = (Button)findViewById(R.id.button);
        et = (EditText)findViewById(R.id.editText);
        t = Toast.makeText(this,PruebaLibreria.texto,Toast.LENGTH_SHORT);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cantidad de Números");

        final EditText input = new EditText(this);

        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                nSuma = Integer.parseInt(input.getText().toString());
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();

    }

    @Override
    public void onClick(View v) {

    }
}
