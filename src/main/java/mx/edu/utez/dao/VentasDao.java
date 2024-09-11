package mx.edu.utez.dao;

import mx.edu.utez.model.Ventas;
import mx.edu.utez.utis.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentasDao {

    // Método para agregar una nueva venta
    public int addVenta(Ventas venta) {
        int ventaId = 0;
        String query = "INSERT INTO Ventas (Nombre, Descripcion, Estado) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            // Asignar valores a la consulta
            pstmt.setString(1, venta.getNombre());
            pstmt.setString(2, venta.getDescripcion());
            pstmt.setBoolean(3, venta.getEstado());

            // Ejecutar la consulta
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    ventaId = generatedKeys.getInt(1);
                }
            }

            return ventaId;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    // Método para deshabilitar una venta por ID
    public static boolean deshabilitarVenta(int ID_Venta) {
        String query = "UPDATE Ventas SET Estado = '0' WHERE ID_Venta = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, ID_Venta);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para habilitar una venta por ID
    public static boolean habilitarVenta(int ID_Venta) {
        String query = "UPDATE Ventas SET Estado = '1' WHERE ID_Venta = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, ID_Venta);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para obtener todas las ventas
    public List<Ventas> getAllVentas() {
        List<Ventas> ventas = new ArrayList<>();
        String query = "SELECT * FROM Ventas";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int ID = rs.getInt("ID_Venta");
                String Nombre = rs.getString("Nombre");
                String Descripcion = rs.getString("Descripcion");
                boolean Estado = rs.getBoolean("Estado");

                Ventas venta = new Ventas(ID, Nombre, Descripcion, Estado);
                ventas.add(venta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ventas;
    }
}
