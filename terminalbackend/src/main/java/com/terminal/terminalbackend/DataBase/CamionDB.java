package com.terminaldzy.terminal.DataBase;

import java.sql.*;
import java.util.ArrayList;

import com.terminaldzy.terminal.database;
import com.terminaldzy.terminal.Model.Camion; 

public class CamionDB {

    public void inserisciCamion(String targa, String marca)
    {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "INSERT INTO camion (targa, marca) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, targa);
            stmt.setString(2, marca);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Camion> getTuttiICamion() 
    {
        ArrayList<Camion> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "SELECT targa, marca FROM camion";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Camion camion = new Camion(
                    rs.getString("targa"),
                    rs.getString("marca")
                );
                lista.add(camion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void eliminaCamion(String targa) 
    {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "DELETE FROM camion WHERE targa = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, targa);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}