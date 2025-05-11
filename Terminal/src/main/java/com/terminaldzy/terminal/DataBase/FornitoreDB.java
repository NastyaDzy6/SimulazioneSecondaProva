package com.terminaldzy.terminal.DataBase;

import java.sql.*;
import java.util.ArrayList;

import com.terminaldzy.terminal.database;
import com.terminaldzy.terminal.Model.Fornitore;

public class FornitoreDB {

    public void inserisciFornitore(int idFornitore, String nome, String cognome, String telefono, String nomeAzienda) 
    {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) 
        {
            String sql = "INSERT INTO Fornitore (idFornitore, nome, cognome, telefono, nomeAzienda) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idFornitore);
            stmt.setString(2, nome);
            stmt.setString(3, cognome);
            stmt.setString(4, telefono);
            stmt.setString(5, nomeAzienda);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Fornitore> getTuttiFornitori() 
    {
        ArrayList<Fornitore> lista = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "SELECT * FROM Fornitore";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Fornitore f = new Fornitore(
                    rs.getInt("idFornitore"),
                    rs.getString("nome"),
                    rs.getString("cognome"),
                    rs.getString("telefono"),
                    rs.getString("nomeAzienda")
                );
                lista.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void eliminaFornitore(int idFornitore) 
    {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) 
        {
            String sql = "DELETE FROM Fornitore WHERE idFornitore = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idFornitore);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}