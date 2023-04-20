/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Persona;
import Entidades.Vehiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * Clase que implementa la interfaz IVehiculoDAO
 * @author dany
 */
public class VehiculoDAO implements IVehiculoDAO {
    
    /**
     * Objeto para la conexion a la BD
     */
    private IConexionBD conexionBD;
    
    /**
     * Método constructor que crea la conexion con la base de datos
     * @param conexionBD conexionBD
     */
    public VehiculoDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    /**
     * Método que agrega un vehículo a la bd
     * @param vehiculo vehículo a agregar
     * @return el vehículo, nulo de lo contrario
     */
    @Override
    public Vehiculo agregarVehiculo(Vehiculo vehiculo) {
        EntityManager em = conexionBD.Conexion();
        try {
            em.getTransaction().begin();
            em.persist(vehiculo); //Agrega el nueva vehículo en la base de datos
            em.getTransaction().commit();
            return vehiculo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Método que imprime una lista de los vehiculos de una persona en especifico
     * @param persona persona en especifico 
     * @return la lista de vehiculos 
     */
    @Override
    public List<Vehiculo> listaVehiculosCliente(Persona persona) {
        EntityManager em = conexionBD.Conexion();
        try {
            em.getTransaction().begin();
            String jpql = "SELECT v FROM Vehiculo v WHERE v.persona.id = :id";
            TypedQuery<Vehiculo> query = em.createQuery(jpql, Vehiculo.class);
            query.setParameter("id", persona.getId());
            List<Vehiculo> listaVehiculos = query.getResultList();
            em.getTransaction().commit();
            return listaVehiculos;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Metodo que se encarga de devolver un vehiculo
     * dependiendo del id ingresado en el parametro
     * @param id id del vehiculo
     * @return vehiculo 
     */
    @Override
    public Vehiculo buscarVehiculo(int id) {
        EntityManager em = conexionBD.Conexion();
        try {
            em.getTransaction().begin();
            String jpql = "SELECT v FROM Vehiculo v WHERE v.id = :id ";
            TypedQuery<Vehiculo> query = em.createQuery(jpql, Vehiculo.class);
            query.setParameter("id", id);
            Vehiculo vehiculo = query.getSingleResult();
            em.getTransaction().commit();
            return vehiculo;
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * Metodo que se encarga de devolver el estado del vehiculo
     * @param id_vehiculo id del vehiculo
     * @return estado del coche nuevo
     */
    @Override
    public Vehiculo estadoNuevo(int id_vehiculo) {
        EntityManager em = conexionBD.Conexion();
        try {
            em.getTransaction().begin();

            TypedQuery<Vehiculo> consultaPlaca = em.createQuery("SELECT v FROM Vehiculo v WHERE v.id = :id AND v.estado = 'Nuevo'", Vehiculo.class);
            consultaPlaca.setParameter("id", id_vehiculo);
            Vehiculo vehiculoNuevo = consultaPlaca.getSingleResult();

            em.getTransaction().commit();

            return vehiculoNuevo;
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    /**
     * Metodo que se encarga de cambiar el estado del vehiculo a usado
     * @param id_vehiculo id del vehiculo a cambiar el estado
     * @return vehiculo con el estado en Usado
     */
    @Override
    public Vehiculo cambiarEstado(int id_vehiculo) {
        EntityManager em = conexionBD.Conexion();
        try {
            em.getTransaction().begin();
            Vehiculo vehiculo = this.estadoNuevo(id_vehiculo);

            Vehiculo estadoUsado = em.find(Vehiculo.class, vehiculo.getId());

            estadoUsado.setEstado("Usado");
            em.merge(estadoUsado); //Agrega la nueva placa en la base de datos
            em.getTransaction().commit();
            return vehiculo;
        } catch (Exception e) {

            return null;
        }
    }
}
    

