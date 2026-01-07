package com.mycompany.controller;

import com.mycompany.Utility.FechaUtil;
import com.mycompany.Utility.RangoFecha;
import com.mycompany.model.ClienteDAO;
import com.mycompany.model.Compra;
import com.mycompany.model.CompraDAO;
import com.mycompany.model.FlujoCaja;
import com.mycompany.model.FlujoCajaDAO;
import com.mycompany.model.Pago;
import com.mycompany.model.PagoDAO;
import com.mycompany.model.VentaDAO;
import com.mycompany.vista.FrmPrincipal;
import com.toedter.calendar.JDateChooser;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import java.time.YearMonth;
import org.jfree.chart.plot.DatasetRenderingOrder;

public class DashboardController implements ActionListener {
    private FrmPrincipal frm;
    private NumberFormat formatoCOP;
    private VentaDAO vtDAO;
    private PagoDAO pDAO;
    private CompraDAO cDAO;
    private ClienteDAO clDAO;
    private FlujoCajaDAO flDAO;

    public DashboardController(){
        this.frm = new FrmPrincipal();
    }
    
    public DashboardController(FrmPrincipal frm) {
        this.frm = frm;
        this.formatoCOP = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
        this.formatoCOP.setMaximumFractionDigits(0);
        this.vtDAO = new VentaDAO();
        this.pDAO = new PagoDAO();
        this.cDAO = new CompraDAO();
        this.clDAO = new ClienteDAO();
        this.flDAO = new FlujoCajaDAO();
        initEventos();
        initListeners();
        this.frm.getCmbFiltro().addActionListener(this);
    }
    
    private void initEventos(){
        frm.getBtnSdVerEstadisticas().addActionListener(e -> {
            this.frm.getCmbFiltro().setSelectedIndex(0);
            esconderFiltros();
            obtenerDatosDefault();
            mostrarClientesDeudores();
        });
    }
    
    private void initListeners(){
        this.frm.getAnualmenteFiltro().addPropertyChangeListener("year", evt -> {
            int anioSeleccionado = (int) evt.getNewValue();
            cargarFlujoAnual(anioSeleccionado);
        });
        this.frm.getSemanaFiltro().getDateEditor().addPropertyChangeListener("date", evt -> {
            if (evt.getNewValue() == null) return;
            cargarFlujoSemanal();
        });
        frm.getAnioFiltro().addPropertyChangeListener("year", evt -> {
            cargarFlujoMensual();
        });
        frm.getMesFiltro().addPropertyChangeListener("month", evt -> {
            cargarFlujoMensual();
        });
    }
    
    private void cargarFlujoAnual(int value){
        RangoFecha rangoAnio = FechaUtil.rangoPorAnio(value);
        List<FlujoCaja> flujo = flDAO.obtenerFlujoPorRango(rangoAnio.getInicio(), rangoAnio.getFin()); 
        JFreeChart chart = crearGraficaFlujo(flujo);
        mostrarGrafica(chart);
        actualizarLabels(flujo);
    }
    
    private void actualizarLabels(List<FlujoCaja> flujo){
        double cobrosTotal = 0;
        double pagosTotal = 0;
        for(FlujoCaja f : flujo){
            cobrosTotal += f.getCobros();
            pagosTotal += f.getPagos();
        }
        double balanceNeto = cobrosTotal - pagosTotal;
        actualizarDatos(cobrosTotal, pagosTotal, balanceNeto);
    }
    private void cargarFlujoMensual(){
        int anio = frm.getAnioFiltro().getYear();
        int mes = frm.getMesFiltro().getMonth() + 1;
        RangoFecha rangoMensual = FechaUtil.rangoPorMes(anio, mes);
        List<FlujoCaja> flujoMensual = flDAO.obtenerFlujoPorRango(
            rangoMensual.getInicio(),
            rangoMensual.getFin()
        );
        mostrarGrafica(crearGraficaFlujo(flujoMensual));
        actualizarLabels(flujoMensual);
    }
   
