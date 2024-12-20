package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    
    private static final String URL = "jdbc:postgresql://localhost:5432/projet_java";
    private static final String USER = "postgres";
    private static final String PASSWORD = "salaoudine";

    public static Connection connect() {
        try {
            
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données: " + e.getMessage());
            return null;
        }
    }
}
