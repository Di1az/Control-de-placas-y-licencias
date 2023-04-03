/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

/**
 *
 * @author oscar
 */
public interface IConexionBD {
    public EntityManager Conexion() throws PersistenceException; 
}
