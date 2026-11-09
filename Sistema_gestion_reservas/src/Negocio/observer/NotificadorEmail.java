/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.observer;

import Negocio.entidades.Reserva;

/**
 *
 * @author LUIS
 */
public class NotificadorEmail implements ObservadorReserva{
    @Override
    public void actualizar(EventoReserva evento) {

        Reserva reserva = evento.getReserva();

        String destinatario = reserva.getHuesped().getEmail();

        System.out.println("================================");
        System.out.println("NOTIFICACION DE RESERVA");
        System.out.println("================================");

        System.out.println("Para: " + destinatario);

        System.out.println(
                "Huésped: " + reserva.getHuesped().getNombre()
        );

        System.out.println(
                "Habitación: " + reserva.getHabitacion().getNumero()
        );

        System.out.println(
                "Evento: " + evento.getTipoEvento()
        );

        System.out.println(
                "Entrada: " + reserva.getFechaEntrada()
        );

        System.out.println(
                "Salida: " + reserva.getFechaSalida()
        );

        System.out.println(
                "Total: S/ " + reserva.calcularTotal()
        );

        System.out.println("================================");
    }
}
