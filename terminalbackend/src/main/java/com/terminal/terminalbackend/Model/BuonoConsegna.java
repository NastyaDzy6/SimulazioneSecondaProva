package com.terminaldzy.terminal.Model;
import java.util.Date;


public class BuonoConsegna 
{
    private int idBuono;
    private Merce merce;
    private Camionista camionista;
    private Camion camion;
    private String telefonoCliente;
    private Date dataRitiro;
    private double pesoRitirato;

    public BuonoConsegna(int idBuono, Merce merce, Camionista camionista, Camion camion, String telefonoCliente, Date dataRitiro, double pesoRitirato) {
        this.idBuono = idBuono;
        this.merce = merce;
        this.camionista = camionista;
        this.camion = camion;
        this.telefonoCliente = telefonoCliente;
        this.dataRitiro = dataRitiro;
        this.pesoRitirato = pesoRitirato;
    }

    public int getIdBuono() {
        return idBuono;
    }

    public void setIdBuono(int idBuono) {
        this.idBuono = idBuono;
    }

    public Merce getMerce() {
        return merce;
    }

    public void setMerce(Merce merce) {
        this.merce = merce;
    }

    public Camionista getCamionista() {
        return camionista;
    }

    public void setCamionista(Camionista camionista) {
        this.camionista = camionista;
    }

    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public Date getDataRitiro() {
        return dataRitiro;
    }

    public void setDataRitiro(Date dataRitiro) {
        this.dataRitiro = dataRitiro;
    }

    public double getPesoRitirato() {
        return pesoRitirato;
    }

    public void setPesoRitirato(double pesoRitirato) {
        this.pesoRitirato = pesoRitirato;
    }
}