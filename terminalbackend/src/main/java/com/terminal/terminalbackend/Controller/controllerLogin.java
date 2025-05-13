package com.terminal.terminalbackend.Controller;

import com.terminal.terminalbackend.DataBase.*;
import com.terminal.terminalbackend.Model.Utente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class controllerLogin {
    private final UtenteDB Utente = new UtenteDB();

    @GetMapping
    public Utente login(@RequestParam String username, @RequestParam String password) 
    {
        String ruolo = Utente.verificaCredenziali(username, password);
        if (ruolo.equals("Admin")) {
            return new Utente(username, password,"Admin");
        }else if (ruolo.equals("Camionista")){
            return new Utente(username, password,"Camionista");
        }else if (ruolo.equals("Fornitore")){
            return new Utente(username, password,"Fornitore");
        }else if (ruolo.equals("Cliente")){
            return new Utente(username, password,"Cliente");
        }

        return new Utente("-1","-1","null");
    }
}
