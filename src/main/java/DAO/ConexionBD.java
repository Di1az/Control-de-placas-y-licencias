/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 *
 * @author oscar
 */
public class ConexionBD implements IConexionBD{

    @Override
    public EntityManager Conexion() throws PersistenceException{
        //Creamos un Entitiy Manager factory
        EntityManagerFactory managerF = Persistence.createEntityManagerFactory("ConexionPU");
        //Creamos un objeto en la base de datos
        EntityManager entityManager = managerF.createEntityManager();

        return entityManager;
    }

}
