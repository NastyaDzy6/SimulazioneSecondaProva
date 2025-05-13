package com.terminal.terminalbackend.DataBase;

import java.sql.*;
import java.util.ArrayList;

import com.terminal.terminalbackend.database;
import com.terminal.terminalbackend.Model.Nave;


public class NaveDB {

    public void inserisciNave(String nome) {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "INSERT INTO navi (nome) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Nave> getTutteLeNavi() {
        ArrayList<Nave> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "SELECT id AS id_nave, nome FROM navi";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Nave nave = new Nave(rs.getInt("id_nave"), rs.getString("nome"));
                lista.add(nave);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void eliminaNave(int id) {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "DELETE FROM navi WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
