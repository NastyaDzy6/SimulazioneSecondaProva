package com.terminaldzy.terminal.DataBase;

import java.sql.*;
import java.util.ArrayList;

import com.terminaldzy.terminal.database;
import com.terminaldzy.terminal.Model.Polizza;
import com.terminaldzy.terminal.Model.Porto;
import com.terminaldzy.terminal.Model.Viaggio;

public class PolizzaDB {
      public void inserisciPolizza(int franchigiaGiorni, String fornitore, String destinazione, int idPortoCarico, int idViaggio) {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "INSERT INTO polizza (franchigia_giorni, fornitore, destinazione, id_porto_carico, id_viaggio) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, franchigiaGiorni);
            stmt.setString(2, fornitore);
            stmt.setString(3, destinazione);
            stmt.setInt(4, idPortoCarico);
            stmt.setInt(5, idViaggio);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Polizza> getTutteLePolizze() {
        ArrayList<Polizza> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "SELECT p.id_polizza, p.franchigia_giorni, p.fornitore, p.destinazione, " +
                         "p.id_porto_carico, p.id_viaggio, " +
                         "portoCarico.nome AS nome_porto_carico, portoCarico.nazione AS nazione_porto_carico, " +
                         "viaggio.id_viaggio, viaggio.data_partenza, viaggio.data_arribamento, " +
                         "portoPartenza.nome AS nome_porto_partenza, portoArrivo.nome AS nome_porto_arrivo " +
                         "FROM polizza p " +
                         "JOIN porto portoCarico ON p.id_porto_carico = portoCarico.id_porto " +
                         "JOIN viaggio viaggio ON p.id_viaggio = viaggio.id_viaggio " +
                         "JOIN porto portoPartenza ON viaggio.id_porto_partenza = portoPartenza.id_porto " +
                         "JOIN porto portoArrivo ON viaggio.id_porto_arrivo = portoArrivo.id_porto";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Porto portoCarico = new Porto(
                        rs.getInt("id_porto_carico"),
                        rs.getString("nome_porto_carico"),
                        rs.getString("nazione_porto_carico"),
                        null 
                );

                Porto portoPartenza = new Porto(
                        rs.getInt("id_porto_partenza"),
                        rs.getString("nome_porto_partenza"),
                        null,  
                        null
                );

                Porto portoArrivo = new Porto(
                        rs.getInt("id_porto_arrivo"),
                        rs.getString("nome_porto_arrivo"),
                        null, 
                        null
                );

                Viaggio viaggio = new Viaggio(
                        rs.getInt("id_viaggio"),
                        rs.getInt("id_nave"),  
                        rs.getDate("data_partenza"),
                        rs.getDate("data_arribamento"),
                        portoPartenza,
                        portoArrivo
                );

                Polizza polizza = new Polizza(
                        rs.getInt("id_polizza"),
                        rs.getInt("franchigia_giorni"),
                        rs.getString("fornitore"),
                        rs.getString("destinazione"),
                        portoCarico,
                        viaggio
                );
                lista.add(polizza);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void eliminaPolizza(int idPolizza) {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "DELETE FROM polizza WHERE id_polizza = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPolizza);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
