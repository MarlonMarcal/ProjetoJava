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

    public void salvar(Cliente c) {

        String sql = "INSERT INTO cliente(CGC, NOME, CELULAR, TELEFONE, EMAIL, CEP, ENDERECO,"
                + " COMPLEMENTO, NUMERO, BAIRRO, CIDADE, UF, INATIVO ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        con = null;
        stmt = null;
        rs = null;
        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, c.getCgc());
            stmt.setString(2, c.getNome());
            stmt.setString(3, c.getCelular());
            stmt.setString(4, c.getTelefone());
            stmt.setString(5, c.getEmail());
            stmt.setString(6, c.getCep());
            stmt.setString(7, c.getEndereco());
            stmt.setString(8, c.getComplemento());
            stmt.setString(9, c.getNumero());
            stmt.setString(10, c.getBairro());
            stmt.setString(11, c.getCidade());
            stmt.setString(12, c.getUf());
            stmt.setBoolean(13, c.getInativo());
            //stmt.setDate(14, c.getDatacadastro());
            //stmt.setDate(15, c.getDataalteracao());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO SALVAR " + e);
            System.out.println(e);
        } finally {

            //Fechar as conexões 
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

    }
    /**
     * Deleta cliente
     *
     * @param c
     * @exception  Exception caso ocorra algum erro
     */
    
    public void Deletar(Cliente c) {

        con = ConnectionFactory.getConnection();
        stmt = null;

        String sql = "delete from cliente where idcliente = ?;";

        try {

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setInt(1, c.getIdCliente());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cliente Excluido!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    /**
     * update Cliente
     *
     * @param c cliente
     * @exception  Exception caso ocorra algum erro
     */
    public void update(Cliente c) {

        String sql = "UPDATE cliente SET CGC=?, NOME=?, CELULAR=?, TELEFONE=?, EMAIL=?, CEP=?, ENDERECO=?, COMPLEMENTO=?, NUMERO=?, BAIRRO=?, CIDADE=?, UF=?, INATIVO=?, DATAALTERACAO=? WHERE idcliente =?";

        con = null;
        stmt = null;
        rs = null;
        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, c.getCgc());
            stmt.setString(2, c.getNome());
            stmt.setString(3, c.getCelular());
            stmt.setString(4, c.getTelefone());
            stmt.setString(5, c.getEmail());
            stmt.setString(6, c.getCep());
            stmt.setString(7, c.getEndereco());
            stmt.setString(8, c.getComplemento());
            stmt.setString(9, c.getNumero());
            stmt.setString(10, c.getBairro());
            stmt.setString(11, c.getCidade());
            stmt.setString(12, c.getUf());
            stmt.setBoolean(13, c.getInativo());
            //stmt.setDate(14, c.getDatacadastro());
            stmt.setTimestamp(14, c.getDataalteracao());
            stmt.setInt(15, c.getIdCliente());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Atualizado");
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR " + e);
            
        } finally {

            //Fechar as conexões 
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

    }
    /**
     * Recupera codigo e data do banco de dados
     *
     * @param c
     * @exception  Exception caso ocorra algum erro
     */
    public void recuperarCliente(Cliente c) {

        String sql = "select max(idcliente), max(datacadastro) from cliente";

        try {
            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {

                c.setIdCliente(rs.getInt(1));

                c.setDatacadastro(rs.getTimestamp(2));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro Buscar ID" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

    }
    /**
     * Lista de cliente, busca cliente pelo CGC
     *
     * @return clientes
     * @exception  SQLException caso ocorra algum erro
     */
    public List<Cliente> readcgc() {

        con = ConnectionFactory.getConnection();
        stmt = null;
        rs = null;

        List<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT * FROM cliente where cgc like ? ";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, txtPesquisaCli.getText() + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente objcliente = new Cliente();
                
                objcliente.setIdCliente(rs.getInt("idcliente"));
                objcliente.setCgc(rs.getString("cgc"));
                objcliente.setNome(rs.getString("nome"));
                objcliente.setCelular(rs.getString("celular"));
                objcliente.setCidade(rs.getString("cidade"));
                clientes.add(objcliente);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return clientes;
    }
    /**
     * Lista de cliente, busca cliente pelo Nome
     *
     * @return clientes
     * @exception  SQLException caso ocorra algum erro
     */
    public List<Cliente> readnome() {

        con = ConnectionFactory.getConnection();
        stmt = null;
        rs = null;

        List<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT * FROM cliente where nome like ? ";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + txtPesquisaCli.getText() + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente objcliente = new Cliente();
                
                objcliente.setIdCliente(rs.getInt("idcliente"));
                objcliente.setCgc(rs.getString("cgc"));
                objcliente.setNome(rs.getString("nome"));
                objcliente.setCelular(rs.getString("celular"));
                objcliente.setCidade(rs.getString("cidade"));
                clientes.add(objcliente);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return clientes;
    }
    
    /**
     * seta os dados do cliente na tela de clientes, do cliente selecionado na tela 
     * pesquisado de Clientes
     *
     * @param c cliente
     * @exception  SQLException caso ocorra algum erro
     */
    public void setar_campos(Cliente c) {

        //int setar = jTable1.getSelectedRow();
        String id =  "" +jTable1.getValueAt(jTable1.getSelectedRow(), 0);
        String sql = "select * from cliente where idcliente= ?";

        try {

            con = ConnectionFactory.getConnection();
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
                c.setDatacadastro(rs.getTimestamp(15));
                c.setDataalteracao(rs.getTimestamp(16));
                
               

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

    public void read(Cliente c) {

        con = ConnectionFactory.getConnection();
        stmt = null;
        rs = null;

        String sql = "SELECT * FROM cliente where cgc = ? ";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getCgc());
            rs = stmt.executeQuery();

            if (rs.next()) {

                System.out.println(rs);

                c.setCgc(rs.getString("cgc"));
                c.setNome(rs.getString("nome"));
                c.setCelular(rs.getString("celular"));
                c.setCidade(rs.getString("cidade"));
            } else {
                JOptionPane.showMessageDialog(null, "Cliente Não Cadastrado!");
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Não Encontrado " + e);
        }

    }

}
