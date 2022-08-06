package view;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.bean.Usuario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marlon
 */
public class teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("meubancoBase");
       EntityManager gerente = fabrica.createEntityManager();
        
        
       Usuario P1 = new Usuario(null, "Marlon", "991876644", "admin", "159357", "teste", "teste");
       
       gerente.getTransaction().begin();
       gerente.persist(P1);
       gerente.getTransaction().commit();
       
        System.out.println("Pronto !");
    }
    
}
