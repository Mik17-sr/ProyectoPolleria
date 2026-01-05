package com.mycompany.vista;

import com.mycompany.forms.PanelRound;
import com.mycompany.model.Proveedor;
import com.toedter.calendar.JDateChooser;
import java.awt.CardLayout;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;


public class FrmPrincipal extends javax.swing.JFrame {
    
    private CardLayout cardLayout;
    
    public static final String CARD_INICIO = "INICIO";
    public static final String CARD_REG_CLIENT = "REG_CLIENT";
    public static final String CARD_REG_PROV = "REG_PROV";
    public static final String CARD_REG_COMPRA = "REG_COMPRA";
    public static final String CARD_REG_VENTA = "REG_VENTA";
    public static final String CARD_EDIT_PROV = "EDIT_PROV";
    public static final String CARD_EDIT_CLIENT = "EDIT_CLIENT";
    public static final String CARD_VER_COMPRAS = "VER_COMPRAS";
    public static final String CARD_VER_VENTAS = "VER_VENTAS";
    public static final String CARD_INS_PAGO = "INS_PAGO";
    
    public FrmPrincipal() {
        initComponents();
        NumberFormat formatoCOP = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
        formatoCOP.setMaximumFractionDigits(0);

        NumberFormatter formatter = new NumberFormatter(formatoCOP);
        formatter.setAllowsInvalid(false); 
        formatter.setMinimum(0);           
        DefaultFormatterFactory factory =
            new DefaultFormatterFactory(formatter);

        txtPrecioVenta.setFormatterFactory(factory);
        txtPrecioCompra.setFormatterFactory(factory);
        txtMontoPago.setFormatterFactory(factory);

        txtPrecioVenta.setValue(0);
        txtPrecioCompra.setValue(0);
        txtMontoPago.setValue(0);

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

    public JButton getBtnAddVenta() {
        return btnAddVenta;
    }

    public void setBtnAddVenta(JButton btnAddVenta) {
        this.btnAddVenta = btnAddVenta;
    }

    public JButton getBtnRegistrarVenta() {
        return btnRegistrarVenta;
    }

    public void setBtnRegistrarVenta(JButton btnRegistrarVenta) {
        this.btnRegistrarVenta = btnRegistrarVenta;
    }

    public JButton getBtnCrearNuevoPedido2() {
        return btnregistrarcompra;
    }

    public void setBtnCrearNuevoPedido2(JButton btnCrearNuevoPedido2) {
        this.btnregistrarcompra = btnCrearNuevoPedido2;
    }

    public JButton getBtnSdEditClient() {
        return btnSdEditClient1;
    }

    public void setBtnSdEditClient(JButton btnSdEditClient) {
        this.btnSdEditClient1 = btnSdEditClient;
    }

    public JButton getBtnSdEditProv() {
        return btnSdEditProv1;
    }

    public void setBtnSdEditProv(JButton btnSdEditProv) {
        this.btnSdEditProv1 = btnSdEditProv;
    }

    public JButton getBtnSdInicio() {
        return btnSdInicio;
    }

    public void setBtnSdInicio(JButton btnSdInicio) {
        this.btnSdInicio = btnSdInicio;
    }



    public JButton getBtnSdRegCompra() {
        return btnSdRegCompra;
    }

    public void setBtnSdRegCompra(JButton btnSdRegCompra) {
        this.btnSdRegCompra = btnSdRegCompra;
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

    public JButton getBtnRegistrarCliente() {
        return btnRegistrarCliente;
    }

    public void setBtnRegistrarCliente(JButton btnRegistrarCliente) {
        this.btnRegistrarCliente = btnRegistrarCliente;
    }

    public JButton getBtnregistrarcliente2() {
        return btnEditproveedor;
    }

    public void setBtnregistrarcliente2(JButton btnregistrarcliente2) {
        this.btnEditproveedor = btnregistrarcliente2;
    }

    public JButton getBtnEditClient() {
        return btnEditClient;
    }

    public void setBtnEditClient(JButton btnEditClient) {
        this.btnEditClient = btnEditClient;
    }

    public JComboBox<Object> getCmbRegVentaClient() {
        return cmbRegVentaClient;
    }

    public void setCmbRegVentaClient(JComboBox<Object> cmbRegVentaClient) {
        this.cmbRegVentaClient = cmbRegVentaClient;
    }
    
    

    public JComboBox<Proveedor> getCmbcompraReg() {
        return cmbcompraReg;
    }

    public void setCmbcompraReg(JComboBox<Proveedor> cmbcompraReg) {
        this.cmbcompraReg = cmbcompraReg;
    }

    public JComboBox<Object> getCmbCliente() {
        return cmbCliente;
    }

    public void setCmbCliente(JComboBox<Object> cmbCliente) {
        this.cmbCliente = cmbCliente;
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

    public JDateChooser getDateFechaVenta() {
        return dateFechaVenta;
    }

    public void setDateFechaVenta(JDateChooser dateFechaVenta) {
        this.dateFechaVenta = dateFechaVenta;
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

    public JFormattedTextField getTxtPrecioCompra() {
        return txtPrecioCompra;
    }

    public void setTxtPrecioCompra(JFormattedTextField txtPrecioCompra) {
        this.txtPrecioCompra = txtPrecioCompra;
    }

    public JFormattedTextField getTxtPrecioVenta() {
        return txtPrecioVenta;
    }

    public void setTxtPrecioVenta(JFormattedTextField txtPrecioVenta) {
        this.txtPrecioVenta = txtPrecioVenta;
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

    public JTextField getTxtDireccionCliente() {
        return txtDireccionCliente;
    }

    public void setTxtDireccionCliente(JTextField txtDireccionCliente) {
        this.txtDireccionCliente = txtDireccionCliente;
    }

    public JTextField getTxtdireccioncliente2() {
        return txtdireccionEditproveedor;
    }

    public void setTxtdireccioncliente2(JTextField txtdireccioncliente2) {
        this.txtdireccionEditproveedor = txtdireccioncliente2;
    }

    public JTextField getTxtEditDirCliente() {
        return txtEditDirCliente;
    }

    public void setTxtEditDirCliente(JTextField txtEditDirCliente) {
        this.txtEditDirCliente = txtEditDirCliente;
    }

    public JTextField getTxtnombrecliente() {
        return txtnombreproveedor;
    }

    public void setTxtnombrecliente(JTextField txtnombrecliente) {
        this.txtnombreproveedor = txtnombrecliente;
    }

    public JTextField getTxtNombreCliente() {
        return txtNombreCliente;
    }

    public void setTxtNombreCliente(JTextField txtNombreCliente) {
        this.txtNombreCliente = txtNombreCliente;
    }

    public JTextField getTxtnombrecliente2() {
        return txtnombreEditproveedor;
    }

    public void setTxtnombrecliente2(JTextField txtnombrecliente2) {
        this.txtnombreEditproveedor = txtnombrecliente2;
    }

    public JTextField getTxtEditNameCliente() {
        return txtEditNameCliente;
    }

    public void setTxtEditNameCliente(JTextField txtEditNameCliente) {
        this.txtEditNameCliente = txtEditNameCliente;
    }

    public JTextPane getTxtObservacionesVenta() {
        return txtObservacionesVenta;
    }

    public void setTxtObservacionesVenta(JTextPane txtObservacionesVenta) {
        this.txtObservacionesVenta = txtObservacionesVenta;
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

    public JTextField getTxtTelefonoCliente() {
        return txtTelefonoCliente;
    }

    public void setTxtTelefonoCliente(JTextField txtTelefonoCliente) {
        this.txtTelefonoCliente = txtTelefonoCliente;
    }

    public JTextField getTxttelefonocliente2() {
        return txttelefonoEditproveedor;
    }

    public void setTxttelefonocliente2(JTextField txttelefonocliente2) {
        this.txttelefonoEditproveedor = txttelefonocliente2;
    }

    public JTextField getTxtEditTelefonoCliente() {
        return txtEditTelefonoCliente;
    }

    public void setTxtEditTelefonoCliente(JTextField txtEditTelefonoCliente) {
        this.txtEditTelefonoCliente = txtEditTelefonoCliente;
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
        btnSdRegCompra = new javax.swing.JButton();
        btnSdRegVenta = new javax.swing.JButton();
        btnSdVerCompras = new javax.swing.JButton();
        btnSdVerVentas = new javax.swing.JButton();
        btnSdInsertarPago = new javax.swing.JButton();
        lblPollo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnDB = new javax.swing.JButton();
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
        txtNombreCliente = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtTelefonoCliente = new javax.swing.JTextField();
        txtDireccionCliente = new javax.swing.JTextField();
        btnRegistrarCliente = new javax.swing.JButton();
        lblPollo2 = new javax.swing.JLabel();
        btnSdEditClient1 = new javax.swing.JButton();
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
        btnSdEditProv1 = new javax.swing.JButton();
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
        jLabel32 = new javax.swing.JLabel();
        btnagrProvRegistraraComp = new javax.swing.JButton();
        txtPrecioCompra = new javax.swing.JFormattedTextField();
        registrarVenta = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObservacionesVenta = new javax.swing.JTextPane();
        cmbRegVentaClient = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        lblPollo5 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnAddVenta = new javax.swing.JButton();
        dateFechaVenta = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnRegistrarVenta = new javax.swing.JButton();
        txtPrecioVenta = new javax.swing.JFormattedTextField();
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
        txtEditNameCliente = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtEditTelefonoCliente = new javax.swing.JTextField();
        txtEditDirCliente = new javax.swing.JTextField();
        btnEditClient = new javax.swing.JButton();
        lblPollo7 = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        verCompras = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblCompras = new javax.swing.JTable();
        jLabel41 = new javax.swing.JLabel();
        lblPollo8 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblTotalCompras = new javax.swing.JLabel();
        verVentas = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        lblPollo9 = new javax.swing.JLabel();
        lblTotalVentas = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        insPago = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        cmbMetodoPago = new javax.swing.JComboBox<>();
        jLabel49 = new javax.swing.JLabel();
        lblPollo11 = new javax.swing.JLabel();
        cmbVentaPago = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        dateFechaPago = new com.toedter.calendar.JDateChooser();
        jLabel52 = new javax.swing.JLabel();
        txtMontoPago = new javax.swing.JFormattedTextField();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtObservacionesPago = new javax.swing.JTextPane();
        panelRound2 = new com.mycompany.forms.PanelRound();
        jSeparator1 = new javax.swing.JSeparator();
        totalVenta1 = new javax.swing.JLabel();
        totalVenta = new javax.swing.JLabel();
        lblSaldoPendiente = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblTotalVenta = new javax.swing.JLabel();
        totalVenta2 = new javax.swing.JLabel();
        lblTotalPagado = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        btnRegistrarPago = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        dashboard = new javax.swing.JPanel();
        clientesDeudores = new com.mycompany.forms.PanelRound();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tableDeudores = new javax.swing.JTable();
        flujoCaja = new com.mycompany.forms.PanelRound();
        jLabel46 = new javax.swing.JLabel();
        cuentasCobrar = new com.mycompany.forms.PanelRound();
        panelRound8 = new com.mycompany.forms.PanelRound();
        jLabel44 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        lblCuentasCobrar = new javax.swing.JLabel();
        detailsCuentasCobrar = new javax.swing.JLabel();
        balanceNeto = new com.mycompany.forms.PanelRound();
        panelRound9 = new com.mycompany.forms.PanelRound();
        jLabel45 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        lblBalanceNeto = new javax.swing.JLabel();
        detailsBalanceNeto = new javax.swing.JLabel();
        pagosProveedores = new com.mycompany.forms.PanelRound();
        panelRound7 = new com.mycompany.forms.PanelRound();
        jLabel43 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        lblPagosProveedores = new javax.swing.JLabel();
        detailsPagosProveedores = new javax.swing.JLabel();
        cobrosTotales = new com.mycompany.forms.PanelRound();
        panelRound5 = new com.mycompany.forms.PanelRound();
        jLabel15 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        detailsCobrosTotales = new javax.swing.JLabel();
        lblCobrosTotales = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel59 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        metodosPago = new com.mycompany.forms.PanelRound();
        jLabel56 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(840, 540));
        setMinimumSize(new java.awt.Dimension(840, 540));

        background.setMaximumSize(new java.awt.Dimension(830, 560));
        background.setMinimumSize(new java.awt.Dimension(830, 560));
        background.setPreferredSize(new java.awt.Dimension(830, 560));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sideBar.setMaximumSize(new java.awt.Dimension(830, 530));
        sideBar.setMinimumSize(new java.awt.Dimension(830, 530));
        sideBar.setPreferredSize(new java.awt.Dimension(830, 530));
        sideBar.setRequestFocusEnabled(false);
        sideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSdInicio.setText("Inicio");
        btnSdInicio.setToolTipText("");
        sideBar.add(btnSdInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 150, -1));

        btnSdRegCompra.setText("Registrar Compra");
        btnSdRegCompra.setToolTipText("");
        sideBar.add(btnSdRegCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 150, -1));

        btnSdRegVenta.setText("Registrar Venta");
        btnSdRegVenta.setToolTipText("");
        sideBar.add(btnSdRegVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 150, -1));

        btnSdVerCompras.setText("Ver Compras");
        btnSdVerCompras.setToolTipText("");
        sideBar.add(btnSdVerCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 150, -1));

        btnSdVerVentas.setText("Ver Ventas");
        btnSdVerVentas.setToolTipText("");
        sideBar.add(btnSdVerVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 150, -1));

        btnSdInsertarPago.setText("Insertar Pago");
        btnSdInsertarPago.setToolTipText("");
        sideBar.add(btnSdInsertarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 150, -1));

