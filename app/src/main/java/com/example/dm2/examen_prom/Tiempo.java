package com.example.dm2.examen_prom;

/**
 * Created by dm2 on 02/02/2018.
 */

public class Tiempo {

    private String hora;
    private String temperatura;
    private String cielo;

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public void setCielo(String cielo) {
        this.cielo = cielo;
    }

    public String getHora() {

        return hora;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public String getCielo() {
        return cielo;
    }
}
