/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Marca;
import model.dao.MarcaDAO;

/**
 *
 * @author Marlon
 */
public class TelaMarca extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaMarca
     */
    public TelaMarca() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbMarcas = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setTitle("Cadastro de Marcas");
        setToolTipText("");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jLabel1.setText("Codigo");

        txtCodigo.setEditable(false);

        jLabel2.setText("Marca");

        jtbMarcas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Marca"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbMarcas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbMarcasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbMarcas);
        if (jtbMarcas.getColumnModel().getColumnCount() > 0) {
            jtbMarcas.getColumnModel().getColumn(0).setPreferredWidth(5);
            jtbMarcas.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluir)
                        .addGap(12, 12, 12)
                        .addComponent(btnNovo)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSair)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnSalvar)
                    .addComponent(btnNovo)
                    .addComponent(btnCancelar)
                    .addComponent(btnExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:

        if (txtMarca.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Preencha Todos o Caompo Descrição !");

        } else {

            if (txtCodigo.getText().isEmpty()) {

                btnsalvar();
                readTableMarca();

                // BOTÕES
                // btnDesativar.setEnabled(true);
                //btnSalvar.setEnabled(true);
                //btnNovo.setEnabled(true);
            } else {
                btnupdate();
                readTableMarca();
            }

        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jtbMarcasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbMarcasMouseClicked
        // TODO add your handling code here:

        setar();
    }//GEN-LAST:event_jtbMarcasMouseClicked

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        readTableMarca();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        
        btnexcluir();
        readTableMarca();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        
        dispose();
        JfPrincipal.cadMarca = false;
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
       
        txtCodigo.setText(null);
        txtMarca.setText(null);
        txtMarca.requestFocus();
        
        
    }//GEN-LAST:event_btnNovoActionPerformed

    public void btnupdate() {

        MarcaDAO objMarca = new MarcaDAO();

        Marca objmarca = new Marca();

        objmarca.setCodigo(Integer.parseInt(txtCodigo.getText()));
        objmarca.setMarca(txtMarca.getText());

        
        objMarca.update(objmarca);
        
        txtCodigo.setText(null);
        txtMarca.setText(null);

    }

    public void readTableMarca() {

        DefaultTableModel modelo = (DefaultTableModel) jtbMarcas.getModel();
        modelo.setNumRows(0);
        MarcaDAO mdao = new MarcaDAO();

        mdao.readmarcas().forEach((m) -> {
            modelo.addRow(new Object[]{
                m.getCodigo(),
                m.getMarca(),});
        });

    }

    public void btnsalvar() {

        MarcaDAO objMarca = new MarcaDAO();

        Marca objmarca = new Marca();

        objmarca.setMarca(txtMarca.getText());

        objMarca.salvar(objmarca);
        
        txtCodigo.setText(null);
        txtMarca.setText(null);

    }

    public void setar() {

        MarcaDAO Objsetar = new MarcaDAO();

        Marca objsetar = new Marca();

        Objsetar.setar_marcas(objsetar);

        txtCodigo.setText(String.valueOf(objsetar.getCodigo()));
        txtMarca.setText(objsetar.getMarca());

    }

    public void btnexcluir() {

        MarcaDAO dao = new MarcaDAO();

        Marca m = new Marca();

        m.setCodigo(Integer.parseInt(txtCodigo.getText()));

        dao.Deletar(m);

        txtCodigo.setText(null);
        txtMarca.setText(null);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jtbMarcas;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtMarca;
    // End of variables declaration//GEN-END:variables
}