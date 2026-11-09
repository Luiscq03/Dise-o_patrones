/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.servicios;

import Datos.ReservaRepositorio;
import Datos.HabitacionRepositorio;
import Datos.HuespedRepositorio;

import Negocio.entidades.Reserva;
import Negocio.entidades.Habitacion;

import Negocio.enums.EstadoReserva;
import Negocio.enums.EstadoHabitacion;
import Negocio.enums.TipoEventoReserva;
import Negocio.observer.EventoReserva;
import Negocio.observer.NotificadorEmail;
import Negocio.observer.PublicadorReservas;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author LUIS
 */
public class ReservaService {
    private final ReservaRepositorio reservaRepositorio;
    private final HabitacionRepositorio habitacionRepositorio;
    private final HuespedRepositorio huespedRepositorio;
    private final PublicadorReservas publicador;

    // Constructor principal
    public ReservaService(
            ReservaRepositorio reservaRepositorio,
            HabitacionRepositorio habitacionRepositorio,
            HuespedRepositorio huespedRepositorio,
            PublicadorReservas publicador) {

        this.reservaRepositorio = reservaRepositorio;
        this.habitacionRepositorio = habitacionRepositorio;
        this.huespedRepositorio = huespedRepositorio;
        this.publicador = publicador;
    }

    // Constructor para utilizar el notificador predeterminado
    public ReservaService(
            ReservaRepositorio reservaRepositorio,
            HabitacionRepositorio habitacionRepositorio,
            HuespedRepositorio huespedRepositorio) {

        this(
                reservaRepositorio,
                habitacionRepositorio,
                huespedRepositorio,
                crearPublicador()
        );
    }

    private static PublicadorReservas crearPublicador() {
        PublicadorReservas publicador = new PublicadorReservas();
        publicador.agregarObservador(new NotificadorEmail());
        return publicador;
    }

    // REGISTRAR RESERVA
    public int registrarReserva(Reserva reserva) throws SQLException {

        if (reserva == null || reserva.getHuesped() == null
                || reserva.getHabitacion() == null) {
            throw new IllegalArgumentException(
                    "Debe seleccionar un huésped y una habitación."
            );
        }

        if (huespedRepositorio.buscarPorId(
                reserva.getHuesped().getId()) == null) {
            throw new IllegalArgumentException("El huésped no existe.");
        }

        if (reserva.getFechaEntrada() == null
                || reserva.getFechaSalida() == null) {
            throw new IllegalArgumentException("Debe indicar las fechas.");
        }

        if (reserva.getFechaEntrada().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException(
                    "La fecha de entrada no puede ser anterior a hoy."
            );
        }

        if (!reserva.getFechaSalida().isAfter(
                reserva.getFechaEntrada())) {
            throw new IllegalArgumentException(
                    "La salida debe ser posterior a la entrada."
            );
        }

        if (reserva.getNumeroHuespedes() <= 0) {
            throw new IllegalArgumentException(
                    "Debe ingresar al menos un huésped."
            );
        }

        Habitacion habitacion = habitacionRepositorio.buscarPorId(
                reserva.getHabitacion().getId()
        );

        if (habitacion == null) {
            throw new IllegalArgumentException("La habitación no existe.");
        }

        if (habitacion.getEstado() != EstadoHabitacion.DISPONIBLE) {
            throw new IllegalArgumentException(
                    "La habitación está en mantenimiento."
            );
        }

        if (reserva.getNumeroHuespedes() > habitacion.getCapacidad()) {
            throw new IllegalArgumentException(
                    "La habitación no tiene capacidad suficiente."
            );
        }

        boolean existeCruce = reservaRepositorio.existeCruce(
                habitacion.getId(),
                reserva.getFechaEntrada(),
                reserva.getFechaSalida(),
                0
        );

        if (existeCruce) {
            throw new IllegalArgumentException(
                    "La habitación ya tiene una reserva en esas fechas."
            );
        }

        reserva.setHabitacion(habitacion);
        reserva.setPrecioNoche(habitacion.getPrecioNoche());
        reserva.setEstado(EstadoReserva.PENDIENTE);

        // Guardar en MySQL
        int id = reservaRepositorio.guardar(reserva);
        reserva.setId(id);

        // Notificar después de guardar correctamente
        publicador.notificar(
                new EventoReserva(reserva, TipoEventoReserva.CREADA)
        );

        return id;
    }

    // LISTAR RESERVAS
    public List<Reserva> listarReservas() throws SQLException {
        return reservaRepositorio.listar();
    }

    // BUSCAR RESERVA
    public Reserva buscarReserva(int id) throws SQLException {

        Reserva reserva = reservaRepositorio.buscarPorId(id);

        if (reserva == null) {
            throw new IllegalArgumentException(
                    "No se encontró la reserva."
            );
        }

        return reserva;
    }

    // CONFIRMAR RESERVA
    public boolean confirmarReserva(int id) throws SQLException {

        Reserva reserva = buscarReserva(id);

        if (reserva.getEstado() != EstadoReserva.PENDIENTE) {
            throw new IllegalArgumentException(
                    "Solo se pueden confirmar reservas pendientes."
            );
        }

        if (reservaRepositorio.existeCruce(
                reserva.getHabitacion().getId(),
                reserva.getFechaEntrada(),
                reserva.getFechaSalida(),
                reserva.getId())) {

            throw new IllegalArgumentException(
                    "Existe otra reserva que ocupa esas fechas."
            );
        }

        boolean actualizado = reservaRepositorio.cambiarEstado(
                id,
                EstadoReserva.CONFIRMADO.name()
        );

        if (actualizado) {
            reserva.setEstado(EstadoReserva.CONFIRMADO);

            publicador.notificar(
                    new EventoReserva(
                            reserva,
                            TipoEventoReserva.CONFIRMADA
                    )
            );
        }

        return actualizado;
    }

    // CANCELAR RESERVA
    public boolean cancelarReserva(int id) throws SQLException {

        Reserva reserva = buscarReserva(id);

        if (reserva.getEstado() == EstadoReserva.CANCELADO) {
            throw new IllegalArgumentException(
                    "La reserva ya está cancelada."
            );
        }

        if (reserva.getEstado() != EstadoReserva.PENDIENTE
                && reserva.getEstado() != EstadoReserva.CONFIRMADO) {
            throw new IllegalArgumentException(
                    "No se puede cancelar esta reserva."
            );
        }

        boolean actualizado = reservaRepositorio.cambiarEstado(
                id,
                EstadoReserva.CANCELADO.name()
        );

        if (actualizado) {
            reserva.setEstado(EstadoReserva.CANCELADO);

            publicador.notificar(
                    new EventoReserva(
                            reserva,
                            TipoEventoReserva.CANCELADA
                    )
            );
        }

        return actualizado;
    }
}
