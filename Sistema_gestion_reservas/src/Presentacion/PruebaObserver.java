/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Negocio.entidades.Habitacion;
import Negocio.entidades.Huesped;
import Negocio.entidades.Reserva;
import Negocio.enums.EstadoHabitacion;
import Negocio.enums.EstadoReserva;
import Negocio.enums.TipoEventoReserva;
import Negocio.enums.TipoHabitacion;
import Negocio.observer.EventoReserva;
import Negocio.observer.NotificadorEmail;
import Negocio.observer.PublicadorReservas;
import java.time.LocalDate;

/**
 *
 * @author LUIS
 */
public class PruebaObserver {
    public static void main(String[] args) {

        Huesped huesped = new Huesped(
                1,
                "Juan Perez",
                "76543210",
                "987654321",
                "juan@gmail.com"
        );

        Habitacion habitacion = new Habitacion(
                1,
                "101",
                TipoHabitacion.DOBLE,
                EstadoHabitacion.DISPONIBLE
        );

        Reserva reserva = new Reserva();

        reserva.setId(1);
        reserva.setHuesped(huesped);
        reserva.setHabitacion(habitacion);
        reserva.setFechaEntrada(LocalDate.of(2026, 12, 10));
        reserva.setFechaSalida(LocalDate.of(2026, 12, 13));
        reserva.setNumeroHuespedes(2);
        reserva.setPrecioNoche(150);
        reserva.setEstado(EstadoReserva.PENDIENTE);

        PublicadorReservas publicador = new PublicadorReservas();

        NotificadorEmail notificador = new NotificadorEmail();

        publicador.agregarObservador(notificador);

        EventoReserva evento = new EventoReserva(
                reserva,
                TipoEventoReserva.CREADA
        );

        publicador.notificar(evento);
    }
}
