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
    
}
