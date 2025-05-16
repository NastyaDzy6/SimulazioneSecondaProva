package com.terminal.terminalbackend.Controller;

import java.sql.*;
import com.terminal.terminalbackend.database;
import org.springframework.web.bind.annotation.*;
import com.terminal.terminalbackend.DataBase.BuonoDB;

public class controllerCamionistaGuida {
    private final BuonoDB buonoDB = new BuonoDB();

    @PostMapping("/inserisciBuono")
    public String inserisciBuonoConsegna(
        @RequestParam int idBuono,
        @RequestParam int idMerce,
        @RequestParam int idCamionista,
        @RequestParam String targaCamion,
        @RequestParam String telefonoCliente,
        @RequestParam String dataRitiro,
        @RequestParam double pesoRitirato
    ) {
        try {
            Date parsedData = java.sql.Date.valueOf(dataRitiro);
            buonoDB.inserisciBuonoConsegna(idBuono, idMerce, idCamionista, targaCamion, telefonoCliente, parsedData, pesoRitirato);
            return "Buono inserito con successo";
        } catch (Exception e) {
            return "Errore: " + e.getMessage();
        }
    }

    @GetMapping("/getTuttiBuoni")
    public List<BuonoConsegna> getTuttiIBuoni() {
        return buonoDB.getTuttiIBuoni();
    }

    @DeleteMapping("/eliminaBuono")
    public String eliminaBuonoConsegna(@RequestParamint id) {
        try {
            buonoDB.eliminaBuonoConsegna(id);
            return "Buono eliminato con successo";
        } catch (Exception e) {
            return "Errore: " + e.getMessage();
        }
    }
}
