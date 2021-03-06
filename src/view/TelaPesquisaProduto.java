/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import conection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.PesquisaProduto;

/**
 *
 * @author Marlon
 */
public class TelaPesquisaProduto extends javax.swing.JInternalFrame {
    
    
    
    /**
     * Creates new form TelaTeste
     */
    public TelaPesquisaProduto() {
        initComponents();
        
        
    }
    public static boolean telaPesquisaProd;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtTest = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();
        btnSelecionar = new javax.swing.JButton();
        jcbTipoPesquisa = new javax.swing.JComboBox<>();
        txtPesquisa = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        precoRender1 = new util.PrecoRender();

        setTitle("Pesquisa de Produtos");

        jtTest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descrição", "Marca", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jtTest);
        if (jtTest.getColumnModel().getColumnCount() > 0) {
            jtTest.getColumnModel().getColumn(0).setMinWidth(80);
            jtTest.getColumnModel().getColumn(0).setPreferredWidth(80);
            jtTest.getColumnModel().getColumn(0).setMaxWidth(80);
            jtTest.getColumnModel().getColumn(2).setMinWidth(120);
            jtTest.getColumnModel().getColumn(2).setPreferredWidth(120);
            jtTest.getColumnModel().getColumn(2).setMaxWidth(120);
            jtTest.getColumnModel().getColumn(3).setMinWidth(100);
            jtTest.getColumnModel().getColumn(3).setPreferredWidth(100);
            jtTest.getColumnModel().getColumn(3).setMaxWidth(100);
            jtTest.getColumnModel().getColumn(3).setCellRenderer(precoRender1);
        }

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons18/icons8-desligar-18.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons18/icons8-ok-18.png"))); // NOI18N
        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        jcbTipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CODIGO", "DESCRIÇÃO", "MARCA", "CODIGO BARRAS" }));

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons18/icons8-pesquisar-18.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jLabel1.setText("Tipo de Pesquisa:");

        jLabel2.setText("Valor a Pesquisar:");

        precoRender1.setText("precoRender1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(precoRender1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSelecionar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnSelecionar)
                    .addComponent(precoRender1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        dispose();
        telaPesquisaProd = false;
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
        
        readProd();
    }//GEN-LAST:event_btnPesquisarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSelecionar;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> jcbTipoPesquisa;
    private javax.swing.JTable jtTest;
    private util.PrecoRender precoRender1;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables

    public List<PesquisaProduto> listaprodutos() {

        Connection con;
        PreparedStatement stmt;
        ResultSet rs;

        con = ConnectionFactory.getConnection();
        stmt = null;
        rs = null;

        List<PesquisaProduto> produtos = new ArrayList<>();

        String sql = "select \n"
                + "\n"
                + "p.codigo,\n"
                + "p.descricao,\n"
                + "m.descricao as Marca,\n"
                + "p.precovenda,\n"
                + "\n"
                + "f.nome as Fornecedor\n"
                + "\n"
                + "\n"
                + "from produtos p \n"
                + "left join marcas m on p.codmarca = m.codigo\n"
                + "left join fornecedor f on p.codfornecedor = f.idfornecedor "
                + "order by p.codigo";
        try {
            stmt = con.prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {

                PesquisaProduto t = new PesquisaProduto();
                

                t.setCodigo(rs.getInt("codigo"));
                t.setDescricao(rs.getString("descricao"));
                t.setMarca(rs.getString("Marca"));
                t.setValor(rs.getFloat("precovenda"));

                produtos.add(t);

            }

        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro!"+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;
    }
    
    public void readProd(){

        DefaultTableModel modelo = (DefaultTableModel) jtTest.getModel();
        modelo.setNumRows(0);
        //EmbalagemDAO dao = new EmbalagemDAO();

        listaprodutos().forEach((t) -> {
            modelo.addRow(new Object[]{
                t.getCodigo(),
                t.getDescricao(),
                t.getMarca(),
                t.getPrecoFormatado()});
        });

    }

}
