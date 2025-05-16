package com.terminal.terminalbackend.DataBase;

import java.sql.*;
import com.terminal.terminalbackend.database;

public class BuonoConsegnaDB 
{
    public void inserisciBuonoConsegna(int idMerce, int idCamionista, String targaCamion, String telefonoCliente, Date dataRitiro, double pesoRitirato) {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "INSERT INTO BuonoConsegna (idMerce, idCamionista, targaCamion, telefonoCliente, dataRitiro, pesoRitirato) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idBuono);
            stmt.setInt(2, idMerce);
            stmt.setInt(3, idCamionista);
            stmt.setString(4, targaCamion);
            stmt.setString(5, telefonoCliente);
            stmt.setDate(6, new java.sql.Date(dataRitiro.getTime()));
            stmt.setDouble(7, pesoRitirato);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  /*******fare get tutti buoni */

    public void eliminaBuonoConsegna(int idBuono) {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "DELETE FROM BuonoConsegna WHERE idBuono = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idBuono);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
