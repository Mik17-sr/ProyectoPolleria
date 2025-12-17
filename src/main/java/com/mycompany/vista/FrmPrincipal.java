package com.mycompany.vista;

import com.mycompany.forms.PanelRound;
import com.mycompany.model.Proveedor;
import com.toedter.calendar.JDateChooser;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author Miguel
 */
public class FrmPrincipal extends javax.swing.JFrame {
    
    private CardLayout cardLayout;
    
    public static final String CARD_INICIO = "INICIO";
    public static final String CARD_REG_CLIENT = "REG_CLIENT";
    public static final String CARD_REG_PROV = "REG_PROV";
    public static final String CARD_REG_COMPRA = "REG_COMPRA";
    public static final String CARD_REG_VENTA = "REG_VENTA";
    public static final String CARD_EDIT_PROV = "EDIT_PROV";
    public static final String CARD_EDIT_CLIENT = "EDIT_CLIENT";
    
    public FrmPrincipal() {
        initComponents();
        
        cardLayout = (CardLayout) pnlCards.getLayout();
    }

    public JButton getBtnEditproveedor() {
        return btnEditproveedor;
    }

    public void setBtnEditproveedor(JButton btnEditproveedor) {
        this.btnEditproveedor = btnEditproveedor;
    }

    public JComboBox<Proveedor> getCmbnombreEditproveedor() {
        return cmbnombreEditproveedor;
    }

    public void setCmbnombreEditproveedor(JComboBox<Proveedor> cmbnombreEditproveedor) {
        this.cmbnombreEditproveedor = cmbnombreEditproveedor;
    }



    public JTextField getTxtdireccionEditproveedor() {
        return txtdireccionEditproveedor;
    }

    public void setTxtdireccionEditproveedor(JTextField txtdireccionEditproveedor) {
        this.txtdireccionEditproveedor = txtdireccionEditproveedor;
    }

    public JTextField getTxtnombreEditproveedor() {
        return txtnombreEditproveedor;
    }

    public void setTxtnombreEditproveedor(JTextField txtnombreEditproveedor) {
        this.txtnombreEditproveedor = txtnombreEditproveedor;
    }

    public JTextField getTxttelefonoEditproveedor() {
        return txttelefonoEditproveedor;
    }

    public void setTxttelefonoEditproveedor(JTextField txttelefonoEditproveedor) {
        this.txttelefonoEditproveedor = txttelefonoEditproveedor;
    }

    public JButton getBtnregistrarproveedor() {
        return btnregistrarproveedor;
    }

    public void setBtnregistrarproveedor(JButton btnregistrarproveedor) {
        this.btnregistrarproveedor = btnregistrarproveedor;
    }

    public JTextField getTxtdireccionproveedor() {
        return txtdireccionproveedor;
    }

    public void setTxtdireccionproveedor(JTextField txtdireccionproveedor) {
        this.txtdireccionproveedor = txtdireccionproveedor;
    }

    public JTextField getTxtnombreproveedor() {
        return txtnombreproveedor;
    }

    public void setTxtnombreproveedor(JTextField txtnombreproveedor) {
        this.txtnombreproveedor = txtnombreproveedor;
    }

    public JTextField getTxttelefonoproveedor() {
        return txttelefonoproveedor;
    }

    public void setTxttelefonoproveedor(JTextField txttelefonoproveedor) {
        this.txttelefonoproveedor = txttelefonoproveedor;
    }
    
