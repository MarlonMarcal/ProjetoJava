/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conection.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import model.bean.Marca;

/**
 *
 * @author Marlon
 */
public class MarcaDAO {

    EntityManager em = new ConnectionFactory().getConnection();

    public Marca save(Marca m) {

        try {
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return m;

    }

    public List<Marca> readmarcas() {

        List<Marca> marcas = null;

        try {
            marcas = em.createQuery("from Marca m").getResultList();

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }

        return marcas;
    }

    public Marca findById(Integer id) {

        Marca marca = null;

        try {
            marca = em.find(Marca.class, id);

        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2);
        } finally {
            em.close();
        }
        return marca;

    }

    public void update(Marca m) {

        try {
            em.getTransaction().begin();
            em.merge(m);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }

    public Marca remove(Integer id) {

        Marca m = null;
        try {
            m = em.find(Marca.class, id);
            em.getTransaction().begin();
            em.remove(m);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e);
        } finally {
            em.close();
        }
        return m;

    }



    public void setarNome(Marca m) {

    }

}
