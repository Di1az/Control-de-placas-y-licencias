/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Vehiculo;
import java.util.List;
import Entidades.Persona;

/**
 * Interfaz VehiculoDAO
 * @author dany
 */
public interface IVehiculoDAO {
    
    /**
     * Método que agrega a la bd un vehículo
     * @param vehiculo vehículo a agregar
     * @return el vehículo si se agrego, null de lo contrario
     */
    public Vehiculo agregarVehiculo (Vehiculo vehiculo);
    
    /**
     * Método que regresa la lista de los vehículos
     * @return lista de vehículos
     */
    public List <Vehiculo> listaVehiculo();
    
     /**
      * Lista de cuentas utilizada para el comboBox
      * @param persona cliente
      * @return regresa la lista con las cuentas agregadas
      */
     public List<Vehiculo> listaVehiculosCliente(Persona persona);
}
