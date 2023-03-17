/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.m03poomattaj.model;

/**
 *
 * @author Admin
 */
public class PlacaSolar {
    /**
     * Declaración de la clase PlacaSolar con sus atributos: int superficie, 
     * double precio, int energiaProporcionada y Casa casa;
     */
    private int superficiePlacasSolares;
    private double precio;
    private int energiaProporcionada;
    private Casa casa;
    
    public PlacaSolar(Casa nif, int superficiePlacasSolares, double precio, int energiaProporcionada){
        /**
         * Constructor de la clase PlacaSolar que inializa sus atributos.
         */
        this.casa = casa;
        this.superficiePlacasSolares = superficiePlacasSolares;
        this.precio = precio;
        this.energiaProporcionada = energiaProporcionada;
    }
    
    public int getSPS() { // Método para obtener el valor del atributo superficiePlacasSolares.
        return this.superficiePlacasSolares;
    }
    
    public double getPrecio() { // Método para obtener el valor del atributo Precio.
        return this.precio;
    }
    
    public int getEP() { // Método para obtener el valor del atributo EnergiaProporcionada.
        return this.energiaProporcionada;
    }
    
    public Casa getCasa() { // Método para obtener los valores del constructor Casa en el atributo casa.
        return casa;
    }
}
