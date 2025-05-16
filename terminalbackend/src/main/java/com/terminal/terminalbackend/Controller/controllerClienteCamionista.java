package com.terminal.terminalbackend.Controller;

import java.sql.*;
import com.terminal.terminalbackend.database;
import org.springframework.web.bind.annotation.*;
import com.terminal.terminalbackend.DataBase.CamionistaDB;

@RestController
@RequestMapping("/gestioneCamionisti")
public class controllerClienteCamionista 
{
    private final CamionistaDB Camionista = new CamionistaDB();

    @GetMapping("/inserisciCamionista")
    public String inserisci(@RequestParam String nome, @RequestParam String cognome, @RequestParam String telefono, @RequestParam int idCamion) 
    {
        Camionista.inserisciCamionista(nome, cognome, telefono, idCamion);
        return "OK";
    }

    @GetMapping("/getTuttiCamionisti")
    public ArrayList<Autista> trovaTutti() 
    {
        return Camionista.getTuttiCamionisti();
    }

    @GetMapping("/eliminaCamionista")
    public String elimina(@RequestParam int id) 
    {
        Camionista.eliminaCamionista(id);
        return "OK";
    }
}
