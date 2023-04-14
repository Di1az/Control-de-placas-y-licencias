/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Licencia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * Clase que implementa la interfaz ILicenciaDAO
 * @author Dany
 */
public class LicenciaDAO implements ILicenciaDAO{
    
     /**
     * Objeto para la conexion a la BD
     */
    private IConexionBD conexionBD;
    
    /**
     * Método constructor que crea la conexion con la base de datos
     * @param conexionBD objeto para la conexión
     */
    public LicenciaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     * Metodo que se encarga de insertar licencia
     * @param licencia
     * @return licencia
     */
    @Override
    public Licencia agregarLicencia(Licencia licencia) {
       EntityManager em = conexionBD.Conexion();
        try {
            em.getTransaction().begin();
            em.persist(licencia); //Agrega la nueva licencia en la base de datos
            em.getTransaction().commit();
            return licencia;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Metodo que regresa una lista con
     * todas las licecias registradas
     * @return 
     */
    @Override
    public List<Licencia> listaLicencia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Metodo que se encarga de regresar una lista de licencias
     * dependiendo del rfc recibido en el parametro
     * @param rfc
     * @return 
     */
    @Override
    public List<Licencia> listarLicenciaVigentesPersona(String rfc) {
        EntityManager em = conexionBD.Conexion();
        try {
            em.getTransaction().begin();
            String jpql = "SELECT l FROM Licencia l WHERE l.persona.rfc = :rfc AND l.fechaRecepcion > CURRENT_DATE";
            TypedQuery<Licencia> query = em.createQuery(jpql, Licencia.class);
            query.setParameter("rfc", rfc);
            List<Licencia> licencia = query.getResultList();
            em.getTransaction().commit();
            return licencia;
        } catch (Exception e) {
            return null;
        }
    }
    
    
}
