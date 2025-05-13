package com.terminaldzy.terminal.DataBase;
import java.sql.*;
import java.util.ArrayList;

import com.terminaldzy.terminal.database;
import com.terminaldzy.terminal.Model.GuidaCamion;

public class GuidaCamionDB 
{
    public void inserisciGuidaCamion(int idCamionista, String targa, Date dataInizio, Date dataFine) {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "INSERT INTO guida_camion (idCamionista, targa, dataInizio, dataFine) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCamionista);
            stmt.setString(2, targa);
            stmt.setDate(3, dataInizio);
            stmt.setDate(4, dataFine);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<GuidaCamion> trovaTutteLeGuide() {
        ArrayList<GuidaCamion> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "SELECT idCamionista, targa, dataInizio, dataFine FROM guida_camion";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                GuidaCamion g = new GuidaCamion(
                    rs.getInt("idCamionista"),
                    rs.getString("targa"),
                    rs.getDate("dataInizio"),
                    rs.getDate("dataFine")
                );
                lista.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void eliminaGuidaCamion(int idCamionista, String targa) {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "DELETE FROM guida_camion WHERE idCamionista = ? AND targa = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCamionista);
            stmt.setString(2, targa);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}