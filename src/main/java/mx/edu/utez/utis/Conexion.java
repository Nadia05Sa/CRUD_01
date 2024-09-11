package mx.edu.utez.utis;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.DriverManager;

public class Conexion {
        private static final String URL = "jdbc:mysql://localhost:3306/CRUD";
        private static final String USER = "root";
        private static final String PASSWORD = "root";

        public static Connection getConnection() {
            Connection connection = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el driver de MySQL
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexión exitosa a la base de datos");
            } catch (ClassNotFoundException e) {
                System.out.println("Error al cargar el driver de MySQL");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Error al conectar con la base de datos");
                e.printStackTrace();
            }
            return connection;
        }

        public static void main(String[] args) {
            // Prueba de la conexión
            Connection connection = Conexion.getConnection();
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