    private void cargarFlujoSemanal(){
        int anio = obtenerAnioDesdeJDateChooser(frm.getSemanaFiltro());
        int semana = obtenerSemanaDesdeJDateChooser(frm.getSemanaFiltro());
        RangoFecha rango = FechaUtil.rangoPorSemana(anio, semana);
        List<FlujoCaja> flujoSemanal = flDAO.obtenerFlujoPorRango(
            rango.getInicio(),
            rango.getFin()
        );
        JFreeChart chartSemanal = crearGraficaFlujo(flujoSemanal);
        mostrarGrafica(chartSemanal);
        actualizarLabels(flujoSemanal);
    }

    public FrmPrincipal getFrm() {
        return frm;
    }

    public void setFrm(FrmPrincipal frm) {
        this.frm = frm;
    }
    
    private void esconderFiltros(){
        frm.getFiltros().setVisible(false);
    }
    
    private void mostrarFiltros(){
        frm.getFiltros().setVisible(true);
    }
    
    private void esconderComponente(Component c){
        c.setVisible(false);
    }
    
    private void mostrarComponente(Component c){
        c.setVisible(true);
    }
    
    private void esconderAnualmente(){
        mostrarComponente(frm.getAnualmenteFiltro());
        esconderComponente(frm.getAnioFiltro());
        esconderComponente(frm.getMesFiltro());
        esconderComponente(frm.getSemanaFiltro());
    }
    
    private void esconderMensualmente(){
        esconderComponente(frm.getAnualmenteFiltro());
        mostrarComponente(frm.getAnioFiltro());
        mostrarComponente(frm.getMesFiltro());
        esconderComponente(frm.getSemanaFiltro());
    }
    
    private void esconderSemanalmente(){
        esconderComponente(frm.getAnualmenteFiltro());
        esconderComponente(frm.getAnioFiltro());
        esconderComponente(frm.getMesFiltro());
        mostrarComponente(frm.getSemanaFiltro());
    }
    
    private void mostrarGrafica(JFreeChart chart) {
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setMouseWheelEnabled(true);
        frm.getPnlGraficaFlujoCaja().removeAll();
        frm.getPnlGraficaFlujoCaja().setLayout(new java.awt.BorderLayout());
        frm.getPnlGraficaFlujoCaja().add(chartPanel, java.awt.BorderLayout.CENTER);
        frm.getPnlGraficaFlujoCaja().revalidate();
        frm.getPnlGraficaFlujoCaja().repaint();
    }
    
    private JFreeChart crearGraficaFlujo(List<FlujoCaja> datos) {
        DefaultCategoryDataset barras = new DefaultCategoryDataset();
        DefaultCategoryDataset linea = new DefaultCategoryDataset();
        for (FlujoCaja f : datos) {
            barras.addValue(f.getCobros(), "Cobros Clientes", f.getFecha());
            linea.addValue(f.getPagos(), "Pagos Proveedores", f.getFecha());
        }
        JFreeChart chart = ChartFactory.createBarChart(
                "Flujo de Caja",
                "Fecha",
                "Monto",
                barras
        );
        chart.setBackgroundPaint(Color.WHITE);
        chart.getTitle().setFont(new Font("SansSerif", Font.BOLD, 16));

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);
        plot.setRangeGridlinePaint(new Color(220, 220, 220));
        plot.setDomainGridlinesVisible(false);

        BarRenderer barRenderer = (BarRenderer) plot.getRenderer();
        barRenderer.setSeriesPaint(0, new Color(239, 125, 24));
        barRenderer.setBarPainter(new StandardBarPainter());
        barRenderer.setShadowVisible(false);
        barRenderer.setItemMargin(0.1);
        plot.setDataset(1, linea);
        LineAndShapeRenderer lineRenderer = new LineAndShapeRenderer();
        lineRenderer.setSeriesPaint(0, new Color(182, 46, 24));
        lineRenderer.setSeriesStroke(0, new BasicStroke(2.5f));
        lineRenderer.setDefaultShapesVisible(true);
        lineRenderer.setSeriesShape(0, new Ellipse2D.Double(-3, -3, 6, 6));
        lineRenderer.setDefaultToolTipGenerator(
                new StandardCategoryToolTipGenerator(
                        "{0}: {2}",
                        NumberFormat.getCurrencyInstance(new Locale("es", "CO"))
                )
        );

