package com.example.dm2.examen_prom;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Multimedia extends AppCompatActivity {

    private Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multimedia);

        sp=(Spinner) findViewById(R.id.spinner);

        ArrayList nombres=new ArrayList<String>();
        try {
            InputStream fraw = getResources().openRawResource(R.raw.burro);
            BufferedReader brin = new BufferedReader(new InputStreamReader(fraw));

            String texto = "";
            String linea = brin.readLine();
            while (linea != null) {
                nombres.add(linea);
                linea = brin.readLine();
            }
            brin.close();
            fraw.close();

            //why no cierra el bufferedreader
            ArrayAdapter<String> adaptador= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,provincias);
            adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sp.setAdapter(adaptador);

            sp.setOnItemSelectedListener();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
