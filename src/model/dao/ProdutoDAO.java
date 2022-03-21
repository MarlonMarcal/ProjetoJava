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
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Marca;
import model.bean.Produto;

/**
 *
 * @author Marlon
 */
public class ProdutoDAO {

    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public void salvar(Produto p) {

        String sql = "INSERT INTO produtos"
                + "(referencia, "
                + "codbarras, "
                + "descricao, "
                + "codfornecedor, "
                + "codmarca, "
                + "codgrupo, "
                + "codsubgrupo, "
                + "unidade, "
                + "peso, "
                + "altura, "
                + "largura, "
                + "precocompra, "
                + "ipi, "
                + "icmsst, "
                + "frete, "
                + "custototal, "
                + "cmv, "
                + "mkp, "
                + "lucroliquido, "
                + "precovenda, "
                + "ncm, "
                + "cest, "
                + "cst, "
                + "icmsinterno, "
                + "icmsexterno, "
                + "pis, "
                + "confins ) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        con = null;
        stmt = null;
        rs = null;
        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, p.getReferencia());
            stmt.setString(2, p.getCodBarras());
            stmt.setString(3, p.getDescricao());
            stmt.setInt(4, p.getCodFornecedor());
            stmt.setInt(5, p.getCodMarca());
            stmt.setInt(6, p.getCodGrupo());
            stmt.setInt(7, p.getCodSubgrupo());
            stmt.setString(8, p.getUnidade());
            stmt.setFloat(9, p.getPeso());
            stmt.setFloat(10, p.getAltura());
            stmt.setFloat(11, p.getLargura());
            stmt.setFloat(12, p.getPrecoCompra());
            stmt.setFloat(13, p.getPrIpi());
            stmt.setFloat(14, p.getIcmsST());
            stmt.setFloat(15, p.getFrete());
            stmt.setFloat(16, p.getCustoTotal());
            stmt.setFloat(17, p.getCmv());
            stmt.setFloat(18, p.getMk());
            stmt.setFloat(19, p.getLl());
            stmt.setFloat(20, p.getPrecoVenda());
            stmt.setInt(21, p.getNcm());
            stmt.setInt(22, p.getCest());
            stmt.setInt(23, p.getCst());
            stmt.setFloat(24, p.getIcmsInterno());
            stmt.setFloat(25, p.getIcmsExterno());
            stmt.setFloat(26, p.getPis());
            stmt.setFloat(27, p.getCofins());

            stmt.executeUpdate();

            System.out.println(stmt);
            System.out.println("PESO: "+p.getPeso());

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO SALVAR " + e);
            System.out.println(e);
        } finally {

            //Fechar as conexões 
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

    }

    public void buscarProduto(Produto objproduto) {

        con = ConnectionFactory.getConnection();
        stmt = null;
        rs = null;
        
        Marca objMarca = new Marca();
        
        String sql = "SELECT * FROM produtos where codigo =" + objproduto.getCodigo();
        try {
            stmt = con.prepareStatement(sql);

            rs = stmt.executeQuery();

            if (rs.next()) {

                objproduto.setCodigo(rs.getInt("codigo"));
                objproduto.setReferencia(rs.getString("referencia"));
                objproduto.setDescricao(rs.getString("descricao"));
                objproduto.setCodFornecedor(rs.getInt("codFornecedor"));
                objMarca.setCodigo(rs.getInt("codmarca"));
                objproduto.setCodGrupo(rs.getInt("codgrupo"));
                objproduto.setCodSubgrupo(rs.getInt("codsubgrupo"));
                objproduto.setUnidade(rs.getString("unidade"));
                objproduto.setPeso(rs.getFloat("peso"));
                objproduto.setAltura(rs.getFloat("altura"));
                objproduto.setLargura(rs.getFloat("largura"));
                objproduto.setPrecoCompra(rs.getFloat("precocompra"));
                objproduto.setPrecoVenda(rs.getFloat("precovenda"));

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

    }

}
