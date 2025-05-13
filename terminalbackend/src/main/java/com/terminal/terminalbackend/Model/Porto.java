package com.terminaldzy.terminal.Model;

public class Porto 
{
    private int idPorto;
    private String nome;
    private String nazione;
    private String linea;

    public Porto(int idPorto, String nome, String nazione, String linea) {
        this.idPorto = idPorto;
        this.nome = nome;
        this.nazione = nazione;
        this.linea = linea;
    }

    public int getIdPorto() {
        return idPorto;
    }

    public String getNome() {
        return nome;
    }

    public String getNazione() {
        return nazione;
    }

    public String getLinea() {
        return linea;
    }

    public void setIdPorto(int idPorto) {
        this.idPorto = idPorto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }
}