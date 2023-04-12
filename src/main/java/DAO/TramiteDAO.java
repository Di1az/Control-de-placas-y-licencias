/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Tramite;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author oscar
 */
public class TramiteDAO implements ITramiteDAO{

    /**
     * Objeto para la conexion a la BD
     */
    private IConexionBD conexionBD;
    
    /**
     * Método constructor que crea la conexion con la base de datos
     * @param conexionBD objeto para la conexión
     */
    public TramiteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
   
    
    
}
