package pl.projekt.uniterm;

import java.sql.*;

public class DatabaseConnection {

    private final String databaseName = "uniterm";

    private Connection connection;

    private final String url = "jdbc:mysql://localhost:3306/" + databaseName;
    private final String user = "root";
    private final String password = "root";

    //tworzenie połączenia z bazą danych
    public DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Połączono z bazą danych!");
        } catch (SQLException e) {
            System.err.println("Nie udało się połączyć z bazą danych: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    //zamykanie połączenia z bazą danych
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Połączenie z bazą danych zostało zamknięte.");
            }
        } catch (SQLException e) {
            System.err.println("Błąd podczas zamykania połączenia: " + e.getMessage());
        }
    }

    //metoda do wykonywania zapytań SELECT
    public ResultSet executeQuery(String query) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            System.err.println("Błąd podczas wykonywania zapytania: " + e.getMessage());
            return null;
        }
    }

    //metoda do wykonywania zapytań INSERT, DELETE
    public int executeUpdate(String query) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            return statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Błąd podczas wykonywania zapytania: " + e.getMessage());
            return -1;
        }
    }
}
