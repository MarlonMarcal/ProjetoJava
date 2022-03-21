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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Embalagem;
import static view.TelaEmbalagem.jtbEmbalagens;

/**
 *
 * @author Marlon
 */
public class EmbalagemDAO {

    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    /**
     * Salvar, salvar dados da embalagem no banco de dados 
     * @param e Embalagem 
     * @exception  SQLException caso ocorra algum erro
     */
    public void salvar(Embalagem  e) {

        String sql = "INSERT INTO embalagem (embalagem, descricao) VALUES(?,?)";

        con = null;
        stmt = null;
        rs = null;

        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, e.getEmbalagem());
            stmt.setString(2, e.getDescricao());

            stmt.execute();

            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO SALVAR " + ex);
            System.out.println(e);
        } finally {

            //Fechar as conexões 
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

    }
    
    /**
     * Retorna uma lista de Embalagens 
     * @return embalagens   
     * @exception  SQLException caso ocorra algum erro
     */
    public List<Embalagem> readEmbalagem() {

        con = ConnectionFactory.getConnection();
        stmt = null;
        rs = null;

        List<Embalagem> embalagens = new ArrayList<>();

        String sql = "SELECT * FROM embalagem";
        try {
            stmt = con.prepareStatement(sql);
            //stmt.setString(1, txtPesquisaCli.getText() + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Embalagem e = new Embalagem();

                e.setCodigo(rs.getInt("codigo"));
                e.setEmbalagem(rs.getString("embalagem"));
                e.setDescricao(rs.getString("descricao"));

                embalagens.add(e);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return embalagens;
    }
    
    
    /**
     * Seta os campos da embalagem selecionada na tabela
     * @param e Embalagem
     * @exception  SQLException caso ocorra algum erro
     */
    public void setarEmbalagem(Embalagem e) {

        //int setar = jtbUsuario.getSelectedRow();
        con = null;
        stmt = null;
        rs = null;

        String id = "" + jtbEmbalagens.getValueAt(jtbEmbalagens.getSelectedRow(), 0);
        String sql = "select * from embalagem where codigo= ?";

        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);
            //stmt = con.prepareStatement(sql);

            stmt.setString(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {

                e.setCodigo(rs.getInt(1));
                e.setEmbalagem(rs.getString(2));
                e.setDescricao(rs.getString(3));

                //desabilitando funções
            } else {
                JOptionPane.showMessageDialog(null, "Embalagem não Encontrada!");
            }
        } catch (SQLException e2) {
            JOptionPane.showMessageDialog(null, e2);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

    }
    
    /**
     * Retorna uma lista de Embalagens
     * @param e Embalagem
     * @exception  SQLException caso ocorra algum erro
     */
    public void update(Embalagem e) {

        String sql = "UPDATE embalagem SET embalagem=?, descricao=? WHERE codigo =?";

        con = null;
        stmt = null;
        rs = null;
        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, e.getEmbalagem());
            stmt.setString(2, e.getDescricao());
            stmt.setInt(3, e.getCodigo());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Atualizado");
            System.out.println("teste: " + stmt);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR " + ex);

        } finally {

            //Fechar as conexões 
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

    }
    
    public void Deletar(Embalagem e) {

        con = ConnectionFactory.getConnection();
        stmt = null;

        String sql = "delete from embalagem where codigo = ?;";

        try {

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setInt(1, e.getCodigo());

            stmt.executeUpdate();

            //JOptionPane.showMessageDialog(null, "Marca Excluido!");
            System.out.println("TESTE" + stmt);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir " + e1);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public void setarcampo(Embalagem e) {

        //int setar = jtbUsuario.getSelectedRow();
        con = null;
        stmt = null;
        rs = null;

        //String id = txtCodMarca.getText();
        String sql = "select * from embalagem where codigo =" + e.getCodigo();

        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);

            //stmt.setInt(1, m.getCodigo());
            rs = stmt.executeQuery();
            System.out.println(sql);
            if (rs.next()) {

                e.setCodigo(rs.getInt(1));
                e.setEmbalagem(rs.getString(2));
                e.setDescricao(rs.getString(3));

            } else {
                JOptionPane.showMessageDialog(null, "Embalagem não Encontrada!");
                
            }

        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Erro!"+e1);
        }

    }
    
    public void setarNome(Embalagem e) {

        //int setar = jtbUsuario.getSelectedRow();
        con = null;
        stmt = null;
        rs = null;

        //String id = txtCodMarca.getText();
        String desc = e.getEmbalagem();
        
        String sql = "select * from embalagem where embalagem ='"+desc+"'";

        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);

            //stmt.setInt(1, m.getCodigo());
            rs = stmt.executeQuery();

            if (rs.next()) {

                e.setCodigo(rs.getInt(1));
                e.setEmbalagem(rs.getString(2));
                e.setDescricao(rs.getString(3));

            } else {
                JOptionPane.showMessageDialog(null, "Grupo não Encontrada!");
               
            }

        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Erro!"+e1);
        }

    }
}
