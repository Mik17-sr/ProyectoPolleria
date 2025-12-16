package com.mycompany.controller;

import com.mycompany.model.Proveedor;
import com.mycompany.vista.FrmPrincipal;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ProveedorController implements ActionListener {

    private FrmPrincipal frm;

    public ProveedorController(FrmPrincipal frm) {
        this.frm = frm;
        frm.getBtnregistrarproveedor().addActionListener(this);
        frm.getCmbnombreEditproveedor().addActionListener(this);
        frm.getBtnEditproveedor().addActionListener(this);
        frm.getBtnagrProvRegistraraComp().addActionListener(this);
        frm.getCmbcompraReg().addActionListener(this);
        frm.getBtnregistrarcompra().addActionListener(this);
        cargarCombos();
        fechaactual();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.getBtnregistrarproveedor()) {
            String nombre = frm.getTxtnombreproveedor().getText();
            String telefono = frm.getTxttelefonoproveedor().getText();
            String direccion = frm.getTxtdireccionproveedor().getText();
            registrar(nombre, telefono, direccion);
        }
        //Rellena los formularios en base al combox
        if (e.getSource() == frm.getCmbnombreEditproveedor()) {
            Proveedor[] lista = consulta();
        }
        if (e.getSource() == frm.getBtnEditproveedor()) {
            String nombre = frm.getTxtnombreEditproveedor().getText();
            String telefono = frm.getTxttelefonoEditproveedor().getText();
            String direccion = frm.getTxtdireccionEditproveedor().getText();
            edit(nombre, telefono, direccion);
        }
        if (e.getSource() == frm.getBtnagrProvRegistraraComp()) {
            CardLayout card = (CardLayout) frm.getPnlCards().getLayout();
            card.show(frm.getPnlCards(), "REG_PROV");
        }
        if (e.getSource() == frm.getCmbcompraReg()) {
            
        }
        if(e.getSource() == frm.getBtnregistrarcompra()){
            registrarcompra();
        }
    }

    public void registrar(String nombre, String telefono, String direccion) {

    }

    public void edit(String nombre, String telefono, String direccion) {

    }

    public Proveedor[] consulta() {
        Proveedor[] proveedorlist = null;
        return proveedorlist;
    }

    private void cargarCombos() {

    }

    private void fechaactual() {
        Date fecha = new Date(); // hoy
        frm.getjDatefechaCompra().setDate(fecha);
    }

    private void registrarcompra() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
