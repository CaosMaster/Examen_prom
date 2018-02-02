package com.example.dm2.examen_prom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Eltiempo(View v){
        Intent Ejer1 = new Intent(this, Eltiempo.class);
        startActivity(Ejer1);
    }

    public void tomic(View v){
        Intent Ejer1 = new Intent(this, Atomic.class);
        startActivity(Ejer1);
    }

   public void Mutlti(View v){
        Intent Ejer1 = new Intent(this, Multimedia.class);
        startActivity(Ejer1);
    }

    public void salir(View view){
        finish();
    }
}
