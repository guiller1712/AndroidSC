package com.example.guill.librerias;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.milibreria.PruebaLibreria;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    AlertDialog.Builder builder;

    TextView tv;
    Button btn, asg;
    EditText et;

    Toast tCer;
    Toast tVac;
    Toast tLLe;
    Toast tC;
    Toast tCont;

    int nSuma, cont = 0;
    int suma[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.textView);
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(this);
        asg = (Button)findViewById(R.id.button2);
        asg.setOnClickListener(this);
        et = (EditText)findViewById(R.id.editText);

        tVac = Toast.makeText(this,PruebaLibreria.vacio,Toast.LENGTH_SHORT);
        tLLe = Toast.makeText(this,PruebaLibreria.lleno,Toast.LENGTH_SHORT);
        tC = Toast.makeText(this,PruebaLibreria.texto,Toast.LENGTH_SHORT);
        tCer = Toast.makeText(this,PruebaLibreria.cero,Toast.LENGTH_SHORT);

        nSuma = 0;

        inicBuilder();

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button){
            if(et.getText().toString().equals("")){
                tVac.show();
                return;
            }
            if(nSuma == 0){
                tCer.show();
                return;
            }
            if(cont == nSuma){
                //tLLe.show();
                tCont = Toast.makeText(this,"Promedio: "+PruebaLibreria.Promedio(suma),Toast.LENGTH_SHORT);
                return;
            }
            suma[cont] = Integer.parseInt(et.getText().toString());
            tCont = Toast.makeText(this,"Contador: "+ (cont+1),Toast.LENGTH_SHORT);
            cont++;
        }
       if(v.getId() == R.id.button2){
           inicBuilder();
       }

    }

    private void inicBuilder(){ //Construccion del builder o input dialog
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Cantidad de Números");

        final EditText input = new EditText(this);

        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        builder.setPositiveButton("No hace nada", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                nSuma = Integer.parseInt(input.getText().toString());
                tCont = Toast.makeText(MainActivity.this,nSuma+" - Suma",Toast.LENGTH_SHORT);
                suma = new int[nSuma];
                cont = 0;
                if(input.getText().toString().equals("")){
                    tVac.show();
                    return;
                }


            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tCont = Toast.makeText(MainActivity.this,"Cancelo",Toast.LENGTH_SHORT);
                dialog.cancel();
            }
        });
        builder.show();
    }
}
