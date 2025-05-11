package com.terminaldzy.terminal.DataBase;

import java.sql.*;
import java.util.ArrayList;

import com.terminaldzy.terminal.database;
import com.terminaldzy.terminal.Model.Porto;
import com.terminaldzy.terminal.Model.Viaggio;

public class ViaggioDB {
     public void inserisciViaggio(int idNave, Date dataPartenza, Date dataArribamento, int idPortoPartenza, int idPortoArrivo) {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "INSERT INTO viaggio (id_nave, data_partenza, data_arribamento, id_porto_partenza, id_porto_arrivo) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idNave);
            stmt.setDate(2, dataPartenza);
            stmt.setDate(3, dataArribamento);
            stmt.setInt(4, idPortoPartenza);
            stmt.setInt(5, idPortoArrivo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Viaggio> getTuttiIViaggi() {
        ArrayList<Viaggio> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "SELECT v.id_viaggio, v.id_nave, v.data_partenza, v.data_arribamento, " +
                         "v.id_porto_partenza, v.id_porto_arrivo, " +
                         "p1.nome AS porto_partenza_nome, p1.nazione AS porto_partenza_nazione, p1.linea AS porto_partenza_linea, " +
                         "p2.nome AS porto_arrivo_nome, p2.nazione AS porto_arrivo_nazione, p2.linea AS porto_arrivo_linea " +
                         "FROM viaggio v " +
                         "JOIN porto p1 ON v.id_porto_partenza = p1.id_porto " +
                         "JOIN porto p2 ON v.id_porto_arrivo = p2.id_porto";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Porto portoPartenza = new Porto(
                        rs.getInt("id_porto_partenza"),
                        rs.getString("porto_partenza_nome"),
                        rs.getString("porto_partenza_nazione"),
                        rs.getString("porto_partenza_linea")
                );
                Porto portoArrivo = new Porto(
                        rs.getInt("id_porto_arrivo"),
                        rs.getString("porto_arrivo_nome"),
                        rs.getString("porto_arrivo_nazione"),
                        rs.getString("porto_arrivo_linea")
                );
                Viaggio viaggio = new Viaggio(
                        rs.getInt("id_viaggio"),
                        rs.getInt("id_nave"),
                        rs.getDate("data_partenza"),
                        rs.getDate("data_arribamento"),
                        portoPartenza,
                        portoArrivo
                );
                lista.add(viaggio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void eliminaViaggio(int idViaggio) {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "DELETE FROM viaggio WHERE id_viaggio = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idViaggio);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
