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
 *
 * @author dany
 */
public class PlacaDAO implements IPlacaDAO {

    /**
     * Objeto para la conexion a la BD
     */
    private IConexionBD conexionBD;

    /**
     * Método constructor que crea la conexion con la base de datos
     *
     * @param conexionBD objeto para la conexión
     */
    public PlacaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     * Método que agrega una placa 
     * @param placa placa a agregar
     * @return la placa
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
    
    /**
     * Método que genera una lista de las placas 
     * @return lista de placas
     */
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

    /**
     * Metodo que se encarga de comprobar que el vehiculo cuenta con una placa
     * activa
     * @param id_vehiculo id del vehiculo
     * @return placa que se encuentre activa
     */
    @Override
    public Placa placaActiva(int id_vehiculo) {
        EntityManager em = conexionBD.Conexion();
        try {
            em.getTransaction().begin();

            // Verificar si existe una licencia vigente para el usuario
            TypedQuery<Placa> consultaPlaca = em.createQuery("SELECT p FROM Placa p WHERE p.vehiculo.id = :id AND p.estado = 'Vigentes'", Placa.class);
            consultaPlaca.setParameter("id", id_vehiculo);
            Placa PlacaActiva = consultaPlaca.getSingleResult();

            em.getTransaction().commit();

            return PlacaActiva;
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    /**
     * Metodo que se encarga de desactivar placa del vehiculo
     *
     * @param id_vehiculo id del vehiculo
     * @return placa que se encuentre activa
     */
    @Override
    public Placa DesactivarPlaca(int id_vehiculo) {
        EntityManager em = conexionBD.Conexion();
        try {
            em.getTransaction().begin();
            Placa placa = this.placaActiva(id_vehiculo);

            Placa placaCambiar = em.find(Placa.class, placa.getId());

            placaCambiar.setEstado("Vencidas");
            em.merge(placaCambiar); //Agrega la nueva placa en la base de datos
            em.getTransaction().commit();
            return placa;
        } catch (Exception e) {

            return null;
        }
    }
}
