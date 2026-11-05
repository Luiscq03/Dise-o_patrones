/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.enums;

/**
 *
 * @author LUIS
 */
public enum TipoHabitacion {
    INDIVIDUAL(1, 90.00),
    DOBLE(2, 150.00),
    FAMILIAR(4, 220.00),
    SUITE(6, 350.00);

    private final int capacidad;
    private final double precio;

    TipoHabitacion(int capacidad, double precio) {
        this.capacidad = capacidad;
        this.precio = precio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getPrecio() {
        return precio;
    }
}
