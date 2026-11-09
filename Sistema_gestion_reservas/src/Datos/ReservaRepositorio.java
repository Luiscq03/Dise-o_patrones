/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Datos;

import Negocio.entidades.Reserva;
import java.util.*;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author LUIS
 */
public interface ReservaRepositorio {
    // Registrar una reserva
    int guardar(Reserva reserva) throws SQLException;

    // Listar todas las reservas
    List<Reserva> listar() throws SQLException;

    // Buscar reserva por ID
    Reserva buscarPorId(int id) throws SQLException;

    // Cambiar estado de una reserva
    boolean cambiarEstado(int id, String estado)
            throws SQLException;

    // Comprobar cruce de fechas
    boolean existeCruce(int habitacionId,
                        LocalDate entrada,
                        LocalDate salida,
                        int idExcluir) throws SQLException;
    
    boolean tieneReservasActivasFuturas(
        int habitacionId,
        LocalDate fecha
    ) throws SQLException;
}
