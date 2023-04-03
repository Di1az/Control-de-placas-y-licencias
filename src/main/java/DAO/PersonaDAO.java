/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Persona;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author oscar
 */
public class PersonaDAO implements IPersonaDAO{
    private IConexionBD conexionBD;

    public PersonaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Persona registrarPersona(Persona persona) {
    EntityManager em = conexionBD.Conexion();
    try {
        em.getTransaction().begin();
        em.persist(persona); //Agrega la nueva persona en la base de datos
        em.getTransaction().commit();
        return persona;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    } finally {
        em.close();
    }
}

    @Override
    public List<Persona> listaPersona() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
