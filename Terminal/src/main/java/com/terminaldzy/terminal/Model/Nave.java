package com.terminaldzy.terminal.Model;

public class Nave 
{
    private int idNave;
    private String nome;

    public Nave() {
    }

    public Nave(int idNave, String nome) {
        this.idNave = idNave;
        this.nome = nome;
    }

    public int getIdNave() {
        return idNave;
    }

    public void setIdNave(int idNave) {
        this.idNave = idNave;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}