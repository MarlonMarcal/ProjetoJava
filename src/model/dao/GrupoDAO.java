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
import model.bean.Grupo;
import static view.TelaGrupos.jtbGrupos;
import static view.TelaProdutos.txtCodGrupo;

/**
 *
 * @author Marlon
 */
public class GrupoDAO {

    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public void salvar(Grupo g) {

        String sql = "INSERT INTO grupos (descricao) VALUES(?)";

        con = null;
        stmt = null;
        rs = null;

        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, g.getGrupo());

            stmt.execute();

            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO SALVAR " + e);
            System.out.println(e);
        } finally {

            //Fechar as conexões 
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

    }

    public List<Grupo> readgrupos() {

        con = ConnectionFactory.getConnection();
        stmt = null;
        rs = null;

        List<Grupo> grupos = new ArrayList<>();

        String sql = "SELECT * FROM grupos";
        try {
            stmt = con.prepareStatement(sql);
            //stmt.setString(1, txtPesquisaCli.getText() + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Grupo objgrupo = new Grupo();

                objgrupo.setCodigo(rs.getInt("codigo"));
                objgrupo.setGrupo(rs.getString("descricao"));

                grupos.add(objgrupo);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return grupos;
    }

    public void setar_grupos(Grupo g) {

        //int setar = jtbUsuario.getSelectedRow();
        con = null;
        stmt = null;
        rs = null;

        String id = "" + jtbGrupos.getValueAt(jtbGrupos.getSelectedRow(), 0);
        String sql = "select * from grupos where codigo= ?";

        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);
            //stmt = con.prepareStatement(sql);

            stmt.setString(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {

                g.setCodigo(rs.getInt(1));
                g.setGrupo(rs.getString(2));

                //desabilitando funções
            } else {
                JOptionPane.showMessageDialog(null, "Grupo não Encontrada!");
            }
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

    }

    public void update(Grupo g) {

        String sql = "UPDATE grupos SET descricao=? WHERE codigo =?";

        con = null;
        stmt = null;
        rs = null;
        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, g.getGrupo());
            stmt.setInt(2, g.getCodigo());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Atualizado");
            System.out.println("teste: " + stmt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR " + e);

        } finally {

            //Fechar as conexões 
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

    }
    
    public void Deletar(Grupo g) {

        con = ConnectionFactory.getConnection();
        stmt = null;

        String sql = "delete from grupos where codigo = ?;";

        try {

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setInt(1, g.getCodigo());

            stmt.executeUpdate();

            //JOptionPane.showMessageDialog(null, "Marca Excluido!");
            System.out.println("TESTE" + stmt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public void setarcampo(Grupo g) {

        //int setar = jtbUsuario.getSelectedRow();
        con = null;
        stmt = null;
        rs = null;

        //String id = txtCodMarca.getText();
        String sql = "select * from grupos where codigo =" + g.getCodigo();

        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);

            //stmt.setInt(1, m.getCodigo());
            rs = stmt.executeQuery();
            System.out.println(sql);
            if (rs.next()) {

                g.setCodigo(rs.getInt(1));
                g.setGrupo(rs.getString(2));

            } else {
                JOptionPane.showMessageDialog(null, "Grupo não Encontrada!");
                txtCodGrupo.setText("");
            }

        } catch (Exception e) {
        }

    }
    
    public void setarNome(Grupo g) {

        //int setar = jtbUsuario.getSelectedRow();
        con = null;
        stmt = null;
        rs = null;

        //String id = txtCodMarca.getText();
        String desc = g.getGrupo();
        
        String sql = "select * from grupos where descricao ='"+desc+"'";

        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);

            //stmt.setInt(1, m.getCodigo());
            rs = stmt.executeQuery();

            if (rs.next()) {

                g.setCodigo(rs.getInt(1));
                g.setGrupo(rs.getString(2));

            } else {
                JOptionPane.showMessageDialog(null, "Grupo não Encontrada!");
               
            }

        } catch (Exception e) {
        }

    }
}
