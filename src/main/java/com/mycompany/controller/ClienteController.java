package com.mycompany.controller;

import com.mycompany.vista.FrmPrincipal;

public class ClienteController {
    private FrmPrincipal frm;

    public ClienteController() {
        super();
    }
    
    public ClienteController(FrmPrincipal frm) {
        this.frm = frm;
    }

    public FrmPrincipal getFrm() {
        return frm;
    }

    public void setFrm(FrmPrincipal frm) {
        this.frm = frm;
    }
}