        plot.setRenderer(1, lineRenderer);

        NumberAxis axisY = (NumberAxis) plot.getRangeAxis();
        axisY.setNumberFormatOverride(
                NumberFormat.getCurrencyInstance(new Locale("es", "CO"))
        );
        axisY.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 11));

        CategoryAxis axisX = plot.getDomainAxis();
        axisX.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 11));
        axisX.setCategoryLabelPositions(
                CategoryLabelPositions.DOWN_45.createUpRotationLabelPositions(Math.PI / 6)
        );
        
        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        plot.mapDatasetToRangeAxis(1, 0);
        plot.setRenderer(1, lineRenderer);
        LegendTitle legend = chart.getLegend();
        legend.setFrame(BlockBorder.NONE);
        legend.setItemFont(new Font("SansSerif", Font.PLAIN, 12));
        return chart;
    }
    
    private JFreeChart crearGraficaMetodosPago(double efectivo, double transferencia, double pctEfectivo, double pctTransferencia) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Efectivo", efectivo);
        dataset.setValue("Transferencia", transferencia);
        JFreeChart chart = ChartFactory.createRingChart(
                "Métodos de Pago (Clientes)",
                dataset,
                true,
                true,
                false
        );
        chart.setBackgroundPaint(Color.WHITE);
        chart.getTitle().setFont(new Font("SansSerif", Font.BOLD, 16));
        RingPlot plot = (RingPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);
        plot.setSectionPaint("Efectivo", new Color(255, 183, 77));
        plot.setSectionPaint("Transferencia", new Color(255, 152, 0));
        plot.setSectionDepth(0.35);
        plot.setSeparatorsVisible(false);
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setLabelBackgroundPaint(Color.WHITE);
        plot.setLabelOutlinePaint(null);
        plot.setLabelShadowPaint(null);
        plot.setSimpleLabels(true);
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} ({2})") {
            @Override
            public String generateSectionLabel(PieDataset dataset, Comparable key) {
                if (key.equals("Efectivo")) {
                    return String.format("Efectivo (%.0f%%)", pctEfectivo);
                } else if (key.equals("Transferencia")) {
                    return String.format("Transferencia (%.0f%%)", pctTransferencia);
                }
                return "";
            }
        });
        LegendTitle legend = chart.getLegend();
        legend.setFrame(BlockBorder.NONE);
        legend.setItemFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator() {
            @Override
            public String generateSectionLabel(PieDataset dataset, Comparable key) {
                NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
                if (key.equals("Efectivo")) {
                    return String.format("Efectivo: %s (%.0f%%)", 
                        currencyFormat.format(efectivo), pctEfectivo);
                } else if (key.equals("Transferencia")) {
                    return String.format("Transferencia: %s (%.0f%%)", 
                        currencyFormat.format(transferencia), pctTransferencia);
                }
                return key.toString();
            }
        });
        return chart;
    }

    private void cargarGraficaMetodosPago() {
        Map<String, Double> datos = pDAO.obtenerPorcentajeMetodosPago();
        double efectivo = datos.get("EFECTIVO_TOTAL");
        double transferencia = datos.get("TRANSFERENCIA_TOTAL");
        double pctEfectivo = datos.get("EFECTIVO_PCT");
        double pctTransferencia = datos.get("TRANSFERENCIA_PCT");
        JFreeChart chart = crearGraficaMetodosPago(efectivo, transferencia, pctEfectivo, pctTransferencia);
        ChartPanel panel = new ChartPanel(chart);
        panel.setPopupMenu(null);
        panel.setMouseWheelEnabled(false);
        frm.getPnlMetodosPago().removeAll();
        frm.getPnlMetodosPago().setLayout(new BorderLayout());
        frm.getPnlMetodosPago().add(panel, BorderLayout.CENTER);
        frm.getPnlMetodosPago().revalidate();
        frm.getPnlMetodosPago().repaint();
    }


    
    private void mostrarClientesDeudores(){
        List<Object[]> clientes = clDAO.readClientesConDeuda();
        DefaultTableModel model = (DefaultTableModel) frm.getTableDeudores().getModel();
        model.setRowCount(0);
        for(Object[] c : clientes){
            String nombre = (String) c[1];
            double deuda = (double) c[2];
            model.addRow(new Object[]{nombre, formatoCOP.format(deuda)});
        }
    }
    
    private void obtenerDatosDefault(){
        ArrayList<Pago> pagos = (ArrayList<Pago>) pDAO.readAll();
        ArrayList<Compra> compras = (ArrayList<Compra>) cDAO.listarComprasDash();
        double ingresosTotales = 0;
        for(Pago p : pagos){
            ingresosTotales += p.getMonto();
        }
        double pagosProveedores = 0;
        for(Compra c : compras){
            pagosProveedores += c.getPrecio();
        }
        double balanceNeto = ingresosTotales - pagosProveedores;
        double cuentasCobrar = vtDAO.obtenerTotalPendiente();
        frm.getDetailsCuentasCobrar().setText(vtDAO.obtenerCantidadVentasPendientes() + " cuentas por cobrar");
        actualizarDatos(ingresosTotales, pagosProveedores, balanceNeto, cuentasCobrar);
        List<FlujoCaja> flujo = flDAO.obtenerFlujoDiario(); 
        JFreeChart chart = crearGraficaFlujo(flujo);
        mostrarGrafica(chart);
        cargarGraficaMetodosPago();
    }
    
    private void actualizarDatos(double ingresosTotales, double pagosProveedores, double balanceNeto, double cuentasCobrar){
        frm.getLblCobrosTotales().setText(formatoCOP.format(ingresosTotales));
        frm.getLblPagosProveedores().setText(formatoCOP.format(pagosProveedores));
        frm.getLblBalanceNeto().setText(formatoCOP.format(balanceNeto));
        frm.getLblCuentasCobrar().setText(formatoCOP.format(cuentasCobrar));
    }
    
    private void actualizarDatos(double ingresosTotales, double pagosProveedores, double balanceNeto){
        frm.getLblCobrosTotales().setText(formatoCOP.format(ingresosTotales));
        frm.getLblPagosProveedores().setText(formatoCOP.format(pagosProveedores));
        frm.getLblBalanceNeto().setText(formatoCOP.format(balanceNeto));
    }
    
    private void setDatosAnualmente(){
        frm.getAnualmenteFiltro().setYear(2026);
    }
    
    public int obtenerSemanaDesdeJDateChooser(JDateChooser chooser) {
        Date date = chooser.getDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setMinimalDaysInFirstWeek(4);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    public int obtenerAnioDesdeJDateChooser(JDateChooser chooser) {
        Date date = chooser.getDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }
    
    public void setDatosSemanalmente(){
        frm.getSemanaFiltro().setDate(new Date());
    }
    
    public void setDatosMensualmente(){
        frm.getAnioFiltro().setYear(YearMonth.now().getYear());
        frm.getMesFiltro().setMonth(YearMonth.now().getMonthValue() - 1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(frm.getCmbFiltro())){
            int opc = frm.getCmbFiltro().getSelectedIndex();
            System.out.println(opc);
            switch(opc){
                case 0:
                    esconderFiltros();
                    obtenerDatosDefault();
                    break;
                case 1:
                    mostrarFiltros();
                    esconderAnualmente();
                    setDatosAnualmente();
                    cargarFlujoAnual(frm.getAnualmenteFiltro().getYear());
                    break;
                case 2:
                    mostrarFiltros();
                    esconderMensualmente();
                    setDatosMensualmente();
                    cargarFlujoMensual();
                    break;
                case 3:
                    mostrarFiltros();
                    esconderSemanalmente();
                    setDatosSemanalmente();
                    cargarFlujoSemanal();
                    break;
            }
        }
    }
    
    
}
