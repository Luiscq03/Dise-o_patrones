/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.entidades;

import Negocio.enums.EstadoHabitacion;
import Negocio.enums.TipoHabitacion;

/**
 *
 * @author LUIS
 */
public class Habitacion {
    private int id;
    private String numero;
    private TipoHabitacion tipo;
    private EstadoHabitacion estado;

    public Habitacion() {
    }

    public Habitacion(int id, String numero,
                      TipoHabitacion tipo,
                      EstadoHabitacion estado) {

        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

    public EstadoHabitacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoHabitacion estado) {
        this.estado = estado;
    }

    public double getPrecioNoche() {
        return tipo.getPrecio();
    }

    public int getCapacidad() {
        return tipo.getCapacidad();
    }

    @Override
    public String toString() {
        if (tipo == null) {
            return numero != null ? numero : "";
        }
        String nombreTipo = tipo.name().charAt(0) + tipo.name().substring(1).toLowerCase();
        return numero + " - " + nombreTipo;
    }
}
