package com.terminal.terminalbackend.Controller;

@RestController
@RequestMapping("/gestioneCamion")
public class controllerClienteCamion 
{
    CamionDB Camion = new CamionDB();

    @GetMapping("/inserisciCamion")
    public String inserisciCamion(@RequestParam String targa, @RequestParam String marca) {
        Camion.inserisciCamion(targa, marca);
        return "OK";
    }

    @GetMapping("/tuttiCamion")
    public ArrayList<Camion> getTuttiCamion() {
        return daCamiono.getTuttiCamion();
    }

    @GetMapping("/eliminaCamion")
    public String eliminaCamion(@RequestParam String targa) {
        Camion.eliminaCamion(targa);
        return "OK";
    }
}