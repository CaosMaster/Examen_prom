package com.example.dm2.examen_prom;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

public class Atomic extends AppCompatActivity {

    private EditText ele;

    private TextView simb;
    private TextView num;
    private TextView peso;
    private TextView ebu;
    private TextView den;

    private Button info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atomic);

        ele = (EditText) findViewById(R.id.txtelem);

        info = (Button) findViewById(R.id.btninfo);

        simb = (TextView) findViewById(R.id.txtsimbolo);
        simb.setTextColor(Color.BLUE);

        num = (TextView) findViewById(R.id.txtnumero);
        num.setTextColor(Color.BLUE);

        peso = (TextView) findViewById(R.id.txtpeso);
        peso.setTextColor(Color.BLUE);

        ebu = (TextView) findViewById(R.id.txtebulli);
        ebu.setTextColor(Color.BLUE);

        den = (TextView) findViewById(R.id.txtdensidad);
        den.setTextColor(Color.BLUE);

        // AsynchPost task= new AsynchPost();
        // task.execute(ele.getText().toString());
    }
}

   /*private class AsynchPost extends AsyncTask<String ,void,void >{

        @Override
        protected void doInBackground(String... params) {

            try {
                HttpURLConnection conn;
                URL url = new URL ("http://www.webservicex.net/periodictable.asmx?op=GetAtomicNumber");

                String param="IPAddress="+ URLEncoder.encode(params[0],"UTf-8");

                conn=(HttpURLConnection) url.openConnection();

                conn.setDoOutput(true);

                conn.setRequestMethod("POST");

                conn.setFixedLengthStreamingMode(param.getBytes().length);
                conn.setRequestProperty("Content-Type","APLICATION/x-www-form-urlencoded");
                PrintWriter out = new PrintWriter(conn.getOutputStream());
                out.print(param);
                out.close();

                String num2="";
                String simb="";
                String peso="";
                String ebu="";
                String de="";

                String result="";
                Scanner inStream= new Scanner(conn.getInputStream());

                boolean a=false;
                while(inStream.hasNext()){
                    result=inStream.nextLine();
                    String st=inStream.toString();
                    if (result.indexOf("atomicNumber")>0){
                       num2=result;
                        num.setText(dasda");
                    }
                    if (result.indexOf("chemicalSymbol")>0){
                        simb=result;
                    }
                    if (result.indexOf("atomicWeight")>0){
                        peso=result;
                    }
                    if (result.indexOf("density")>0){
                        de=result;
                    }
                    if (result.indexOf("boilingPoint")>0){
                        ebu=result;
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }

            protected void onPostExecute (void result){

            Atomic.nu
        }
        }
    }/*
}