        lblPollo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pollo.png"))); // NOI18N
        sideBar.add(lblPollo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
        sideBar.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 6, -1, 103));

        btnDB.setText("DescargarBD");
        btnDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDBActionPerformed(evt);
            }
        });
        sideBar.add(btnDB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 150, -1));

        background.add(sideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 170, 540));

        pnlCards.setMaximumSize(new java.awt.Dimension(660, 540));
        pnlCards.setMinimumSize(new java.awt.Dimension(660, 540));
        pnlCards.setName(""); // NOI18N
        pnlCards.setPreferredSize(new java.awt.Dimension(660, 540));
        pnlCards.setLayout(new java.awt.CardLayout());

        vistaInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        vistaInicio.setMinimumSize(new java.awt.Dimension(620, 530));
        vistaInicio.setPreferredSize(new java.awt.Dimension(620, 530));
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

            },
            new String [] {
                "ID Proveedor", "Proveedor", "Teléfono"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        panelRound1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 590, 80));

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

            },
            new String [] {
                "ID Pedido", "Cliente", "Estado", "Total"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        panelRound1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 590, 80));

        btnCrearNuevoPedido.setBackground(new java.awt.Color(245, 121, 0));
        btnCrearNuevoPedido.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnCrearNuevoPedido.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearNuevoPedido.setText("Crear Nuevo Pedido");
        panelRound1.add(btnCrearNuevoPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 190, 30));

        vistaInicio.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 610, 360));

        jLabel7.setFont(new java.awt.Font("Gotham", 1, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Panel de Control");
        vistaInicio.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 660, 50));

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
        registrarCliente.add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 189, 480, 32));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel26.setText("Teléfono:");
        registrarCliente.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 285, -1, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel27.setText("Direccion");
        registrarCliente.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 398, -1, -1));
        registrarCliente.add(txtTelefonoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 290, 480, 32));
        registrarCliente.add(txtDireccionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 398, 480, 32));

        btnRegistrarCliente.setBackground(new java.awt.Color(245, 121, 0));
        btnRegistrarCliente.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnRegistrarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarCliente.setText("Registrar");
        registrarCliente.add(btnRegistrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 136, -1));

        lblPollo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pollo.png"))); // NOI18N
        registrarCliente.add(lblPollo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 100, -1));

        btnSdEditClient1.setText("Editar Cliente");
        btnSdEditClient1.setToolTipText("");
        registrarCliente.add(btnSdEditClient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 126, -1));

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
        registrarProveedor.add(btnregistrarproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, 136, -1));

        lblPollo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pollo.png"))); // NOI18N
        registrarProveedor.add(lblPollo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 100, -1));

        btnSdEditProv1.setText("Editar Proveedor");
        btnSdEditProv1.setToolTipText("");
        registrarProveedor.add(btnSdEditProv1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 150, -1));

        pnlCards.add(registrarProveedor, "REG_PROV");

        registrarCompra.setMinimumSize(new java.awt.Dimension(630, 530));
        registrarCompra.setPreferredSize(new java.awt.Dimension(630, 530));
        registrarCompra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setViewportView(txtobservacionescompra);

        registrarCompra.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 600, 160));

        registrarCompra.add(cmbcompraReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 320, 30));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel28.setText("Observaciones:");
        registrarCompra.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        lblPollo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pollo.png"))); // NOI18N
        registrarCompra.add(lblPollo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jLabel29.setFont(new java.awt.Font("Gotham", 1, 36)); // NOI18N
        jLabel29.setText("Registrar Compra");
        registrarCompra.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, 48));

        btnregistrarcompra.setBackground(new java.awt.Color(245, 121, 0));
        btnregistrarcompra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnregistrarcompra.setForeground(new java.awt.Color(255, 255, 255));
        btnregistrarcompra.setText("Registrar Compra");
        registrarCompra.add(btnregistrarcompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 530, 170, 30));
        registrarCompra.add(jDatefechaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 450, 30));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel30.setText("Proveedor:");
        registrarCompra.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel31.setText("Fecha Compra:");
        registrarCompra.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel32.setText("Precio Compra:");
        registrarCompra.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        btnagrProvRegistraraComp.setBackground(new java.awt.Color(245, 121, 0));
        btnagrProvRegistraraComp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnagrProvRegistraraComp.setForeground(new java.awt.Color(255, 255, 255));
        btnagrProvRegistraraComp.setText("Agregar Proveedor");
        btnagrProvRegistraraComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagrProvRegistraraCompActionPerformed(evt);
            }
        });
        registrarCompra.add(btnagrProvRegistraraComp, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 170, 30));

        txtPrecioCompra.setColumns(10);
        registrarCompra.add(txtPrecioCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 460, 30));

        pnlCards.add(registrarCompra, "REG_COMPRA");

        registrarVenta.setMinimumSize(new java.awt.Dimension(630, 530));
        registrarVenta.setPreferredSize(new java.awt.Dimension(630, 530));
        registrarVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setViewportView(txtObservacionesVenta);

        registrarVenta.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 600, 160));

        registrarVenta.add(cmbRegVentaClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 380, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel19.setText("Observaciones:");
        registrarVenta.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        lblPollo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pollo.png"))); // NOI18N
        registrarVenta.add(lblPollo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jLabel21.setFont(new java.awt.Font("Gotham", 1, 36)); // NOI18N
        jLabel21.setText("Registrar Venta");
        registrarVenta.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, 48));

        btnAddVenta.setBackground(new java.awt.Color(245, 121, 0));
        btnAddVenta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnAddVenta.setText("Agregar Cliente");
        registrarVenta.add(btnAddVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 150, 30));
        registrarVenta.add(dateFechaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 470, 30));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel22.setText("Cliente:");
        registrarVenta.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel23.setText("Fecha Venta:");
        registrarVenta.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel24.setText("Precio Venta:");
        registrarVenta.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        btnRegistrarVenta.setBackground(new java.awt.Color(245, 121, 0));
        btnRegistrarVenta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistrarVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarVenta.setText("Registrar Venta");
        registrarVenta.add(btnRegistrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 530, 170, 30));

        txtPrecioVenta.setColumns(10);
        registrarVenta.add(txtPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 460, 30));

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
        editarProveedor.add(btnEditproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 136, -1));

        lblPollo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pollo.png"))); // NOI18N
        editarProveedor.add(lblPollo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 100, -1));

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
        editarCliente.add(txtEditNameCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 480, 32));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel38.setText("Teléfono:");
        editarCliente.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel39.setText("Direccion");
        editarCliente.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));
        editarCliente.add(txtEditTelefonoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 480, 32));
        editarCliente.add(txtEditDirCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 480, 32));

        btnEditClient.setBackground(new java.awt.Color(245, 121, 0));
        btnEditClient.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnEditClient.setForeground(new java.awt.Color(255, 255, 255));
        btnEditClient.setText("Editar");
        editarCliente.add(btnEditClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 136, -1));

        lblPollo7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pollo.png"))); // NOI18N
        editarCliente.add(lblPollo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 100, -1));
        editarCliente.add(cmbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 480, 30));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel40.setText("Cliente:");
        editarCliente.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        pnlCards.add(editarCliente, "EDIT_CLIENT");

        verCompras.setMinimumSize(new java.awt.Dimension(650, 660));
        verCompras.setPreferredSize(new java.awt.Dimension(650, 660));
        verCompras.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Proveedor", "Fecha Compra", "Precio Compra", "Observaciones"
            }
        ));
        jScrollPane5.setViewportView(tblCompras);

        verCompras.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 183, 620, 320));

        jLabel41.setFont(new java.awt.Font("Gotham", 1, 36)); // NOI18N
        jLabel41.setText("Ver Compras");
        verCompras.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, 48));

        lblPollo8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pollo.png"))); // NOI18N
        verCompras.add(lblPollo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 100, -1));

        jLabel20.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        jLabel20.setText("Total en Ventas:");
        verCompras.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 520, -1, 30));

        lblTotalCompras.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        verCompras.add(lblTotalCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 520, 120, 30));

        pnlCards.add(verCompras, "VER_COMPRAS");

        verVentas.setMinimumSize(new java.awt.Dimension(640, 560));
        verVentas.setPreferredSize(new java.awt.Dimension(640, 560));
        verVentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Gotham", 1, 36)); // NOI18N
        jLabel42.setText("Ver Ventas");
        verVentas.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, 48));

        jScrollPane6.setPreferredSize(new java.awt.Dimension(200, 200));

        tblVentas.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Fecha Venta", "Precio Venta", "Observaciones", "Estatus Pago"
            }
        ));
        jScrollPane6.setViewportView(tblVentas);

        verVentas.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 630, 330));

        lblPollo9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pollo.png"))); // NOI18N
        verVentas.add(lblPollo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 100, -1));

        lblTotalVentas.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        verVentas.add(lblTotalVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 500, 120, 30));

        jLabel8.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        jLabel8.setText("Total en Ventas:");
        verVentas.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, -1, 30));

        pnlCards.add(verVentas, "VER_VENTAS");

        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane7.setMaximumSize(new java.awt.Dimension(660, 550));
        jScrollPane7.setMinimumSize(new java.awt.Dimension(660, 550));
        jScrollPane7.setPreferredSize(new java.awt.Dimension(660, 550));

        insPago.setMaximumSize(new java.awt.Dimension(650, 800));
        insPago.setMinimumSize(new java.awt.Dimension(650, 800));
        insPago.setPreferredSize(new java.awt.Dimension(650, 800));
        insPago.setRequestFocusEnabled(false);
        insPago.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel48.setText("Método Pago:");
        insPago.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));

        cmbMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un metodo de pago", "Efectivo", "Transferencia" }));
        insPago.add(cmbMetodoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, 460, 30));

        jLabel49.setFont(new java.awt.Font("Gotham", 1, 36)); // NOI18N
        jLabel49.setText("Insertar Pago");
        insPago.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, 48));

        lblPollo11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pollo.png"))); // NOI18N
        insPago.add(lblPollo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 100, -1));
        insPago.add(cmbVentaPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 540, 30));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel51.setText("Fecha Pago:");
        insPago.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));
        insPago.add(dateFechaPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 480, 30));

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel52.setText("Monto Pago:");
        insPago.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        txtMontoPago.setColumns(10);
        insPago.add(txtMontoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 480, 30));

        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel53.setText("Observaciones:");
        insPago.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, -1));

        jScrollPane9.setViewportView(txtObservacionesPago);

        insPago.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 620, 130));

        panelRound2.setBackground(new java.awt.Color(235, 240, 243));
        panelRound2.setRoundBottomLeft(35);
        panelRound2.setRoundBottomRight(35);
        panelRound2.setRoundTopLeft(35);
        panelRound2.setRoundTopRight(35);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(215, 217, 222));
        jSeparator1.setForeground(new java.awt.Color(215, 217, 222));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panelRound2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 21, 120));

        totalVenta1.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N
        totalVenta1.setForeground(new java.awt.Color(33, 33, 33));
        totalVenta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalVenta1.setText("Saldo Pendiente");
        panelRound2.add(totalVenta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 210, -1));

        totalVenta.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N
        totalVenta.setForeground(new java.awt.Color(33, 33, 33));
        totalVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalVenta.setText("Total Venta");
        panelRound2.add(totalVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 10, 210, -1));

        lblSaldoPendiente.setFont(new java.awt.Font("Inter", 1, 31)); // NOI18N
        lblSaldoPendiente.setForeground(new java.awt.Color(117, 117, 117));
        lblSaldoPendiente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaldoPendiente.setText("$--.--");
        panelRound2.add(lblSaldoPendiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 210, 60));

        jSeparator2.setBackground(new java.awt.Color(215, 217, 222));
        jSeparator2.setForeground(new java.awt.Color(215, 217, 222));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panelRound2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 21, 120));

        lblTotalVenta.setFont(new java.awt.Font("Inter", 1, 31)); // NOI18N
        lblTotalVenta.setForeground(new java.awt.Color(117, 117, 117));
        lblTotalVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalVenta.setText("$--.--");
        panelRound2.add(lblTotalVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 210, 60));

        totalVenta2.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N
        totalVenta2.setForeground(new java.awt.Color(33, 33, 33));
        totalVenta2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalVenta2.setText("Total Pagado");
        panelRound2.add(totalVenta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 210, -1));

        lblTotalPagado.setFont(new java.awt.Font("Inter", 1, 31)); // NOI18N
        lblTotalPagado.setForeground(new java.awt.Color(117, 117, 117));
        lblTotalPagado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalPagado.setText("$--.--");
        panelRound2.add(lblTotalPagado, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 210, 60));

        insPago.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 630, 150));

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel54.setText("Venta:");
        insPago.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        btnRegistrarPago.setBackground(new java.awt.Color(245, 121, 0));
        btnRegistrarPago.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegistrarPago.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarPago.setText("Registrar Pago");
        insPago.add(btnRegistrarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 730, 170, 30));

        jScrollPane7.setViewportView(insPago);

        pnlCards.add(jScrollPane7, "INS_PAGO");

        jScrollPane8.setPreferredSize(new java.awt.Dimension(630, 530));

        dashboard.setBackground(new java.awt.Color(245, 245, 247));
        dashboard.setForeground(new java.awt.Color(245, 245, 247));
        dashboard.setMaximumSize(new java.awt.Dimension(650, 900));
        dashboard.setMinimumSize(new java.awt.Dimension(650, 900));
        dashboard.setPreferredSize(new java.awt.Dimension(650, 900));
        dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        clientesDeudores.setBackground(new java.awt.Color(255, 255, 255));
        clientesDeudores.setForeground(new java.awt.Color(255, 255, 255));
        clientesDeudores.setRoundBottomLeft(35);
        clientesDeudores.setRoundBottomRight(35);
        clientesDeudores.setRoundTopLeft(35);
        clientesDeudores.setRoundTopRight(35);
        clientesDeudores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setBackground(new java.awt.Color(33, 33, 33));
        jLabel50.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(33, 33, 33));
        jLabel50.setText("Clientes deudores");
        clientesDeudores.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        tableDeudores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane10.setViewportView(tableDeudores);

        clientesDeudores.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 260, 230));

        dashboard.add(clientesDeudores, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 600, 290, 290));

        flujoCaja.setBackground(new java.awt.Color(255, 255, 255));
        flujoCaja.setForeground(new java.awt.Color(255, 255, 255));
        flujoCaja.setRoundBottomLeft(35);
        flujoCaja.setRoundBottomRight(35);
        flujoCaja.setRoundTopLeft(35);
        flujoCaja.setRoundTopRight(35);
        flujoCaja.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setBackground(new java.awt.Color(33, 33, 33));
        jLabel46.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(33, 33, 33));
        jLabel46.setText("Flujo de Caja: Compras y Ventas");
        flujoCaja.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        dashboard.add(flujoCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 580, 290));

        cuentasCobrar.setBackground(new java.awt.Color(255, 255, 255));
        cuentasCobrar.setForeground(new java.awt.Color(255, 255, 255));
        cuentasCobrar.setRoundBottomLeft(35);
        cuentasCobrar.setRoundBottomRight(35);
        cuentasCobrar.setRoundTopLeft(35);
        cuentasCobrar.setRoundTopRight(35);
        cuentasCobrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound8.setBackground(new java.awt.Color(245, 245, 245));
        panelRound8.setRoundBottomLeft(35);
        panelRound8.setRoundBottomRight(35);
        panelRound8.setRoundTopLeft(35);
        panelRound8.setRoundTopRight(35);
        panelRound8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/receipt.png"))); // NOI18N
        panelRound8.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        cuentasCobrar.add(panelRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 60));

        jLabel61.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 0, 0));
        jLabel61.setText("Cuentas por Cobrar:");
        cuentasCobrar.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 180, 30));

        lblCuentasCobrar.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N
        cuentasCobrar.add(lblCuentasCobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 26, 180, 35));

        detailsCuentasCobrar.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        detailsCuentasCobrar.setForeground(new java.awt.Color(211, 139, 74));
        cuentasCobrar.add(detailsCuentasCobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 180, 15));

        dashboard.add(cuentasCobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 275, 80));

        balanceNeto.setBackground(new java.awt.Color(255, 255, 255));
        balanceNeto.setForeground(new java.awt.Color(255, 255, 255));
        balanceNeto.setRoundBottomLeft(35);
        balanceNeto.setRoundBottomRight(35);
        balanceNeto.setRoundTopLeft(35);
        balanceNeto.setRoundTopRight(35);
        balanceNeto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound9.setBackground(new java.awt.Color(255, 244, 230));
        panelRound9.setRoundBottomLeft(35);
        panelRound9.setRoundBottomRight(35);
        panelRound9.setRoundTopLeft(35);
        panelRound9.setRoundTopRight(35);
        panelRound9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/balance.png"))); // NOI18N
        panelRound9.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        balanceNeto.add(panelRound9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 60));

        jLabel62.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 0, 0));
        jLabel62.setText("Balance Neto:");
        balanceNeto.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 180, 30));

        lblBalanceNeto.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N
        lblBalanceNeto.setForeground(new java.awt.Color(33, 33, 33));
        balanceNeto.add(lblBalanceNeto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 26, 180, 35));

        detailsBalanceNeto.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        detailsBalanceNeto.setForeground(new java.awt.Color(211, 139, 74));
        balanceNeto.add(detailsBalanceNeto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 180, 15));

        dashboard.add(balanceNeto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 275, 80));

        pagosProveedores.setBackground(new java.awt.Color(255, 255, 255));
        pagosProveedores.setForeground(new java.awt.Color(255, 255, 255));
        pagosProveedores.setRoundBottomLeft(35);
        pagosProveedores.setRoundBottomRight(35);
        pagosProveedores.setRoundTopLeft(35);
        pagosProveedores.setRoundTopRight(35);
        pagosProveedores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound7.setBackground(new java.awt.Color(254, 236, 214));
        panelRound7.setRoundBottomLeft(35);
        panelRound7.setRoundBottomRight(35);
        panelRound7.setRoundTopLeft(35);
        panelRound7.setRoundTopRight(35);
        panelRound7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wallet.png"))); // NOI18N
        panelRound7.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        pagosProveedores.add(panelRound7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 60));

        jLabel60.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 0, 0));
        jLabel60.setText("Pagos a Proveedores:");
        pagosProveedores.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 180, 30));

        lblPagosProveedores.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N
        lblPagosProveedores.setForeground(new java.awt.Color(33, 33, 33));
        pagosProveedores.add(lblPagosProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 26, 180, 35));

        detailsPagosProveedores.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        detailsPagosProveedores.setForeground(new java.awt.Color(211, 139, 74));
        pagosProveedores.add(detailsPagosProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 180, 15));

        dashboard.add(pagosProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 275, 80));

        cobrosTotales.setBackground(new java.awt.Color(255, 255, 255));
        cobrosTotales.setForeground(new java.awt.Color(255, 255, 255));
        cobrosTotales.setRoundBottomLeft(35);
        cobrosTotales.setRoundBottomRight(35);
        cobrosTotales.setRoundTopLeft(35);
        cobrosTotales.setRoundTopRight(35);
        cobrosTotales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound5.setBackground(new java.awt.Color(220, 237, 224));
        panelRound5.setRoundBottomLeft(35);
        panelRound5.setRoundBottomRight(35);
        panelRound5.setRoundTopLeft(35);
        panelRound5.setRoundTopRight(35);
        panelRound5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/upward.png"))); // NOI18N
        panelRound5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        cobrosTotales.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 60));

        jLabel55.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 0, 0));
        jLabel55.setText("Cobros Totales (Ventas):");
        cobrosTotales.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 180, 30));

        detailsCobrosTotales.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        detailsCobrosTotales.setForeground(new java.awt.Color(46, 125, 50));
        cobrosTotales.add(detailsCobrosTotales, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 180, 15));

        lblCobrosTotales.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N
        lblCobrosTotales.setForeground(new java.awt.Color(33, 33, 33));
        cobrosTotales.add(lblCobrosTotales, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 26, 180, 35));

        dashboard.add(cobrosTotales, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 275, 80));

        jSeparator5.setBackground(new java.awt.Color(2, 5, 2));
        jSeparator5.setForeground(new java.awt.Color(245, 121, 0));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jSeparator5.setMinimumSize(new java.awt.Dimension(60, 0));
        jSeparator5.setPreferredSize(new java.awt.Dimension(60, 0));
        dashboard.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 10, 180));

        jLabel59.setFont(new java.awt.Font("Gotham", 1, 24)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(33, 33, 33));
        jLabel59.setText("ESTADISTICAS FINANCIERAS");
        dashboard.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 48));

        jLabel47.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(33, 33, 33));
        jLabel47.setText("Filtrar: ");
        dashboard.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Anualmente", "Mensualmente", "Semanalmente" }));
        dashboard.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 53, 110, -1));

        metodosPago.setBackground(new java.awt.Color(255, 255, 255));
        metodosPago.setForeground(new java.awt.Color(255, 255, 255));
        metodosPago.setRoundBottomLeft(35);
        metodosPago.setRoundBottomRight(35);
        metodosPago.setRoundTopLeft(35);
        metodosPago.setRoundTopRight(35);
        metodosPago.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel56.setBackground(new java.awt.Color(33, 33, 33));
        jLabel56.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(33, 33, 33));
        jLabel56.setText("Métodos de Pago");
        metodosPago.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        dashboard.add(metodosPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, 280, 290));

        jScrollPane8.setViewportView(dashboard);

        pnlCards.add(jScrollPane8, "DASHBOARD");

        background.add(pnlCards, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 660, 580));

        getContentPane().add(background, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnagrProvRegistraraCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagrProvRegistraraCompActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnagrProvRegistraraCompActionPerformed

    private void btnDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDBActionPerformed

    public JButton getBtnDB() {
        return btnDB;
    }

    public void setBtnDB(JButton btnDB) {
        this.btnDB = btnDB;
    }

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

    public JButton getBtnSdInsertarPago() {
        return btnSdInsertarPago;
    }

    public void setBtnSdInsertarPago(JButton btnSdInsertarPago) {
        this.btnSdInsertarPago = btnSdInsertarPago;
    }

    public JButton getBtnSdVerCompras() {
        return btnSdVerCompras;
    }

    public void setBtnSdVerCompras(JButton btnSdVerCompras) {
        this.btnSdVerCompras = btnSdVerCompras;
    }

    public JButton getBtnSdVerVentas() {
        return btnSdVerVentas;
    }

    public void setBtnSdVerVentas(JButton btnSdVerVentas) {
        this.btnSdVerVentas = btnSdVerVentas;
    }

    public JPanel getVerCompras() {
        return verCompras;
    }

    public void setVerCompras(JPanel verCompras) {
        this.verCompras = verCompras;
    }

    public JLabel getLblTotalCompras() {
        return lblTotalCompras;
    }

    public void setLblTotalCompras(JLabel lblTotalCompras) {
        this.lblTotalCompras = lblTotalCompras;
    }

    public JButton getBtnRegistrarPago() {
        return btnRegistrarPago;
    }

    public void setBtnRegistrarPago(JButton btnRegistrarPago) {
        this.btnRegistrarPago = btnRegistrarPago;
    }

    public JComboBox<String> getCmbMetodoPago() {
        return cmbMetodoPago;
    }

    public void setCmbMetodoPago(JComboBox<String> cmbMetodoPago) {
        this.cmbMetodoPago = cmbMetodoPago;
    }

    public JComboBox<Object> getCmbVentaPago() {
        return cmbVentaPago;
    }

    public void setCmbVentaPago(JComboBox<Object> cmbVentaPago) {
        this.cmbVentaPago = cmbVentaPago;
    }

    public JDateChooser getDateFechaPago() {
        return dateFechaPago;
    }

    public void setDateFechaPago(JDateChooser dateFechaPago) {
        this.dateFechaPago = dateFechaPago;
    }

    public JPanel getInsPago() {
        return insPago;
    }

    public void setInsPago(JPanel insPago) {
        this.insPago = insPago;
    }

    public JLabel getjLabel41() {
        return jLabel41;
    }

    public void setjLabel41(JLabel jLabel41) {
        this.jLabel41 = jLabel41;
    }

    public JLabel getjLabel42() {
        return jLabel42;
    }

    public void setjLabel42(JLabel jLabel42) {
        this.jLabel42 = jLabel42;
    }

    public JLabel getjLabel48() {
        return jLabel48;
    }

    public void setjLabel48(JLabel jLabel48) {
        this.jLabel48 = jLabel48;
    }

    public JLabel getjLabel49() {
        return jLabel49;
    }

    public void setjLabel49(JLabel jLabel49) {
        this.jLabel49 = jLabel49;
    }

    public JLabel getjLabel51() {
        return jLabel51;
    }

    public void setjLabel51(JLabel jLabel51) {
        this.jLabel51 = jLabel51;
    }

    public JLabel getjLabel52() {
        return jLabel52;
    }

    public void setjLabel52(JLabel jLabel52) {
        this.jLabel52 = jLabel52;
    }

    public JLabel getjLabel53() {
        return jLabel53;
    }

    public void setjLabel53(JLabel jLabel53) {
        this.jLabel53 = jLabel53;
    }

    public JLabel getjLabel54() {
        return jLabel54;
    }

    public void setjLabel54(JLabel jLabel54) {
        this.jLabel54 = jLabel54;
    }

    public JScrollPane getjScrollPane5() {
        return jScrollPane5;
    }

    public void setjScrollPane5(JScrollPane jScrollPane5) {
        this.jScrollPane5 = jScrollPane5;
    }

    public JScrollPane getjScrollPane6() {
        return jScrollPane6;
    }

    public void setjScrollPane6(JScrollPane jScrollPane6) {
        this.jScrollPane6 = jScrollPane6;
    }

    public JScrollPane getjScrollPane7() {
        return jScrollPane7;
    }

    public void setjScrollPane7(JScrollPane jScrollPane7) {
        this.jScrollPane7 = jScrollPane7;
    }

    public JScrollPane getjScrollPane9() {
        return jScrollPane9;
    }

    public void setjScrollPane9(JScrollPane jScrollPane9) {
        this.jScrollPane9 = jScrollPane9;
    }

    public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(JSeparator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }

    public JSeparator getjSeparator2() {
        return jSeparator2;
    }

    public void setjSeparator2(JSeparator jSeparator2) {
        this.jSeparator2 = jSeparator2;
    }

    public JLabel getLblPollo11() {
        return lblPollo11;
    }

    public void setLblPollo11(JLabel lblPollo11) {
        this.lblPollo11 = lblPollo11;
    }

    public JLabel getLblPollo8() {
        return lblPollo8;
    }

    public void setLblPollo8(JLabel lblPollo8) {
        this.lblPollo8 = lblPollo8;
    }

    public JLabel getLblPollo9() {
        return lblPollo9;
    }

    public void setLblPollo9(JLabel lblPollo9) {
        this.lblPollo9 = lblPollo9;
    }

    public JLabel getLblSaldoPendiente() {
        return lblSaldoPendiente;
    }

    public void setLblSaldoPendiente(JLabel lblSaldoPendiente) {
        this.lblSaldoPendiente = lblSaldoPendiente;
    }

    public JLabel getLblTotalPagado() {
        return lblTotalPagado;
    }

    public void setLblTotalPagado(JLabel lblTotalPagado) {
        this.lblTotalPagado = lblTotalPagado;
    }

    public JLabel getLblTotalVenta() {
        return lblTotalVenta;
    }

    public void setLblTotalVenta(JLabel lblTotalVenta) {
        this.lblTotalVenta = lblTotalVenta;
    }

    public PanelRound getPanelRound2() {
        return panelRound2;
    }

    public void setPanelRound2(PanelRound panelRound2) {
        this.panelRound2 = panelRound2;
    }

    public JTable getTblCompras() {
        return tblCompras;
    }

    public void setTblCompras(JTable tblCompras) {
        this.tblCompras = tblCompras;
    }

    public JTable getTblVentas() {
        return tblVentas;
    }

    public void setTblVentas(JTable tblVentas) {
        this.tblVentas = tblVentas;
    }

    public JLabel getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(JLabel totalVenta) {
        this.totalVenta = totalVenta;
    }

    public JLabel getTotalVenta1() {
        return totalVenta1;
    }

    public void setTotalVenta1(JLabel totalVenta1) {
        this.totalVenta1 = totalVenta1;
    }

    public JLabel getTotalVenta2() {
        return totalVenta2;
    }

    public void setTotalVenta2(JLabel totalVenta2) {
        this.totalVenta2 = totalVenta2;
    }

    public JFormattedTextField getTxtMontoPago() {
        return txtMontoPago;
    }

    public void setTxtMontoPago(JFormattedTextField txtMontoPago) {
        this.txtMontoPago = txtMontoPago;
    }

    public JTextPane getTxtObservacionesPago() {
        return txtObservacionesPago;
    }

    public void setTxtObservacionesPago(JTextPane txtObservacionesPago) {
        this.txtObservacionesPago = txtObservacionesPago;
    }

    public JPanel getVerVentas() {
        return verVentas;
    }

    public void setVerVentas(JPanel verVentas) {
        this.verVentas = verVentas;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JLabel getLblTotalVentas() {
        return lblTotalVentas;
    }

    public void setLblTotalVentas(JLabel lblTotalVentas) {
        this.lblTotalVentas = lblTotalVentas;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private com.mycompany.forms.PanelRound balanceNeto;
    private javax.swing.JButton btnAddVenta;
    private javax.swing.JButton btnCrearNuevoPedido;
    private javax.swing.JButton btnDB;
    private javax.swing.JButton btnEditClient;
    private javax.swing.JButton btnEditproveedor;
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JButton btnRegistrarPago;
    private javax.swing.JButton btnRegistrarVenta;
    private javax.swing.JButton btnSdEditClient1;
    private javax.swing.JButton btnSdEditProv1;
    private javax.swing.JButton btnSdInicio;
    private javax.swing.JButton btnSdInsertarPago;
    private javax.swing.JButton btnSdRegCompra;
    private javax.swing.JButton btnSdRegVenta;
    private javax.swing.JButton btnSdVerCompras;
    private javax.swing.JButton btnSdVerVentas;
    private javax.swing.JButton btnagrProvRegistraraComp;
    private javax.swing.JButton btnregistrarcompra;
    private javax.swing.JButton btnregistrarproveedor;
    private com.mycompany.forms.PanelRound clientesDeudores;
    private javax.swing.JComboBox<Object> cmbCliente;
    private javax.swing.JComboBox<String> cmbMetodoPago;
    private javax.swing.JComboBox<Object> cmbRegVentaClient;
    private javax.swing.JComboBox<Object> cmbVentaPago;
    private javax.swing.JComboBox<Proveedor> cmbcompraReg;
    private javax.swing.JComboBox<Proveedor> cmbnombreEditproveedor;
    private com.mycompany.forms.PanelRound cobrosTotales;
    private com.mycompany.forms.PanelRound cuentasCobrar;
    private javax.swing.JPanel dashboard;
    private com.toedter.calendar.JDateChooser dateFechaPago;
    private com.toedter.calendar.JDateChooser dateFechaVenta;
    private javax.swing.JLabel detailsBalanceNeto;
    private javax.swing.JLabel detailsCobrosTotales;
    private javax.swing.JLabel detailsCuentasCobrar;
    private javax.swing.JLabel detailsPagosProveedores;
    private javax.swing.JPanel editarCliente;
    private javax.swing.JPanel editarProveedor;
    private com.mycompany.forms.PanelRound flujoCaja;
    private javax.swing.JPanel insPago;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDatefechaCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblBalanceNeto;
    private javax.swing.JLabel lblCobrosTotales;
    private javax.swing.JLabel lblCuentasCobrar;
    private javax.swing.JLabel lblPagosProveedores;
    private javax.swing.JLabel lblPollo1;
    private javax.swing.JLabel lblPollo11;
    private javax.swing.JLabel lblPollo2;
    private javax.swing.JLabel lblPollo3;
    private javax.swing.JLabel lblPollo4;
    private javax.swing.JLabel lblPollo5;
    private javax.swing.JLabel lblPollo6;
    private javax.swing.JLabel lblPollo7;
    private javax.swing.JLabel lblPollo8;
    private javax.swing.JLabel lblPollo9;
    private javax.swing.JLabel lblSaldoPendiente;
    private javax.swing.JLabel lblTotalCompras;
    private javax.swing.JLabel lblTotalPagado;
    private javax.swing.JLabel lblTotalVenta;
    private javax.swing.JLabel lblTotalVentas;
    private com.mycompany.forms.PanelRound metodosPago;
    private com.mycompany.forms.PanelRound pagosProveedores;
    private com.mycompany.forms.PanelRound panelRound1;
    private com.mycompany.forms.PanelRound panelRound2;
    private com.mycompany.forms.PanelRound panelRound5;
    private com.mycompany.forms.PanelRound panelRound7;
    private com.mycompany.forms.PanelRound panelRound8;
    private com.mycompany.forms.PanelRound panelRound9;
    private javax.swing.JPanel pnlCards;
    private javax.swing.JPanel registrarCliente;
    private javax.swing.JPanel registrarCompra;
    private javax.swing.JPanel registrarProveedor;
    private javax.swing.JPanel registrarVenta;
    private javax.swing.JPanel sideBar;
    private javax.swing.JTable tableDeudores;
    private javax.swing.JTable tblCompras;
    private javax.swing.JTable tblVentas;
    private javax.swing.JLabel totalVenta;
    private javax.swing.JLabel totalVenta1;
    private javax.swing.JLabel totalVenta2;
    private javax.swing.JTextField txtDireccionCliente;
    private javax.swing.JTextField txtEditDirCliente;
    private javax.swing.JTextField txtEditNameCliente;
    private javax.swing.JTextField txtEditTelefonoCliente;
    private javax.swing.JFormattedTextField txtMontoPago;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextPane txtObservacionesPago;
    private javax.swing.JTextPane txtObservacionesVenta;
    private javax.swing.JFormattedTextField txtPrecioCompra;
    private javax.swing.JFormattedTextField txtPrecioVenta;
    private javax.swing.JTextField txtTelefonoCliente;
    private javax.swing.JTextField txtdireccionEditproveedor;
    private javax.swing.JTextField txtdireccionproveedor;
    private javax.swing.JTextField txtnombreEditproveedor;
    private javax.swing.JTextField txtnombreproveedor;
    private javax.swing.JTextPane txtobservacionescompra;
    private javax.swing.JTextField txttelefonoEditproveedor;
    private javax.swing.JTextField txttelefonoproveedor;
    private javax.swing.JPanel verCompras;
    private javax.swing.JPanel verVentas;
    private javax.swing.JPanel vistaInicio;
    // End of variables declaration//GEN-END:variables
}
