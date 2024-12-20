package repositories;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import entity.Dette;
import entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetteRepository {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/projet_java"; 
    private static final String DB_USER = "postgres"; 
    private static final String DB_PASSWORD = "salaoudine"; 

    
    public void addDette(Dette dette) {
        String query = "INSERT INTO dettes (date, montant, montant_verser, montant_restant, client_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, dette.getDate());
            statement.setDouble(2, dette.getMontant());
            statement.setDouble(3, dette.getMontantVerser());
            statement.setDouble(4, dette.getMontantRestant());
            statement.setInt(5, dette.getClient().getId());
            statement.executeUpdate();
            System.out.println("Dette ajoutée avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de la dette : " + e.getMessage());
        }
    }

    
    public List<Dette> getAllDettes() {
        List<Dette> dettes = new ArrayList<>();
        String query = "SELECT * FROM dettes";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Dette dette = new Dette();
                dette.setId(resultSet.getInt("id"));
                dette.setDate(resultSet.getString("date"));
                dette.setMontant(resultSet.getDouble("montant"));
                dette.setMontantVerser(resultSet.getDouble("montant_verser"));
                dette.setMontantRestant(resultSet.getDouble("montant_restant"));
                Client client = new Client();
                client.setId(resultSet.getInt("client_id"));
                dette.setClient(client);
                dettes.add(dette);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des dettes : " + e.getMessage());
        }
        return dettes;
    }

    
    public List<Dette> getUnpaidDettes() {
        List<Dette> dettes = new ArrayList<>();
        String query = "SELECT * FROM dettes WHERE montant_restant > 0";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Dette dette = new Dette();
                dette.setId(resultSet.getInt("id"));
                dette.setDate(resultSet.getString("date"));
                dette.setMontant(resultSet.getDouble("montant"));
                dette.setMontantVerser(resultSet.getDouble("montant_verser"));
                dette.setMontantRestant(resultSet.getDouble("montant_restant"));
                Client client = new Client();
                client.setId(resultSet.getInt("client_id"));
                dette.setClient(client);
                dettes.add(dette);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des dettes non soldées : " + e.getMessage());
        }
        return dettes;
    }

    
    public void updateDette(Dette dette) {
        String query = "UPDATE dettes SET date = ?, montant = ?, montant_verser = ?, montant_restant = ?, client_id = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, dette.getDate());
            statement.setDouble(2, dette.getMontant());
            statement.setDouble(3, dette.getMontantVerser());
            statement.setDouble(4, dette.getMontantRestant());
            statement.setInt(5, dette.getClient().getId());
            statement.setInt(6, dette.getId());
            statement.executeUpdate();
            System.out.println("Dette mise à jour avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de la dette : " + e.getMessage());
        }
    }

    
    public void deleteDette(int detteId) {
        String query = "DELETE FROM dettes WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, detteId);
            statement.executeUpdate();
            System.out.println("Dette supprimée avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de la dette : " + e.getMessage());
        }
    }
}
