package com.terminaldzy.terminal.Controller;

import com.terminaldzy.terminal.DataBase.*;
import com.terminaldzy.terminal.Model.Utente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class controllerLogin {
    
    private final ClienteDB Cliente = new ClienteDB();
    private final CamionistaDB Camionista = new CamionistaDB();
    private final FornitoreDB Fornitore = new FornitoreDB();
    private final AdminDB Admin = new AdminDB();

    @GetMapping
    public Utente login(@RequestParam String username, @RequestParam String password) 
    {
        int id = Cliente.verificaCredenziali(username, password);
        if (id != -1) {
            return new Utente(id, username, "Cliente");
        }
        id = Camionista.verificaCredenziali(username, password);
        if (id != -1) {
            return new Utente(id,  username, "Camionista");
        }
        id = Fornitore.verificaCredenziali(username, password);
        if (id != -1) {
            return new Utente(id,  username, "Fornitore");
        }
        id = Admin.verificaCredenziali(username, password);
        if (id != -1) {
            return new Utente(id,  username, "Admin");
        }

        return new Utente(-1,"null","null");
    }
}
