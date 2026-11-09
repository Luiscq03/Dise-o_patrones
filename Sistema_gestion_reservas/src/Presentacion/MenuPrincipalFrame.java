package Presentacion;

import Negocio.servicios.HotelFacade;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Ventana 1: Menú Principal ("Hotel Reservas" - "Hotel del Sol - Tu mejor estadía").
 */
public class MenuPrincipalFrame extends JFrame {

    private final HotelFacade hotelFacade;
    private JFrame ventanaActiva = null;
    private boolean redirigiendo = false;
    private Image imagenRecepcion;

    public MenuPrincipalFrame() {
        this.hotelFacade = new HotelFacade();
        initComponents();
        cargarImagenRecepcion();
        inicializarComponentes();
        setAlwaysOnTop(true);
        SwingUtilities.invokeLater(() -> setAlwaysOnTop(false));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFoto = new javax.swing.JPanel();
        lblFotoRecepcion = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        btnHuespedes = new javax.swing.JButton();
        btnHabitaciones = new javax.swing.JButton();
        btnReservas = new javax.swing.JButton();
        btnDashboard = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblBarraEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hotel Reservas - Hotel del Sol");
        setResizable(false);
        getContentPane().setLayout(null);

        panelFoto.setBackground(new java.awt.Color(238, 238, 238));
        panelFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblFotoRecepcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFotoRecepcion.setText("[ Foto Recepción Hotel ]");
        panelFoto.add(lblFotoRecepcion);

        getContentPane().add(panelFoto);
        panelFoto.setBounds(20, 20, 240, 370);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(16, 32, 80));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Hotel del Sol");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(280, 25, 300, 35);

        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSubtitulo.setForeground(new java.awt.Color(55, 75, 105));
        lblSubtitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubtitulo.setText("Tu mejor estadía");
        getContentPane().add(lblSubtitulo);
        lblSubtitulo.setBounds(280, 60, 300, 20);

        btnHuespedes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHuespedes.setText("Huéspedes");
        getContentPane().add(btnHuespedes);
        btnHuespedes.setBounds(300, 100, 260, 42);

        btnHabitaciones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHabitaciones.setText("Habitaciones");
        getContentPane().add(btnHabitaciones);
        btnHabitaciones.setBounds(300, 152, 260, 42);

        btnReservas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReservas.setText("Reservas");
        getContentPane().add(btnReservas);
        btnReservas.setBounds(300, 204, 260, 42);

        btnDashboard.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDashboard.setText("Panel de Control");
        getContentPane().add(btnDashboard);
        btnDashboard.setBounds(300, 256, 260, 42);

        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalir.setText("Salir");
        getContentPane().add(btnSalir);
        btnSalir.setBounds(300, 308, 260, 42);

        lblBarraEstado.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblBarraEstado.setForeground(new java.awt.Color(102, 102, 102));
        lblBarraEstado.setText(" Sistema de Reservas - Hotel del Sol");
        getContentPane().add(lblBarraEstado);
        lblBarraEstado.setBounds(20, 405, 560, 20);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnHabitaciones;
    private javax.swing.JButton btnHuespedes;
    private javax.swing.JButton btnReservas;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblBarraEstado;
    private javax.swing.JLabel lblFotoRecepcion;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelFoto;
    // End of variables declaration//GEN-END:variables

    private void cargarImagenRecepcion() {
        try {
            URL recurso = getClass().getResource("/Presentacion/recepcion_hotel.jpg");
            if (recurso != null) {
                imagenRecepcion = ImageIO.read(recurso);
            } else {
                File archivo = new File("src/Presentacion/recepcion_hotel.jpg");
                if (archivo.exists()) {
                    imagenRecepcion = ImageIO.read(archivo);
                }
            }
        } catch (Exception ignored) {
        }
    }

    private void inicializarComponentes() {
        setSize(620, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(EstilosUI.BG_WINDOW);

        // Foto en el panel izquierdo
        if (imagenRecepcion != null) {
            panelFoto.removeAll();
            panelFoto.setLayout(new BorderLayout());
            JPanel panelIlustracion = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                    int w = getWidth();
                    int h = getHeight();
                    g2.setClip(new RoundRectangle2D.Double(0, 0, w, h, 14, 14));

                    int imgW = imagenRecepcion.getWidth(null);
                    int imgH = imagenRecepcion.getHeight(null);
                    if (imgW > 0 && imgH > 0) {
                        double escala = Math.max((double) w / imgW, (double) h / imgH);
                        int drawW = (int) Math.round(imgW * escala);
                        int drawH = (int) Math.round(imgH * escala);
                        g2.drawImage(imagenRecepcion, (w - drawW) / 2, (h - drawH) / 2, drawW, drawH, this);
                    }

                    g2.setClip(null);
                    g2.setColor(EstilosUI.BORDER_COLOR);
                    g2.draw(new RoundRectangle2D.Double(0, 0, w - 1, h - 1, 14, 14));
                    g2.dispose();
                }
            };
            panelIlustracion.setOpaque(false);
            panelFoto.add(panelIlustracion, BorderLayout.CENTER);
            panelFoto.revalidate();
            panelFoto.repaint();
        }

        // Estilos y eventos a los botones generados por NetBeans
        btnHuespedes.setFocusPainted(false);
        btnHuespedes.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnHuespedes.setIcon(EstilosUI.crearIcono("HUESPEDES", 20));
        btnHuespedes.addActionListener(e -> navegarHacia(new GestionHuespedesFrame(hotelFacade)));

        btnHabitaciones.setFocusPainted(false);
        btnHabitaciones.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnHabitaciones.setIcon(EstilosUI.crearIcono("HABITACIONES", 20));
        btnHabitaciones.addActionListener(e -> navegarHacia(new GestionHabitacionesFrame(hotelFacade)));

        btnReservas.setFocusPainted(false);
        btnReservas.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnReservas.setIcon(EstilosUI.crearIcono("RESERVAS", 20));
        btnReservas.addActionListener(e -> navegarHacia(new GestionReservasFrame(hotelFacade)));

        btnDashboard.setFocusPainted(false);
        btnDashboard.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnDashboard.setIcon(EstilosUI.crearIcono("DASHBOARD", 20));
        btnDashboard.addActionListener(e -> abrirPanelControl());

        btnSalir.setFocusPainted(false);
        btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSalir.setIcon(EstilosUI.crearIcono("SALIR", 20));
        btnSalir.addActionListener(e -> System.exit(0));
    }

    private void navegarHacia(JFrame nuevaVentana) {
        redirigiendo = true;
        if (ventanaActiva != null && ventanaActiva.isDisplayable()) {
            ventanaActiva.dispose();
        }
        setVisible(false);
        ventanaActiva = nuevaVentana;

        nuevaVentana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (!redirigiendo) {
                    ventanaActiva = null;
                    setVisible(true);
                    toFront();
                }
            }
        });

        redirigiendo = false;
        nuevaVentana.setVisible(true);
        nuevaVentana.toFront();
    }

    private void abrirPanelControl() {
        PanelControlFrame frame = new PanelControlFrame(
                hotelFacade,
                () -> navegarHacia(new GestionReservasFrame(hotelFacade)),
                () -> navegarHacia(new GestionHabitacionesFrame(hotelFacade)),
                () -> navegarHacia(new GestionHuespedesFrame(hotelFacade))
        );
        navegarHacia(frame);
    }

    public static void main(String args[]) {
        EstilosUI.aplicarLookAndFeel();
        SwingUtilities.invokeLater(() -> {
            new MenuPrincipalFrame().setVisible(true);
        });
    }
}
