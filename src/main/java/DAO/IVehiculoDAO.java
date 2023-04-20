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
      * Lista de cuentas utilizada para el comboBox
      * @param persona cliente
      * @return regresa la lista con las cuentas agregadas
      */
     public List<Vehiculo> listaVehiculosCliente(Persona persona);
     
     /**
      * Metodo que se encarga de buscar un vehiculo
      * @param id
      * @return 
      */
     public Vehiculo buscarVehiculo(int id);
     
     /**
      * Método que te regresa el estado de un vehiculo
      * @param id_vehiculo id del vehiculo
      * @return el estado del vehiculo
      */
     public Vehiculo estadoNuevo(int id_vehiculo);
     
     /**
      * Método que cambia el estado a usado
      * @param id_vehiculo id del vehiculo
      * @return vehiculo con el estado actualizado
      */
     public Vehiculo cambiarEstado(int id_vehiculo);
}
