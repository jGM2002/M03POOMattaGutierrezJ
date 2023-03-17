/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.m03poomattaj.model;

/**
 *
 * @author Admin
 */
public class Aparatos {
    /**
     * Declaración de la clase Aparatos con sus atributos: String descripcion, 
     * int consumo y boolean interruptorAparato.
     */
    private String descripcion;
    private int consumo;
    private boolean interruptorAparato;
    private Casa casa;
    
    public Aparatos(Casa nif, String descripcion, int consumo, boolean interruptorAparato) {
        /**
         * Contructor de la clase Aparatos que inializa sus atributos.
         */
        this.casa = casa;
        this.descripcion = descripcion;
        this.consumo = consumo;
        this.interruptorAparato = interruptorAparato;
    }
    
    public String getDescripcion() { // Método para obtener el valor del atributo descripcion.
        return this.descripcion;
    }
    
    public int getConsumo() { // Método para obtener el valor del atributo consumo.
        return this.consumo;
    }
    
    public boolean getIA() { // Método para obtener el valor del atributo interruptorAparato.
        return this.interruptorAparato;
    }
    
    public void setIA(boolean interruptorAparato) { // Método para modificar el atributo interruptorAparato.
        this.interruptorAparato = interruptorAparato;
    }
    
    public Casa getCasa() { // Método para obtener los valores del constructor Casa en el atributo casa.
        return casa;
    }
}
