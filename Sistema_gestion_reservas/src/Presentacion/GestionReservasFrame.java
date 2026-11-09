package Presentacion;

import Negocio.entidades.Habitacion;
import Negocio.entidades.Huesped;
import Negocio.entidades.Reserva;
import Negocio.enums.EstadoReserva;
import Negocio.servicios.HotelFacade;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 * Ventana 4: Gestión de Reservas ("Hotel del Sol").
 */
public class GestionReservasFrame extends JFrame {

    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final HotelFacade hotelFacade;

    private DefaultTableModel modeloTabla;

    private List<Reserva> listaReservas = new ArrayList<>();

    public GestionReservasFrame(HotelFacade hotelFacade) {
        this.hotelFacade = hotelFacade;
        initComponents();
        inicializarComponentes();
        recargarTodo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloBanner = new javax.swing.JLabel();
        lblHuesped = new javax.swing.JLabel();
        cmbHuesped = new javax.swing.JComboBox<>();
        lblHabitacion = new javax.swing.JLabel();
        cmbHabitacion = new javax.swing.JComboBox<>();
        lblFechaEntrada = new javax.swing.JLabel();
        txtFechaEntrada = new javax.swing.JTextField();
        lblFechaSalida = new javax.swing.JLabel();
        txtFechaSalida = new javax.swing.JTextField();
        lblNumHuespedes = new javax.swing.JLabel();
        spnNumeroHuespedes = new javax.swing.JSpinner();
        lblEstado = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        lblObservaciones = new javax.swing.JLabel();
        jScrollPaneObs = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        btnRegistrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnLimpiarBusqueda = new javax.swing.JButton();
        jScrollPaneTabla = new javax.swing.JScrollPane();
        tablaReservas = new javax.swing.JTable();
        btnConfirmar = new javax.swing.JButton();
        btnCancelarReserva = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Reservas - Hotel del Sol");
        setResizable(false);
        getContentPane().setLayout(null);

        lblTituloBanner.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTituloBanner.setForeground(new java.awt.Color(25, 58, 107));
        lblTituloBanner.setText("Gestión de Reservas - Hotel del Sol");
        getContentPane().add(lblTituloBanner);
        lblTituloBanner.setBounds(20, 10, 380, 28);

        lblHuesped.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblHuesped.setText("Huésped:");
        getContentPane().add(lblHuesped);
        lblHuesped.setBounds(20, 46, 100, 20);
        getContentPane().add(cmbHuesped);
        cmbHuesped.setBounds(20, 68, 280, 28);

        lblHabitacion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblHabitacion.setText("Habitación:");
        getContentPane().add(lblHabitacion);
        lblHabitacion.setBounds(20, 102, 100, 20);
        getContentPane().add(cmbHabitacion);
        cmbHabitacion.setBounds(20, 124, 280, 28);

        lblFechaEntrada.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFechaEntrada.setText("Fecha Entrada:");
        getContentPane().add(lblFechaEntrada);
        lblFechaEntrada.setBounds(20, 158, 135, 20);
        getContentPane().add(txtFechaEntrada);
        txtFechaEntrada.setBounds(20, 180, 135, 28);

        lblFechaSalida.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFechaSalida.setText("Fecha Salida:");
        getContentPane().add(lblFechaSalida);
        lblFechaSalida.setBounds(165, 158, 135, 20);
        getContentPane().add(txtFechaSalida);
        txtFechaSalida.setBounds(165, 180, 135, 28);

        lblNumHuespedes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNumHuespedes.setText("Núm. Huéspedes:");
        getContentPane().add(lblNumHuespedes);
        lblNumHuespedes.setBounds(20, 214, 100, 20);

        spnNumeroHuespedes.setModel(new javax.swing.SpinnerNumberModel(2, 1, 20, 1));
        getContentPane().add(spnNumeroHuespedes);
        spnNumeroHuespedes.setBounds(20, 236, 80, 28);

        lblEstado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEstado.setText("Estado:");
        getContentPane().add(lblEstado);
        lblEstado.setBounds(115, 214, 80, 20);

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Confirmada", "Cancelada" }));
        getContentPane().add(cmbEstado);
        cmbEstado.setBounds(115, 236, 185, 28);

        lblObservaciones.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblObservaciones.setText("Observaciones:");
        getContentPane().add(lblObservaciones);
        lblObservaciones.setBounds(20, 270, 120, 20);

        txtObservaciones.setColumns(15);
        txtObservaciones.setRows(2);
        jScrollPaneObs.setViewportView(txtObservaciones);

        getContentPane().add(jScrollPaneObs);
        jScrollPaneObs.setBounds(20, 292, 280, 52);

        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegistrar.setText("Registrar Reserva");
        getContentPane().add(btnRegistrar);
        btnRegistrar.setBounds(20, 356, 280, 34);

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnLimpiar.setText("Limpiar");
        getContentPane().add(btnLimpiar);
        btnLimpiar.setBounds(20, 398, 135, 30);

        btnVolver.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnVolver.setText("Volver al Menú");
        getContentPane().add(btnVolver);
        btnVolver.setBounds(165, 398, 135, 30);

        lblBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBuscar.setText("Buscar:");
        getContentPane().add(lblBuscar);
        lblBuscar.setBounds(320, 46, 60, 24);
        getContentPane().add(txtBuscar);
        txtBuscar.setBounds(380, 44, 310, 28);

        btnLimpiarBusqueda.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnLimpiarBusqueda.setText("Limpiar");
        getContentPane().add(btnLimpiarBusqueda);
        btnLimpiarBusqueda.setBounds(700, 44, 90, 28);

        tablaReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Huésped", "Hab.", "Entrada", "Salida", "Total", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneTabla.setViewportView(tablaReservas);

        getContentPane().add(jScrollPaneTabla);
        jScrollPaneTabla.setBounds(320, 80, 470, 295);

        btnConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConfirmar.setText("Confirmar Reserva");
        getContentPane().add(btnConfirmar);
        btnConfirmar.setBounds(320, 395, 160, 32);

        btnCancelarReserva.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancelarReserva.setText("Cancelar Reserva");
        getContentPane().add(btnCancelarReserva);
        btnCancelarReserva.setBounds(490, 395, 160, 32);

        getContentPane().setPreferredSize(new java.awt.Dimension(820, 460));
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarReserva;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiarBusqueda;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<Habitacion> cmbHabitacion;
    private javax.swing.JComboBox<Huesped> cmbHuesped;
    private javax.swing.JScrollPane jScrollPaneObs;
    private javax.swing.JScrollPane jScrollPaneTabla;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFechaEntrada;
    private javax.swing.JLabel lblFechaSalida;
    private javax.swing.JLabel lblHabitacion;
    private javax.swing.JLabel lblHuesped;
    private javax.swing.JLabel lblNumHuespedes;
    private javax.swing.JLabel lblObservaciones;
    private javax.swing.JLabel lblTituloBanner;
    private javax.swing.JSpinner spnNumeroHuespedes;
    private javax.swing.JTable tablaReservas;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtFechaEntrada;
    private javax.swing.JTextField txtFechaSalida;
    private javax.swing.JTextArea txtObservaciones;
    // End of variables declaration//GEN-END:variables

    private void inicializarComponentes() {
        setSize(840, 500);
        setLocationRelativeTo(null);
        getContentPane().setBackground(EstilosUI.BG_WINDOW);

        txtFechaEntrada.setText(LocalDate.now().format(FORMATO_FECHA));
        txtFechaSalida.setText(LocalDate.now().plusDays(3).format(FORMATO_FECHA));

        txtObservaciones.setLineWrap(true);
        txtObservaciones.setWrapStyleWord(true);
        txtObservaciones.setFont(EstilosUI.FONT_INPUT);

        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Huésped", "Habitación", "Estado"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaReservas.setModel(modeloTabla);
        EstilosUI.estilizarTabla(tablaReservas);

        tablaReservas.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                mostrarDetalleSeleccion();
            }
        });

        btnRegistrar.addActionListener(e -> registrarReserva());
        btnLimpiar.addActionListener(e -> limpiarFormulario());
        btnVolver.addActionListener(e -> dispose());
        btnConfirmar.addActionListener(e -> confirmarReservaSeleccionada());
        btnCancelarReserva.addActionListener(e -> cancelarReservaSeleccionada());
        btnLimpiarBusqueda.addActionListener(e -> {
            txtBuscar.setText("");
            filtrarTabla();
        });

        txtBuscar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarTabla();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarTabla();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarTabla();
            }
        });
    }

    public final void recargarTodo() {
        cargarCombos();
        cargarReservas();
    }

    private void cargarCombos() {
        try {
            cmbHuesped.removeAllItems();
            for (Huesped h : hotelFacade.listarHuespedes()) {
                cmbHuesped.addItem(h);
            }

            cmbHabitacion.removeAllItems();
            for (Habitacion hab : hotelFacade.listarHabitaciones()) {
                cmbHabitacion.addItem(hab);
            }
        } catch (Exception ignored) {
        }
    }

    public final void cargarReservas() {
        try {
            listaReservas = hotelFacade.listarReservas();
            filtrarTabla();
        } catch (Exception ex) {
            System.err.println("Aviso al cargar reservas: " + ex.getMessage());
        }
    }

    private void filtrarTabla() {
        String filtro = txtBuscar != null ? txtBuscar.getText().trim().toLowerCase() : "";
        modeloTabla.setRowCount(0);
        for (Reserva r : listaReservas) {
            String huesped = (r.getHuesped() != null && r.getHuesped().getNombre() != null)
                    ? r.getHuesped().getNombre() : "";
            String habitacion = (r.getHabitacion() != null && r.getHabitacion().getNumero() != null)
                    ? r.getHabitacion().getNumero() : "";
            String estado = r.getEstado() != null
                    ? EstilosUI.formatearEstadoReservaUI(r.getEstado().name()) : "";

            if (filtro.isEmpty()
                    || huesped.toLowerCase().contains(filtro)
                    || habitacion.toLowerCase().contains(filtro)
                    || estado.toLowerCase().contains(filtro)
                    || String.valueOf(r.getId()).contains(filtro)) {
                modeloTabla.addRow(new Object[]{r.getId(), huesped, habitacion, estado});
            }
        }
    }

    private void mostrarDetalleSeleccion() {
        int fila = tablaReservas.getSelectedRow();
        if (fila < 0) {
            return;
        }
        int id = (int) modeloTabla.getValueAt(fila, 0);
        for (Reserva r : listaReservas) {
            if (r.getId() == id) {
                if (r.getFechaEntrada() != null) {
                    txtFechaEntrada.setText(r.getFechaEntrada().format(FORMATO_FECHA));
                }
                if (r.getFechaSalida() != null) {
                    txtFechaSalida.setText(r.getFechaSalida().format(FORMATO_FECHA));
                }
                spnNumeroHuespedes.setValue(r.getNumeroHuespedes());
                txtObservaciones.setText(r.getObservaciones() != null ? r.getObservaciones() : "");
                cmbEstado.setSelectedItem(EstilosUI.formatearEstadoReservaUI(r.getEstado().name()));
                break;
            }
        }
    }

    private LocalDate parsearFecha(String texto, String nombreCampo) {
        try {
            return LocalDate.parse(texto.trim(), FORMATO_FECHA);
        } catch (DateTimeParseException e) {
            try {
                return LocalDate.parse(texto.trim());
            } catch (DateTimeParseException ex) {
                throw new IllegalArgumentException("Formato inválido en " + nombreCampo + ". Use dd/MM/yyyy (ej. 10/12/2026).");
            }
        }
    }

    private void registrarReserva() {
        Huesped huesped = (Huesped) cmbHuesped.getSelectedItem();
        Habitacion habitacion = (Habitacion) cmbHabitacion.getSelectedItem();

        if (huesped == null || habitacion == null) {
            JOptionPane.showMessageDialog(this,
                    "Debe seleccionar un huésped y una habitación.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            LocalDate entrada = parsearFecha(txtFechaEntrada.getText(), "Fecha Entrada");
            LocalDate salida = parsearFecha(txtFechaSalida.getText(), "Fecha Salida");

            Reserva nueva = new Reserva();
            nueva.setHuesped(huesped);
            nueva.setHabitacion(habitacion);
            nueva.setFechaEntrada(entrada);
            nueva.setFechaSalida(salida);
            nueva.setNumeroHuespedes((int) spnNumeroHuespedes.getValue());
            nueva.setObservaciones(txtObservaciones.getText().trim());
            nueva.setEstado(EstadoReserva.PENDIENTE);

            int id = hotelFacade.registrarReserva(nueva);

            JOptionPane.showMessageDialog(this,
                    "Reserva registrada exitosamente (ID: " + id + ").\n"
                    + "Total: S/ " + String.format("%.2f", nueva.calcularTotal()),
                    "Reserva Registrada",
                    JOptionPane.INFORMATION_MESSAGE);

            limpiarFormulario();
            cargarReservas();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "No se pudo registrar la reserva",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void confirmarReservaSeleccionada() {
        int fila = tablaReservas.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this,
                    "Seleccione una reserva de la tabla para confirmar.",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int id = (int) modeloTabla.getValueAt(fila, 0);
        try {
            if (hotelFacade.confirmarReserva(id)) {
                JOptionPane.showMessageDialog(this,
                        "Reserva #" + id + " confirmada correctamente.",
                        "Reserva Confirmada",
                        JOptionPane.INFORMATION_MESSAGE);
                cargarReservas();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Error al confirmar reserva",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void cancelarReservaSeleccionada() {
        int fila = tablaReservas.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this,
                    "Seleccione una reserva de la tabla para cancelar.",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int id = (int) modeloTabla.getValueAt(fila, 0);
        int confirmar = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de cancelar la reserva #" + id + "?",
                "Confirmar Cancelación",
                JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {
            try {
                if (hotelFacade.cancelarReserva(id)) {
                    JOptionPane.showMessageDialog(this,
                            "Reserva #" + id + " cancelada correctamente.",
                            "Reserva Cancelada",
                            JOptionPane.INFORMATION_MESSAGE);
                    cargarReservas();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        ex.getMessage(),
                        "Error al cancelar reserva",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void limpiarFormulario() {
        if (cmbHuesped.getItemCount() > 0) {
            cmbHuesped.setSelectedIndex(0);
        }
        if (cmbHabitacion.getItemCount() > 0) {
            cmbHabitacion.setSelectedIndex(0);
        }
        txtFechaEntrada.setText(LocalDate.now().format(FORMATO_FECHA));
        txtFechaSalida.setText(LocalDate.now().plusDays(3).format(FORMATO_FECHA));
        spnNumeroHuespedes.setValue(2);
        txtObservaciones.setText("");
        cmbEstado.setSelectedIndex(0);
        tablaReservas.clearSelection();
    }
}
