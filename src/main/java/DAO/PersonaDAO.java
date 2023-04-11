/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Encriptacion.Encriptar;
import Entidades.Persona;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author oscar
 */
public class PersonaDAO implements IPersonaDAO {

    private IConexionBD conexionBD;

    public PersonaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Persona registrarPersona(Persona persona) {
        EntityManager em = conexionBD.Conexion();
        Encriptar en= new Encriptar();
        String nombre=en.encriptar(persona.getNombre());
        String apellidoP= en.encriptar(persona.getApellidoP());
        String apellidoM= en.encriptar(persona.getApellidoM());
        persona.setNombre(nombre);
        persona.setApellidoP(apellidoP);
        persona.setApellidoM(apellidoM);
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

    /**
     * Método que devuelve la lista de personas
     *
     * @return lista de personas
     */
    @Override
    public List<Persona> listaPersona() {
        EntityManager em = conexionBD.Conexion();
        try {
            em.getTransaction().begin();
            String jpql = "SELECT p FROM Persona p ";
            TypedQuery<Persona> query = em.createQuery(jpql, Persona.class);
            List<Persona> listaPersonas = query.getResultList();
            em.getTransaction().commit();
            return listaPersonas;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Método que por medio del rfc busca si una persona esta registrada en la
     * bd
     *
     * @param RFC rfc de la persona
     * @return la persona, null de lo contrario
     */
    @Override
    public Persona buscarPersona(String RFC) {
        EntityManager em = conexionBD.Conexion();
        try {
            em.getTransaction().begin();
            String jpql = "SELECT p FROM Persona p WHERE p.rfc = :rfc ";
            TypedQuery<Persona> query = em.createQuery(jpql, Persona.class);
            query.setParameter("rfc", RFC);
            Persona persona = query.getSingleResult();
            em.getTransaction().commit();
            return persona;
        } catch (Exception e) {
            return null;
        }

    }
}
