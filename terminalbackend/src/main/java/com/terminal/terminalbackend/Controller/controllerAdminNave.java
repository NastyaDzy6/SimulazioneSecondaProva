package com.terminal.terminalbackend.Controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.terminal.terminalbackend.DataBase.NaveDB;
import com.terminal.terminalbackend.Model.Nave;

@RestController
@RequestMapping("/gestioneNavi")
public class controllerAdminNave {
    private final NaveDB nave = new NaveDB();

    @GetMapping("/inserisciNave")
    public String inserisciNave(@RequestParam String nome) 
    {
        nave.inserisciNave(nome);
        return "OK";
    }

    @GetMapping("/getNavi")
    public ArrayList<Nave> getTutteLeNavi() 
    {
        return nave.getTutteLeNavi();
    }

    @GetMapping("/eliminaNave")
    public String elimina(@RequestParam int id) 
    {
        nave.eliminaNave(id);
        return "OK";
    }
}
