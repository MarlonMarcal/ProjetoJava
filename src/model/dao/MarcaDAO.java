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
import model.bean.Marca;
import static view.TelaMarca.jtbMarcas;
import static view.TelaProdutos.txtCodMarca;

/**
 *
 * @author Marlon
 */
public class MarcaDAO {

    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public void salvar(Marca m) {

        String sql = "INSERT INTO marcas (descricao) VALUES(?)";

        con = null;
        stmt = null;
        rs = null;

        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, m.getMarca());

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

    public List<Marca> readmarcas() {

        con = ConnectionFactory.getConnection();
        stmt = null;
        rs = null;

        List<Marca> marcas = new ArrayList<>();

        String sql = "SELECT * FROM marcas";
        try {
            stmt = con.prepareStatement(sql);
            //stmt.setString(1, txtPesquisaCli.getText() + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Marca objmarca = new Marca();

                objmarca.setCodigo(rs.getInt("codigo"));
                objmarca.setMarca(rs.getString("descricao"));

                marcas.add(objmarca);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return marcas;
    }

    public void setar_marcas(Marca m) {

        //int setar = jtbUsuario.getSelectedRow();
        con = null;
        stmt = null;
        rs = null;

        String id = "" + jtbMarcas.getValueAt(jtbMarcas.getSelectedRow(), 0);
        String sql = "select * from marcas where codigo= ?";

        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);
            //stmt = con.prepareStatement(sql);

            stmt.setString(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {

                m.setCodigo(rs.getInt(1));
                m.setMarca(rs.getString(2));

                //desabilitando funções
            } else {
                JOptionPane.showMessageDialog(null, "Marca não Encontrada!");

            }
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

    }

    public void setarcampo(Marca m) {

        //int setar = jtbUsuario.getSelectedRow();
        con = null;
        stmt = null;
        rs = null;

        //String id = txtCodMarca.getText();
        String sql = "select * from marcas where codigo =" + m.getCodigo();

        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);

            //stmt.setInt(1, m.getCodigo());
            rs = stmt.executeQuery();

            if (rs.next()) {

                m.setCodigo(rs.getInt(1));
                m.setMarca(rs.getString(2));

            } else {
                JOptionPane.showMessageDialog(null, "Marca não Encontrada!");
                txtCodMarca.setText("");
            }

        } catch (Exception e) {
        }

    }

    public void update(Marca m) {

        String sql = "UPDATE marcas SET descricao=? WHERE codigo =?";

        con = null;
        stmt = null;
        rs = null;
        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, m.getMarca());
            stmt.setInt(2, m.getCodigo());

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

    public void Deletar(Marca m) {

        con = ConnectionFactory.getConnection();
        stmt = null;

        String sql = "delete from marcas where codigo = ?;";

        try {

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setInt(1, m.getCodigo());

            stmt.executeUpdate();

            //JOptionPane.showMessageDialog(null, "Marca Excluido!");
            System.out.println("TESTE" + stmt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void setarNome(Marca m) {

        //int setar = jtbUsuario.getSelectedRow();
        con = null;
        stmt = null;
        rs = null;

        //String id = txtCodMarca.getText();
        String desc = m.getMarca();

        String sql = "select * from marcas where descricao ='" + desc + "'";

        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);

            //stmt.setInt(1, m.getCodigo());
            rs = stmt.executeQuery();

            System.out.println(sql);

            if (rs.next()) {

                m.setCodigo(rs.getInt(1));
                m.setMarca(rs.getString(2));

            } else {
                JOptionPane.showMessageDialog(null, "Marca não Encontrada!");

            }

        } catch (Exception e) {
        }

    }

}
