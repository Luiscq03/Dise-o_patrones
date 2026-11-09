/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.builder;

import Negocio.entidades.Habitacion;
import Negocio.entidades.Huesped;
import Negocio.entidades.Reserva;
import Negocio.enums.EstadoReserva;
import java.time.LocalDate;

/**
 *
 * @author LUIS
 */
public class ReservaBuilder {
    private Huesped huesped;
    private Habitacion habitacion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private int numeroHuespedes;
    private String observaciones;

    public ReservaBuilder setHuesped(Huesped huesped) {
        this.huesped = huesped;
        return this;
    }

    public ReservaBuilder setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
        return this;
    }

    public ReservaBuilder setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
        return this;
    }

    public ReservaBuilder setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
        return this;
    }

    public ReservaBuilder setNumeroHuespedes(int numeroHuespedes) {
        this.numeroHuespedes = numeroHuespedes;
        return this;
    }

    public ReservaBuilder setObservaciones(String observaciones) {
        this.observaciones = observaciones;
        return this;
    }

    public Reserva build() {

        if (huesped == null) {
            throw new IllegalArgumentException("Debe seleccionar un huésped.");
        }

        if (habitacion == null) {
            throw new IllegalArgumentException("Debe seleccionar una habitación.");
        }

        if (fechaEntrada == null || fechaSalida == null) {
            throw new IllegalArgumentException("Debe indicar las fechas.");
        }

        if (!fechaSalida.isAfter(fechaEntrada)) {
            throw new IllegalArgumentException(
                    "La fecha de salida debe ser posterior a la entrada."
            );
        }

        if (numeroHuespedes <= 0) {
            throw new IllegalArgumentException(
                    "El número de huéspedes debe ser mayor que cero."
            );
        }

        if (numeroHuespedes > habitacion.getCapacidad()) {
            throw new IllegalArgumentException(
                    "La habitación no tiene capacidad suficiente."
            );
        }

        Reserva reserva = new Reserva();

        reserva.setHuesped(huesped);
        reserva.setHabitacion(habitacion);
        reserva.setFechaEntrada(fechaEntrada);
        reserva.setFechaSalida(fechaSalida);
        reserva.setNumeroHuespedes(numeroHuespedes);
        reserva.setPrecioNoche(habitacion.getPrecioNoche());
        reserva.setObservaciones(observaciones);
        reserva.setEstado(EstadoReserva.PENDIENTE);

        return reserva;
    }
}
