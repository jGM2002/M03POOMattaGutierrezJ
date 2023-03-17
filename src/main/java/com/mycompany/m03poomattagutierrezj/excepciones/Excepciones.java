/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.m03poomattagutierrezj.excepciones;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Excepciones extends Exception {
    public static final int NIF_REPETIDO = 0;
    public static final int NIF_NO_EXISTE = 1;
    public static final int SUPTEJADO_MENOR_A_DIES = 2;
    public static final int SUPPLACAS_MENOR_A_CERO = 3;
    public static final int POTENCIAPLACAS_MENOR_A_CERO = 4;
    public static final int PRECIO_MENOR_A_CERO = 5;
    public static final int DESCRIPCION_REPETIDO = 6;
    public static final int INTERRUPTOR_ENCENDIDO = 7;
    public static final int INTERRUPTOR_APAGADO = 8;
    
    private final List<String> mensajes = Arrays.asList(
            "ERROR: Número de paràmetres incorrecte.\\nÚs: addCasa [nif] [nom] [superficie]",
            "ERROR: Superficie incorrecta. Ha de ser més gran de 10.",
            "ERROR: Ja hi ha una casa registrada amb aquest nif",
            "ERROR: Número de paràmetres incorrecte.\nÚs: addPlaca [nif] [superficie] [preu] [potència]",
            "ERROR: No hi ha cap casa registrada amb aquest nif.",
            "ERROR: Superfície incorrecta. Ha de ser més gran de 0.",
            "ERROR: No hi ha espai disponible per a instal·lar aquesta placa.",
            "ERROR: Preu incorrecte. Ha de ser més gran de 0.",
            "ERROR: Potència incorrecte. Ha de ser més gran de 0.",
            "ERROR: Número de paràmetres incorrecte.\nÚs: addAparell [nif] [descripció] [potència]",
            "ERROR: No hi ha cap casa registrada amb aquest nif.",
            "ERROR: Ja existeix un aparell amb aquesta descripció a la casa indicada.",
            "ERROR: Potència incorrecte. Ha de ser més gran de 0.",
            "ERROR: Número de paràmetres incorrecte.\nÚs: onCasa [nif]",
            "ERROR: No hi ha cap casa registrada amb aquest nif.",
            "ERROR: La casa ja té l'interruptor encès.",
            "ERROR: Número de paràmetres incorrecte \nÚs: onAparell [nif] [descripció aparell]",
            "ERROR: No hi ha cap casa registrada amb aquest nif.",
            "ERROR: No hi ha cap aparell registrat amb aquesta descripció a la casa indicada.",
            "ERROR: L'aparell ja està encès.",
            "ERROR: No es pot encendre l'aparell. L'interruptor general està apagat.",
            "ERROR: Han saltat els ploms. La casa ha quedat completament apagada.",
            "ERROR: Número de paràmetres incorrecte.\nÚs: offAparell [nif] [descripció aparell]",
            "ERROR: No hi ha cap casa registrada amb aquest nif.",
            "ERROR: No hi ha cap aparell registrat amb aquesta descripció a la casa indicada.",
            "ERROR: L'aparell ja està apagat.",
            "ERROR: Número de paràmetres incorrecte.\nÚs: list",
            "ERROR: Número de paràmetres incorrecte.\nÚs: info [nif]",
            "ERROR: No hi ha cap casa registrada amb aquest nif.",
            "ERROR: Número de paràmetres incorrecte.\nÚs: quit)");
    
    private final int nif;
    
    public Excepciones (int nif) {
        this.nif = nif;
    }
    
    @Override
    public String getMessage() {
        return mensajes.get(nif);
    }
}
