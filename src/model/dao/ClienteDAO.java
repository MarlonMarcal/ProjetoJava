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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import static view.TelaConsultaCliente.jTable1;
import static view.TelaConsultaCliente.txtPesquisaCli;

/**
 *
 * @author Marlon
 */
public class ClienteDAO {

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    EntityManager em = new ConnectionFactory().getConnection();

    public Cliente save(Cliente c) {

        try {

            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (Exception e) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "ERRO AO SALVAR " + e);

        } finally {
            em.close();
        }
        return c;

    }

    public Cliente remove(Integer id) {

        Cliente c = null;
        try {
            c = em.find(Cliente.class, id);
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e);
        } finally {
            em.close();
        }
        return c;

    }

    public void update(Cliente c) {

        try {
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }

    public void recuperarCliente(Cliente c) {

    }

    public List<Cliente> findByCgc(String cgc) {

        List<Cliente> clientes = null;

        try {
            clientes = em.createQuery("from Cliente c where c.cgc like '%" + cgc + "%'").getResultList();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return clientes;

    }

    public Cliente findById(Integer id) {

        Cliente cliente = null;

        try {
            cliente = em.find(Cliente.class, id);

        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2);
        } finally {
            em.close();
        }
        return cliente;

    }

    public List<Cliente> findByNome(String nome) {

        List<Cliente> clientes = null;

        try {
            clientes = em.createQuery("from Cliente c where c.nome like '%" + nome + "%'").getResultList();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return clientes;
    }

    public void setar_campos(Cliente c) {

        //int setar = jTable1.getSelectedRow();
        String id = "" + jTable1.getValueAt(jTable1.getSelectedRow(), 0);
        String sql = "select * from cliente where idcliente= ?";

        try {

            con = ConnectionFactory.getJdbc();
            stmt = (PreparedStatement) con.prepareStatement(sql);
            //stmt = con.prepareStatement(sql);

            stmt.setString(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {

                c.setIdCliente(rs.getInt(1));
                c.setCgc(rs.getString(2));
                c.setNome(rs.getString(3));
                c.setCelular(rs.getString(4));
                c.setTelefone(rs.getString(5));
                c.setEmail(rs.getString(6));
                c.setCep(rs.getString(7));
                c.setEndereco(rs.getString(8));
                c.setComplemento(rs.getString(9));
                c.setNumero(rs.getString(10));
                c.setBairro(rs.getString(11));
                c.setCidade(rs.getString(12));
                c.setUf(rs.getString(13));
                c.setInativo(rs.getBoolean(14));
                c.setDatacadastro(rs.getDate(15));
                c.setDataalteracao(rs.getDate(16));

                //desabilitando funções
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não Encontrada!");
            }
        } catch (SQLException e2) {
            JOptionPane.showMessageDialog(null, e2);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

    }

    public List<Cliente> findByCod(String cod) {

        List<Cliente> clientes = null;

        try {
            clientes = em.createQuery("from Cliente c where c.nome like '%" + cod + "%'").getResultList();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return clientes;

    }

}
