/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import conection.ConnectionFactory;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Fornecedor;
import model.dao.FornecedorDAO;

import static view.TelaFornecedor.btnCancelar;
import static view.TelaFornecedor.btnEditar;
import static view.TelaFornecedor.btnExcluir;
import static view.TelaFornecedor.btnImprimir;
import static view.TelaFornecedor.btnNovo;
import static view.TelaFornecedor.btnSair;
import static view.TelaFornecedor.btnSalvar;
import static view.TelaFornecedor.cbUF;
import static view.TelaFornecedor.cbxInativo;
import static view.TelaFornecedor.ftxtCelular;
import static view.TelaFornecedor.ftxtCep;
import static view.TelaFornecedor.txtBairro;
import static view.TelaFornecedor.txtCgc;
import static view.TelaFornecedor.txtCidade;
import static view.TelaFornecedor.txtComplemento;
import static view.TelaFornecedor.txtDataCadastro;
import static view.TelaFornecedor.txtEmail;
import static view.TelaFornecedor.txtEndereco;
import static view.TelaFornecedor.txtId;
import static view.TelaFornecedor.txtNome;
import static view.TelaFornecedor.txtNumero;
import static view.TelaFornecedor.txtTelefone;

/**
 *
 * @author Marlon
 */
public final class TelaConsultaFornecedor extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConCli
     */
    public TelaConsultaFornecedor() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowSorter(new TableRowSorter(modelo));
        
        setFrameIcon(new ImageIcon(this.getClass().getResource("/Icons18/icons8-pesquisar-18.png")));

        //readTable();
    }

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public void readTableCgc() {

        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        FornecedorDAO fdao = new FornecedorDAO();

        fdao.findByCgc().forEach((Fornecedor f) -> {
            modelo.addRow(new Object[]{
                f.getIdFornecedor(),
                f.getCgc(),
                f.getNome(),
                f.getCelular(),
                f.getCidade()

            });
        });

    }

    public void readTableNome() {

        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        FornecedorDAO fdao = new FornecedorDAO();

        fdao.findByNome().forEach((f) -> {
            modelo.addRow(new Object[]{
                f.getIdFornecedor(),
                f.getCgc(),
                f.getNome(),
                f.getCelular(),
                f.getCidade()

            });
        });

    }

    public void pesquisar() {
        if (cbxPesq.getSelectedItem().toString().equals("NOME")) {
            readTableNome();
        }

        if (cbxPesq.getSelectedItem().toString().equals("CGC")) {
            readTableCgc();
        }

    }

    public void setar() {

        FornecedorDAO Objsetar = new FornecedorDAO();

        Fornecedor objsetar = new Fornecedor();

        Objsetar.setar_campos(objsetar);

        txtId.setText(String.valueOf(objsetar.getIdFornecedor()));
        txtCgc.setText(objsetar.getCgc());
        txtNome.setText(objsetar.getNome());
        ftxtCelular.setText(objsetar.getCelular());
        txtTelefone.setText(objsetar.getTelefone());
        txtEmail.setText(objsetar.getEmail());
        ftxtCep.setText(objsetar.getCep());
        txtEndereco.setText(objsetar.getEndereco());
        txtComplemento.setText(objsetar.getComplemento());
        txtNumero.setText(objsetar.getNumero());
        txtBairro.setText(objsetar.getBairro());
        txtCidade.setText(objsetar.getCidade());
        cbUF.setSelectedItem(objsetar.getUf());

        cbxInativo.setSelected(objsetar.getInativo());

        txtDataCadastro.setText(sdf.format(objsetar.getDatacadastro()));

        //txtDataCadastro.setText(objsetar.getDatacadastro().toString());
        //cbxInativo.isSelected(objsetar.getInativo(1))
    }

    public void recuperarFornecedor() {

        String sql = "select max(idfornecedor), max(datacadastro) from fornecedor";

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getJdbc();
            stmt = (PreparedStatement) con.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {

                txtId.setText(rs.getString(1));
                txtDataCadastro.setText(rs.getString(2));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro Buscar ID" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxPesq = new javax.swing.JComboBox<>();
        txtPesquisaCli = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();

        setAutoscrolls(true);

        cbxPesq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CGC", "NOME" }));

        txtPesquisaCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaCliKeyPressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons24/icons8-pesquisar-24.png"))); // NOI18N
        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Condigo", "CGC", "Nome", "Celular", "Cidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(100);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(1).setMinWidth(120);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(3).setMinWidth(120);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(4).setMinWidth(110);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(110);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(110);
        }

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons24/icons8-ok-24.png"))); // NOI18N
        jToggleButton1.setText("Selecionar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons24/icons8-desligar-24.png"))); // NOI18N
        jToggleButton2.setText("Sair");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToggleButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbxPesq, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPesquisaCli, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton1)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisaCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        TelaFornecedor.TelaComForn = false;
        dispose();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jTable1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1AncestorAdded

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        pesquisar();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtPesquisaCliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaCliKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            pesquisar();

        }
    }//GEN-LAST:event_txtPesquisaCliKeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            setar();
            TelaFornecedor.TelaComForn = false;
            dispose();
            ativarcampos();
        }


    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        // TODO add your handling code here:


    }//GEN-LAST:event_jTable1MouseEntered

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        setar();
        TelaFornecedor.TelaComForn = false;
        dispose();
        ativarcampos();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            setar();
            TelaFornecedor.TelaComForn = false;
            dispose();
            ativarcampos();

        }

    }//GEN-LAST:event_jTable1KeyPressed
    public void ativarcampos() {
        //Ativando campos
        txtCgc.setEnabled(true);
        txtNome.setEnabled(true);

        ftxtCelular.setEnabled(true);
        txtTelefone.setEnabled(true);
        txtEmail.setEnabled(true);
        ftxtCep.setEnabled(true);
        txtEndereco.setEnabled(true);
        txtComplemento.setEnabled(true);
        txtNumero.setEnabled(true);
        txtBairro.setEnabled(true);
        txtCidade.setEnabled(true);

        cbUF.setEnabled(true);

        // BOTÕES
        btnNovo.setEnabled(true);
        btnEditar.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnExcluir.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnSair.setEnabled(true);
        cbxInativo.setEnabled(true);
        btnImprimir.setEnabled(true);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxPesq;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    public static javax.swing.JTextField txtPesquisaCli;
    // End of variables declaration//GEN-END:variables

    //(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Icons18/icons8-pesquisar-18.png")));
}
