package com.terminal.terminalbackend.Model;
public class Fornitore {
    private int idFornitore;
    private String nome;
    private String cognome;
    private String telefono;
    private String nomeAzienda;
    private String credenziali;

    public Fornitore(int idFornitore, String nome, String cognome, String telefono, String nomeAzienda, String credenziali) {
        this.idFornitore = idFornitore;
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.nomeAzienda = nomeAzienda;
        this.credenziali = credenziali;
    }

    public int getIdFornitore() {
        return idFornitore;
    }

    public void setIdFornitore(int idFornitore) {
        this.idFornitore = idFornitore;
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

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public void setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
    }
    public String getCredenziali() {
        return credenziali;
    }
    public void setCredenziali(String credenziali) {
        this.credenziali = credenziali;
    }
}
