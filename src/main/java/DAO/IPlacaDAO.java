/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Placa;
import java.util.List;



/**
 * Interfaz con todo los metodos de Placas
 * @author dany
 */
public interface IPlacaDAO {
    
    /**
     * Método para agregar una placa 
     * @param placa placa a registrar
     * @return la placa si se agrega, null de lo contrario
     */
    public Placa agregarPlaca (Placa placa);
    
    /**
     * Método que regresa la lista de las placas
     * @return lista de placas
     */
    public List <Placa> listaPlaca();
    
    /**
     * Metodo que se encarga de comprobar
     * que el vehiculo cuenta con una placa activa
     * @param id_vehiculo
     * @return placa que se encuentre activa
     */
    public Placa placaActiva(int id_vehiculo);
    
    /**
     * Metodo que se encarga de desactivar placa
     * del vehiculo
     * @param id_vehiculo
     * @return placa que se encuentre activa
     */
    public Placa DesactivarPlaca(int id_vehiculo);
}
