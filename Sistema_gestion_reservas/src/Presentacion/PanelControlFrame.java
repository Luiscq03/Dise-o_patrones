package Presentacion;

import Negocio.entidades.Habitacion;
import Negocio.entidades.Huesped;
import Negocio.entidades.Reserva;
import Negocio.enums.EstadoReserva;
import Negocio.servicios.HotelFacade;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 * Ventana 5: Panel de Control (Dashboard) - "Hotel del Sol".
 */
public class PanelControlFrame extends JFrame {

    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter FORMATO_RELOJ = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm");

    private final HotelFacade hotelFacade;
    private final Runnable accionAbrirReservas;
    private final Runnable accionAbrirHabitaciones;
    private final Runnable accionAbrirHuespedes;

    private DefaultTableModel modeloProximas;

    public PanelControlFrame(
            HotelFacade hotelFacade,
            Runnable accionAbrirReservas,
            Runnable accionAbrirHabitaciones,
            Runnable accionAbrirHuespedes) {
        this.hotelFacade = hotelFacade;
        this.accionAbrirReservas = accionAbrirReservas;
        this.accionAbrirHabitaciones = accionAbrirHabitaciones;
        this.accionAbrirHuespedes = accionAbrirHuespedes;

        initComponents();
        inicializarComponentes();
        actualizarIndicadores();
        iniciarReloj();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloBanner = new javax.swing.JLabel();
        lblReloj = new javax.swing.JLabel();
        panelCard1 = new javax.swing.JPanel();
        lblCard1Titulo = new javax.swing.JLabel();
        lblTotalHuespedes = new javax.swing.JLabel();
        panelCard2 = new javax.swing.JPanel();
        lblCard2Titulo = new javax.swing.JLabel();
        lblTotalHabitaciones = new javax.swing.JLabel();
        panelCard3 = new javax.swing.JPanel();
        lblCard3Titulo = new javax.swing.JLabel();
        lblReservasActivas = new javax.swing.JLabel();
        panelCard4 = new javax.swing.JPanel();
        lblCard4Titulo = new javax.swing.JLabel();
        lblOcupacion = new javax.swing.JLabel();
        btnAccesoReservas = new javax.swing.JButton();
        btnAccesoHabitaciones = new javax.swing.JButton();
        btnAccesoHuespedes = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        lblProximas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProximas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Panel de Control - Hotel del Sol");
        setResizable(false);
        getContentPane().setLayout(null);

        lblTituloBanner.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTituloBanner.setForeground(new java.awt.Color(25, 58, 107));
        lblTituloBanner.setText("Panel de Control - Dashboard");
        getContentPane().add(lblTituloBanner);
        lblTituloBanner.setBounds(20, 10, 350, 28);

        lblReloj.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblReloj.setForeground(new java.awt.Color(102, 102, 102));
        lblReloj.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblReloj.setText("09/11/2026  10:00");
        getContentPane().add(lblReloj);
        lblReloj.setBounds(590, 14, 195, 24);

        panelCard1.setBackground(new java.awt.Color(208, 230, 252));
        panelCard1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCard1Titulo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblCard1Titulo.setText("Total Huéspedes");
        panelCard1.add(lblCard1Titulo);

        lblTotalHuespedes.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTotalHuespedes.setForeground(new java.awt.Color(25, 58, 107));
        lblTotalHuespedes.setText("0");
        panelCard1.add(lblTotalHuespedes);

        getContentPane().add(panelCard1);
        panelCard1.setBounds(20, 48, 180, 85);

        panelCard2.setBackground(new java.awt.Color(209, 242, 217));
        panelCard2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCard2Titulo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblCard2Titulo.setText("Total Habitaciones");
        panelCard2.add(lblCard2Titulo);

        lblTotalHabitaciones.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTotalHabitaciones.setForeground(new java.awt.Color(34, 120, 65));
        lblTotalHabitaciones.setText("0");
        panelCard2.add(lblTotalHabitaciones);

        getContentPane().add(panelCard2);
        panelCard2.setBounds(215, 48, 180, 85);

        panelCard3.setBackground(new java.awt.Color(253, 228, 195));
        panelCard3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCard3Titulo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblCard3Titulo.setText("Reservas Activas");
        panelCard3.add(lblCard3Titulo);

        lblReservasActivas.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblReservasActivas.setForeground(new java.awt.Color(180, 95, 20));
        lblReservasActivas.setText("0");
        panelCard3.add(lblReservasActivas);

        getContentPane().add(panelCard3);
        panelCard3.setBounds(410, 48, 180, 85);

        panelCard4.setBackground(new java.awt.Color(228, 215, 250));
        panelCard4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCard4Titulo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblCard4Titulo.setText("Ocupación %");
        panelCard4.add(lblCard4Titulo);

        lblOcupacion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblOcupacion.setForeground(new java.awt.Color(108, 60, 175));
        lblOcupacion.setText("0%");
        panelCard4.add(lblOcupacion);

        getContentPane().add(panelCard4);
        panelCard4.setBounds(605, 48, 180, 85);

        btnAccesoReservas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAccesoReservas.setText("Ir a Reservas");
        getContentPane().add(btnAccesoReservas);
        btnAccesoReservas.setBounds(20, 145, 180, 32);

        btnAccesoHabitaciones.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAccesoHabitaciones.setText("Ir a Habitaciones");
        getContentPane().add(btnAccesoHabitaciones);
        btnAccesoHabitaciones.setBounds(215, 145, 180, 32);

        btnAccesoHuespedes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAccesoHuespedes.setText("Ir a Huéspedes");
        getContentPane().add(btnAccesoHuespedes);
        btnAccesoHuespedes.setBounds(410, 145, 180, 32);

        btnCerrar.setText("Volver al Menú");
        getContentPane().add(btnCerrar);
        btnCerrar.setBounds(605, 145, 180, 32);

        lblProximas.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblProximas.setText("Próximas Reservas / Check-ins:");
        getContentPane().add(lblProximas);
        lblProximas.setBounds(20, 190, 300, 24);

        tablaProximas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Huésped", "Habitación", "Fecha Entrada", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProximas);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 218, 765, 215);

        getContentPane().setPreferredSize(new java.awt.Dimension(820, 460));
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccesoHabitaciones;
    private javax.swing.JButton btnAccesoHuespedes;
    private javax.swing.JButton btnAccesoReservas;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCard1Titulo;
    private javax.swing.JLabel lblCard2Titulo;
    private javax.swing.JLabel lblCard3Titulo;
    private javax.swing.JLabel lblCard4Titulo;
    private javax.swing.JLabel lblOcupacion;
    private javax.swing.JLabel lblProximas;
    private javax.swing.JLabel lblReloj;
    private javax.swing.JLabel lblReservasActivas;
    private javax.swing.JLabel lblTituloBanner;
    private javax.swing.JLabel lblTotalHabitaciones;
    private javax.swing.JLabel lblTotalHuespedes;
    private javax.swing.JPanel panelCard1;
    private javax.swing.JPanel panelCard2;
    private javax.swing.JPanel panelCard3;
    private javax.swing.JPanel panelCard4;
    private javax.swing.JTable tablaProximas;
    // End of variables declaration//GEN-END:variables

    private void inicializarComponentes() {
        setSize(840, 490);
        setLocationRelativeTo(null);
        getContentPane().setBackground(EstilosUI.BG_WINDOW);

        modeloProximas = new DefaultTableModel(
                new Object[]{"Fecha Entrada", "Fecha Salida", "Huésped", "Habitación"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaProximas.setModel(modeloProximas);
        EstilosUI.estilizarTabla(tablaProximas);

        btnAccesoReservas.addActionListener(e -> {
            if (accionAbrirReservas != null) {
                accionAbrirReservas.run();
            }
        });
        btnAccesoHabitaciones.addActionListener(e -> {
            if (accionAbrirHabitaciones != null) {
                accionAbrirHabitaciones.run();
            }
        });
        btnAccesoHuespedes.addActionListener(e -> {
            if (accionAbrirHuespedes != null) {
                accionAbrirHuespedes.run();
            }
        });
        btnCerrar.addActionListener(e -> dispose());
    }

    public final void actualizarIndicadores() {
        try {
            List<Huesped> huespedes = hotelFacade.listarHuespedes();
            List<Habitacion> habitaciones = hotelFacade.listarHabitaciones();
            List<Reserva> reservas = hotelFacade.listarReservas();

            int totalHuespedes = huespedes.size();
            int totalHabitaciones = habitaciones.size();

            int activas = 0;
            Set<Integer> habitacionesOcupadas = new HashSet<>();

            for (Reserva r : reservas) {
                if (r.getEstado() == EstadoReserva.PENDIENTE || r.getEstado() == EstadoReserva.CONFIRMADO) {
                    activas++;
                    if (r.getHabitacion() != null) {
                        habitacionesOcupadas.add(r.getHabitacion().getId());
                    }
                }
            }

            int porcentajeOcupacion = totalHabitaciones > 0
                    ? (int) Math.round((habitacionesOcupadas.size() * 100.0) / totalHabitaciones)
                    : 0;

            lblTotalHuespedes.setText(String.valueOf(totalHuespedes));
            lblTotalHabitaciones.setText(String.valueOf(totalHabitaciones));
            lblReservasActivas.setText(String.valueOf(activas));
            lblOcupacion.setText(porcentajeOcupacion + "%");

            modeloProximas.setRowCount(0);
            reservas.stream()
                    .filter(r -> r.getEstado() != EstadoReserva.CANCELADO)
                    .sorted(Comparator.comparing(Reserva::getFechaEntrada, Comparator.nullsLast(Comparator.naturalOrder())))
                    .forEach(r -> {
                        String entrada = r.getFechaEntrada() != null ? r.getFechaEntrada().format(FORMATO_FECHA) : "";
                        String salida = r.getFechaSalida() != null ? r.getFechaSalida().format(FORMATO_FECHA) : "";
                        String huesped = r.getHuesped() != null ? r.getHuesped().getNombre() : "";
                        String hab = r.getHabitacion() != null ? r.getHabitacion().getNumero() : "";
                        modeloProximas.addRow(new Object[]{entrada, salida, huesped, hab});
                    });

        } catch (Exception ignored) {
        }
    }

    private void iniciarReloj() {
        Timer timer = new Timer(30000, e -> lblReloj.setText(LocalDateTime.now().format(FORMATO_RELOJ)));
        timer.start();
    }
}
