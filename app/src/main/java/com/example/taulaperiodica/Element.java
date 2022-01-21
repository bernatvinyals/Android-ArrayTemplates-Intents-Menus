package com.example.taulaperiodica;

import java.io.Serializable;

public class Element implements Serializable {
    private String inicials;
    private String nom;
    private int numero;
    private float pesAtomic;
    private TipusDeElement tipus;
    //non esential
    private String serieQuimica;
    private int grup;
    private int periodo;

    public Element(String inicials, String nom, int numero, float pesAtomic,TipusDeElement etipus) {
        this.inicials = inicials;
        this.nom = nom;
        this.numero = numero;
        this.pesAtomic = pesAtomic;
        this.tipus = etipus;
    }
    public TipusDeElement getTipus(){
        return tipus;
    }

    public String getInicials() {
        return inicials;
    }

    public void setInicials(String inicials) {
        this.inicials = inicials;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getPesAtomic() {
        return pesAtomic;
    }

    public void setPesAtomic(float pesAtomic) {
        this.pesAtomic = pesAtomic;
    }

    public String getSerieQuimica() {
        return serieQuimica;
    }

    public void setSerieQuimica(String serieQuimica) {
        this.serieQuimica = serieQuimica;
    }

    public int getGrup() {
        return grup;
    }

    public void setGrup(int grup) {
        this.grup = grup;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public String getConfiguracioElectronica() {
        return configuracioElectronica;
    }

    public void setConfiguracioElectronica(String configuracioElectronica) {
        this.configuracioElectronica = configuracioElectronica;
    }

    public float getElectronesPerNivell() {
        return electronesPerNivell;
    }

    public void setElectronesPerNivell(float electronesPerNivell) {
        this.electronesPerNivell = electronesPerNivell;
    }

    private String bloque;
    private String configuracioElectronica;
    private float electronesPerNivell;
}
