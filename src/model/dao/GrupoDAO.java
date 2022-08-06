/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import model.bean.Grupo;

/**
 *
 * @author Marlon
 */
public class GrupoDAO {

    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    EntityManager em = new ConnectionFactory().getConnection();

    public Grupo save(Grupo g) {

        try {
            em.getTransaction().begin();
            em.persist(g);
            em.getTransaction().commit();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return g;

    }

    public List<Grupo> readGrupos() {

        List<Grupo> grupos = null;

        try {
            grupos = em.createQuery("from Grupo g").getResultList();

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }

        return grupos;
    }

    public Grupo findById(Integer id) {

        Grupo grupo = null;

        try {
            grupo = em.find(Grupo.class, id);

        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2);
        } finally {
            em.close();
        }
        return grupo;

    }

    public void update(Grupo g) {
        
        try{
        em.getTransaction().begin();
        em.merge(g);
        em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
    }

    public Grupo remove(Integer id) {
        Grupo g = null;
        try {
            g = em.find(Grupo.class, id);
            em.getTransaction().begin();
            em.remove(g);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e);
        }finally{
            em.close();
        }
        return g;
        
    }


}
