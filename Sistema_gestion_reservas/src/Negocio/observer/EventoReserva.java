/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.observer;

import Negocio.entidades.Reserva;
import Negocio.enums.TipoEventoReserva;

/**
 *
 * @author LUIS
 */
public class EventoReserva {
    private final Reserva reserva;
    private final TipoEventoReserva tipoEvento;

    public EventoReserva(Reserva reserva, TipoEventoReserva tipoEvento) {
        this.reserva = reserva;
        this.tipoEvento = tipoEvento;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public TipoEventoReserva getTipoEvento() {
        return tipoEvento;
    }
}
