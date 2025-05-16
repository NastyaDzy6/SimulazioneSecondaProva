package com.terminal.terminalbackend.Controller;

@RestController
@RequestMapping("/camionista/merce")
public class controllerCamionista {

    private final MerceDB merceDB = new MerceDB();

    @PostMapping("/inserisciMerce")
    public String inserisciMerce(
        @RequestParam int idMerce,
        @RequestParam String tipologia,
        @RequestParam double peso,
        @RequestParam double volume,
        @RequestParam String condizioniConservazione,
        @RequestParam int franchigiaGiorni,
        @RequestParam String fornitorePolizza,
        @RequestParam String destinazione,
        @RequestParam int idPortoCarico,
        @RequestParam int idViaggio,
        @RequestParam int idFornitore
    ) {
        try {
            Porto portoCarico = new Porto(idPortoCarico, "", "", "");
            Viaggio viaggio = new Viaggio(idViaggio, 0, null, null, null, null);
            Polizza polizza = new Polizza(0, franchigiaGiorni, fornitorePolizza, destinazione, portoCarico, viaggio);

            merceDB.inserisciMerce(idMerce, tipologia, peso, volume, condizioniConservazione, polizza, idFornitore);
            return "Merce inserita con successo";
        } catch (Exception e) {
            return "Errore: " + e.getMessage();
        }
    }


    @GetMapping("/tutteMerci")
    public ArrayList<Merce> getTutteLeMerce() {
        return merceDB.getTutteLeMerce();
    }

    @DeleteMapping("/eliminaMerce")
    public ResponseEntity<String> eliminaMerce(@PathVariable int id) {
        try {
            merceDB.eliminaMerce(id);
            return "Merce eliminata con successo";
        } catch (Exception e) {
            return "Errore: " + e.getMessage();
        }
    }
}
