/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.servicios;

import Datos.HabitacionRepositorioMySQL;
import Datos.HuespedRepositorioMySQL;
import Datos.ReservaRepositorioMySQL;
import Negocio.entidades.Habitacion;
import Negocio.entidades.Huesped;
import Negocio.entidades.Reserva;
import Negocio.enums.EstadoHabitacion;
import java.util.List;
import java.sql.SQLException;
/**
 *
 * @author LUIS
 */
public class HotelFacade {
    private final HuespedRepositorioMySQL huespedRepositorio;
    private final HabitacionRepositorioMySQL habitacionRepositorio;
    private final ReservaRepositorioMySQL reservaRepositorio;

    private final ReservaService reservaService;
    private final HabitacionService habitacionService;

    public HotelFacade() {

        huespedRepositorio = new HuespedRepositorioMySQL();
        habitacionRepositorio = new HabitacionRepositorioMySQL();
        reservaRepositorio = new ReservaRepositorioMySQL();

        reservaService = new ReservaService(
                reservaRepositorio,
                habitacionRepositorio,
                huespedRepositorio
        );

        habitacionService = new HabitacionService(
                habitacionRepositorio,
                reservaRepositorio
        );
    }

    // ==============================
    // GESTIÓN DE HUÉSPEDES
    // ==============================

    public int registrarHuesped(Huesped huesped) throws SQLException {
        return huespedRepositorio.guardar(huesped);
    }

    public List<Huesped> listarHuespedes() throws SQLException {
        return huespedRepositorio.listar();
    }

    public Huesped buscarHuesped(int id) throws SQLException {
        return huespedRepositorio.buscarPorId(id);
    }

    public boolean actualizarHuesped(Huesped huesped) throws SQLException {
        return huespedRepositorio.actualizar(huesped);
    }

    public boolean eliminarHuesped(int id) throws SQLException {
        return huespedRepositorio.eliminar(id);
    }

    // ==============================
    // GESTIÓN DE HABITACIONES
    // ==============================

    public int registrarHabitacion(Habitacion habitacion) throws SQLException {
        return habitacionRepositorio.guardar(habitacion);
    }

    public List<Habitacion> listarHabitaciones() throws SQLException {
        return habitacionRepositorio.listar();
    }

    public Habitacion buscarHabitacion(int id) throws SQLException {
        return habitacionRepositorio.buscarPorId(id);
    }

    public boolean actualizarHabitacion(Habitacion habitacion) throws SQLException {
        return habitacionRepositorio.actualizar(habitacion);
    }

    public boolean eliminarHabitacion(int id) throws SQLException {
        return habitacionRepositorio.eliminar(id);
    }

    public boolean cambiarEstadoHabitacion(
            int id,
            EstadoHabitacion estado) throws SQLException {

        return habitacionService.cambiarEstado(id, estado);
    }

    // ==============================
    // GESTIÓN DE RESERVAS
    // ==============================

    public int registrarReserva(Reserva reserva) throws SQLException {
        return reservaService.registrarReserva(reserva);
    }

    public List<Reserva> listarReservas() throws SQLException {
        return reservaService.listarReservas();
    }

    public Reserva buscarReserva(int id) throws SQLException {
        return reservaService.buscarReserva(id);
    }

    public boolean confirmarReserva(int id) throws SQLException {
        return reservaService.confirmarReserva(id);
    }

    public boolean cancelarReserva(int id) throws SQLException {
        return reservaService.cancelarReserva(id);
    }
}
