/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

/**
 * Interfaz implementada en ConexionDAO
 * @author oscar
 */
public interface IConexionBD {
    /**
     * Método para realizar la conexión a la BD
     * @return entity manager
     * @throws PersistenceException 
     */
    public EntityManager Conexion() throws PersistenceException; 
}
