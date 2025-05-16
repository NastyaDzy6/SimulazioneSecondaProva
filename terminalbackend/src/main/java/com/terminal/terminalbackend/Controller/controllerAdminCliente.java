package com.terminal.terminalbackend.Controller;

@RestController
@RequestMapping("/gestioneClienti")
public class controllerAdminCliente {

    private final ClienteDB Cliente = new ClienteDB();

    @GetMapping("/inserisciCliente")
    public String inserisciCliente(@RequestParam String nome,@RequestParam String cognome,@RequestParam String telefono) throws SQLException
    {
        Cliente.inserisciCliente(nome, cognome, telefono);
        return "OK";
    }

    @GetMapping("/getTuttiClienti")
    public ArrayList<Cliente> getTuttiClienti() 
    {
        return Cliente.getTuttiClienti();
    }

    @GetMapping("/eliminaCliente")
    public String elimina(@RequestParam int id) 
    {
        Cliente.eliminaCliente(id);
        return "OK";
    }
}
