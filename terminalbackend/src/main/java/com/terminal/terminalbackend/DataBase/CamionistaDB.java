package com.terminal.terminalbackend.DataBase;

import java.sql.*;
import java.util.ArrayList;

import com.terminal.terminalbackend.database;
import com.terminal.terminalbackend.Model.Camionista;

public class CamionistaDB {
     public void inserisciCamionista(int idCamionista, String nome, String cognome, String telefono, int idCamion) {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "INSERT INTO Camionista (idCamionista, nome, cognome, telefono, idCamion) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCamionista);
            stmt.setString(2, nome);
            stmt.setString(3, cognome);
            stmt.setString(4, telefono);
            stmt.setInt(5, idCamion);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Camionista> getTuttiCamionisti() {
        ArrayList<Camionista> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "SELECT * FROM Camionista";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Camionista c = new Camionista(
                    rs.getInt("idCamionista"),
                    rs.getString("nome"),
                    rs.getString("cognome"),
                    rs.getString("telefono"),
                    rs.getInt("idCamion")
                );
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void eliminaCamionista(int idCamionista) {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "DELETE FROM Camionista WHERE idCamionista = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCamionista);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
