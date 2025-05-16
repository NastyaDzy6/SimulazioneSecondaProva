package com.terminal.terminalbackend.Model;

public class Cliente 
{
    private int idCliente;
    private String nome;
    private String cognome;
    private String telefono;
    private String credenziali;

    public Cliente() {
    }

    public Cliente(int idCliente, String nome, String cognome, String telefono, String credenziali) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.credenziali = credenziali;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public String getCredenziali() {
        return credenziali;
    }

    public void setCredenziali(String credenziali) {
        this.credenziali = credenziali;
    }
}