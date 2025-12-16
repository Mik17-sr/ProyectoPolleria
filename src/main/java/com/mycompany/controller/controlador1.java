package com.mycompany.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author krate
 */
public class controlador1 implements ActionListener {
    Controller vis;
    
    public controlador1() {
        vis = new Controller();
        vis.iniciar();
        vis.getFrm().getBtniniciosidebar().addActionListener(this);
        vis.getFrm().getBtnregistrarproveedorsidebar().addActionListener(this);
        vis.getFrm().getBtnregistrarclientesidebar().addActionListener(this);
        vis.getFrm().getBtneditarproveedorsidebar().addActionListener(this);
        vis.getFrm().getBtneditarclientesidebar().addActionListener(this);
        vis.getFrm().getBtnregistrarcomprasidebar().addActionListener(this);
        vis.getFrm().getBtnregistrarventasidebar().addActionListener(this);        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vis.getFrm().getBtniniciosidebar()) {
            JOptionPane.showMessageDialog(null, "Seleccionaste el botón de inicio en el Sidebar");
        } 
        else if (e.getSource() == vis.getFrm().getBtnregistrarproveedorsidebar()) {
            JOptionPane.showMessageDialog(null, "Seleccionaste el botón de registrar proveedor");
            // Aquí iría la lógica para abrir el formulario de registro de proveedor
        }
        else if (e.getSource() == vis.getFrm().getBtnregistrarclientesidebar()) {
            JOptionPane.showMessageDialog(null, "Seleccionaste el botón de registrar cliente");
            // Aquí iría la lógica para abrir el formulario de registro de cliente
        }
        else if (e.getSource() == vis.getFrm().getBtneditarproveedorsidebar()) {
            JOptionPane.showMessageDialog(null, "Seleccionaste el botón de editar proveedor");
            // Aquí iría la lógica para abrir el formulario de edición de proveedor
        }
        else if (e.getSource() == vis.getFrm().getBtneditarclientesidebar()) {
            JOptionPane.showMessageDialog(null, "Seleccionaste el botón de editar cliente");
            // Aquí iría la lógica para abrir el formulario de edición de cliente
        }
        else if (e.getSource() == vis.getFrm().getBtnregistrarcomprasidebar()) {
            JOptionPane.showMessageDialog(null, "Seleccionaste el botón de registrar compra");
            // Aquí iría la lógica para abrir el formulario de registro de compra
        }
        else if (e.getSource() == vis.getFrm().getBtnregistrarventasidebar()) {
            JOptionPane.showMessageDialog(null, "Seleccionaste el botón de registrar venta");
            // Aquí iría la lógica para abrir el formulario de registro de venta
        }
    }
}