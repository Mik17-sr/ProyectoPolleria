package com.mycompany.controller;

import com.mycompany.Utility.guardarBD;
import com.mycompany.vista.FrmPrincipal;
import javax.swing.JFrame;

public class Controller {
    private FrmPrincipal frm;


    public Controller(){
        this.frm = new FrmPrincipal();
        initEventos();
        new ProveedorController(frm);
        new ClienteController(frm);
        new CompraController(frm);
        new VentaController(frm);
        new PagoController(frm);
    }
    
    public Controller(FrmPrincipal frm) {
        this.frm = frm;
    }

    public FrmPrincipal getFrm() {
        return frm;
    }

    public void setFrm(FrmPrincipal frm) {
        this.frm = frm;
    }
    
    public void iniciar(){
        frm.setTitle("Aplicacion polleria");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.setResizable(false);
        frm.setVisible(true);
    }
    private void initEventos(){
        frm.getBtnSdInicio().addActionListener(e->frm.mostrarCard(FrmPrincipal.CARD_INICIO));
        frm.getBtnSdRegCompra().addActionListener(e->frm.mostrarCard(FrmPrincipal.CARD_REG_COMPRA));
        frm.getBtnSdRegVenta().addActionListener(e->frm.mostrarCard(FrmPrincipal.CARD_REG_VENTA));
        frm.getBtnSdEditProv().addActionListener(e->frm.mostrarCard(FrmPrincipal.CARD_EDIT_PROV));
        frm.getBtnSdEditClient().addActionListener(e->frm.mostrarCard(FrmPrincipal.CARD_EDIT_CLIENT));
        frm.getBtnSdVerVentas().addActionListener(e->frm.mostrarCard(FrmPrincipal.CARD_VER_VENTAS));
        frm.getBtnSdVerCompras().addActionListener(e->frm.mostrarCard(FrmPrincipal.CARD_VER_COMPRAS));
        frm.getBtnSdInsertarPago().addActionListener(e->frm.mostrarCard(FrmPrincipal.CARD_INS_PAGO));
        frm.getBtnDB().addActionListener(e->guardarBD.descargar());
    }    
}
