package com.terminaldzy.terminal.Model;

public class Merce 
{
    private int idMerce;
    private String tipologia;
    private double peso;
    private double volume;
    private String condizioniConservazione;
    private Polizza polizza;
    private int idFornitore;


    public Merce() {
    }

    public Merce(int idMerce, String tipologia, double peso, double volume, String condizioniConservazione, Polizza polizza, int idFornitore) {
        this.idMerce = idMerce;
        this.tipologia = tipologia;
        this.peso = peso;
        this.volume = volume;
        this.condizioniConservazione = condizioniConservazione;
        this.polizza = polizza;
        this.idFornitore = idFornitore;
    }

    public int getIdFornitore() {
        return idFornitore;
    }

    public void setIdFornitore(int idFornitore) {
        this.idFornitore = idFornitore;
    }

    public int getIdMerce() {
        return idMerce;
    }

    public void setIdMerce(int idMerce) {
        this.idMerce = idMerce;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getCondizioniConservazione() {
        return condizioniConservazione;
    }

    public void setCondizioniConservazione(String condizioniConservazione) {
        this.condizioniConservazione = condizioniConservazione;
    }

    public Polizza getPolizza() {
        return polizza;
    }

    public void setPolizza(Polizza polizza) {
        this.polizza = polizza;
    }
}