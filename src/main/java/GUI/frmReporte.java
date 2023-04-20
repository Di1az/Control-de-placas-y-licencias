/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.ConexionBD;
import DAO.IConexionBD;
import DAO.Reporte;
import DAO.TramiteDAO;
import Encriptacion.Encriptar;
import Entidades.Licencia;
import Entidades.Persona;
import Entidades.Placa;
import Entidades.Tramite;
import java.awt.Color;
import java.awt.Font;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * Frame de reportes
 * @author oscar
 */
public class frmReporte extends javax.swing.JFrame {
    
    /**
     * Objeto para establecer la conexion
     */
    IConexionBD conexionBD = new ConexionBD();
    
    /**
     * Objeto de tipo TramiteDAO
     */
    TramiteDAO tramiteDAO = new TramiteDAO(conexionBD);

    /**
     * Atributo para mantener siempre la lista
     */
    private List<Tramite> listaTabla;

    /**
     * Método constructor que inicializa los atributos
     */
    public frmReporte() {
        initComponents();
        this.listaTabla = new ArrayList<Tramite>();
        this.llenarTramites();
    }

    /**
     * Metodo que se encarga de llenar la tabla de tramite dependiendo del
     * filtro que el usuario utilice
     */
    public void llenarTramites() {
        System.out.println(cbLicencia.isSelected());
        System.out.println(cbPlaca.isSelected());
        listaTabla = tramiteDAO.ListaTramite(cbLicencia.isSelected(), cbPlaca.isSelected(), this.txtFecha_inicio.getDate(), this.txtFecha_fin.getDate());
        listaTabla = desencriptarListaTramite(listaTabla);
        if (txtNombre.getText() != null) {
            List<Tramite> Listanombre = new ArrayList<Tramite>();
            for (int i = 0; i < listaTabla.size(); i++) {
                Persona persona = listaTabla.get(i).getPersona();
                String nombreCompleto = persona.getNombre() + " " + persona.getApellidoP() + " " + persona.getApellidoM();

                if (nombreCompleto.toLowerCase().contains(txtNombre.getText().toLowerCase())) {
                    Listanombre.add(listaTabla.get(i));
                }

            }
            listaTabla = Listanombre;

        }
        DefaultTableModel modelo = (DefaultTableModel) tblReporte.getModel();
        modelo.setRowCount(0);
        for (int i = 0; i < listaTabla.size(); i++) {
            Object[] datos = new Object[modelo.getColumnCount()];
            if (listaTabla.get(i) instanceof Placa) {
                datos[0] = "Placas";
                Placa placa = (Placa) listaTabla.get(i);
                datos[2] = placa.getCosto();
            }
            if (listaTabla.get(i) instanceof Licencia) {
                datos[0] = "Licencias";
                Licencia licencia = (Licencia) listaTabla.get(i);
                datos[2] = licencia.getCosto();
            }
            Persona persona = listaTabla.get(i).getPersona();
            String nombreCompleto = persona.getNombre() + " " + persona.getApellidoP() + " " + persona.getApellidoM();

            datos[1] = nombreCompleto;

            datos[3] = listaTabla.get(i).getFechaEmision();
            modelo.addRow(datos);
        }
    }

