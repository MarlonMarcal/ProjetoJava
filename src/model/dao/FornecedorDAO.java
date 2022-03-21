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
import model.bean.Fornecedor;
import static view.TelaConsultaFornecedor.jTable1;
import static view.TelaConsultaFornecedor.txtPesquisaCli;
import static view.TelaProdutos.txtCodFornecedor;

/**
 *
 * @author Marlon
 */
public class FornecedorDAO {

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public void salvar(Fornecedor f) {

        String sql = "INSERT INTO fornecedor(CGC, NOME, CELULAR, TELEFONE, EMAIL, CEP, ENDERECO, COMPLEMENTO, NUMERO, BAIRRO, CIDADE, UF, INATIVO ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        con = null;
        stmt = null;
        rs = null;
        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, f.getCgc());
            stmt.setString(2, f.getNome());
            stmt.setString(3, f.getCelular());
            stmt.setString(4, f.getTelefone());
            stmt.setString(5, f.getEmail());
            stmt.setString(6, f.getCep());
            stmt.setString(7, f.getEndereco());
            stmt.setString(8, f.getComplemento());
            stmt.setString(9, f.getNumero());
            stmt.setString(10, f.getBairro());
            stmt.setString(11, f.getCidade());
            stmt.setString(12, f.getUf());
            stmt.setBoolean(13, f.getInativo());
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

    public void Deletar(Fornecedor f) {

        con = ConnectionFactory.getConnection();
        stmt = null;

        String sql = "delete from fornecedor where idfornecedor = ?;";

        try {

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setInt(1, f.getIdFornecedor());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Fornecedor Excluido!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void update(Fornecedor f) {

        String sql = "UPDATE fornecedor SET CGC=?, NOME=?, CELULAR=?, TELEFONE=?, EMAIL=?, CEP=?, ENDERECO=?, COMPLEMENTO=?, NUMERO=?, BAIRRO=?, CIDADE=?, UF=?, INATIVO=? WHERE idfornecedor =?";

        con = null;
        stmt = null;
        rs = null;
        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, f.getCgc());
            stmt.setString(2, f.getNome());
            stmt.setString(3, f.getCelular());
            stmt.setString(4, f.getTelefone());
            stmt.setString(5, f.getEmail());
            stmt.setString(6, f.getCep());
            stmt.setString(7, f.getEndereco());
            stmt.setString(8, f.getComplemento());
            stmt.setString(9, f.getNumero());
            stmt.setString(10, f.getBairro());
            stmt.setString(11, f.getCidade());
            stmt.setString(12, f.getUf());
            stmt.setBoolean(13, f.getInativo());
            stmt.setInt(14, f.getIdFornecedor());
            //stmt.setDate(14, c.getDatacadastro());
            //stmt.setDate(15, c.getDataalteracao());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Atualizado");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR " + e);
            System.out.println("teste: " + stmt);
        } finally {

            //Fechar as conexões 
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

    }

    public void recuperarFornecedor(Fornecedor f) {

        String sql = "select max(idfornecedor), max(datacadastro) from fornecedor";

        try {
            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {

                f.setIdFornecedor(rs.getInt(1));

                f.setDatacadastro(rs.getDate(2));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro Buscar ID" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

    }

    public List<Fornecedor> readcgc() {

        con = ConnectionFactory.getConnection();
        stmt = null;
        rs = null;

        List<Fornecedor> fornecedores = new ArrayList<>();

        String sql = "SELECT * FROM fornecedor where cgc like ? ";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, txtPesquisaCli.getText() + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Fornecedor f = new Fornecedor();
                
                f.setIdFornecedor(rs.getInt("idfornecedor"));
                f.setCgc(rs.getString("cgc"));
                f.setNome(rs.getString("nome"));
                f.setCelular(rs.getString("celular"));
                f.setCidade(rs.getString("cidade"));
                fornecedores.add(f);

            }

        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return fornecedores;
    }

    public List<Fornecedor> readnome() {

        con = ConnectionFactory.getConnection();
        stmt = null;
        rs = null;

        List<Fornecedor> fornecedores = new ArrayList<>();

        String sql = "SELECT * FROM fornecedor where nome like ? ";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + txtPesquisaCli.getText() + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Fornecedor f = new Fornecedor();
                
                f.setIdFornecedor(rs.getInt("idcliente"));
                f.setCgc(rs.getString("cgc"));
                f.setNome(rs.getString("nome"));
                f.setCelular(rs.getString("celular"));
                f.setCidade(rs.getString("cidade"));
                fornecedores.add(f);

            }

        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return fornecedores;
    }

    public void setar_campos(Fornecedor f) {

        //int setar = jTable1.getSelectedRow();
        String id =  "" +jTable1.getValueAt(jTable1.getSelectedRow(), 0);
        String sql = "select * from fornecedor where idfornecedor= ?";

        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);
            //stmt = con.prepareStatement(sql);

            stmt.setString(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {

                f.setIdFornecedor(rs.getInt(1));
                f.setCgc(rs.getString(2));
                f.setNome(rs.getString(3));
                f.setCelular(rs.getString(4));
                f.setTelefone(rs.getString(5));
                f.setEmail(rs.getString(6));
                f.setCep(rs.getString(7));
                f.setEndereco(rs.getString(8));
                f.setComplemento(rs.getString(9));
                f.setNumero(rs.getString(10));
                f.setBairro(rs.getString(11));
                f.setCidade(rs.getString(12));
                f.setUf(rs.getString(13));
                f.setInativo(rs.getBoolean(14));
                f.setDatacadastro(rs.getDate(15));
                
                

                //desabilitando funções
            } else {
                JOptionPane.showMessageDialog(null, "Fornecedor não Encontrada!");
            }
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

    }

    public void read(Fornecedor f) {

        con = ConnectionFactory.getConnection();
        stmt = null;
        rs = null;

        String sql = "SELECT * FROM fornecedor where cgc = ? ";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, f.getCgc());
            rs = stmt.executeQuery();

            if (rs.next()) {

                System.out.println(rs);

                f.setCgc(rs.getString("cgc"));
                f.setNome(rs.getString("nome"));
                f.setCelular(rs.getString("celular"));
                f.setCidade(rs.getString("cidade"));
            } else {
                JOptionPane.showMessageDialog(null, "Fornecedor Não Cadastrado!");
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Não Encontrado " + e);
        }

    }
    
