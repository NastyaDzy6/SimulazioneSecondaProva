package com.terminal.terminalbackend.DataBase;

import java.sql.*;

import com.terminal.terminalbackend.database;

public class UtenteDB 
{
    public String verificaCredenziali(String username, String password) 
    {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) 
        {
            String sql = "SELECT * FROM utente WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("ruolo");
            } else {
                return "errore";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "errore";
        }
    }

    public boolean inserisciUtente(String username, String password, String ruolo) {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) 
        {
            String sql = "INSERT INTO utente (username, password, ruolo) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, ruolo);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            return false;
        }
    }
}
