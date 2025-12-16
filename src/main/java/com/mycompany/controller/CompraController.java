package com.mycompany.controller;

import com.mycompany.vista.FrmPrincipal;

public class CompraController {
    private FrmPrincipal frm;

    public CompraController() {
        super();
    }
    
    public CompraController(FrmPrincipal frm) {
        this.frm = frm;
    }

    public FrmPrincipal getFrm() {
        return frm;
    }

    public void setFrm(FrmPrincipal frm) {
        this.frm = frm;
    }
}
