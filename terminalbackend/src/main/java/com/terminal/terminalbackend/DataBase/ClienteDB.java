package com.terminal.terminalbackend.DataBase;

import java.sql.*;
import java.util.ArrayList;

import com.terminal.terminalbackend.database;
import com.terminal.terminalbackend.Model.Cliente;

public class ClienteDB 
{
    public void inserisciCliente(int idCliente, String nome, String cognome, String telefono) 
    {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) 
        {
            String sql = "INSERT INTO Cliente (idCliente, nome, cognome, telefono) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCliente);
            stmt.setString(2, nome);
            stmt.setString(3, cognome);
            stmt.setString(4, telefono);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Cliente> getTuttiClienti() 
    {
        ArrayList<Cliente> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) 
        {
            String sql = "SELECT * FROM Cliente";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Cliente c = new Cliente(
                    rs.getInt("idCliente"),
                    rs.getString("nome"),
                    rs.getString("cognome"),
                    rs.getString("telefono")
                );
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void eliminaCliente(int idCliente) 
    {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) 
        {
            String sql = "DELETE FROM Cliente WHERE idCliente = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCliente);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int verificaCredenziali(String username, String password) 
    {
        try (Connection conn = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD)) 
        {
            String sql = "SELECT id FROM cliente WHERE password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            } else {
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
