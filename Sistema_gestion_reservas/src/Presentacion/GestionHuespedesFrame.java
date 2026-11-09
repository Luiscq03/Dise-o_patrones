package Presentacion;

import Negocio.entidades.Huesped;
import Negocio.servicios.HotelFacade;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 * Ventana 2: Gestión de Huéspedes ("Hotel del Sol").
 */
public class GestionHuespedesFrame extends JFrame {

    private final HotelFacade hotelFacade;

    private DefaultTableModel modeloTabla;

    private List<Huesped> listaActual = new ArrayList<>();
    private Integer idEnEdicion = null;

    public GestionHuespedesFrame(HotelFacade hotelFacade) {
        this.hotelFacade = hotelFacade;
        initComponents();
        inicializarComponentes();
        cargarHuespedes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloBanner = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblDni = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnLimpiarBusqueda = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHuespedes = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Huéspedes - Hotel del Sol");
        setResizable(false);
        getContentPane().setLayout(null);

        lblTituloBanner.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTituloBanner.setForeground(new java.awt.Color(25, 58, 107));
        lblTituloBanner.setText("Gestión de Huéspedes");
        getContentPane().add(lblTituloBanner);
        lblTituloBanner.setBounds(20, 12, 300, 28);

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNombre.setText("Nombre Completo:");
        getContentPane().add(lblNombre);
        lblNombre.setBounds(20, 48, 150, 20);
        getContentPane().add(txtNombre);
        txtNombre.setBounds(20, 70, 230, 28);

        lblDni.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDni.setText("DNI / Documento:");
        getContentPane().add(lblDni);
        lblDni.setBounds(20, 104, 150, 20);
        getContentPane().add(txtDni);
        txtDni.setBounds(20, 126, 230, 28);

        lblTelefono.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTelefono.setText("Teléfono:");
        getContentPane().add(lblTelefono);
        lblTelefono.setBounds(20, 160, 150, 20);
        getContentPane().add(txtTelefono);
        txtTelefono.setBounds(20, 182, 230, 28);

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEmail.setText("Correo Electrónico:");
        getContentPane().add(lblEmail);
        lblEmail.setBounds(20, 216, 150, 20);
        getContentPane().add(txtEmail);
        txtEmail.setBounds(20, 238, 230, 28);

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar.setText("Guardar / Actualizar");
        getContentPane().add(btnGuardar);
        btnGuardar.setBounds(20, 280, 230, 34);

        btnLimpiar.setText("Limpiar");
        getContentPane().add(btnLimpiar);
        btnLimpiar.setBounds(20, 324, 110, 30);

        btnVolver.setText("Volver");
        getContentPane().add(btnVolver);
        btnVolver.setBounds(140, 324, 110, 30);

        lblBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBuscar.setText("Buscar:");
        getContentPane().add(lblBuscar);
        lblBuscar.setBounds(280, 48, 60, 24);
        getContentPane().add(txtBuscar);
        txtBuscar.setBounds(340, 46, 240, 28);

        btnLimpiarBusqueda.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnLimpiarBusqueda.setText("Limpiar");
        getContentPane().add(btnLimpiarBusqueda);
        btnLimpiarBusqueda.setBounds(590, 46, 90, 28);

        tablaHuespedes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "DNI", "Teléfono", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaHuespedes);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(280, 82, 410, 270);

        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditar.setText("Editar");
        getContentPane().add(btnEditar);
        btnEditar.setBounds(280, 362, 120, 30);

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(410, 362, 120, 30);

