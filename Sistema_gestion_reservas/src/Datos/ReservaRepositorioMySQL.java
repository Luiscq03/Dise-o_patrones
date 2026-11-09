/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;
import Negocio.entidades.Habitacion;
import Negocio.entidades.Huesped;
import Negocio.entidades.Reserva;
import Negocio.enums.EstadoHabitacion;
import Negocio.enums.EstadoReserva;
import Negocio.enums.TipoHabitacion;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author LUIS
 */
public class ReservaRepositorioMySQL implements ReservaRepositorio{
    // REGISTRAR RESERVA
    @Override
    public int guardar(Reserva reserva) throws SQLException {

        String sql = "INSERT INTO reservas "
                + "(huesped_id, habitacion_id, fecha_entrada, "
                + "fecha_salida, numero_huespedes, precio_noche, "
                + "observaciones, estado) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection cn = ConexionMySQL.getConnection()) {

            if (cn == null) {
                throw new SQLException("No hay conexion con MySQL");
            }

            try (PreparedStatement ps = cn.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS)) {

                ps.setInt(1, reserva.getHuesped().getId());
                ps.setInt(2, reserva.getHabitacion().getId());

                ps.setDate(3, Date.valueOf(reserva.getFechaEntrada()));
                ps.setDate(4, Date.valueOf(reserva.getFechaSalida()));

                ps.setInt(5, reserva.getNumeroHuespedes());
                ps.setDouble(6, reserva.getPrecioNoche());
                ps.setString(7, reserva.getObservaciones());
                ps.setString(8, reserva.getEstado().name());

                ps.executeUpdate();

                try (ResultSet rs = ps.getGeneratedKeys()) {

                    if (rs.next()) {

                        int id = rs.getInt(1);
                        reserva.setId(id);

                        return id;
                    }
                }
            }
        }

        return 0;
    }

    // LISTAR RESERVAS
    @Override
    public List<Reserva> listar() throws SQLException {

        List<Reserva> lista = new ArrayList<>();

        String sql = "SELECT r.*, "
                + "h.nombre, h.documento, h.telefono, h.email, "
                + "ha.numero, ha.tipo, ha.estado AS estado_habitacion "
                + "FROM reservas r "
                + "INNER JOIN huespedes h ON r.huesped_id = h.id "
                + "INNER JOIN habitaciones ha ON r.habitacion_id = ha.id "
                + "ORDER BY r.id DESC";

        try (Connection cn = ConexionMySQL.getConnection()) {

            if (cn == null) {
                throw new SQLException("No hay conexion con MySQL");
            }

            try (PreparedStatement ps = cn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    lista.add(mapearReserva(rs));
                }
            }
        }

        return lista;
    }

    // BUSCAR RESERVA POR ID
    @Override
    public Reserva buscarPorId(int id) throws SQLException {

        String sql = "SELECT r.*, "
                + "h.nombre, h.documento, h.telefono, h.email, "
                + "ha.numero, ha.tipo, ha.estado AS estado_habitacion "
                + "FROM reservas r "
                + "INNER JOIN huespedes h ON r.huesped_id = h.id "
                + "INNER JOIN habitaciones ha ON r.habitacion_id = ha.id "
                + "WHERE r.id = ?";

        try (Connection cn = ConexionMySQL.getConnection()) {

            if (cn == null) {
                throw new SQLException("No hay conexion con MySQL");
            }

            try (PreparedStatement ps = cn.prepareStatement(sql)) {

                ps.setInt(1, id);

                try (ResultSet rs = ps.executeQuery()) {

                    if (rs.next()) {
                        return mapearReserva(rs);
                    }
                }
            }
        }

        return null;
    }

    // CAMBIAR ESTADO DE RESERVA
    @Override
    public boolean cambiarEstado(int id, String estado)
            throws SQLException {

        EstadoReserva.valueOf(estado);

        String sql = "UPDATE reservas SET estado = ? WHERE id = ?";

        try (Connection cn = ConexionMySQL.getConnection()) {

            if (cn == null) {
                throw new SQLException("No hay conexion con MySQL");
            }

            try (PreparedStatement ps = cn.prepareStatement(sql)) {

                ps.setString(1, estado);
                ps.setInt(2, id);

                return ps.executeUpdate() > 0;
            }
        }
    }

    // COMPROBAR CRUCE DE FECHAS
    @Override
    public boolean existeCruce(int habitacionId,
                               LocalDate entrada,
                               LocalDate salida,
                               int idExcluir) throws SQLException {

        String sql = "SELECT COUNT(*) FROM reservas "
                + "WHERE habitacion_id = ? "
                + "AND estado IN ('PENDIENTE', 'CONFIRMADO', 'CONFIRMADA') "
                + "AND fecha_entrada < ? "
                + "AND fecha_salida > ? "
                + "AND id <> ?";

        try (Connection cn = ConexionMySQL.getConnection()) {

            if (cn == null) {
                throw new SQLException("No hay conexion con MySQL");
            }

            try (PreparedStatement ps = cn.prepareStatement(sql)) {

                ps.setInt(1, habitacionId);
                ps.setDate(2, Date.valueOf(salida));
                ps.setDate(3, Date.valueOf(entrada));
                ps.setInt(4, idExcluir);

                try (ResultSet rs = ps.executeQuery()) {

                    if (rs.next()) {
                        return rs.getInt(1) > 0;
                    }
                }
            }
        }

        return false;
    }

    // CONVERTIR RESULTADO SQL EN OBJETO RESERVA
    private Reserva mapearReserva(ResultSet rs) throws SQLException {

        Huesped huesped = new Huesped();

        huesped.setId(rs.getInt("huesped_id"));
        huesped.setNombre(rs.getString("nombre"));
        huesped.setDocumento(rs.getString("documento"));
        huesped.setTelefono(rs.getString("telefono"));
        huesped.setEmail(rs.getString("email"));

        Habitacion habitacion = new Habitacion();

        habitacion.setId(rs.getInt("habitacion_id"));
        habitacion.setNumero(rs.getString("numero"));

        habitacion.setTipo(
                TipoHabitacion.valueOf(rs.getString("tipo").trim().toUpperCase())
        );

        habitacion.setEstado(
                EstadoHabitacion.valueOf(
                        rs.getString("estado_habitacion").trim().toUpperCase()
                )
        );

        Reserva reserva = new Reserva();

        reserva.setId(rs.getInt("id"));
        reserva.setHuesped(huesped);
        reserva.setHabitacion(habitacion);

        reserva.setFechaEntrada(
                rs.getDate("fecha_entrada").toLocalDate()
        );

        reserva.setFechaSalida(
                rs.getDate("fecha_salida").toLocalDate()
        );

        reserva.setNumeroHuespedes(
                rs.getInt("numero_huespedes")
        );

        reserva.setPrecioNoche(
                rs.getDouble("precio_noche")
        );

        reserva.setObservaciones(
                rs.getString("observaciones")
        );

        String estadoBD = rs.getString("estado").trim().toUpperCase();
        if ("CONFIRMADA".equals(estadoBD)) {
            reserva.setEstado(EstadoReserva.CONFIRMADO);
        } else if ("CANCELADA".equals(estadoBD)) {
            reserva.setEstado(EstadoReserva.CANCELADO);
        } else {
            reserva.setEstado(EstadoReserva.valueOf(estadoBD));
        }

        return reserva;
    }

    @Override
    public boolean tieneReservasActivasFuturas(
            int habitacionId,
            LocalDate fecha) throws SQLException {

        String sql = "SELECT COUNT(*) FROM reservas "
                + "WHERE habitacion_id = ? "
                + "AND estado IN ('PENDIENTE', 'CONFIRMADO', 'CONFIRMADA') "
                + "AND fecha_salida > ?";

        try (Connection cn = ConexionMySQL.getConnection()) {

            if (cn == null) {
                throw new SQLException("No hay conexion con MySQL");
            }

            try (PreparedStatement ps = cn.prepareStatement(sql)) {

                ps.setInt(1, habitacionId);
                ps.setDate(2, java.sql.Date.valueOf(fecha));

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt(1) > 0;
                    }
                }
            }
        }

        return false;
    }
}
