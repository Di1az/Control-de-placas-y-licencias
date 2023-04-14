/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Placa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * Clase que implementa la interfaz IPlacaDAO
 * @author dany
 */
public class PlacaDAO implements IPlacaDAO {
    
    /**
     * Objeto para la conexion a la BD
     */
    private IConexionBD conexionBD;

    /**
     * Método constructor que crea la conexion con la base de datos
     * @param conexionBD objeto para la conexión
     */
    public PlacaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
 
    /**
     * 
     * @param placa
     * @return 
     */
    @Override
    public Placa agregarPlaca(Placa placa) {
        EntityManager em = conexionBD.Conexion();
        try {
            em.getTransaction().begin();
            em.persist(placa); //Agrega la nueva placa en la base de datos
            em.getTransaction().commit();
            return placa;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Placa> listaPlaca() {
        EntityManager em = conexionBD.Conexion();
        try {
            em.getTransaction().begin();
            String jpql = "SELECT p FROM Persona p ";
            TypedQuery<Placa> query = em.createQuery(jpql, Placa.class);
            List<Placa> listaPlacas = query.getResultList();
            em.getTransaction().commit();
            
            
            return listaPlacas;
        } catch (Exception e) {
            return null;
        }
    }
    
}
