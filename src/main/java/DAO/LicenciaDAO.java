/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Licencia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Clase que implementa la interfaz ILicenciaDAO 
 *
 * @author Dany
 */
public class LicenciaDAO implements ILicenciaDAO {

    /**
     * Objeto para la conexion a la BD
     */
    private IConexionBD conexionBD;

    /**
     * Método constructor que crea la conexion con la base de datos
     *
     * @param conexionBD objeto para la conexión
     */
    public LicenciaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     * Metodo que se encarga de insertar licencia
     *
     * @param licencia licencia a agregar
     * @return la licencia si es agregada, null de lo contrario
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
     * Metodo que se encarga de regresar una lista de licencias dependiendo del
     * rfc recibido en el parametro
     *
     * @param rfc RFC de la persona
     * @return Licencias vigentes de personas
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

    /**
     * Metodo que se encarga de obtener la licencia que la persona tiene
     * actualmente
     *
     * @param id_persona id de la persona
     * @return Licencia que se encuentre activa
     */
    @Override
    public Licencia LicenciaActiva(int id_persona) {
        EntityManager em = conexionBD.Conexion();
        try {
            em.getTransaction().begin();

            // Verificar si existe una licencia vigente para el usuario
            TypedQuery<Licencia> consultaLicencia = em.createQuery("SELECT l FROM Licencia l WHERE l.persona.id = :id AND l.estado = 'Activa'", Licencia.class);
            consultaLicencia.setParameter("id", id_persona);
            Licencia LicenciasActiva = consultaLicencia.getSingleResult();

            em.getTransaction().commit();

            return LicenciasActiva;
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }

    }

    /**
     * Metodo que se encarga de desactivar la licencia que la persona tiene
     * actualmente
     *
     * @param id_persona id de la persona
     * @return Licencia desactivada
     */
    @Override
    public Licencia DesactivarActual(int id_persona) {
        EntityManager em = conexionBD.Conexion();
        try {
            em.getTransaction().begin();
            Licencia licencia = this.LicenciaActiva(id_persona);

            Licencia licenciaCambiar = em.find(Licencia.class, licencia.getId());

            licenciaCambiar.setEstado("Desactivado");
            em.merge(licenciaCambiar); //Agrega la nueva licencia en la base de datos
            em.getTransaction().commit();
            return licencia;
        } catch (Exception e) {

            return null;
        }
    }

}
