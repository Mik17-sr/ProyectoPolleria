package com.mycompany.controller;

import com.mycompany.vista.FrmPrincipal;

public class ProveedorController {
    private FrmPrincipal frm;

    public ProveedorController() {
        super();
    }
    
    public ProveedorController(FrmPrincipal frm) {
        this.frm = frm;
    }

    public FrmPrincipal getFrm() {
        return frm;
    }

    public void setFrm(FrmPrincipal frm) {
        this.frm = frm;
    }
    
    
    
}