    /**
     * Metodo que se encaega de regresar una lista de tramite con el nombre de
     * la persona desencriptado
     *
     * @param lista lista desencriptada de los tramites
     * @return Lista de tramite con el nombre de la persona desencriptado
     */
    public List<Tramite> desencriptarListaTramite(List<Tramite> lista) {
        Encriptar encriptacion = new Encriptar();
        List<Persona> personasDesencriptadas = new ArrayList<>();
        List<Tramite> lista_tramitePersona = new ArrayList<>();

        for (Tramite tramite : lista) {
            Persona persona = tramite.getPersona();

            if (!personasDesencriptadas.contains(persona)) {
                personasDesencriptadas.add(persona);
                persona.setNombre(encriptacion.desencriptar(persona.getNombre()));
                persona.setApellidoP(encriptacion.desencriptar(persona.getApellidoP()));
                persona.setApellidoM(encriptacion.desencriptar(persona.getApellidoM()));
            }
            lista_tramitePersona.add(tramite);
        }

        return lista_tramitePersona;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporte = new javax.swing.JTable();
        txtNombre = new javax.swing.JTextField();
        cbPlaca = new javax.swing.JCheckBox();
        cbLicencia = new javax.swing.JCheckBox();
        txtFecha_inicio = new com.toedter.calendar.JDateChooser();
        txtFecha_fin = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegresar.setBackground(new java.awt.Color(0, 153, 204));
        btnRegresar.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setOpaque(true);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, -1, -1));

        btnPDF.setBackground(new java.awt.Color(0, 153, 204));
        btnPDF.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        btnPDF.setForeground(new java.awt.Color(255, 255, 255));
        btnPDF.setText("Generar PDF");
        btnPDF.setContentAreaFilled(false);
        btnPDF.setOpaque(true);
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });
        jPanel1.add(btnPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, -1, -1));

        btnAceptar.setBackground(new java.awt.Color(0, 153, 204));
        btnAceptar.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.setContentAreaFilled(false);
        btnAceptar.setOpaque(true);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, -1, -1));

        tblReporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tipo de tramite", "Persona", "Costo", "Fecha de expedición"
            }
        ));
        jScrollPane1.setViewportView(tblReporte);
        tblReporte.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tblReporte.getTableHeader().setOpaque(false);
        tblReporte.getTableHeader().setBackground(new Color(102,89,222));
        tblReporte.getTableHeader().setForeground(new Color(255,255,255));

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 530, 110));

        txtNombre.setBorder(null);
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 120, -1));

        cbPlaca.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        cbPlaca.setText("Placa");
        cbPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPlacaActionPerformed(evt);
            }
        });
        jPanel1.add(cbPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, -1, -1));

        cbLicencia.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        cbLicencia.setText("Licencia");
        cbLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLicenciaActionPerformed(evt);
            }
        });
        jPanel1.add(cbLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, -1, -1));

        txtFecha_inicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(txtFecha_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 160, -1));

        txtFecha_fin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(txtFecha_fin, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 160, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/favicon.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel11.setFont(new java.awt.Font("Roboto Medium", 1, 36)); // NOI18N
        jLabel11.setText("REPORTES");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/city.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 0, 250, -1));

        jLabel19.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel19.setText("Y");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        jLabel20.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        jLabel20.setText("Tipo de trámite");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, -1, -1));

        jLabel21.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel21.setText("Fecha entre");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel22.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel22.setText("Nombre");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1, -1));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 190, 20));

        jLabel23.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        jLabel23.setText("Buscar Por");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo que se encarga de regresar al menu principal
     *
     * @param evt evt
     */
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        frmMenuPrincipal principal = new frmMenuPrincipal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
     * Metodo que se encarga de aceptar los filtros que el usuario desea
     * utilizar
     *
     * @param evt evt
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        this.llenarTramites();
    }//GEN-LAST:event_btnAceptarActionPerformed

    /**
     * Metodo que se encarga de mostrar la tabla si el check button de placa se
     * encuentra seleccionado
     *
     * @param evt evt
     */
    private void cbPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPlacaActionPerformed
        // TODO add your handling code here:
        llenarTramites();
    }//GEN-LAST:event_cbPlacaActionPerformed

    /**
     * Metodo que se encarga de mostrar la tabla si el check button de placa se
     * encuentra seleccionado
     *
     * @param evt evt
     */
    private void cbLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLicenciaActionPerformed
        // TODO add your handling code here:
        llenarTramites();
    }//GEN-LAST:event_cbLicenciaActionPerformed

    /**
     * Metodo para que mientras vayas escribiendo en un txt se vaya llenando la
     * tabla
     *
     * @param evt evt
     */
    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        // TODO add your handling code here:
        llenarTramites();
    }//GEN-LAST:event_txtNombreKeyReleased
    /**
     * Método para agregar la información al pdf al generarse
     * @param evt evt
     */
    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        int opcion = JOptionPane.showConfirmDialog(null, "¿Quiere generar un reporte de la siguienta tabla?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            List<Reporte> listaReporte = new ArrayList<Reporte>();

            if (listaTabla.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se tiene almacenado ningún trámite");
                return;
            }

            for (Tramite tramite : listaTabla) {
                Reporte reporte = new Reporte();
                Persona persona = tramite.getPersona();
                String nombreCompleto = persona.getNombre() + " "
                        + persona.getApellidoP() + " " + persona.getApellidoM();
                reporte.setNombre(nombreCompleto);
                reporte.setFecha(tramite.getFechaEmision().toString());

                if (tramite instanceof Placa) {
                    reporte.setTipoTramite("Expedición de Placa");
                    Placa placa = (Placa) tramite;
                    reporte.setCosto(String.valueOf(placa.getCosto()));
                }

                if (tramite instanceof Licencia) {
                    reporte.setTipoTramite("Expedición de Licencia");
                    Licencia licencia = (Licencia) tramite;
                    reporte.setCosto(String.valueOf(licencia.getCosto()));
                }
                listaReporte.add(reporte);
            }
            try{
                Map parametro = new HashMap();
                
                LocalDateTime fechaHoraActual = LocalDateTime.now();
                DateTimeFormatter formatEscrito = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy, hh:mm a");
                String fechaHoraEscrita = fechaHoraActual.format(formatEscrito);
                
                parametro.put("fechaReporte", fechaHoraEscrita);
                JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(listaReporte);

                // Cargar el archivo JRXML del reporte
                InputStream reportFile = getClass().getResourceAsStream("/reporteTramites_1_1_1.jrxml");
                JasperReport jasperReport = JasperCompileManager.compileReport(reportFile);

                // Llenar el reporte con los datos
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, beanColDataSource);

                // Visualizar el reporte
                JasperExportManager.exportReportToPdfFile(jasperPrint, "./Reporte_Tramites.pdf");
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btnPDFActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JCheckBox cbLicencia;
    private javax.swing.JCheckBox cbPlaca;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable tblReporte;
    private com.toedter.calendar.JDateChooser txtFecha_fin;
    private com.toedter.calendar.JDateChooser txtFecha_inicio;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
