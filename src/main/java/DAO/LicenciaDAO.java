/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Licencia;
import java.util.List;
import javax.persistence.EntityManager;

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
     * @param conexionBD conexionBD
     */
    public LicenciaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

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

    @Override
    public List<Licencia> listaLicencia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
