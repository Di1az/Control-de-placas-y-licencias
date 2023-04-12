/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Placa;
import java.util.List;
import javax.persistence.EntityManager;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
