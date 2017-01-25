package com.example.nextu.practicauno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView txt;
    String frases[] = new String[5];
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frases = creaFrases();
        btn = (Button)findViewById(R.id.button);
        txt = (TextView)findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 4){
                    txt.setText(frases[i]);
                    i = 0;
                    return;
                }
                txt.setText(frases[i]);
                i++;
            }
        });
    }

    public String[] creaFrases(){
        String s[]= new String[5];
        s[0] = "Pienso, luego existo";
        s[1] = "Yo solo se que no se nada";
        s[2] = "Mira hacia el futuro, vive en el presente";
        s[3] = "No manches frida";
        s[4] = "Hola k ase";
        return s;
    }

}
