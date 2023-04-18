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
    
    /**
     * Objeto de tipo IPlacaDAO
     */
    private final IPlacaDAO placaDAO;
    
    /**
     * Objeto de tipo IVehiculoDAO
     */
    private final IVehiculoDAO vehiculoDAO;
    
    /**
     * Objeto de tipo Persona
     */
    private Persona persona;
    
    /**
     * Objeto de tipo Vehiculo
     */
    private Vehiculo vehiculo;
    
    /**
     * Atributo de tipo booleano para desactivar la placa
     */
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
     * Método para generar aleatoriamente el número de placa
     * @return el String de la placa
     */
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
    
    /**
     * Método para calcular el precio del vehiculo dependiendo si es usado o nuevo
     * @param vehiculo objeto para sacar el estado del vehiculo
     * @return el precio de la placa
     */
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

        jPanel1 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        cbVehiculo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
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
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, -1, -1));

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
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, -1, -1));

        cbVehiculo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204), 2));
        jPanel1.add(cbVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 240, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/city.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, -1, -1));

        jLabel11.setFont(new java.awt.Font("Roboto Medium", 1, 36)); // NOI18N
        jLabel11.setText("TRÁMITE PLACA");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/favicon.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel14.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        jLabel14.setText("Vehículo");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Método que al dar click al boton regresa al menu principal
     * @param evt 
     */
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        frmMenuPrincipal principal = new frmMenuPrincipal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed
    /**
     * Método que al dar click en el boton agrega las placas al vehiculo seleccionado, si el 
     * vehiculo ya cuenta con placas, pregunta si al usuario si desea sacar otras placas
     * @param evt evt
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<Vehiculo> cbVehiculo;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
