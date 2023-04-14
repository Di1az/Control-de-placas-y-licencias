/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author oscar
 */
public class Main {
    public static void main(String[] args) {
        frmMenuPrincipal principal= new frmMenuPrincipal();
        principal.setVisible(true);
        EntityManagerFactory enti = Persistence.createEntityManagerFactory("ConexionPU");
        //Entimanager
        EntityManager entity = enti.createEntityManager();
        //Transacion

        entity.getTransaction().begin();
        entity.getTransaction().commit();
        entity.close();
        enti.close();
    }
}
