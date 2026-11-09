package Presentacion;

import Negocio.entidades.Habitacion;
import Negocio.enums.EstadoHabitacion;
import Negocio.enums.TipoHabitacion;
import Negocio.servicios.HotelFacade;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 * Ventana 3: Gestión de Habitaciones ("Hotel del Sol").
 */
public class GestionHabitacionesFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private final HotelFacade hotelFacade;

    private DefaultTableModel modeloTabla;

    private List<Habitacion> listaActual = new ArrayList<>();
    private Integer idEnEdicion = null;

    public GestionHabitacionesFrame(HotelFacade hotelFacade) {
        this.hotelFacade = hotelFacade;
        initComponents();
        inicializarComponentes();
        actualizarCamposPorTipo();
        cargarHabitaciones();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloBanner = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        lblCapacidad = new javax.swing.JLabel();
        txtCapacidad = new javax.swing.JTextField();
        lblPrecioNoche = new javax.swing.JLabel();
        txtPrecioNoche = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnLimpiarFiltro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHabitaciones = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnCambiarEstado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Habitaciones - Hotel del Sol");
        setResizable(false);
        getContentPane().setLayout(null);

        lblTituloBanner.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTituloBanner.setForeground(new java.awt.Color(25, 58, 107));
        lblTituloBanner.setText("Gestión de Habitaciones");
        getContentPane().add(lblTituloBanner);
        lblTituloBanner.setBounds(20, 12, 300, 28);

        lblNumero.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNumero.setText("Número Habitación:");
        getContentPane().add(lblNumero);
        lblNumero.setBounds(20, 48, 150, 20);
        getContentPane().add(txtNumero);
        txtNumero.setBounds(20, 70, 230, 28);

        lblTipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTipo.setText("Tipo de Habitación:");
        getContentPane().add(lblTipo);
        lblTipo.setBounds(20, 104, 150, 20);

        getContentPane().add(cmbTipo);
        cmbTipo.setBounds(20, 126, 230, 28);

        lblCapacidad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCapacidad.setText("Capacidad (personas):");
        getContentPane().add(lblCapacidad);
        lblCapacidad.setBounds(20, 160, 150, 20);
        getContentPane().add(txtCapacidad);
        txtCapacidad.setBounds(20, 182, 230, 28);

        lblPrecioNoche.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPrecioNoche.setText("Precio por Noche (S/):");
        getContentPane().add(lblPrecioNoche);
        lblPrecioNoche.setBounds(20, 216, 150, 20);
        getContentPane().add(txtPrecioNoche);
        txtPrecioNoche.setBounds(20, 238, 230, 28);

        lblEstado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEstado.setText("Estado inicial:");
        getContentPane().add(lblEstado);
        lblEstado.setBounds(20, 272, 150, 20);

        getContentPane().add(cmbEstado);
        cmbEstado.setBounds(20, 294, 230, 28);

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar.setText("Guardar / Actualizar");
        getContentPane().add(btnGuardar);
        btnGuardar.setBounds(20, 334, 230, 34);

        btnLimpiar.setText("Limpiar");
        getContentPane().add(btnLimpiar);
        btnLimpiar.setBounds(20, 376, 110, 30);

        btnVolver.setText("Volver");
        getContentPane().add(btnVolver);
        btnVolver.setBounds(140, 376, 110, 30);

        lblBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBuscar.setText("Buscar:");
        getContentPane().add(lblBuscar);
        lblBuscar.setBounds(280, 48, 60, 24);
        getContentPane().add(txtBuscar);
        txtBuscar.setBounds(340, 46, 280, 28);

        btnLimpiarFiltro.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnLimpiarFiltro.setText("Limpiar");
        getContentPane().add(btnLimpiarFiltro);
        btnLimpiarFiltro.setBounds(630, 46, 90, 28);

        tablaHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Número", "Tipo", "Capacidad", "Precio/Noche", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaHabitaciones);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(280, 82, 440, 280);

        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditar.setText("Editar Seleccionada");
        getContentPane().add(btnEditar);
        btnEditar.setBounds(280, 376, 160, 30);

        btnCambiarEstado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCambiarEstado.setText("Cambiar Estado");
        getContentPane().add(btnCambiarEstado);
        btnCambiarEstado.setBounds(450, 376, 160, 30);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarEstado;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiarFiltro;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<EstadoHabitacion> cmbEstado;
    private javax.swing.JComboBox<TipoHabitacion> cmbTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCapacidad;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblPrecioNoche;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTituloBanner;
    private javax.swing.JTable tablaHabitaciones;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPrecioNoche;
    // End of variables declaration//GEN-END:variables

    private void inicializarComponentes() {
        setSize(780, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(EstilosUI.BG_WINDOW);

        // Modelo y tipo de combos
        for (TipoHabitacion t : TipoHabitacion.values()) {
            cmbTipo.addItem(t);
        }
        cmbTipo.setSelectedItem(TipoHabitacion.DOBLE);
        cmbTipo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof TipoHabitacion) {
                    setText(EstilosUI.formatearCapitalizado(((TipoHabitacion) value).name()));
                }
                return this;
            }
        });
        cmbTipo.addActionListener(e -> actualizarCamposPorTipo());

        txtCapacidad.setEditable(false);
        txtCapacidad.setBackground(new Color(238, 243, 250));

        txtPrecioNoche.setEditable(false);
        txtPrecioNoche.setBackground(new Color(238, 243, 250));

        for (EstadoHabitacion eh : EstadoHabitacion.values()) {
            cmbEstado.addItem(eh);
        }
        cmbEstado.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof EstadoHabitacion) {
                    setText(EstilosUI.formatearCapitalizado(((EstadoHabitacion) value).name()));
                }
                return this;
            }
        });

        modeloTabla = new DefaultTableModel(new Object[]{"ID", "N° Hab.", "Tipo", "Estado"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaHabitaciones.setModel(modeloTabla);
        EstilosUI.estilizarTabla(tablaHabitaciones);

        btnGuardar.addActionListener(e -> guardarHabitacion());
        btnLimpiar.addActionListener(e -> limpiarFormulario());
        btnVolver.addActionListener(e -> dispose());
        btnEditar.addActionListener(e -> cargarSeleccionParaEditar());
        btnCambiarEstado.addActionListener(e -> cambiarEstadoSeleccionada());
        btnLimpiarFiltro.addActionListener(e -> {
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

    private void actualizarCamposPorTipo() {
        TipoHabitacion tipo = (TipoHabitacion) cmbTipo.getSelectedItem();
        if (tipo != null) {
            txtCapacidad.setText(String.valueOf(tipo.getCapacidad()));
            txtPrecioNoche.setText(String.format(Locale.US, "%.2f", tipo.getPrecio()));
        }
    }

    public final void cargarHabitaciones() {
        try {
            listaActual = hotelFacade.listarHabitaciones();
            filtrarTabla();
        } catch (Exception ex) {
            System.err.println("Aviso al cargar habitaciones: " + ex.getMessage());
        }
    }

    private void filtrarTabla() {
        String filtro = txtBuscar != null ? txtBuscar.getText().trim().toLowerCase() : "";
        modeloTabla.setRowCount(0);
        for (Habitacion h : listaActual) {
            String numero = h.getNumero() != null ? h.getNumero() : "";
            String tipo = h.getTipo() != null ? EstilosUI.formatearCapitalizado(h.getTipo().name()) : "";
            String estado = h.getEstado() != null ? EstilosUI.formatearCapitalizado(h.getEstado().name()) : "";

            if (filtro.isEmpty()
                    || numero.toLowerCase().contains(filtro)
                    || tipo.toLowerCase().contains(filtro)
                    || estado.toLowerCase().contains(filtro)
                    || String.valueOf(h.getId()).contains(filtro)) {
                modeloTabla.addRow(new Object[]{h.getId(), numero, tipo, estado});
            }
        }
    }

    private void guardarHabitacion() {
        String numero = txtNumero.getText().trim();
        TipoHabitacion tipo = (TipoHabitacion) cmbTipo.getSelectedItem();
        EstadoHabitacion estado = (EstadoHabitacion) cmbEstado.getSelectedItem();

        if (numero.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "El número de habitación es obligatorio.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Habitacion h = new Habitacion();
            h.setNumero(numero);
            h.setTipo(tipo);
            h.setEstado(estado);

            if (idEnEdicion == null) {
                int nuevoId = hotelFacade.registrarHabitacion(h);
                JOptionPane.showMessageDialog(this,
                        "Habitación registrada correctamente (ID: " + nuevoId + ").",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                h.setId(idEnEdicion);
                if (estado == EstadoHabitacion.MANTENIMIENTO) {
                    hotelFacade.cambiarEstadoHabitacion(idEnEdicion, EstadoHabitacion.MANTENIMIENTO);
                }
                if (hotelFacade.actualizarHabitacion(h)) {
                    JOptionPane.showMessageDialog(this,
                            "Habitación actualizada correctamente.",
                            "Éxito",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }

            limpiarFormulario();
            cargarHabitaciones();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error al guardar la habitación:\n" + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarSeleccionParaEditar() {
        int fila = tablaHabitaciones.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this,
                    "Seleccione una habitación de la tabla para editar.",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int id = (int) modeloTabla.getValueAt(fila, 0);
        for (Habitacion h : listaActual) {
            if (h.getId() == id) {
                idEnEdicion = h.getId();
                txtNumero.setText(h.getNumero());
                cmbTipo.setSelectedItem(h.getTipo());
                cmbEstado.setSelectedItem(h.getEstado());
                actualizarCamposPorTipo();
                return;
            }
        }
    }

    private void cambiarEstadoSeleccionada() {
        int fila = tablaHabitaciones.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this,
                    "Seleccione una habitación de la tabla para cambiar su estado.",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int id = (int) modeloTabla.getValueAt(fila, 0);
        Habitacion seleccionada = null;
        for (Habitacion h : listaActual) {
            if (h.getId() == id) {
                seleccionada = h;
                break;
            }
        }
        if (seleccionada == null) {
            return;
        }

        EstadoHabitacion nuevoEstado = (seleccionada.getEstado() == EstadoHabitacion.DISPONIBLE)
                ? EstadoHabitacion.MANTENIMIENTO
                : EstadoHabitacion.DISPONIBLE;

        String mensaje = "¿Desea cambiar el estado de la habitación N° "
                + seleccionada.getNumero()
                + " a "
                + EstilosUI.formatearCapitalizado(nuevoEstado.name())
                + "?";

        int confirmar = JOptionPane.showConfirmDialog(
                this,
                mensaje,
                "Cambiar Estado",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmar == JOptionPane.YES_OPTION) {
            try {
                if (hotelFacade.cambiarEstadoHabitacion(id, nuevoEstado)) {
                    JOptionPane.showMessageDialog(this,
                            "Estado actualizado a " + EstilosUI.formatearCapitalizado(nuevoEstado.name()) + ".",
                            "Éxito",
                            JOptionPane.INFORMATION_MESSAGE);
                    cargarHabitaciones();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        ex.getMessage(),
                        "No se pudo cambiar el estado",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void limpiarFormulario() {
        idEnEdicion = null;
        txtNumero.setText("");
        cmbTipo.setSelectedItem(TipoHabitacion.DOBLE);
        cmbEstado.setSelectedItem(EstadoHabitacion.DISPONIBLE);
        actualizarCamposPorTipo();
        tablaHabitaciones.clearSelection();
        txtNumero.requestFocus();
    }
}
