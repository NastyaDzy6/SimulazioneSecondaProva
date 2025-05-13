package com.terminaldzy.terminal.DataBase;

import java.sql.*;
import java.util.ArrayList;

import com.terminaldzy.terminal.database;
import com.terminaldzy.terminal.Model.Porto;

public class PortoDB {
      public void inserisciPorto(String nome, String nazione, String linea) {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "INSERT INTO porto (nome, nazione, linea) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, nazione);
            stmt.setString(3, linea);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Porto> getTuttiIPorti() {
        ArrayList<Porto> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "SELECT id_porto, nome, nazione, linea FROM porto";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Porto porto = new Porto(
                        rs.getInt("id_porto"),
                        rs.getString("nome"),
                        rs.getString("nazione"),
                        rs.getString("linea")
                );
                lista.add(porto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Porto trovaPortoPerId(int idPorto) {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "SELECT id_porto, nome, nazione, linea FROM porto WHERE id_porto = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPorto);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Porto(
                        rs.getInt("id_porto"),
                        rs.getString("nome"),
                        rs.getString("nazione"),
                        rs.getString("linea")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void eliminaPorto(int idPorto) {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "DELETE FROM porto WHERE id_porto = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPorto);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
