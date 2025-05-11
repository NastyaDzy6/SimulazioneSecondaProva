package com.terminaldzy.terminal.DataBase;
import java.sql.*;
import java.util.ArrayList;

import com.terminaldzy.terminal.database;
import com.terminaldzy.terminal.Model.Merce;
import com.terminaldzy.terminal.Model.Polizza;
import com.terminaldzy.terminal.Model.Porto;
import com.terminaldzy.terminal.Model.Viaggio;

public class MerceDB 
{
      public void inserisciMerce(int idMerce, String tipologia, double peso, double volume, String condizioniConservazione, Polizza polizza, int idFornitore) {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sqlPolizza = "INSERT INTO polizza (franchigiaGiorni, fornitore, destinazione, portoCarico, viaggioId) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmtPolizza = conn.prepareStatement(sqlPolizza, Statement.RETURN_GENERATED_KEYS);
            stmtPolizza.setInt(1, polizza.getFranchigiaGiorni());
            stmtPolizza.setString(2, polizza.getFornitore());
            stmtPolizza.setString(3, polizza.getDestinazione());
            stmtPolizza.setString(4, polizza.getPortoCarico().toString());
            stmtPolizza.setInt(5, polizza.getViaggio().getIdViaggio()); 
            stmtPolizza.executeUpdate();
            
            ResultSet rs = stmtPolizza.getGeneratedKeys();
            int polizzaId = -1;
            if (rs.next()) {
                polizzaId = rs.getInt(1);
            }
            
            String sqlMerce = "INSERT INTO merce (idMerce, tipologia, peso, volume, condizioniConservazione, polizzaId, idFornitore) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmtMerce = conn.prepareStatement(sqlMerce);
            stmtMerce.setInt(1, idMerce);
            stmtMerce.setString(2, tipologia);
            stmtMerce.setDouble(3, peso);
            stmtMerce.setDouble(4, volume);
            stmtMerce.setString(5, condizioniConservazione);
            stmtMerce.setInt(6, polizzaId);
            stmtMerce.setInt(7, idFornitore);
            stmtMerce.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   public ArrayList<Merce> getTutteLeMerce() {
        ArrayList<Merce> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sql = "SELECT m.idMerce, m.tipologia, m.peso, m.volume, m.condizioniConservazione, " +
                    "p.idPolizza, p.franchigiaGiorni, p.fornitore, p.destinazione, p.portoCarico, p.viaggioId, " +
                    "m.idFornitore " +
                    "FROM merce m " +
                    "JOIN polizza p ON m.polizzaId = p.idPolizza";
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Porto portoCarico = getPortoById(rs.getInt("portoCarico"), conn);  
                Viaggio viaggio = getViaggioById(rs.getInt("viaggioId"), conn);  
                
                Polizza polizza = new Polizza(
                    rs.getInt("idPolizza"),
                    rs.getInt("franchigiaGiorni"),
                    rs.getString("fornitore"),
                    rs.getString("destinazione"),
                    portoCarico,
                    viaggio
                );

                Merce m = new Merce(
                    rs.getInt("idMerce"),
                    rs.getString("tipologia"),
                    rs.getDouble("peso"),
                    rs.getDouble("volume"),
                    rs.getString("condizioniConservazione"),
                    polizza,
                    rs.getInt("idFornitore")
                );
                lista.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    private Porto getPortoById(int portoId, Connection conn) throws SQLException {
        String sqlPorto = "SELECT * FROM porto WHERE idPorto = ?";
        PreparedStatement stmtPorto = conn.prepareStatement(sqlPorto);
        stmtPorto.setInt(1, portoId);
        ResultSet rs = stmtPorto.executeQuery();
        if (rs.next()) {
            return new Porto(
                rs.getInt("idPorto"),
                rs.getString("nome"),
                rs.getString("nazione"),
                rs.getString("linea")
            );
        }
        return null; 
    }

    private Viaggio getViaggioById(int viaggioId, Connection conn) throws SQLException {
        String sqlViaggio = "SELECT * FROM viaggio WHERE idViaggio = ?";
        PreparedStatement stmtViaggio = conn.prepareStatement(sqlViaggio);
        stmtViaggio.setInt(1, viaggioId);
        ResultSet rs = stmtViaggio.executeQuery();
        if (rs.next()) {
            Porto portoPartenza = getPortoById(rs.getInt("portoPartenza"), conn);  
            Porto portoArrivo = getPortoById(rs.getInt("portoArrivo"), conn);  
            return new Viaggio(
                rs.getInt("idViaggio"),
                rs.getInt("idNave"),
                rs.getDate("dataPartenza"),
                rs.getDate("dataArribamento"),
                portoPartenza,
                portoArrivo
            );
        }
        return null; 
    }

    public void eliminaMerce(int idMerce) {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) {
            String sqlMerce = "DELETE FROM merce WHERE idMerce = ?";
            PreparedStatement stmtMerce = conn.prepareStatement(sqlMerce);
            stmtMerce.setInt(1, idMerce);
            stmtMerce.executeUpdate();
            
            String sqlPolizza = "DELETE FROM polizza WHERE idPolizza = (SELECT polizzaId FROM merce WHERE idMerce = ?)";
            PreparedStatement stmtPolizza = conn.prepareStatement(sqlPolizza);
            stmtPolizza.setInt(1, idMerce);
            stmtPolizza.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}