        getContentPane().setPreferredSize(new java.awt.Dimension(720, 420));
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiarBusqueda;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTituloBanner;
    private javax.swing.JTable tablaHuespedes;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    private void inicializarComponentes() {
        setSize(740, 460);
        setLocationRelativeTo(null);
        getContentPane().setBackground(EstilosUI.BG_WINDOW);

        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre", "DNI", "Teléfono", "Email"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaHuespedes.setModel(modeloTabla);
        EstilosUI.estilizarTabla(tablaHuespedes);

        btnGuardar.addActionListener(e -> guardarHuesped());
        btnLimpiar.addActionListener(e -> limpiarFormulario());
        btnVolver.addActionListener(e -> dispose());
        btnEditar.addActionListener(e -> cargarSeleccionParaEditar());
        btnEliminar.addActionListener(e -> eliminarSeleccionado());
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

    public final void cargarHuespedes() {
        try {
            listaActual = hotelFacade.listarHuespedes();
            filtrarTabla();
        } catch (Exception ex) {
            System.err.println("Aviso al cargar huéspedes: " + ex.getMessage());
        }
    }

    private void filtrarTabla() {
        String filtro = txtBuscar != null ? txtBuscar.getText().trim().toLowerCase() : "";
        modeloTabla.setRowCount(0);
        for (Huesped h : listaActual) {
            String nombre = h.getNombre() != null ? h.getNombre() : "";
            String doc = h.getDocumento() != null ? h.getDocumento() : "";
            if (filtro.isEmpty()
                    || nombre.toLowerCase().contains(filtro)
                    || doc.toLowerCase().contains(filtro)
                    || String.valueOf(h.getId()).contains(filtro)) {
                modeloTabla.addRow(new Object[]{h.getId(), nombre, doc});
            }
        }
    }

    private void guardarHuesped() {
        String nombre = txtNombre.getText().trim();
        String dni = txtDni.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String email = txtEmail.getText().trim();

        if (nombre.isEmpty() || dni.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "El Nombre y el DNI son obligatorios.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Huesped h = new Huesped();
            h.setNombre(nombre);
            h.setDocumento(dni);
            h.setTelefono(telefono);
            h.setEmail(email);

            if (idEnEdicion == null) {
                int nuevoId = hotelFacade.registrarHuesped(h);
                JOptionPane.showMessageDialog(this,
                        "Huésped registrado correctamente (ID: " + nuevoId + ").",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                h.setId(idEnEdicion);
                if (hotelFacade.actualizarHuesped(h)) {
                    JOptionPane.showMessageDialog(this,
                            "Huésped actualizado correctamente.",
                            "Éxito",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }

            limpiarFormulario();
            cargarHuespedes();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error al guardar huésped:\n" + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarSeleccionParaEditar() {
        int fila = tablaHuespedes.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this,
                    "Seleccione un huésped de la tabla para editar.",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int id = (int) modeloTabla.getValueAt(fila, 0);
        for (Huesped h : listaActual) {
            if (h.getId() == id) {
                idEnEdicion = h.getId();
                txtNombre.setText(h.getNombre());
                txtDni.setText(h.getDocumento());
                txtTelefono.setText(h.getTelefono());
                txtEmail.setText(h.getEmail());
                return;
            }
        }
    }

    private void eliminarSeleccionado() {
        int fila = tablaHuespedes.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this,
                    "Seleccione un huésped de la tabla para eliminar.",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int id = (int) modeloTabla.getValueAt(fila, 0);
        String nombre = String.valueOf(modeloTabla.getValueAt(fila, 1));

        int confirmar = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de eliminar al huésped \"" + nombre + "\" (ID: " + id + ")?",
                "Confirmar Eliminación",
                JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {
            try {
                if (hotelFacade.eliminarHuesped(id)) {
                    JOptionPane.showMessageDialog(this,
                            "Huésped eliminado correctamente.",
                            "Éxito",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (idEnEdicion != null && idEnEdicion == id) {
                        limpiarFormulario();
                    }
                    cargarHuespedes();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "No se pudo eliminar el huésped (verifique que no tenga reservas asociadas):\n" + ex.getMessage(),
                        "Error al Eliminar",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void limpiarFormulario() {
        idEnEdicion = null;
        txtNombre.setText("");
        txtDni.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        tablaHuespedes.clearSelection();
        txtNombre.requestFocus();
    }
}
