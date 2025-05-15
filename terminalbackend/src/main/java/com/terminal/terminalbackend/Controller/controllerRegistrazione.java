package com.terminal.terminalbackend.Controller;

import java.sql.*;
import com.terminal.terminalbackend.database;
import org.springframework.web.bind.annotation.*;
import com.terminal.terminalbackend.DataBase.UtenteDB;

@RestController
@RequestMapping("/registrazione")
public class controllerRegistrazione {
      UtenteDB db = new UtenteDB();

    @PostMapping("/registrazione/camionista")
    public String registraCamionista(@RequestParam String username,@RequestParam String password,@RequestParam String nome,@RequestParam String cognome,@RequestParam String telefono, @RequestParam int idCamion) {
        if (!db.inserisciUtente(username, password, "camionista")) {
            return "Errore inserimento utente";
        }

        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "INSERT INTO camionista (nome, cognome, telefono, idCamion, credenziali) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setString(3, telefono);
            stmt.setInt(4, idCamion);
            stmt.setString(5, username);
            stmt.executeUpdate();
            return "Camionista registrato";
        } catch (Exception e) {
            e.printStackTrace();
            return "Errore camionista";
        }
    }

    @PostMapping("/registrazione/cliente")
    public String registraCliente(@RequestParam String username,@RequestParam String password,@RequestParam String nome,@RequestParam String cognome,@RequestParam String telefono) {
        if (!db.inserisciUtente(username, password, "cliente")) {
            return "Errore inserimento utente";
        }

        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "INSERT INTO cliente (nome, cognome, telefono, credenziali) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setString(3, telefono);
            stmt.setString(4, username);
            stmt.executeUpdate();
            return "Cliente registrato";
        } catch (Exception e) {
            e.printStackTrace();
            return "Errore cliente";
        }
    }

    @PostMapping("/registrazione/fornitore")
    public String registraFornitore(@RequestParam String username,@RequestParam String password,@RequestParam String nome,@RequestParam String cognome,@RequestParam String telefono,@RequestParam String nomeAzienda) {
        if (!db.inserisciUtente(username, password, "fornitore")) {
            return "Errore inserimento utente";
        }

        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "INSERT INTO fornitore (nome, cognome, telefono, nomeAzienda, credenziali) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setString(3, telefono);
            stmt.setString(4, nomeAzienda);
            stmt.setString(5, username);
            stmt.executeUpdate();
            return "Fornitore registrato";
        } catch (Exception e) {
            e.printStackTrace();
            return "Errore fornitore";
        }
    }

    @PostMapping("/registrazione/admin")
    public String registraAdmin(@RequestParam String username,@RequestParam String password) {
        if (!db.inserisciUtente(username, password, "admin")) {
            return "Errore inserimento utente";
        }

        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "INSERT INTO admin (username, password) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate();
            return "Admin registrato";
        } catch (Exception e) {
            e.printStackTrace();
            return "Errore admin";
        }
    }
}
