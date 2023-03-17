/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.m03poomattaj.model;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Casa {
    /**
     * Declaración de la clase Casa con sus atributos: String nif, 
     * String nom, int superficieTejado, boolean interruptor, 
     * ArrayList placasSolares y ArrayList aparato.
     */
    private String nif;
    private String nom;
    private int superficieTejado;
    private boolean interruptor;
    private ArrayList<PlacaSolar> placasSolares = new ArrayList();
    private ArrayList<Aparatos> aparatos = new ArrayList();
    
    public Casa(String nif, String nom, int superficieTejado, boolean interruptor) {
        /**
         * Constructor de la clase Casa que inializa sus atributos.
         */
        this.nif = nif;
        this.nom = nom;
        this.superficieTejado = superficieTejado;
        this.interruptor = interruptor;
        this.placasSolares = new ArrayList<>();
        this.aparatos = new ArrayList<>();
    }
    
    public String getNif(){ // Método para obtener el valor del atributo nif.
        return this.nif;
    }
    
    public String getNom() { // Método para obtener el valor del atributo nom.
        return this.nom;
    }
    
    public int getST() { // Método para obtener el valor del atributo superficie.
        return this.superficieTejado;
    }
    
    public boolean getInterruptor() { // Método para obtener el valor del atributo interruptor.
        return this.interruptor;
    }
    
    public void setInterruptor(boolean interruptor){ // Método para modificar el atributo interruptor.
        this.interruptor = interruptor;
    }
    
    public ArrayList<PlacaSolar> getPlacas() { // Método para obtener el valor del atributo placasSolares.
        return this.placasSolares;
    }
    
    public ArrayList<Aparatos> getAparatos() { // Método para obtener el valor del atributo aparato.
        return this.aparatos;
    }
    
    public void addPlacaSolar(PlacaSolar placa) { // Método para añadir una Placa Solar a la lista de placasSolares.
        placasSolares.add(placa);
    }

    public void addAparato(Aparatos aparato) { // Método para añadir un Aparato a la lista de aparato.
        aparatos.add(aparato);
    }
}
