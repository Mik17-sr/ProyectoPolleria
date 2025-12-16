package com.mycompany.controller;

import com.mycompany.vista.FrmPrincipal;

public class VentaController {
    private FrmPrincipal frm;

    public VentaController() {
        super();
    }
    
    public VentaController(FrmPrincipal frm) {
        this.frm = frm;
    }

    public FrmPrincipal getFrm() {
        return frm;
    }

    public void setFrm(FrmPrincipal frm) {
        this.frm = frm;
    }
}
