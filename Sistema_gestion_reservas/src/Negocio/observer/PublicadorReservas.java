/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LUIS
 */
public class PublicadorReservas {
    private final List<ObservadorReserva> observadores =
            new ArrayList<>();

    public void agregarObservador(ObservadorReserva observador) {
        if (observador != null && !observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    public void eliminarObservador(ObservadorReserva observador) {
        observadores.remove(observador);
    }

    public void notificar(EventoReserva evento) {

        for (ObservadorReserva observador : observadores) {
            try {
                observador.actualizar(evento);
            } catch (RuntimeException e) {
                System.err.println(
                        "Error al notificar observador: " + e.getMessage()
                );
            }
        }
    }
}
