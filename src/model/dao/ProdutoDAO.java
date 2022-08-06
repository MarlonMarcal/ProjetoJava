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
import model.bean.Produto;

/**
 *
 * @author Marlon
 */
public class ProdutoDAO {



    EntityManager em = new ConnectionFactory().getConnection();

    public Produto save(Produto p) {

        try {

            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (Exception e) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "ERRO AO SALVAR " + e);

        } finally {
            em.close();
        }
        System.out.println(p);
        return p;

    }

    public List<Produto>  findById(Integer id) {

        List<Produto> produtos = null;

        try {
            produtos = em.createQuery("from Produto p where p.codigo ="+ id).getResultList();

        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2);
        } finally {
            em.close();
        }
        return produtos;

    }

    public List<Produto> findBymarcas() {

        List<Produto> produtos = null;

        try {
            produtos = em.createQuery("from Produto p").getResultList();

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }

        return produtos;
    }

    public List<Produto> findByDescricao(String descricao) {

        List<Produto> produtos = null;

        try {
           produtos = em.createQuery("from Produto p where p.descricao like'%"+ descricao +"%'").getResultList();

        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2);
        } finally {
            em.close();
        }
        return produtos;

    }

    public List<Produto> findByCodMarca(Marca marca) {

        List<Produto> produtos = null;

        try {
            em.merge(marca);
            produtos = em.createQuery("from Produto p where p.marca ="+ marca.getCodigo()).getResultList();

        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2);
        } finally {
            em.close();
        }
        return produtos;

    }

 

}