    public void mostrarCard(String nombreCard) {
        System.out.println("Mostrando card: " + nombreCard);
        cardLayout.show(pnlCards, nombreCard);
        pnlCards.revalidate();
        pnlCards.repaint();
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public JPanel getBackgrounda() {
        return background;
    }

    public void setBackground(JPanel background) {
        this.background = background;
    }

    public JButton getBtnCrearNuevoPedido() {
        return btnCrearNuevoPedido;
    }

    public void setBtnCrearNuevoPedido(JButton btnCrearNuevoPedido) {
        this.btnCrearNuevoPedido = btnCrearNuevoPedido;
    }

    public JButton getBtnCrearNuevoPedido1() {
        return btnCrearNuevoPedido1;
    }

    public void setBtnCrearNuevoPedido1(JButton btnCrearNuevoPedido1) {
        this.btnCrearNuevoPedido1 = btnCrearNuevoPedido1;
    }

    public JButton getBtnCrearNuevoPedido2() {
        return btnregistrarcompra;
    }

    public void setBtnCrearNuevoPedido2(JButton btnCrearNuevoPedido2) {
        this.btnregistrarcompra = btnCrearNuevoPedido2;
    }

    public JButton getBtnSdEditClient() {
        return btnSdEditClient;
    }

    public void setBtnSdEditClient(JButton btnSdEditClient) {
        this.btnSdEditClient = btnSdEditClient;
    }

    public JButton getBtnSdEditProv() {
        return btnSdEditProv;
    }

    public void setBtnSdEditProv(JButton btnSdEditProv) {
        this.btnSdEditProv = btnSdEditProv;
    }
    
    public JButton getBtnSdInicio() {
        return btnSdInicio;
    }

    public void setBtnSdInicio(JButton btnSdInicio) {
        this.btnSdInicio = btnSdInicio;
    }

    public JButton getBtnSdRegClient() {
        return btnSdRegClient;
    }

    public void setBtnSdRegClient(JButton btnSdRegClient) {
        this.btnSdRegClient = btnSdRegClient;
    }

    public JButton getBtnSdRegCompra() {
        return btnSdRegCompra;
    }

    public void setBtnSdRegCompra(JButton btnSdRegCompra) {
        this.btnSdRegCompra = btnSdRegCompra;
    }

    public JButton getBtnSdRegProv() {
        return btnSdRegProv;
    }

    public void setBtnSdRegProv(JButton btnSdRegProv) {
        this.btnSdRegProv = btnSdRegProv;
    }

    public JButton getBtnSdRegVenta() {
        return btnSdRegVenta;
    }

    public void setBtnSdRegVenta(JButton btnSdRegVenta) {
        this.btnSdRegVenta = btnSdRegVenta;
    }

    public JButton getBtnregistrarcliente() {
        return btnregistrarproveedor;
    }

    public void setBtnregistrarcliente(JButton btnregistrarcliente) {
        this.btnregistrarproveedor = btnregistrarcliente;
    }

    public JButton getBtnregistrarcliente1() {
        return btnregistrarcliente1;
    }

    public void setBtnregistrarcliente1(JButton btnregistrarcliente1) {
        this.btnregistrarcliente1 = btnregistrarcliente1;
    }

    public JButton getBtnregistrarcliente2() {
        return btnEditproveedor;
    }

    public void setBtnregistrarcliente2(JButton btnregistrarcliente2) {
        this.btnEditproveedor = btnregistrarcliente2;
    }

    public JButton getBtnregistrarcliente3() {
        return btnregistrarcliente3;
    }

    public void setBtnregistrarcliente3(JButton btnregistrarcliente3) {
        this.btnregistrarcliente3 = btnregistrarcliente3;
    }

    public JComboBox<String> getCmbcliente() {
        return cmbcliente;
    }

    public void setCmbcliente(JComboBox<String> cmbcliente) {
        this.cmbcliente = cmbcliente;
    }




    public JComboBox<String> getCmbcliente3() {
        return cmbcliente3;
    }

    public void setCmbcliente3(JComboBox<String> cmbcliente3) {
        this.cmbcliente3 = cmbcliente3;
    }

    public JPanel getEditarCliente() {
        return editarCliente;
    }

    public void setEditarCliente(JPanel editarCliente) {
        this.editarCliente = editarCliente;
    }

    public JPanel getEditarProveedor() {
        return editarProveedor;
    }

    public void setEditarProveedor(JPanel editarProveedor) {
        this.editarProveedor = editarProveedor;
    }

    public JDateChooser getjDateChooser1() {
        return jDateChooser1;
    }

    public void setjDateChooser1(JDateChooser jDateChooser1) {
        this.jDateChooser1 = jDateChooser1;
    }

    public JDateChooser getjDateChooser2() {
        return jDatefechaCompra;
    }

    public void setjDateChooser2(JDateChooser jDateChooser2) {
        this.jDatefechaCompra = jDateChooser2;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JLabel getjLabel11() {
        return jLabel11;
    }

    public void setjLabel11(JLabel jLabel11) {
        this.jLabel11 = jLabel11;
    }

    public JLabel getjLabel12() {
        return jLabel12;
    }

    public void setjLabel12(JLabel jLabel12) {
        this.jLabel12 = jLabel12;
    }

    public JLabel getjLabel13() {
        return jLabel13;
    }

    public void setjLabel13(JLabel jLabel13) {
        this.jLabel13 = jLabel13;
    }

    public JLabel getjLabel14() {
        return jLabel14;
    }

    public void setjLabel14(JLabel jLabel14) {
        this.jLabel14 = jLabel14;
    }

    public JLabel getjLabel16() {
        return jLabel16;
    }

    public void setjLabel16(JLabel jLabel16) {
        this.jLabel16 = jLabel16;
    }

    public JLabel getjLabel17() {
        return jLabel17;
    }

    public void setjLabel17(JLabel jLabel17) {
        this.jLabel17 = jLabel17;
    }

    public JLabel getjLabel18() {
        return jLabel18;
    }

    public void setjLabel18(JLabel jLabel18) {
        this.jLabel18 = jLabel18;
    }

    public JLabel getjLabel19() {
        return jLabel19;
    }

    public void setjLabel19(JLabel jLabel19) {
        this.jLabel19 = jLabel19;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel21() {
        return jLabel21;
    }

    public void setjLabel21(JLabel jLabel21) {
        this.jLabel21 = jLabel21;
    }

    public JLabel getjLabel22() {
        return jLabel22;
    }

    public void setjLabel22(JLabel jLabel22) {
        this.jLabel22 = jLabel22;
    }

    public JLabel getjLabel23() {
        return jLabel23;
    }

    public void setjLabel23(JLabel jLabel23) {
        this.jLabel23 = jLabel23;
    }

    public JLabel getjLabel24() {
        return jLabel24;
    }

    public void setjLabel24(JLabel jLabel24) {
        this.jLabel24 = jLabel24;
    }

    public JLabel getjLabel25() {
        return jLabel25;
    }

    public void setjLabel25(JLabel jLabel25) {
        this.jLabel25 = jLabel25;
    }

    public JLabel getjLabel26() {
        return jLabel26;
    }

    public void setjLabel26(JLabel jLabel26) {
        this.jLabel26 = jLabel26;
    }

    public JLabel getjLabel27() {
        return jLabel27;
    }

    public void setjLabel27(JLabel jLabel27) {
        this.jLabel27 = jLabel27;
    }

    public JLabel getjLabel28() {
        return jLabel28;
    }

    public void setjLabel28(JLabel jLabel28) {
        this.jLabel28 = jLabel28;
    }

    public JLabel getjLabel29() {
        return jLabel29;
    }

    public void setjLabel29(JLabel jLabel29) {
        this.jLabel29 = jLabel29;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel30() {
        return jLabel30;
    }

    public void setjLabel30(JLabel jLabel30) {
        this.jLabel30 = jLabel30;
    }

    public JLabel getjLabel31() {
        return jLabel31;
    }

    public void setjLabel31(JLabel jLabel31) {
        this.jLabel31 = jLabel31;
    }

    public JLabel getjLabel32() {
        return jLabel32;
    }

    public void setjLabel32(JLabel jLabel32) {
        this.jLabel32 = jLabel32;
    }

    public JLabel getjLabel33() {
        return jLabel33;
    }

    public void setjLabel33(JLabel jLabel33) {
        this.jLabel33 = jLabel33;
    }

    public JLabel getjLabel34() {
        return jLabel34;
    }

    public void setjLabel34(JLabel jLabel34) {
        this.jLabel34 = jLabel34;
    }

    public JLabel getjLabel35() {
        return jLabel35;
    }

    public void setjLabel35(JLabel jLabel35) {
        this.jLabel35 = jLabel35;
    }

    public JLabel getjLabel36() {
        return jLabel36;
    }

    public void setjLabel36(JLabel jLabel36) {
        this.jLabel36 = jLabel36;
    }

    public JLabel getjLabel37() {
        return jLabel37;
    }

    public void setjLabel37(JLabel jLabel37) {
        this.jLabel37 = jLabel37;
    }

    public JLabel getjLabel38() {
        return jLabel38;
    }

    public void setjLabel38(JLabel jLabel38) {
        this.jLabel38 = jLabel38;
    }

    public JLabel getjLabel39() {
        return jLabel39;
    }

    public void setjLabel39(JLabel jLabel39) {
        this.jLabel39 = jLabel39;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel40() {
        return jLabel40;
    }

    public void setjLabel40(JLabel jLabel40) {
        this.jLabel40 = jLabel40;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public void setjScrollPane3(JScrollPane jScrollPane3) {
        this.jScrollPane3 = jScrollPane3;
    }

    public JScrollPane getjScrollPane4() {
        return jScrollPane4;
    }

    public void setjScrollPane4(JScrollPane jScrollPane4) {
        this.jScrollPane4 = jScrollPane4;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    public JTable getjTable2() {
        return jTable2;
    }

    public void setjTable2(JTable jTable2) {
        this.jTable2 = jTable2;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    public JTextField getjTextField2() {
        return txtpreciocompra;
    }

    public void setjTextField2(JTextField jTextField2) {
        this.txtpreciocompra = jTextField2;
    }

    public JLabel getLblPollo1() {
        return lblPollo1;
    }

    public void setLblPollo1(JLabel lblPollo1) {
        this.lblPollo1 = lblPollo1;
    }

    public JLabel getLblPollo2() {
        return lblPollo2;
    }

    public void setLblPollo2(JLabel lblPollo2) {
        this.lblPollo2 = lblPollo2;
    }

    public JLabel getLblPollo3() {
        return lblPollo3;
    }

    public void setLblPollo3(JLabel lblPollo3) {
        this.lblPollo3 = lblPollo3;
    }

    public JLabel getLblPollo4() {
        return lblPollo4;
    }

    public void setLblPollo4(JLabel lblPollo4) {
        this.lblPollo4 = lblPollo4;
    }

    public JLabel getLblPollo5() {
        return lblPollo5;
    }

    public void setLblPollo5(JLabel lblPollo5) {
        this.lblPollo5 = lblPollo5;
    }

    public JLabel getLblPollo6() {
        return lblPollo6;
    }

    public void setLblPollo6(JLabel lblPollo6) {
        this.lblPollo6 = lblPollo6;
    }

    public JLabel getLblPollo7() {
        return lblPollo7;
    }

    public void setLblPollo7(JLabel lblPollo7) {
        this.lblPollo7 = lblPollo7;
    }

    public PanelRound getPanelRound1() {
        return panelRound1;
    }

    public void setPanelRound1(PanelRound panelRound1) {
        this.panelRound1 = panelRound1;
    }

    public JPanel getPnlCards() {
        return pnlCards;
    }

    public void setPnlCards(JPanel pnlCards) {
        this.pnlCards = pnlCards;
    }

    public JPanel getRegistrarCliente() {
        return registrarCliente;
    }

    public void setRegistrarCliente(JPanel registrarCliente) {
        this.registrarCliente = registrarCliente;
    }

    public JPanel getRegistrarCompra() {
        return registrarCompra;
    }

    public void setRegistrarCompra(JPanel registrarCompra) {
        this.registrarCompra = registrarCompra;
    }

    public JPanel getRegistrarProveedor() {
        return registrarProveedor;
    }

    public void setRegistrarProveedor(JPanel registrarProveedor) {
        this.registrarProveedor = registrarProveedor;
    }

    public JPanel getRegistrarVenta() {
        return registrarVenta;
    }

    public void setRegistrarVenta(JPanel registrarVenta) {
        this.registrarVenta = registrarVenta;
    }

    public JPanel getSideBar() {
        return sideBar;
    }

    public void setSideBar(JPanel sideBar) {
        this.sideBar = sideBar;
    }

    public JTextField getTxtdireccioncliente() {
        return txtdireccionproveedor;
    }

    public void setTxtdireccioncliente(JTextField txtdireccioncliente) {
        this.txtdireccionproveedor = txtdireccioncliente;
    }

    public JTextField getTxtdireccioncliente1() {
        return txtdireccioncliente1;
    }

    public void setTxtdireccioncliente1(JTextField txtdireccioncliente1) {
        this.txtdireccioncliente1 = txtdireccioncliente1;
    }

    public JTextField getTxtdireccioncliente2() {
        return txtdireccionEditproveedor;
    }

    public void setTxtdireccioncliente2(JTextField txtdireccioncliente2) {
        this.txtdireccionEditproveedor = txtdireccioncliente2;
    }

    public JTextField getTxtdireccioncliente3() {
        return txtdireccioncliente3;
    }

    public void setTxtdireccioncliente3(JTextField txtdireccioncliente3) {
        this.txtdireccioncliente3 = txtdireccioncliente3;
    }

    public JTextField getTxtnombrecliente() {
        return txtnombreproveedor;
    }

    public void setTxtnombrecliente(JTextField txtnombrecliente) {
        this.txtnombreproveedor = txtnombrecliente;
    }

    public JTextField getTxtnombrecliente1() {
        return txtnombrecliente1;
    }

    public void setTxtnombrecliente1(JTextField txtnombrecliente1) {
        this.txtnombrecliente1 = txtnombrecliente1;
    }

    public JTextField getTxtnombrecliente2() {
        return txtnombreEditproveedor;
    }

    public void setTxtnombrecliente2(JTextField txtnombrecliente2) {
        this.txtnombreEditproveedor = txtnombrecliente2;
    }

    public JTextField getTxtnombrecliente3() {
        return txtnombrecliente3;
    }

    public void setTxtnombrecliente3(JTextField txtnombrecliente3) {
        this.txtnombrecliente3 = txtnombrecliente3;
    }

    public JTextPane getTxtobservacionescliente() {
        return txtobservacionescliente;
    }

    public void setTxtobservacionescliente(JTextPane txtobservacionescliente) {
        this.txtobservacionescliente = txtobservacionescliente;
    }

    public JTextPane getTxtobservacionescliente1() {
        return txtobservacionescompra;
    }

    public void setTxtobservacionescliente1(JTextPane txtobservacionescliente1) {
        this.txtobservacionescompra = txtobservacionescliente1;
    }

    public JTextField getTxttelefonocliente() {
        return txttelefonoproveedor;
    }

    public void setTxttelefonocliente(JTextField txttelefonocliente) {
        this.txttelefonoproveedor = txttelefonocliente;
    }

    public JTextField getTxttelefonocliente1() {
        return txttelefonocliente1;
    }

    public void setTxttelefonocliente1(JTextField txttelefonocliente1) {
        this.txttelefonocliente1 = txttelefonocliente1;
    }

    public JTextField getTxttelefonocliente2() {
        return txttelefonoEditproveedor;
    }

    public void setTxttelefonocliente2(JTextField txttelefonocliente2) {
        this.txttelefonoEditproveedor = txttelefonocliente2;
    }

    public JTextField getTxttelefonocliente3() {
        return txttelefonocliente3;
    }

    public void setTxttelefonocliente3(JTextField txttelefonocliente3) {
        this.txttelefonocliente3 = txttelefonocliente3;
    }

    public JPanel getVistaInicio() {
        return vistaInicio;
    }

    public void setVistaInicio(JPanel vistaInicio) {
        this.vistaInicio = vistaInicio;
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        sideBar = new javax.swing.JPanel();
        btnSdInicio = new javax.swing.JButton();
        btnSdRegProv = new javax.swing.JButton();
        btnSdRegClient = new javax.swing.JButton();
        btnSdEditProv = new javax.swing.JButton();
        btnSdEditClient = new javax.swing.JButton();
        btnSdRegCompra = new javax.swing.JButton();
        btnSdRegVenta = new javax.swing.JButton();
        lblPollo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnlCards = new javax.swing.JPanel();
        vistaInicio = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        panelRound1 = new com.mycompany.forms.PanelRound();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnCrearNuevoPedido = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        registrarCliente = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtnombrecliente1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txttelefonocliente1 = new javax.swing.JTextField();
        txtdireccioncliente1 = new javax.swing.JTextField();
        btnregistrarcliente1 = new javax.swing.JButton();
        lblPollo2 = new javax.swing.JLabel();
        registrarProveedor = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnombreproveedor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txttelefonoproveedor = new javax.swing.JTextField();
        txtdireccionproveedor = new javax.swing.JTextField();
        btnregistrarproveedor = new javax.swing.JButton();
        lblPollo3 = new javax.swing.JLabel();
        registrarCompra = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtobservacionescompra = new javax.swing.JTextPane();
        cmbcompraReg = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        lblPollo4 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        btnregistrarcompra = new javax.swing.JButton();
        jDatefechaCompra = new com.toedter.calendar.JDateChooser();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtpreciocompra = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        btnagrProvRegistraraComp = new javax.swing.JButton();
        registrarVenta = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtobservacionescliente = new javax.swing.JTextPane();
        cmbcliente = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        lblPollo5 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnCrearNuevoPedido1 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        editarProveedor = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtnombreEditproveedor = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txttelefonoEditproveedor = new javax.swing.JTextField();
        txtdireccionEditproveedor = new javax.swing.JTextField();
        btnEditproveedor = new javax.swing.JButton();
        lblPollo6 = new javax.swing.JLabel();
        cmbnombreEditproveedor = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        editarCliente = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtnombrecliente3 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txttelefonocliente3 = new javax.swing.JTextField();
        txtdireccioncliente3 = new javax.swing.JTextField();
        btnregistrarcliente3 = new javax.swing.JButton();
        lblPollo7 = new javax.swing.JLabel();
        cmbcliente3 = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sideBar.setPreferredSize(new java.awt.Dimension(200, 0));
        sideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSdInicio.setText("Inicio");
        btnSdInicio.setToolTipText("");
        sideBar.add(btnSdInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 115, 180, -1));

        btnSdRegProv.setText("Registrar Proveedor");
        btnSdRegProv.setToolTipText("");
        sideBar.add(btnSdRegProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 148, 180, -1));

        btnSdRegClient.setText("Registrar Cliente");
        btnSdRegClient.setToolTipText("");
        sideBar.add(btnSdRegClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 181, 180, -1));

        btnSdEditProv.setText("Editar Proveedor");
        btnSdEditProv.setToolTipText("");
        sideBar.add(btnSdEditProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 214, 180, -1));

        btnSdEditClient.setText("Editar Cliente");
        btnSdEditClient.setToolTipText("");
        sideBar.add(btnSdEditClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 247, 180, -1));

        btnSdRegCompra.setText("Registrar Compra");
        btnSdRegCompra.setToolTipText("");
        sideBar.add(btnSdRegCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 280, 180, -1));

        btnSdRegVenta.setText("Registrar Venta");
        btnSdRegVenta.setToolTipText("");
        sideBar.add(btnSdRegVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 313, 180, -1));

        lblPollo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pollo.png"))); // NOI18N
        sideBar.add(lblPollo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        sideBar.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 6, -1, 103));

        pnlCards.setLayout(new java.awt.CardLayout());

        vistaInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        vistaInicio.setMinimumSize(new java.awt.Dimension(630, 530));
        vistaInicio.setPreferredSize(new java.awt.Dimension(630, 530));
        vistaInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pollo.png"))); // NOI18N
        vistaInicio.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, -1));

        panelRound1.setBackground(new java.awt.Color(237, 238, 242));
        panelRound1.setForeground(new java.awt.Color(237, 238, 242));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(33, 32, 30));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Informacion");
        panelRound1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 170, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Proveedor", "Proveedor", "Teléfono"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        panelRound1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 570, 80));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(33, 32, 30));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Proveedores");
        panelRound1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 170, 30));

        jLabel11.setForeground(new java.awt.Color(179, 179, 179));
        jLabel11.setText("Nombre Empresa Pollo");
        panelRound1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        jLabel12.setForeground(new java.awt.Color(179, 179, 179));
        jLabel12.setText("pollo@gmail.com");
        panelRound1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        jLabel13.setForeground(new java.awt.Color(179, 179, 179));
        jLabel13.setText("+57 315 124 1235");
        panelRound1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(33, 32, 30));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Pedidos Recientes");
        panelRound1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 30));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Pedido", "Cliente", "Estado", "Total"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        panelRound1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 570, 80));

        btnCrearNuevoPedido.setBackground(new java.awt.Color(245, 121, 0));
        btnCrearNuevoPedido.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnCrearNuevoPedido.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearNuevoPedido.setText("Crear Nuevo Pedido");
        panelRound1.add(btnCrearNuevoPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 190, 30));

        vistaInicio.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 590, 360));

        jLabel7.setFont(new java.awt.Font("Gotham", 1, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Panel de Control");
        vistaInicio.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 630, 50));

        pnlCards.add(vistaInicio, "INICIO");

        registrarCliente.setMinimumSize(new java.awt.Dimension(630, 530));
        registrarCliente.setPreferredSize(new java.awt.Dimension(630, 530));
        registrarCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Gotham", 1, 36)); // NOI18N
        jLabel18.setText("Registrar Cliente");
        registrarCliente.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 118, -1, 48));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel25.setText("Nombre:");
        registrarCliente.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 189, -1, -1));
        registrarCliente.add(txtnombrecliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 189, 480, 32));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel26.setText("Teléfono:");
        registrarCliente.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 285, -1, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel27.setText("Direccion");
        registrarCliente.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 398, -1, -1));
        registrarCliente.add(txttelefonocliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 290, 480, 32));
        registrarCliente.add(txtdireccioncliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 398, 480, 32));

        btnregistrarcliente1.setBackground(new java.awt.Color(245, 121, 0));
        btnregistrarcliente1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnregistrarcliente1.setForeground(new java.awt.Color(255, 255, 255));
        btnregistrarcliente1.setText("Registrar");
        btnregistrarcliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarcliente1ActionPerformed(evt);
            }
        });
        registrarCliente.add(btnregistrarcliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 136, -1));

        lblPollo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pollo.png"))); // NOI18N
        registrarCliente.add(lblPollo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 100, -1));

        pnlCards.add(registrarCliente, "REG_CLIENT");

        registrarProveedor.setMinimumSize(new java.awt.Dimension(630, 530));
        registrarProveedor.setPreferredSize(new java.awt.Dimension(630, 530));
        registrarProveedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Gotham", 1, 36)); // NOI18N
        jLabel2.setText("Registrar Proveedor");
        registrarProveedor.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, 48));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Nombre:");
        registrarProveedor.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 189, -1, -1));
        registrarProveedor.add(txtnombreproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 189, 480, 32));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Teléfono:");
        registrarProveedor.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 285, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Direccion");
        registrarProveedor.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 398, -1, -1));
        registrarProveedor.add(txttelefonoproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 290, 480, 32));
        registrarProveedor.add(txtdireccionproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 398, 480, 32));

        btnregistrarproveedor.setBackground(new java.awt.Color(245, 121, 0));
        btnregistrarproveedor.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnregistrarproveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnregistrarproveedor.setText("Registrar");
        btnregistrarproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarproveedorActionPerformed(evt);
            }
        });
        registrarProveedor.add(btnregistrarproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, 136, -1));

        lblPollo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pollo.png"))); // NOI18N
        registrarProveedor.add(lblPollo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 100, -1));

        pnlCards.add(registrarProveedor, "REG_PROV");

        registrarCompra.setMinimumSize(new java.awt.Dimension(630, 530));
        registrarCompra.setPreferredSize(new java.awt.Dimension(630, 530));
        registrarCompra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setViewportView(txtobservacionescompra);

        registrarCompra.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 600, 80));

        registrarCompra.add(cmbcompraReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 320, 30));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel28.setText("Observaciones:");
        registrarCompra.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, -1, -1));

        lblPollo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pollo.png"))); // NOI18N
        registrarCompra.add(lblPollo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jLabel29.setFont(new java.awt.Font("Gotham", 1, 36)); // NOI18N
        jLabel29.setText("Registrar Compra");
        registrarCompra.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, 48));

        btnregistrarcompra.setBackground(new java.awt.Color(245, 121, 0));
        btnregistrarcompra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnregistrarcompra.setForeground(new java.awt.Color(255, 255, 255));
        btnregistrarcompra.setText("Registrar Compra");
        btnregistrarcompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarcompraActionPerformed(evt);
            }
        });
        registrarCompra.add(btnregistrarcompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, 170, 30));
        registrarCompra.add(jDatefechaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 450, 30));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel30.setText("Proveedor:");
        registrarCompra.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, -1, -1));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel31.setText("Fecha Compra:");
        registrarCompra.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, -1));
        registrarCompra.add(txtpreciocompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 450, 30));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel32.setText("Precio Compra:");
        registrarCompra.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, -1, -1));

        btnagrProvRegistraraComp.setBackground(new java.awt.Color(245, 121, 0));
        btnagrProvRegistraraComp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnagrProvRegistraraComp.setForeground(new java.awt.Color(255, 255, 255));
        btnagrProvRegistraraComp.setText("Agregar Proveedor");
        registrarCompra.add(btnagrProvRegistraraComp, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 170, 30));

        pnlCards.add(registrarCompra, "REG_COMPRA");

        registrarVenta.setMinimumSize(new java.awt.Dimension(630, 530));
        registrarVenta.setPreferredSize(new java.awt.Dimension(630, 530));
        registrarVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setViewportView(txtobservacionescliente);

        registrarVenta.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 600, 160));

        registrarVenta.add(cmbcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 380, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel19.setText("Observaciones:");
        registrarVenta.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        lblPollo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pollo.png"))); // NOI18N
        registrarVenta.add(lblPollo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jLabel21.setFont(new java.awt.Font("Gotham", 1, 36)); // NOI18N
        jLabel21.setText("Registrar Venta");
        registrarVenta.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, 48));

        btnCrearNuevoPedido1.setBackground(new java.awt.Color(245, 121, 0));
        btnCrearNuevoPedido1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCrearNuevoPedido1.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearNuevoPedido1.setText("Agregar Cliente");
        registrarVenta.add(btnCrearNuevoPedido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 150, 30));
        registrarVenta.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 470, 30));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel22.setText("Cliente:");
        registrarVenta.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel23.setText("Fecha Venta:");
        registrarVenta.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));
        registrarVenta.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 470, 30));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel24.setText("Precio Venta:");
        registrarVenta.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        pnlCards.add(registrarVenta, "REG_VENTA");

        editarProveedor.setMinimumSize(new java.awt.Dimension(630, 530));
        editarProveedor.setPreferredSize(new java.awt.Dimension(630, 530));
        editarProveedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Gotham", 1, 36)); // NOI18N
        jLabel16.setText("Editar Proveedor");
        editarProveedor.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, 48));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel17.setText("Nombre:");
        editarProveedor.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));
        editarProveedor.add(txtnombreEditproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 480, 32));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel33.setText("Teléfono:");
        editarProveedor.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel34.setText("Direccion");
        editarProveedor.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));
        editarProveedor.add(txttelefonoEditproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 480, 32));
        editarProveedor.add(txtdireccionEditproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 480, 32));

        btnEditproveedor.setBackground(new java.awt.Color(245, 121, 0));
        btnEditproveedor.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnEditproveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnEditproveedor.setText("Editar");
        btnEditproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditproveedorActionPerformed(evt);
            }
        });
        editarProveedor.add(btnEditproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 136, -1));

        lblPollo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pollo.png"))); // NOI18N
        editarProveedor.add(lblPollo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 100, -1));

        cmbnombreEditproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbnombreEditproveedorActionPerformed(evt);
            }
        });
        editarProveedor.add(cmbnombreEditproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 480, 30));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel35.setText("Proveedor:");
        editarProveedor.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        pnlCards.add(editarProveedor, "EDIT_PROV");

        editarCliente.setMinimumSize(new java.awt.Dimension(630, 530));
        editarCliente.setPreferredSize(new java.awt.Dimension(630, 530));
        editarCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Gotham", 1, 36)); // NOI18N
        jLabel36.setText("Editar Cliente");
        editarCliente.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, 48));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel37.setText("Nombre:");
        editarCliente.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));
        editarCliente.add(txtnombrecliente3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 480, 32));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel38.setText("Teléfono:");
        editarCliente.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel39.setText("Direccion");
        editarCliente.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));
        editarCliente.add(txttelefonocliente3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 480, 32));
        editarCliente.add(txtdireccioncliente3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 480, 32));

        btnregistrarcliente3.setBackground(new java.awt.Color(245, 121, 0));
        btnregistrarcliente3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnregistrarcliente3.setForeground(new java.awt.Color(255, 255, 255));
        btnregistrarcliente3.setText("Editar");
        btnregistrarcliente3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarcliente3ActionPerformed(evt);
            }
        });
        editarCliente.add(btnregistrarcliente3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 136, -1));

        lblPollo7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pollo.png"))); // NOI18N
        editarCliente.add(lblPollo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 100, -1));

        editarCliente.add(cmbcliente3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 480, 30));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel40.setText("Cliente:");
        editarCliente.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        pnlCards.add(editarCliente, "EDIT_CLIENT");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sideBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        getContentPane().add(background, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnregistrarproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarproveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnregistrarproveedorActionPerformed

    private void btnregistrarcliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarcliente1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnregistrarcliente1ActionPerformed

    private void btnEditproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditproveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditproveedorActionPerformed

    private void btnregistrarcliente3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarcliente3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnregistrarcliente3ActionPerformed

    private void cmbnombreEditproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbnombreEditproveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbnombreEditproveedorActionPerformed

    private void btnregistrarcompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarcompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnregistrarcompraActionPerformed

    public JButton getBtnagrProvRegistraraComp() {
        return btnagrProvRegistraraComp;
    }

    public void setBtnagrProvRegistraraComp(JButton btnagrProvRegistraraComp) {
        this.btnagrProvRegistraraComp = btnagrProvRegistraraComp;
    }

    public JButton getBtnregistrarcompra() {
        return btnregistrarcompra;
    }

    public void setBtnregistrarcompra(JButton btnregistrarcompra) {
        this.btnregistrarcompra = btnregistrarcompra;
    }

    public JComboBox<Proveedor> getCmbcompraReg() {
        return cmbcompraReg;
    }

    public void setCmbcompraReg(JComboBox<Proveedor> cmbcompraReg) {
        this.cmbcompraReg = cmbcompraReg;
    }



    public JDateChooser getjDatefechaCompra() {
        return jDatefechaCompra;
    }

    public void setjDatefechaCompra(JDateChooser jDatefechaCompra) {
        this.jDatefechaCompra = jDatefechaCompra;
    }

    public JTextPane getTxtobservacionescompra() {
        return txtobservacionescompra;
    }

    public void setTxtobservacionescompra(JTextPane txtobservacionescompra) {
        this.txtobservacionescompra = txtobservacionescompra;
    }

    public JTextField getTxtpreciocompra() {
        return txtpreciocompra;
    }

    public void setTxtpreciocompra(JTextField txtpreciocompra) {
        this.txtpreciocompra = txtpreciocompra;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnCrearNuevoPedido;
    private javax.swing.JButton btnCrearNuevoPedido1;
    private javax.swing.JButton btnEditproveedor;
    private javax.swing.JButton btnSdEditClient;
    private javax.swing.JButton btnSdEditProv;
    private javax.swing.JButton btnSdInicio;
    private javax.swing.JButton btnSdRegClient;
    private javax.swing.JButton btnSdRegCompra;
    private javax.swing.JButton btnSdRegProv;
    private javax.swing.JButton btnSdRegVenta;
    private javax.swing.JButton btnagrProvRegistraraComp;
    private javax.swing.JButton btnregistrarcliente1;
    private javax.swing.JButton btnregistrarcliente3;
    private javax.swing.JButton btnregistrarcompra;
    private javax.swing.JButton btnregistrarproveedor;
    private javax.swing.JComboBox<String> cmbcliente;
    private javax.swing.JComboBox<String> cmbcliente3;
    private javax.swing.JComboBox<Proveedor> cmbcompraReg;
    private javax.swing.JComboBox<Proveedor> cmbnombreEditproveedor;
    private javax.swing.JPanel editarCliente;
    private javax.swing.JPanel editarProveedor;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDatefechaCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblPollo1;
    private javax.swing.JLabel lblPollo2;
    private javax.swing.JLabel lblPollo3;
    private javax.swing.JLabel lblPollo4;
    private javax.swing.JLabel lblPollo5;
    private javax.swing.JLabel lblPollo6;
    private javax.swing.JLabel lblPollo7;
    private com.mycompany.forms.PanelRound panelRound1;
    private javax.swing.JPanel pnlCards;
    private javax.swing.JPanel registrarCliente;
    private javax.swing.JPanel registrarCompra;
    private javax.swing.JPanel registrarProveedor;
    private javax.swing.JPanel registrarVenta;
    private javax.swing.JPanel sideBar;
    private javax.swing.JTextField txtdireccionEditproveedor;
    private javax.swing.JTextField txtdireccioncliente1;
    private javax.swing.JTextField txtdireccioncliente3;
    private javax.swing.JTextField txtdireccionproveedor;
    private javax.swing.JTextField txtnombreEditproveedor;
    private javax.swing.JTextField txtnombrecliente1;
    private javax.swing.JTextField txtnombrecliente3;
    private javax.swing.JTextField txtnombreproveedor;
    private javax.swing.JTextPane txtobservacionescliente;
    private javax.swing.JTextPane txtobservacionescompra;
    private javax.swing.JTextField txtpreciocompra;
    private javax.swing.JTextField txttelefonoEditproveedor;
    private javax.swing.JTextField txttelefonocliente1;
    private javax.swing.JTextField txttelefonocliente3;
    private javax.swing.JTextField txttelefonoproveedor;
    private javax.swing.JPanel vistaInicio;
    // End of variables declaration//GEN-END:variables
}
