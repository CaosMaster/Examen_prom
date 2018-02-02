package com.example.dm2.examen_prom;

import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by dm2 on 02/02/2018.
 */

public class XmlParser {

    private URL rssUrl;

    public XmlParser(String url){
        try {
            this.rssUrl = new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private InputStream getInputStream(){
        try {
            return rssUrl.openConnection().getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> returnTemp(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        List<String> datos = new ArrayList<String>();
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document dom = builder.parse(this.getInputStream());
            Element root = dom.getDocumentElement();

            NodeList lista = root.getElementsByTagName("pronostico_horas");

            for(int i=0;i<lista.getLength();i++) {

                String tag = lista.item(i).getNodeName();

                if (tag.equals("temperatura")) {

                    Node nodo=lista.item(i);
                    datos.add(nodo.getNodeValue());
                }else{
                    if (tag.equals("texto")) {

                        Node nodo=lista.item(i);
                        datos.add(nodo.getNodeValue());
                    }else {
                        {
                            if (tag.equals("hora_datos")) {
                                Node nodo=lista.item(i);
                                datos.add(nodo.getNodeValue());
                            }
                        }
                    }
                    }/*
                    if (tag.equals("hora")){
                        Log.d("XML","ENTRA");
                        NodeList hora = lista.item(i).getChildNodes();
                        datos.add(getNodeText(hora.item(1)));

                    }*/

            }

            return datos;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private String getNodeText(Node dato){
        StringBuilder texto = new StringBuilder();
        NodeList fragmentos = dato.getChildNodes();
        for (int i=0;i<fragmentos.getLength();i++){
            texto.append(fragmentos.item(i).getNodeValue());
        }
        return texto.toString();
    }
}
