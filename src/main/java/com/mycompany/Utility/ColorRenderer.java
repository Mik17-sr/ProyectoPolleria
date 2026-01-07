package com.mycompany.Utility;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ColorRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setHorizontalAlignment(SwingConstants.CENTER);

        if (value != null) {
            String estado = value.toString();
            switch (estado) {
                case "SALDADO":
                    c.setForeground(new Color(46, 125, 50)); 
                    break;
                case "ABONO PARCIAL":
                    c.setForeground(new Color(245, 121, 0)); 
                    break;
                case "PENDIENTE":
                    c.setForeground(Color.RED); 
                    break;
            }
        }
        return c;
    }
}