    public List<Fornecedor> listarFornecedor() {

        con = ConnectionFactory.getConnection();
        stmt = null;
        rs = null;

        List<Fornecedor> fornecedores = new ArrayList<>();

        String sql = "SELECT * FROM fornecedor";
        try {
            stmt = con.prepareStatement(sql);
            //stmt.setString(1, txtPesquisaCli.getText() + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Fornecedor f = new Fornecedor();

                f.setIdFornecedor(rs.getInt("idfornecedor"));
                f.setCgc(rs.getString("cgc"));
                f.setNome(rs.getString("nome"));
                f.setCelular(rs.getString("celular"));
                f.setTelefone(rs.getString("telefone"));
                f.setEmail(rs.getString("email"));
                f.setCep(rs.getString("cep"));
                f.setEndereco(rs.getString("endereco"));
                f.setComplemento(rs.getString("complemento"));
                f.setNumero(rs.getString("numero"));
                f.setBairro(rs.getString("bairro"));
                f.setCidade(rs.getString("cidade"));
                f.setUf(rs.getString("uf"));
                f.setInativo(rs.getBoolean("inativo"));
                f.setDatacadastro(rs.getDate("datacadastro"));
                f.setDataalteracao(rs.getDate("dataalteracao"));
                

                fornecedores.add(f);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return fornecedores;
    }
    
    public void setarcampo(Fornecedor f) {

        //int setar = jtbUsuario.getSelectedRow();
        con = null;
        stmt = null;
        rs = null;

        //String id = txtCodMarca.getText();
        String sql = "select * from fornecedor where idfornecedor =" + f.getIdFornecedor();

        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);

            //stmt.setInt(1, m.getCodigo());
            rs = stmt.executeQuery();
            System.out.println(sql);

            if (rs.next()) {

                f.setIdFornecedor(rs.getInt(1));
                f.setNome(rs.getString(3));

            } else {
                JOptionPane.showMessageDialog(null, "Fornecedor não Encontrada!");
                txtCodFornecedor.setText("");
            }

        } catch (Exception e) {
        }

    }
    
    public void setarNome(Fornecedor f) {

        //int setar = jtbUsuario.getSelectedRow();
        con = null;
        stmt = null;
        rs = null;

        //String id = txtCodMarca.getText();
        String nome = f.getNome();
        
        String sql = "select * from fornecedor where nome ='"+nome+"'";

        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);

            //stmt.setInt(1, m.getCodigo());
            rs = stmt.executeQuery();
            
            System.out.println(sql);
            if (rs.next()) {

                f.setIdFornecedor(rs.getInt(1));
                f.setNome(rs.getString(3));

            } else {
                JOptionPane.showMessageDialog(null, "Fornecedor não Encontrada!");
               
            }

        } catch (Exception e) {
        }

    }

}
