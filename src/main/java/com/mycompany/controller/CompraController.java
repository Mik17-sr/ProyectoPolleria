package com.mycompany.controller;

import com.mycompany.DAO.CompraDAO;
import com.mycompany.DAO.proveedorDAO;
import com.mycompany.Utility.PlaceholderUtil;
import com.mycompany.Utility.validacion;
import com.mycompany.model.Compra;
import com.mycompany.model.Proveedor;
import com.mycompany.vista.FrmPrincipal;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class CompraController implements ActionListener {

    private FrmPrincipal frm;
    private CompraDAO ob;

    public CompraController(FrmPrincipal frm) {
        this.frm = frm;
        ob = new CompraDAO();
        frm.getBtnregistrarcompra().addActionListener(e -> registrar());
        frm.getBtnagrProvRegistraraComp().addActionListener(e -> frm.mostrarCard(FrmPrincipal.CARD_REG_PROV));
        rellenarcombox();
        setFechaHoy();
        rellenarcasillas();
    }

    public void registrar() {
        Proveedor prov = new Proveedor();
        prov = (Proveedor) frm.getCmbcompraReg().getSelectedItem();
        if (prov.getIdproveedor() != -1) {
            if (frm.getjDatefechaCompra().getDate() == null) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha");
                return;
            }
            Date fechaUtil = frm.getjDatefechaCompra().getDate();
            java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());

            if (frm.getTxtpreciocompra().getText() == null || !validacion.esDouble(frm.getTxtpreciocompra().getText())) {
                JOptionPane.showMessageDialog(null, "Valor de precio no aceptado");
                return;
            }
            double precio = Double.parseDouble(frm.getTxtpreciocompra().getText());
            if (precio < 0) {
                JOptionPane.showMessageDialog(null, "Precio no valido");
                return;
            }

            String observaciones = frm.getTxtobservacionescompra().getText();
            Compra compra = new Compra(prov, 0, precio, fechaSql, observaciones);

            ob.guardar(compra);
            setFechaHoy();
            frm.getCmbcompraReg().setSelectedIndex(0);
            rellenarcasillas();
        } else {
            return;
        }
    }

    private void rellenarcombox() {
        DefaultComboBoxModel<Proveedor> modelo = new DefaultComboBoxModel<>();
        proveedorDAO ob = new proveedorDAO();

        Proveedor dummy = new Proveedor();
        dummy.setIdproveedor(-1);
        dummy.setNombre("Seleccione proveedor...");
        modelo.addElement(dummy);

        List<Proveedor> lista = ob.listarTodos();

        lista.sort(Comparator.comparing(
                p -> p.getNombre().toLowerCase()
        ));

        for (Proveedor p : lista) {
            modelo.addElement(p);
        }

        frm.getCmbcompraReg().setModel(modelo);
        frm.getCmbcompraReg().setSelectedIndex(0);
    }

    @Override
    public void actionPerformed(ActionEvent e
    ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void setFechaHoy() {
        JDateChooser dateChooser= frm.getjDatefechaCompra();
        dateChooser.setDate(new Date());
    }
    
    private void rellenarcasillas() {
        PlaceholderUtil.placeholder(frm.getTxtobservacionescompra(), "No es obligatorio ");
        PlaceholderUtil.placeholder(frm.getTxtpreciocompra(), "Obligatorio");

    }

    private void redirigir() {
        
    }
}
