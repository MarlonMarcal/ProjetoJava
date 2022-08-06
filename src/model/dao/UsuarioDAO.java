/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conection.ConnectionFactory;
import java.awt.HeadlessException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import model.bean.Usuario;
import view.JfPrincipal;

/**
 *
 * @author Marlon
 */
public class UsuarioDAO {



    EntityManager em = new ConnectionFactory().getConnection();

    public Usuario logar(String login, String senha) {

        Usuario u = new Usuario();

        try {

            String jpql = "from Usuario u where usuario.login= :login and usuario.senha= :senha";
            Query query = em.createQuery(jpql)
                    .setParameter("login", login)
                    .setParameter("senha", senha);

            if (query.getResultList().isEmpty()) {
                JOptionPane.showMessageDialog(null, "usuário e/ou senha inválido(s)", "Erro ao Logar !", 2);
            } else {

                JfPrincipal principal = new JfPrincipal();
                principal.setVisible(true);

            }

        } catch (HeadlessException e) {
            System.out.println(e);

        } finally {
            em.close();
        }
        return u;

    }

    public Usuario save(Usuario u) {

        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return u;

    }

    public List<Usuario> readusuarios() {

        List<Usuario> usuarios = null;

        try {
            usuarios = em.createQuery("from Usuario m").getResultList();

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }

        return usuarios;
    }

    public Usuario findById(Integer id) {

        Usuario usuario = null;

        try {
            usuario = em.find(Usuario.class, id);

        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2);
        } finally {
            em.close();
        }
        return usuario;

    }

    public void update(Usuario u) {

        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }
}
