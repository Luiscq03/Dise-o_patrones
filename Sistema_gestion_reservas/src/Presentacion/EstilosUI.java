package Presentacion;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/**
 * Utilidades de estilo visual e iconografía vectorial para las interfaces
 * del Sistema de Reservas "Hotel del Sol".
 */
public class EstilosUI {

    public static final Color BG_WINDOW = new Color(235, 242, 250);
    public static final Color BG_PANEL = new Color(245, 248, 253);
    public static final Color BORDER_COLOR = new Color(195, 210, 230);
    public static final Color NAVY_HEADER = new Color(25, 58, 107);
    public static final Color TEXT_DARK = new Color(30, 41, 59);

    public static final Font FONT_LABEL = new Font("Segoe UI", Font.BOLD, 12);
    public static final Font FONT_INPUT = new Font("Segoe UI", Font.PLAIN, 13);

    public static void aplicarLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {
        }
    }

    public static void estilizarTabla(JTable tabla) {
        tabla.setRowHeight(28);
        tabla.setFont(FONT_INPUT);
        tabla.setSelectionBackground(new Color(185, 215, 250));
        tabla.setSelectionForeground(TEXT_DARK);
        tabla.setGridColor(new Color(220, 228, 240));
        tabla.setShowGrid(true);
        tabla.setFillsViewportHeight(true);

        JTableHeader header = tabla.getTableHeader();
        header.setFont(FONT_LABEL);
        header.setBackground(new Color(225, 234, 246));
        header.setForeground(TEXT_DARK);
        header.setPreferredSize(new Dimension(header.getWidth(), 30));

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setBorder(new EmptyBorder(0, 6, 0, 6));
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }

    public static String formatearCapitalizado(String texto) {
        if (texto == null || texto.isEmpty()) {
            return "";
        }
        String lower = texto.toLowerCase();
        return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
    }

    public static String formatearEstadoReservaUI(String estadoEnum) {
        if (estadoEnum == null) {
            return "";
        }
        switch (estadoEnum.toUpperCase()) {
            case "PENDIENTE":
                return "Pendiente";
            case "CONFIRMADO":
            case "CONFIRMADA":
                return "Confirmada";
            case "CANCELADO":
            case "CANCELADA":
                return "Cancelada";
            default:
                return formatearCapitalizado(estadoEnum);
        }
    }

    public static Icon crearIcono(String tipo, int size) {
        return new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.translate(x, y);

                switch (tipo) {
                    case "GUARDAR":
                        g2.setColor(new Color(35, 95, 180));
                        g2.fillRoundRect(1, 1, size - 2, size - 2, 4, 4);
                        g2.setColor(Color.WHITE);
                        g2.fillRect(4, 2, size - 8, 6);
                        g2.fillRoundRect(3, size - 8, size - 6, 6, 2, 2);
                        break;

                    case "LIMPIAR":
                        g2.setColor(new Color(215, 155, 35));
                        g2.setStroke(new BasicStroke(2.2f));
                        g2.drawLine(size - 3, 2, 6, size - 6);
                        g2.setColor(new Color(235, 185, 60));
                        int[] bx = {2, 8, 11, 5};
                        int[] by = {size - 5, size - 11, size - 8, size - 2};
                        g2.fillPolygon(bx, by, 4);
                        break;

                    case "CANCELAR":
                        g2.setColor(new Color(205, 45, 45));
                        g2.setStroke(new BasicStroke(2.6f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                        g2.drawLine(3, 3, size - 4, size - 4);
                        g2.drawLine(size - 4, 3, 3, size - 4);
                        break;

                    case "EDITAR":
                        g2.setColor(new Color(225, 145, 25));
                        g2.setStroke(new BasicStroke(2.2f));
                        g2.drawLine(3, size - 4, size - 4, 3);
                        g2.setColor(new Color(80, 80, 80));
                        g2.fillRect(2, size - 4, 3, 3);
                        break;

                    case "ELIMINAR":
                        g2.setColor(new Color(200, 50, 45));
                        g2.fillRect(4, 5, size - 8, size - 6);
                        g2.fillRect(2, 2, size - 4, 2);
                        g2.setColor(Color.WHITE);
                        g2.drawLine(6, 7, 6, size - 4);
                        g2.drawLine(size / 2, 7, size / 2, size - 4);
                        g2.drawLine(size - 7, 7, size - 7, size - 4);
                        break;

                    case "CONFIRMAR":
                        g2.setColor(new Color(40, 165, 65));
                        g2.setStroke(new BasicStroke(2.8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                        g2.drawLine(2, size / 2 + 1, size / 2 - 1, size - 3);
                        g2.drawLine(size / 2 - 1, size - 3, size - 2, 3);
                        break;

                    case "BUSCAR":
                        g2.setColor(new Color(45, 80, 125));
                        g2.setStroke(new BasicStroke(2f));
                        g2.drawOval(2, 2, size - 7, size - 7);
                        g2.drawLine(size - 6, size - 6, size - 2, size - 2);
                        break;

                    case "ESTADO":
                        g2.setColor(new Color(75, 95, 120));
                        g2.fillOval(3, 3, size - 6, size - 6);
                        g2.setColor(Color.WHITE);
                        g2.fillOval(6, 6, size - 12, size - 12);
                        break;

                    case "HUESPEDES":
                        g2.setColor(new Color(30, 80, 150));
                        g2.fillOval(size / 2 - 4, 1, 8, 8);
                        g2.fillArc(2, 9, size - 4, 10, 0, 180);
                        break;

                    case "HABITACIONES":
                        g2.setColor(new Color(30, 80, 150));
                        g2.fillRect(1, 5, 3, size - 6);
                        g2.fillRect(1, size - 6, size - 2, 3);
                        g2.fillRect(size - 4, size - 8, 3, 7);
                        g2.fillRoundRect(4, 7, 5, 4, 2, 2);
                        g2.fillRoundRect(9, 6, size - 11, 5, 3, 3);
                        break;

                    case "RESERVAS":
                        g2.setColor(new Color(30, 80, 150));
                        g2.drawRoundRect(2, 3, size - 4, size - 4, 3, 3);
                        g2.fillRect(2, 3, size - 4, 4);
                        g2.fillRect(5, 9, 2, 2);
                        g2.fillRect(9, 9, 2, 2);
                        g2.fillRect(5, 12, 2, 2);
                        g2.fillRect(9, 12, 2, 2);
                        break;

                    case "DASHBOARD":
                        g2.setColor(new Color(30, 80, 150));
                        g2.fillRoundRect(2, 2, 6, 6, 2, 2);
                        g2.fillRoundRect(10, 2, 6, 6, 2, 2);
                        g2.fillRoundRect(2, 10, 6, 6, 2, 2);
                        g2.fillRoundRect(10, 10, 6, 6, 2, 2);
                        break;

                    case "SALIR":
                        g2.setColor(new Color(200, 45, 45));
                        g2.setStroke(new BasicStroke(2.2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                        g2.drawArc(3, 4, size - 6, size - 6, 125, 290);
                        g2.drawLine(size / 2, 1, size / 2, size / 2);
                        break;
                }
                g2.dispose();
            }

            @Override
            public int getIconWidth() {
                return size;
            }

            @Override
            public int getIconHeight() {
                return size;
            }
        };
    }
}

