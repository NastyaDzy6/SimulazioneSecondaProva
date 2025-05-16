package com.terminal.terminalbackend.Controller;

@RestController
@RequestMapping("/gestionePolizze")
public class controllerFornitorePolizze 
{

    private final PolizzaDB Polizza = new PolizzaDB();

    @GetMapping("/inserisciPolizza")
    public String inserisciPolizza(@RequestParam int franchigiaGiorni,@RequestParam  String fornitore,@RequestParam  String destinazione,@RequestParam  int idPortoCarico,@RequestParam  int idViaggio) {
        Polizza.inserisciPolizza(franchigiaGiorni,fornitore,destinazione,idPortoCarico,idViaggio);
        return "OK";
    }

    @GetMapping("/tuttePolizza")
    public ArrayList<Polizza> getTutteLePolizze() {
        return Polizza.getTutteLePolizze();
    }


    @GetMapping("/eliminaPolizza")
    public String elimina(@RequestParam int id) {
        Polizza.eliminaPolizza(id);
        return "OK";
    }

}