/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.entidades;

import Negocio.enums.EstadoReserva;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author LUIS
 */
public class Reserva {
    private int id;
    private Huesped huesped;
    private Habitacion habitacion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private int numeroHuespedes;
    private double precioNoche;
    private String observaciones;
    private EstadoReserva estado;

    public Reserva() {
    }

    public Reserva(int id, Huesped huesped,
                   Habitacion habitacion,
                   LocalDate fechaEntrada,
                   LocalDate fechaSalida,
                   int numeroHuespedes,
                   double precioNoche,
                   String observaciones,
                   EstadoReserva estado) {

        this.id = id;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.numeroHuespedes = numeroHuespedes;
        this.precioNoche = precioNoche;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getNumeroHuespedes() {
        return numeroHuespedes;
    }

    public void setNumeroHuespedes(int numeroHuespedes) {
        this.numeroHuespedes = numeroHuespedes;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    // Calcular cantidad de noches
    public long calcularNoches() {

        return ChronoUnit.DAYS.between(
                fechaEntrada, fechaSalida
        );
    }

    // Calcular precio total
    public double calcularTotal() {

        return calcularNoches() * precioNoche;
    }
}
