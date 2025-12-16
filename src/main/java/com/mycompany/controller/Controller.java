package com.mycompany.controller;

import com.mycompany.vista.FrmPrincipal;
import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author Miguel
 */
public class Controller {
    private FrmPrincipal frm;

    public Controller(){
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
        frm = new FrmPrincipal();
        frm.setTitle("Aplicacion polleria");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.setResizable(false);
        frm.setVisible(true);
    }
    
    public void iniciarListener(Container container){
        
    }
    
}
