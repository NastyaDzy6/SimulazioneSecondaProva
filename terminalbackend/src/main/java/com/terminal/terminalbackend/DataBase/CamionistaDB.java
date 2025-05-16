package com.terminal.terminalbackend.DataBase;

import java.sql.*;
import java.util.ArrayList;

import com.terminal.terminalbackend.database;
import com.terminal.terminalbackend.Model.Camionista;

public class CamionistaDB {
     public void inserisciCamionista(String nome, String cognome, String telefono, int idCamion) {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "INSERT INTO Camionista (nome, cognome, telefono, idCamion) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setString(3, telefono);
            stmt.setInt(4, idCamion);
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
