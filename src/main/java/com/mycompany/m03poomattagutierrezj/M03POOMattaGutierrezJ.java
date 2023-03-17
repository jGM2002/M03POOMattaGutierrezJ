/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.m03poomattagutierrezj;

import com.mycompany.m03poomattaj.model.Aparatos; // Importamos la clase Aparatos.
import com.mycompany.m03poomattaj.model.Casa; // Importamos la clase Casa.
import com.mycompany.m03poomattaj.model.PlacaSolar; // Importamos la clase PlacaSolar.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class M03POOMattaGutierrezJ {
    static ArrayList<Casa> casas = new ArrayList(); // Lista de la clase Casa denomido casas.
    
    public static Casa buscarCasa(String buscarCasa) { // Método para buscar el NIF en la clase Casa.
         if (buscarCasa == null) { // Si el NIF que se da no existe, dara null.
            return null;
        }
    
        for (int i = 0; i < casas.size(); i++) { // Si el NIF existe en Casa, se guardara en ,a variable laCasa.
            Casa laCasa = casas.get(i);
            if (buscarCasa.equals(laCasa.getNif())) {
                return laCasa;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader terminal = new BufferedReader(new InputStreamReader(System.in));
        boolean quit = false; 
        do {
            System.out.println("> ");
            String segmento = terminal.readLine();
            String[] dades = segmento.split(" ");
            if (dades[0].equals("addCasa")) {  // Si el usuario escribe addCasa se creara una casa nueva.
                String nif = dades[1];
                String nom = dades[2];
                int superficie = Integer.parseInt(dades[3]);
                registrarVivienda(nif, nom, superficie);
            } else if (dades[0].equals("list")) {
                list(); // dara la lista completa de la vivienda
            } else if  (dades[0].equals("addPlaca")) {
                /**
                 * Si el usario escribe addPlaca se añadir una placa a la vivienda añadida en addCasa.
                 * si la vivienda no existe dara error.
                 */
                String buscarNif = dades[1];
                int superficiePlaca = Integer.parseInt(dades[2]);
                double preu = Double.parseDouble(dades[3]);
                int potencia = Integer.parseInt(dades[4]);
                registrarPlaca(buscarNif, superficiePlaca, preu, potencia);
            } else if (dades[0].equals("addAparell")) {
                /**
                 * Si el usario escribe addAparell se añadir un aparato a la vivienda añadida en addCasa.
                 * si la vivienda no existe dara error.
                 */
                String buscarNif = dades[1];
                String descripcio = dades[2];
                int potencia = Integer.parseInt(dades[3]);
                registrarAparato(buscarNif, descripcio, potencia);
            } else if (dades[0].equals("onCasa")) { // El usario podra encender la vivienda añadida anteriormente.
                String buscarNif = dades[1];
                encenderVivienda(buscarNif);
            } else if (dades[0].equals("onAparell")) { // El usuario podra encender el aparato de una vivienda existente. 
                String buscarNif = dades[1];
                String descripcionAparell = dades[2];
                encenderAparato(buscarNif, descripcionAparell);
            } else if (dades[0].equals("ofAparell")) { // El usuario podra apagar el aparato de una vivienda existente. 
                String buscarNif = dades[1];
                String descripcionAparell = dades[2];
                apagarAparato(buscarNif, descripcionAparell);
            } else if (dades[0].equals("info")) { // Dara la información de una vivienda existente mediante el NIF proporcionado.
                String buscarNif = dades[1];
                info(buscarNif);
            }
        } while (quit == false);
        
    }
    
    public static void list() { // Método que nos dara la lista de casas.
        if (casas.isEmpty()) {
                System.out.println("No hay casas registradas");
                } else {
                    System.out.println("--- Endolls Solars, S.L. ---");
                    for (int i = 0; i < casas.size(); i++) {
                        System.out.println("casa " + (i+1));
                        System.out.println("Cliente: " + casas.get(i).getNif() + casas.get(i).getNom());
                        System.out.println("Superficie del tejado: " + casas.get(i).getST());
                        System.out.println("Interruptor general: " + casas.get(i).getInterruptor());
                        System.out.println("Placas solares instalados: " + casas.get(i).getPlacas().size());
                        System.out.println("Aparatos registrados: " + casas.get(i).getAparatos().size());
                        System.out.println("--------------------");
                    }
                }
    }
    
    public static void registrarVivienda(String nif, String nom, int superficie) throws IOException{ // Método para añadir una vivienda nueva.
        boolean interruptor = true;
        if (superficie < 10) {
            System.out.println("Error: superficie tiene que ser mayor a 10");
        } else {
            Casa unaCasa = new Casa(nif, nom, superficie, interruptor);
            casas.add(unaCasa);
            System.out.println("Vivienda añadida correctamente");
        }
    }
    
    public static void registrarPlaca(String nif, int superficiePlaca, double preu, int potencia) throws IOException{ // Método para añadir un placa a una vivienda existente.
        Casa buscar = buscarCasa(nif);
        if (preu <= 0) {
            System.out.println("El precio tiene que ser mayor a 0.");
        } else {
            if (potencia <= 0) {
                System.out.println("La potencia tiene que ser mayor a 0.");
            } else {
                PlacaSolar unaPlaca = new PlacaSolar(buscar, superficiePlaca, preu, potencia);
                buscar.getPlacas().add(unaPlaca);
                System.out.println("Placa registrada correctamente");
            }
        }
    }
    
    public static void registrarAparato(String nif, String descripcion, int potencia) throws IOException{ // Método para añadir un aparato a una vivienda existente.
        Casa buscar = buscarCasa(nif);
        boolean interruptor = false;
        if (potencia <= 0) {
            System.out.println("Error: La potencia tiene que ser mayor que 0.");
        } else {
            Aparatos unAparato = new Aparatos(buscar, descripcion, potencia, interruptor);
            buscar.getAparatos().add(unAparato);
            System.out.println("Aparato registrado correctamente");
        }
    }
    
    public static void encenderVivienda(String nif) throws IOException{ // Método para encender la luz general de una vivienda existente.
        Casa buscar = buscarCasa(nif);
        if (buscar.getInterruptor() == false){
            buscar.setInterruptor(true);
        } else {
            System.out.println("La vivienda ya tiene las luces encendidas.");
        }
    }
    
    public static void encenderAparato(String nif, String descripcion) throws IOException{ // Método para encender el aparato de una vivienda existente.
        Casa buscar = buscarCasa(nif);
        if (buscar.getInterruptor() == true) {
            ArrayList<Aparatos> aparatosCasa = buscar.getAparatos();
            boolean aparatoEncontrado = false;
            for (int i = 0; i < aparatosCasa.size(); i++) {
                Aparatos iA = aparatosCasa.get(i);
                if (iA.getDescripcion().equals(descripcion)) {
                    aparatoEncontrado = true;
                    if (iA.getIA() == false) {
                        iA.setIA(true);
                        System.out.println(descripcion + " esta encendido");
                    } else{
                        System.out.println(descripcion + " ya estaba encendido");
                    }
                }
            }
            if (!aparatoEncontrado) {
                System.out.println("No se encontro el aparato especificado.");
            }
        } else {
            System.out.println("La luz general de la vivienda esta apagada.");
        }
    }
    
    public static void apagarAparato(String nif, String descripcion) throws IOException{ // Método para apagar el aparato de una vivienda existente.
        Casa buscar = buscarCasa(nif);
        boolean apagado = false;
        if (buscar.getInterruptor() == true) {
            for (int i = 0; i < buscar.getAparatos().size(); i++) {
                Aparatos iA = buscar.getAparatos().get(i);
                if (iA.getDescripcion().equals(descripcion) && iA.getIA() == true) {
                    iA.setIA(false);
                    System.out.println(descripcion + " esta apagado.");
                    apagado = true;
                    break;
                } else if (iA.getDescripcion().equals(descripcion) && iA.getIA() == false) {
                    System.out.println(descripcion + " ya esta apagado.");
                    apagado  = true;
                    break;
                }
            }
            if (!apagado) {
                System.out.println("No se encontró el aparato: " + descripcion);
            } else {
                System.out.println("La luz general de la vivienda esta apagada.");
            }
        }
    }
    
    public static void info(String nif) throws IOException{ // Método para obtener la información exacta de una vivienda existente.
        Casa buscar = buscarCasa(nif);
        if (buscar == null) {
            System.out.println("La vivienda con el NIF " + buscar + " no existe.");
        } else {
            System.out.println("Cliente: " + buscar.getNif() + " - " + buscar.getNom());
            System.out.println("Placas Solares intalados: " + buscar.getPlacas().size());
            System.out.println("Potencia total: " + buscar.getPlacas().get(0).getEP() + "W");
            System.out.println("Inversion total: " + buscar.getPlacas().get(0).getPrecio() + "€");
            System.out.println("Aparatos registrados: " + buscar.getAparatos().size());
        }
    }
}
