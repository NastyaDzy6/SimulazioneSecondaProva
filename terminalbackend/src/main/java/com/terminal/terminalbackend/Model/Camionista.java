package com.terminal.terminalbackend.Model;

public class Camionista {

    private int idCamionista;
    private String nome;
    private String cognome;
    private String telefono;
    private int idCamion;

    public Camionista(int idCamionista, String nome, String cognome, String telefono, int idCamion) {
        this.idCamionista = idCamionista;
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.idCamion = idCamion;
    }

    public int getIdCamionista() {
        return idCamionista;
    }

    public void setIdCamionista(int idCamionista) {
        this.idCamionista = idCamionista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdCamion() {
        return idCamion;
    }

    public void setIdCamion(int idCamion) {
        this.idCamion = idCamion;
    }

}