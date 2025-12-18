package com.mycompany.controller;

import com.mycompany.Utility.PlaceholderUtil;
import com.mycompany.model.Cliente;
import com.mycompany.model.ClienteDAO;
import com.mycompany.vista.FrmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mycompany.model.Venta;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class VentaController implements ActionListener {
    private FrmPrincipal frm;
    private List<Cliente> clientes;
    private ClienteDAO clDAO;

    public VentaController() {
        super();
    }
    
    public VentaController(FrmPrincipal frm) {
        this.frm = frm;
        this.clientes = new ArrayList<>();
        this.clDAO = new ClienteDAO();
        frm.getBtnAddVenta().addActionListener(this);
        frm.getBtnRegistrarVenta().addActionListener(this);
        frm.getCmbRegVentaClient().addActionListener(this);
        initEventos();
        rellenarcasillas();
    }

    public FrmPrincipal getFrm() {
        return frm;
    }

    public void setFrm(FrmPrincipal frm) {
        this.frm = frm;
    }
    
    private void initEventos(){
        frm.getBtnSdRegVenta().addActionListener(e -> {
            cargarClientes();
            listarComboVentas();
            habilitarBotonRegVenta();
            setFechaHoy();
        });
    }
    
    private void habilitarBotonRegVenta(){
        if(!clientes.isEmpty() && frm.getCmbRegVentaClient().getSelectedIndex() != 0){
            frm.getBtnRegistrarVenta().setEnabled(true);
        }else{
            frm.getBtnEditClient().setEnabled(false);
        }
    }
    
    private void listarComboVentas(){
        DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>();
        if(clientes.isEmpty()){
            model.addElement("No hay clientes para elegir");
            frm.getCmbRegVentaClient().setEnabled(false);
        }else{
            model.addElement("Seleccione un cliente");
            for(Cliente c : clientes){
                model.addElement(c);
            }
            frm.getCmbRegVentaClient().setEnabled(true);
        }
        frm.getCmbRegVentaClient().setModel(model);
        frm.getCmbRegVentaClient().setSelectedIndex(0);
    }
    
    private void cargarClientes(){
        clientes = clDAO.readAll();
    }
    
    private void resetTextFields(Container con){
        for(Component c : con.getComponents()){
            if(c instanceof JTextField){
                ((JTextField) c).setText("");
            }else if(c instanceof Container){
                resetTextFields((Container) c);
            }
        }
    }
    
    private void rellenarcasillas() {
        PlaceholderUtil.placeholder(frm.getTxtPrecioVenta(), "Obligatorio");
        PlaceholderUtil.placeholder(frm.getTxtObservacionesVenta(), "No es obligatorio");
    }
    
    public void setFechaHoy() {
        frm.getDateFechaVenta().setDate(new Date());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(frm.getCmbRegVentaClient())){
            Object selected = frm.getCmbRegVentaClient().getSelectedItem();
            if(selected instanceof Cliente){
                setFechaHoy();
                frm.getBtnRegistrarVenta().setEnabled(true);
            }else{
                setFechaHoy();
                frm.getBtnRegistrarVenta().setEnabled(false);
                return;
            }
        }
        
        if(e.getSource().equals(frm.getBtnRegistrarVenta())){
            Cliente selected = (Cliente) frm.getCmbCliente().getSelectedItem();
            Venta venta = new Venta();   
            venta.setCliente(selected);
        }
        
        if(e.getSource().equals(frm.getBtnAddVenta())){
            CardLayout card = (CardLayout) frm.getPnlCards().getLayout();
            card.show(frm.getPnlCards(), "REG_CLIENT");
        }
    }
    
    
}
