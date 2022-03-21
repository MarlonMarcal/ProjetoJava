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
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import model.bean.Venda;

/**
 *
 * @author Marlon
 */
public class VendaDAO {
    
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    
   public void salvar(Venda v) {

        String sql = "INSERT INTO orcamentos(codloja,cgc, totalprodutos, desconto,valorfrete, totalvenda, codvendedor, cfop, status, codpagamento, obs ) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        con = null;
        stmt = null;
        rs = null;
        try {

            con = ConnectionFactory.getConnection();
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setInt(1, v.getCodloja());
            //stmt.setInt(2, v.getCodorcamento());
           // stmt.setTimestamp(3, v.getData());
            stmt.setString(2, v.getCliente());
            stmt.setFloat(3, v.getTotalprodutos());
            stmt.setFloat(4, v.getDesconto());
            stmt.setFloat(5, v.getValorfrete());
            stmt.setFloat(6, v.getTotalvenda());
            stmt.setInt(7, v.getCodvendedor());
            stmt.setInt(8, v.getCfop());
            stmt.setInt(9, v.getStatus());
            stmt.setInt(10, v.getCodpagamento());
            stmt.setString(11, v.getObs());
            //stmt.setDate(14, c.getDatacadastro());
            //stmt.setDate(15, c.getDataalteracao());
             
             
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
    
    
}
