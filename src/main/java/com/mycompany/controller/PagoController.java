package com.mycompany.controller;

import com.mycompany.vista.FrmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import com.mycompany.model.Venta;
import com.mycompany.model.VentaDAO;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;

public class PagoController implements ActionListener {
    private FrmPrincipal frm;
    private List<Venta> ventas;
    private VentaDAO vtDAO;
    
    public PagoController(FrmPrincipal frm){
        this.frm = frm;
        this.ventas = new ArrayList();
        this.vtDAO = new VentaDAO();
        frm.getCmbVentaPago().addActionListener(this);
        initEventos();
    }
    
    private void initEventos(){
        frm.getBtnSdInsertarPago().addActionListener(e -> {
            cargarVentas();
            listarComboVentas();
            habilitarInsVenta();
        });
    }
    
    private void cargarVentas(){
        ventas = vtDAO.readAll();
    }
    
    private void listarComboVentas(){
        DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>();
        if(ventas.isEmpty()){
            model.addElement("No hay ventas para elegir");
            frm.getCmbVentaPago().setEnabled(false);
        }else{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            NumberFormat formatoCOP = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
            formatoCOP.setMaximumFractionDigits(0);
            model.addElement("Seleccione una venta");
            for(Venta v : ventas){
                model.addElement("Cliente: " + v.getCliente().getNombre() + " por Monto: " + formatoCOP.format(v.getPrecio()) + " realizado el " + sdf.format(v.getFecha()));
            }
            frm.getCmbVentaPago().setEnabled(true);
        }
        frm.getCmbVentaPago().setModel(model);
        frm.getCmbVentaPago().setSelectedIndex(0);
    }
    
    private void habilitarInsVenta(){
        if(!ventas.isEmpty() && frm.getCmbVentaPago().getSelectedIndex() != 0){
            frm.getInsPago().setEnabled(true);
        }else{
            frm.getBtnEditClient().setEnabled(false);
        }
    }
    
    private void cambiarColorFuente(){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(frm.getCmbVentaPago())){
            if(frm.getCmbVentaPago().getSelectedIndex() == 0){
                
            }
        }
    }
}
