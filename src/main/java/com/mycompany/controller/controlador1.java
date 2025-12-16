package com.mycompany.controller;

import java.awt.CardLayout;
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
        CardLayout card = (CardLayout) vis.getFrm().getPnlCards().getLayout();
        if (e.getSource() == vis.getFrm().getBtniniciosidebar()) {
            
            card.show(vis.getFrm().getPnlCards(), "INICIO");
        } 
        else if (e.getSource() == vis.getFrm().getBtnregistrarproveedorsidebar()) {
            
            // Aquí iría la lógica para abrir el formulario de registro de proveedor
            card.show(vis.getFrm().getPnlCards(), "REGISTRARPROVEEDOR");
        }
        else if (e.getSource() == vis.getFrm().getBtnregistrarclientesidebar()) {
            card.show(vis.getFrm().getPnlCards(), "REGISTRARCLIENTE");
            // Aquí iría la lógica para abrir el formulario de registro de cliente
        }
        else if (e.getSource() == vis.getFrm().getBtneditarproveedorsidebar()) {
            card.show(vis.getFrm().getPnlCards(), "EDITARPROVEEDOR");
            // Aquí iría la lógica para abrir el formulario de edición de proveedor
        }
        else if (e.getSource() == vis.getFrm().getBtneditarclientesidebar()) {
            card.show(vis.getFrm().getPnlCards(), "EDITARCLIENTE");
            // Aquí iría la lógica para abrir el formulario de edición de cliente
        }
        else if (e.getSource() == vis.getFrm().getBtnregistrarcomprasidebar()) {
            card.show(vis.getFrm().getPnlCards(), "REGISTRARCOMPRA");
            // Aquí iría la lógica para abrir el formulario de registro de compra
        }
        else if (e.getSource() == vis.getFrm().getBtnregistrarventasidebar()) {
            card.show(vis.getFrm().getPnlCards(), "REGISTRARVENTA");
            // Aquí iría la lógica para abrir el formulario de registro de venta
        }
    }
}