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
import model.bean.Usuario;
import view.JfPrincipal;
import static view.JfPrincipal.nomeUser;
import static view.TelaUsuario.jtbUsuario;

/**
 *
 * @author Marlon
 */
public class UsuarioDAO {

    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public void logar(Usuario u) {
        
        
        
        String sql = "select * from usuarios where login=? and senha =?";

        con = null;
        stmt = null;
        rs = null;

        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getSenha());

            rs = stmt.executeQuery();

            if (rs.next()) {

                JfPrincipal principal = new JfPrincipal();
                principal.setVisible(true);
                
                nomeUser.setText( rs.getString(4).toUpperCase());
                //txtUsuario.setText("Usuario: "+rs.getString(4));
                

            } else {

                JOptionPane.showMessageDialog(null, "usuário e/ou senha inválido(s)");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            //Fechar as conexões 
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

    }

    public void salvar(Usuario u) {

        String sql = "INSERT INTO usuarios (usuario, fone, login, senha, perfil, Status ) VALUES(?,?,?,?,?,?)";

        con = null;
        stmt = null;
        rs = null;

        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, u.getUsuario());
            stmt.setString(2, u.getFone());
            stmt.setString(3, u.getLogin());
            stmt.setString(4, u.getSenha());
            stmt.setString(5, u.getPerfil());
            stmt.setString(6, u.getStatus());

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

    public List<Usuario> readusuarios() {

        con = ConnectionFactory.getConnection();
        stmt = null;
        rs = null;

        List<Usuario> usuarios = new ArrayList<>();

        String sql = "SELECT * FROM usuarios";
        try {
            stmt = con.prepareStatement(sql);
            //stmt.setString(1, txtPesquisaCli.getText() + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario objusuario = new Usuario();

                objusuario.setIduser(rs.getString("iduser"));
                objusuario.setUsuario(rs.getString("usuario"));
                objusuario.setFone(rs.getString("fone"));
                objusuario.setLogin(rs.getString("login"));
                objusuario.setSenha(rs.getString("senha"));
                objusuario.setPerfil(rs.getString("perfil"));
                objusuario.setStatus(rs.getString("status"));

                usuarios.add(objusuario);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return usuarios;
    }

    public void setar_usuario(Usuario u) {

        //int setar = jtbUsuario.getSelectedRow();
        con = null;
        stmt = null;
        rs = null;

        String id = "" + jtbUsuario.getValueAt(jtbUsuario.getSelectedRow(), 0);
        String sql = "select * from usuarios where iduser= ?";

        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);
            //stmt = con.prepareStatement(sql);

            stmt.setString(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {

                u.setIduser(rs.getString(1));
                u.setUsuario(rs.getString(2));
                u.setFone(rs.getString(3));
                u.setLogin(rs.getString(4));
                u.setSenha(rs.getString(5));
                u.setPerfil(rs.getString(6));
                u.setStatus(rs.getString(7));

                //desabilitando funções
            } else {
                JOptionPane.showMessageDialog(null, "Usuario não Encontrada!");
            }
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

    }

    public void update(Usuario u) {

        String sql = "UPDATE usuarios SET usuario=?, fone=?, login=?, senha=?, perfil=?, Status=? WHERE iduser =?";

        con = null;
        stmt = null;
        rs = null;
        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, u.getUsuario());
            stmt.setString(2, u.getFone());
            stmt.setString(3, u.getLogin());
            stmt.setString(4, u.getSenha());
            stmt.setString(5, u.getPerfil());
            stmt.setString(6, u.getStatus());
            stmt.setString(7, u.getIduser());

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
}
