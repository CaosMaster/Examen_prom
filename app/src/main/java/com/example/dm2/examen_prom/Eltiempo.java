package com.example.dm2.examen_prom;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class Eltiempo extends AppCompatActivity {

    private String uriVitoria = "http://xml.tutiempo.net/xml/8043.xml";
    private TextView loc;
    private TextView time;
    private TextView temp;
    private TextView sky;

    private List<String> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eltiempo);

        loc=(TextView) findViewById(R.id.txtlocal);
        time=(TextView) findViewById(R.id.txthora);
        temp=(TextView) findViewById(R.id.txttemp);
        sky=(TextView) findViewById(R.id.txtcielo);


    }

    class LoadXml extends AsyncTask<String,Integer,Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {
            XmlParser parser = new XmlParser(params[0]);
            datos = parser.returnTemp();
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            String tempe = "";
            String sk="";
          String hor="";

            if (datos.size() > 0) {
                tempe= datos.get(0);
                sk = datos.get(1);
               hor=datos.get(2);
            }
            temp.setVisibility(View.VISIBLE);
            time.setVisibility(View.VISIBLE);
            sky.setVisibility(View.VISIBLE);

            time.setText(time.getText()+hor);
            temp.setText(temp.getText()+tempe);
            sky.setText(sky.getText()+sk);
        }
    }
    public void volver(View view){
            Intent main = new Intent(this, MainActivity.class);
            startActivity(main);

    }
    public void vitoria(View view){
        loc.setText(loc.getText()+": VITORIA-GASTEIZ");
        LoadXml loader = new LoadXml();
        loader.execute(uriVitoria);
    }
    public void bilbao(View view){
        loc.setText(loc.getText()+": Bilbao-bilbo");
        LoadXml loader = new LoadXml();
        loader.execute(uriVitoria);
    }

    public void donosti(View view){
        loc.setText(loc.getText()+": Donosti-san sebastian");
        LoadXml loader = new LoadXml();
        loader.execute(uriVitoria);
    }


}
