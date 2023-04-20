/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Licencia;
import java.util.List;

/**
 * Interfaz de LicenciaDAO
 * @author Dany
 */
public interface ILicenciaDAO {
    
    /**
     * Método que agrega a la bd una licencia
     * @param licencia licencia a agregar
     * @return una licencia si se agrega, null de lo contrario
     */
    public Licencia agregarLicencia (Licencia licencia);
    
    /**
     * Metodo que se encarga de regresar las licencias
     * que se encuentren vigentes
     * @param rfc RFC
     * @return lista de licencias vigentes
     */
    public List<Licencia> listarLicenciaVigentesPersona(String rfc);
    
     /**
     * Metodo que se encarga de obtener la licencia que la persona tiene
     * actualmente
     *
     * @param id_persona id de la persona
     * @return Licencia que se encuentre activa
     */
    public Licencia LicenciaActiva(int id_persona);
    
    /**
     * Metodo que se encarga de desactivar la licencia que la persona tiene
     * actualmente
     *
     * @param id_persona id de la persona
     * @return Licencia desactivada
     */
    public Licencia DesactivarActual(int id_persona);
}
