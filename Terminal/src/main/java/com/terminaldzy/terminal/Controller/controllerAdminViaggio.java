package com.terminaldzy.terminal.Controller;

import org.springframework.web.bind.annotation.*;
import com.terminaldzy.terminal.DataBase.ViaggioDB;
import com.terminaldzy.terminal.Model.Viaggio;

import java.sql.Date;
import java.util.ArrayList;

public class controllerAdminViaggio {
    
    private final ViaggioDB Viaggio = new ViaggioDB();

    @GetMapping("/inserisciViaggio")
    public String inserisciViaggio(@RequestParam int idNave, @RequestParam Date dataPartenza, @RequestParam Date dataArribamento, @RequestParam int idPortoPartenza, @RequestParam int idPortoArrivo) {
        Viaggio.inserisciViaggio(idNave, dataPartenza, dataArribamento, idPortoPartenza, idPortoArrivo);
        return "OK";
    }

    @GetMapping("/tuttiViaggi")
    public ArrayList<Viaggio> getTuttiViaggi() {
        return Viaggio.getTuttiViaggi();
    }

    @GetMapping("/eliminaViaggio")
    public String eliminaViaggio(@RequestParam int id) {
        Viaggio.eliminaViaggio(id);
        return "OK";
    }
}
