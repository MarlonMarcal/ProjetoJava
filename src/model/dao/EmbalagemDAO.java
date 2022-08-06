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
import model.bean.Embalagem;

/**
 *
 * @author Marlon
 */
public class EmbalagemDAO {

    EntityManager em = new ConnectionFactory().getConnection();

    public Embalagem save(Embalagem e) {

        try {
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return e;
    }

    public List<Embalagem> readEmbalagem() {

        List<Embalagem> embalagens = null;

        try {
            embalagens = em.createQuery("from Embalagem e").getResultList();

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }

        return embalagens;
    }

    public Embalagem findById(Integer id) {

        Embalagem embalagem = null;

        try {
            embalagem = em.find(Embalagem.class, id);

        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2);
        } finally {
            em.close();
        }
        return embalagem;

    }

    public void update(Embalagem e) {

        try {
            em.getTransaction().begin();
            em.merge(e);
            em.getTransaction().commit();
        } catch (Exception e2) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }

    public Embalagem remove(Integer id) {

        Embalagem e = null;
        try {
            e = em.find(Embalagem.class, id);
            em.getTransaction().begin();
            em.remove(e);
            em.getTransaction().commit();

        } catch (Exception e2) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e);
        } finally {
            em.close();
        }
        return e;

    }

    public void setarcampo(Embalagem e) {

    }

    public void setarEmbalagem(Embalagem e) {

    }

    public void setarNome(Embalagem e) {

    }
}
