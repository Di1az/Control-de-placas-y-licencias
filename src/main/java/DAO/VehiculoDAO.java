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
     * Genera una lista de todos los vehículos
     * @return lista de vehículos
     */
    @Override
    public List<Vehiculo> listaVehiculo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
    

