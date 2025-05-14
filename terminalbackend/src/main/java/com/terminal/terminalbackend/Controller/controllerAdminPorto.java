package com.terminal.terminalbackend.Controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.terminal.terminalbackend.Model.Porto;
import com.terminal.terminalbackend.DataBase.PortoDB;

@RestController
@RequestMapping("/gestionePorti")
public class controllerAdminPorto {
    private final PortoDB Porto = new PortoDB();

    @GetMapping("/inserisciPorto")
    public String inserisciPorto(@RequestParam String nome,@RequestParam String nazione,@RequestParam String linea) 
    {
        Porto.inserisciPorto(nome, nazione, linea);
        return "OK";
    }

    @GetMapping("/getPorti")
    public ArrayList<Porto> getTuttiPorto() 
    {
        return Porto.getTuttiPorti();
    }

    @GetMapping("/eliminaPorto")
    public String eliminaPorto(@RequestParam int id) 
    {
        if(id == 1)
            return "No";

        Porto.eliminaPorto(id);
        return "OK";
    }
}
