/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.ConexionBD;
import DAO.IConexionBD;
import DAO.IPlacaDAO;
import DAO.IVehiculoDAO;
import DAO.PlacaDAO;
import DAO.VehiculoDAO;

import Entidades.Persona;
import Entidades.Placa;
import java.util.Iterator;
import java.util.List;
import Entidades.Vehiculo;
import java.util.Date;
import java.util.Random;
import javax.persistence.metamodel.SingularAttribute;
import javax.swing.JOptionPane;

/**
 *
 * @author dany
 */
public class frmPlacas extends javax.swing.JFrame {

    private final IPlacaDAO placaDAO;
    private final IVehiculoDAO vehiculoDAO;
    private Persona persona;
    private Vehiculo vehiculo;
    private boolean desactivarPlaca;

    /**
     * Método constructor que inicializa los atributos
     *
     * @param placaDAO placaDAO
     * @param vehiculoDAO vehiculoDAO
     * @param persona persona param desactivarPlaca
     * @param desactivarPlaca 
     */
    public frmPlacas(IPlacaDAO placaDAO, IVehiculoDAO vehiculoDAO, Persona persona, boolean desactivarPlaca) {
        initComponents();
        this.placaDAO = placaDAO;
        this.vehiculoDAO = vehiculoDAO;
        this.persona = persona;
        this.desactivarPlaca = desactivarPlaca;
        llenarCombo();
    }

    /**
     * Metodo para llenar el comboBox con los vehiculos activos del cliente
     */
    public void llenarCombo() {
        cbVehiculo.removeAllItems();
        List<Vehiculo> llenaCb = vehiculoDAO.listaVehiculosCliente(persona);
        System.out.println(llenaCb.size());
        if (llenaCb == null) {

        } else {
            Iterator bonchan = llenaCb.iterator();
            while (bonchan.hasNext()) {
                Vehiculo vehiculo = (Vehiculo) bonchan.next();
                this.cbVehiculo.addItem(vehiculo);
            }
        }
    }

    /**
     * Método que genera una cadena de 10 digitos aleatoria
     *
     * @return regresa la cadena
     */
//    public String generarPlacaAleatoria(int longitud) {
//        // Lista de caracteres válidos para la placa
//        char[] caracteresValidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
//
//        // Crear un objeto Random
//        Random rnd = new Random();
//
//        // Generar una placa de la longitud especificada
//        StringBuilder placa = new StringBuilder();
//        for (int i = 0; i < longitud; i++) {
//            placa.append(caracteresValidos[rnd.nextInt(caracteresValidos.length)]);
//        }
//
//        return placa.toString();
//    }
    public String generarPlacaAleatoria() {
        // Lista de caracteres válidos para las letras de la placa
        char[] letrasValidas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        // Crear un objeto Random
        Random rnd = new Random();

        // Generar las tres letras de la placa
        StringBuilder letras = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            letras.append(letrasValidas[rnd.nextInt(letrasValidas.length)]);
        }

        // Generar los dos dígitos para la primera parte de la placa
        int num1 = rnd.nextInt(10);
        int num2 = rnd.nextInt(10);

        // Generar los dos dígitos para la segunda parte de la placa
        int num3 = rnd.nextInt(10);
        int num4 = rnd.nextInt(10);

        // Construir la placa completa
        StringBuilder placa = new StringBuilder();
        placa.append(letras);
        placa.append("-");
        placa.append(num1);
        placa.append(num2);
        placa.append("-");
        placa.append(num3);
        placa.append(num4);

        return placa.toString();
    }

    public float calcularPrecio(Vehiculo vehiculo) {
        float precio = 0;
        if (vehiculo.getEstado() != null && vehiculo.getEstado().equals("Nuevo")) {
            precio = 1500;
        } else if (vehiculo.getEstado() != null && vehiculo.getEstado().equals("Usado")) {
            precio = 1000;
        }
        return precio;
    }

    /**
     * Método que agrega la placa a la bd
     */
    public void agregar() {

        Date fechaEmision = new Date();
        Date fechaRecepcion = new Date();

        fechaRecepcion.setYear((fechaRecepcion.getYear() + 6));

        String estado = "Vigentes";

        String p = generarPlacaAleatoria();

        if (cbVehiculo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "No tiene vehiculos");
            return;
        } else {
            vehiculo = (Vehiculo) cbVehiculo.getSelectedItem();
        }

        Placa placa = new Placa(calcularPrecio(vehiculo), p, estado, vehiculo, fechaRecepcion, fechaEmision, persona);
        if (desactivarPlaca) {
           
            placaDAO.DesactivarPlaca(vehiculo.getId());

        }
        if (placaDAO.agregarPlaca(placa) == null) {
            JOptionPane.showMessageDialog(this, "No se pudo registrar la placa");
        } else {

            JOptionPane.showMessageDialog(this, "Registro exitoso");
            frmMenuPrincipal principal = new frmMenuPrincipal(persona);
            principal.setVisible(true);
            this.dispose();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        cbVehiculo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Vehiculo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Solicitar placas");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));

        getContentPane().add(cbVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 180, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        frmMenuPrincipal principal = new frmMenuPrincipal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        /*JOptionPane.showMessageDialog(this, "Placas registradas correctamentes");
        frmMenuPrincipal principal= new frmMenuPrincipal();
        principal.setVisible(true);
        this.dispose();*/
        IConexionBD conexion = new ConexionBD();
        IPlacaDAO pla = new PlacaDAO(conexion);
        vehiculo = (Vehiculo) cbVehiculo.getSelectedItem();
        if (pla.placaActiva(vehiculo.getId()) != null) {
            int opcion = JOptionPane.showConfirmDialog(null, "El vehiculo ya tiene placas vigentes, ¿Deseas una nueva(Toma en cuenta"
                    + " que se cancelara la anterior)?", "Confirmar", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {

                this.agregar();

            } else {
                return;
            }
        } else {

            this.agregar();

        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPlacas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPlacas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPlacas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPlacas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new frmPlacas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<Vehiculo> cbVehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
