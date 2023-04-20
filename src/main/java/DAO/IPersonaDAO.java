/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Entidades.Persona;
import java.util.Date;
import java.util.List;

/**
 * Interfaz a implementar en PersonaDAO con todos los metodos de Persona
 * @author oscar
 */
public interface IPersonaDAO {
    public Persona registrarPersona(Persona persona);
    
    /**
     * Método que devuelve una lista de todas las personas
     * @return lista de personas
     */
    public List<Persona> listaPersona();
    
    /**
     * Método que comprueba si la rfc introducida existe
     * @param RFC rfc de la persona
     * @return persona encontrada, null de lo contrario
     */
    public Persona buscarPersona(String RFC);
    
    /**
     * Metodo que se encarga de buscar tramites mediante el RFC de la persona
     *
     * @param rfc
     * @return
     */
    public List<Persona> listaPersonasRFC (String rfc);

    /**
     * Metodo que se encarga de buscar tramites mediante la fecha de nacimiento
     * de la persona
     *
     * @param fechaN
     * @return
     */
    public List<Persona> listaPersonasFechaN (Date fechaN);

    }
     
