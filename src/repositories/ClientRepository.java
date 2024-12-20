package repositories;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import entity.Client;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/projet_java"; 
    private static final String DB_USER = "postgres"; 
    private static final String DB_PASSWORD = "salaoudine"; 

    
    public void addClient(Client client) {
        String query = "INSERT INTO clients (surname, prenom, telephone, address) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, client.getSurname());
            statement.setString(2, client.getPrenom());
            statement.setString(3, client.getTelephone());
            statement.setString(4, client.getAddress());
            statement.executeUpdate();
            System.out.println("Client ajouté avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du client : " + e.getMessage());
        }
    }

    
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT * FROM clients";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setSurname(resultSet.getString("surname"));
                client.setPrenom(resultSet.getString("prenom"));
                client.setTelephone(resultSet.getString("telephone"));
                client.setAddress(resultSet.getString("address"));
                clients.add(client);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des clients : " + e.getMessage());
        }
        return clients;
    }

    
    public Client getClientByTelephone(int clientId) {
        String query = "SELECT * FROM clients WHERE telephone = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, clientId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Client client = new Client();
                    client.setId(resultSet.getInt("id"));
                    client.setSurname(resultSet.getString("surname"));
                    client.setPrenom(resultSet.getString("prenom"));
                    client.setTelephone(resultSet.getString("telephone"));
                    client.setAddress(resultSet.getString("address"));
                    return client;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche du client : " + e.getMessage());
        }
        return null;
    }
}
