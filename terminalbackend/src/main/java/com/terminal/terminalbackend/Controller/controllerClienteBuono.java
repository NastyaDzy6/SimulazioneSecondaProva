package com.terminal.terminalbackend.Controller;

import org.springframework.web.bind.annotation.*;
import com.terminal.terminalbackend.DataBase.BuonoConsegnaDB;
import com.terminal.terminalbackend.Model.BuonoConsegna;

import java.sql.Date;
import java.util.ArrayList;
@RestController
@RequestMapping("/gestioneBuoni")
public class controllerClienteBuono {

    private final BuonoConsegnaDB BuonoConsegna = new BuonoConsegnaDB();

    @GetMapping("/inserisciBuono")
    public String inserisci(@RequestParam int idMerce,@RequestParam int idCamionista,@RequestParam String targaCamion,@RequestParam String telefonoCliente,@RequestParam Date dataRitiro,@RequestParam double pesoRitirato) 
    {
        BuonoConsegna.inserisciBuono(idMerce, idCamionista, targaCamion, telefonoCliente, dataRitiro, pesoRitirato);
        return "OK";
    }

    @GetMapping("/getTuttiBuoni")
    public ArrayList<Buono> getTuttiBuoni() {
        return BuonoConsegna.getTuttiBuoni();
    }

    @GetMapping("/eliminaBuono")
    public String eliminaBuonoConsegna(@RequestParam int id) {
        BuonoConsegna.eliminaBuonoConsegna(id);
        return "OK";
    }
}