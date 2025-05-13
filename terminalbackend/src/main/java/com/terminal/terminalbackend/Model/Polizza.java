package com.terminal.terminalbackend.Model;
public class Polizza 
{
    private int idPolizza;
    private int franchigiaGiorni;
    private String fornitore;
    private String destinazione;
    private Porto portoCarico;
    private Viaggio viaggio;

    public Polizza() {
    }

    public Polizza(int idPolizza, int franchigiaGiorni, String fornitore, String destinazione, Porto portoCarico, Viaggio viaggio) {
        this.idPolizza = idPolizza;
        this.franchigiaGiorni = franchigiaGiorni;
        this.fornitore = fornitore;
        this.destinazione = destinazione;
        this.portoCarico = portoCarico;
        this.viaggio = viaggio;
    }

    public int getIdPolizza() {
        return idPolizza;
    }

    public void setIdPolizza(int idPolizza) {
        this.idPolizza = idPolizza;
    }

    public int getFranchigiaGiorni() {
        return franchigiaGiorni;
    }

    public void setFranchigiaGiorni(int franchigiaGiorni) {
        this.franchigiaGiorni = franchigiaGiorni;
    }

    public String getFornitore() {
        return fornitore;
    }

    public void setFornitore(String fornitore) {
        this.fornitore = fornitore;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public Porto getPortoCarico() {
        return portoCarico;
    }

    public void setPortoCarico(Porto portoCarico) {
        this.portoCarico = portoCarico;
    }

    public Viaggio getViaggio() {
        return viaggio;
    }

    public void setViaggio(Viaggio viaggio) {
        this.viaggio = viaggio;
    }
}