package com.terminal.terminalbackend.Model;

public class Utente {
    private String username;
    private String password;
    private String ruolo;

    public Utente(String username, String password, String ruolo) {
        this.username = username;
        this.password = password;
        this.ruolo = ruolo;
    }

    public String getPassword() {
        return password;
    }
   
    public String getUsername() {
        return username;
    }

    public String getRuolo() {
        return ruolo;
    }
}
