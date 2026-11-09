/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LUIS
 */
public class ConexionMySQL {
    private static final String URL =
            "jdbc:mysql://localhost:3306/hotel_reservas";

    private static final String USER = "root";

    // Coloca aquí tu contraseña de MySQL
    private static final String PASSWORD = "root";

    public static Connection getConnection() {

        Connection conexion = null;

        try {
            try {
                conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException ex) {
                conexion = DriverManager.getConnection(URL, USER, "");
            }

            System.out.println("Conexion exitosa a MySQL");

        } catch (SQLException e) {

            System.out.println("Error al conectar con MySQL: "
                    + e.getMessage());
        }

        return conexion;
    }
}
