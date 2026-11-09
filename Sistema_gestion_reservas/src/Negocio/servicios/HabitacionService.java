/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.servicios;

import Datos.HabitacionRepositorio;
import Datos.ReservaRepositorio;
import Negocio.entidades.Habitacion;
import Negocio.enums.EstadoHabitacion;
import java.time.LocalDate;
import java.sql.SQLException;

/**
 *
 * @author LUIS
 */
public class HabitacionService {
    private final HabitacionRepositorio habitacionRepositorio;
    private final ReservaRepositorio reservaRepositorio;

    public HabitacionService(
            HabitacionRepositorio habitacionRepositorio,
            ReservaRepositorio reservaRepositorio) {

        this.habitacionRepositorio = habitacionRepositorio;
        this.reservaRepositorio = reservaRepositorio;
    }

    // CAMBIAR ESTADO DE HABITACIÓN
    public boolean cambiarEstado(
            int id,
            EstadoHabitacion nuevoEstado) throws SQLException {

        Habitacion habitacion =
                habitacionRepositorio.buscarPorId(id);

        if (habitacion == null) {
            throw new IllegalArgumentException(
                    "La habitación no existe."
            );
        }

        if (nuevoEstado == null) {
            throw new IllegalArgumentException(
                    "Debe indicar el nuevo estado."
            );
        }

        // Verificar reservas antes de pasar a mantenimiento
        if (nuevoEstado == EstadoHabitacion.MANTENIMIENTO) {

            boolean tieneReservas =
                    reservaRepositorio.tieneReservasActivasFuturas(
                            id,
                            LocalDate.now()
                    );

            if (tieneReservas) {
                throw new IllegalArgumentException(
                        "No se puede poner en mantenimiento. "
                        + "Tiene reservas pendientes o confirmadas "
                        + "con fecha de salida futura."
                );
            }
        }

        return habitacionRepositorio.cambiarEstado(
                id,
                nuevoEstado.name()
        );
    }
}
