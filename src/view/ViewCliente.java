/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerCliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelCliente;

/**
 *
 * @author user
 */
public class ViewCliente extends javax.swing.JFrame {

    ControllerCliente controllerCliente = new ControllerCliente();
    ModelCliente modelCliente = new ModelCliente();
    ArrayList<ModelCliente> listaModelClientes = new ArrayList<>();

    /**
     * Creates new form ViewCliente
     */
    public ViewCliente() {
        initComponents();
        setLocationRelativeTo(null);
        carregarCliente();
        this.habilitarCampos(false);
        this.limparCampos();

    }
    String novoAlterar;

    private void habilitarCampos(boolean condicao) {
        txtNome.setEnabled(condicao);
        txtEnd.setEnabled(condicao);
        txtBairro.setEnabled(condicao);
        txtCity.setEnabled(condicao);
        cboUf.setEnabled(condicao);
        txtCep.setEnabled(condicao);
        txtFone.setEnabled(condicao);
        btnSave.setEnabled(condicao);
    }

    private void limparCampos() {
        txtNome.setText("");
        txtEnd.setText("");
        txtBairro.setText("");
        txtCity.setText("");
        txtCep.setText("");
        txtFone.setText("");
    }

    private void carregarCliente() {
        listaModelClientes = controllerCliente.getListaClienteController();
        DefaultTableModel modelo = (DefaultTableModel) tblCad.getModel();
        modelo.setNumRows(0);
        int cont = listaModelClientes.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelClientes.get(i).getCliId(),
                listaModelClientes.get(i).getCliNome(),
                listaModelClientes.get(i).getCliCidade(),
                listaModelClientes.get(i).getCliFone()

            });

        }
    }

    private void salvarCliente() {
        if (novoAlterar.equals("novo")) {
            modelCliente.setCliNome(this.txtNome.getText());
            modelCliente.setCliFone(this.txtFone.getText());
            modelCliente.setCliEnd(this.txtEnd.getText());
            modelCliente.setCliBairro(this.txtBairro.getText());
            modelCliente.setCliCidade(this.txtCity.getText());
            modelCliente.setCliUF(this.cboUf.getSelectedItem().toString());
            modelCliente.setCliCep(this.txtCep.getText());

            if (controllerCliente.salvarClienteController(modelCliente) > 0) {
                JOptionPane.showMessageDialog(this, "Cliente Salvo Com Sucesso!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                this.carregarCliente();
                this.habilitarCampos(false);
                this.limparCampos();

            } else {
                JOptionPane.showMessageDialog(this, " Erro ao Salvar Registro", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            modelCliente.setCliId(Integer.parseInt(this.txtCod.getText()));
            modelCliente.setCliNome(this.txtNome.getText());
            modelCliente.setCliFone(this.txtFone.getText());
            modelCliente.setCliEnd(this.txtEnd.getText());
            modelCliente.setCliBairro(this.txtBairro.getText());
            modelCliente.setCliCidade(this.txtCity.getText());
            modelCliente.setCliUF(this.cboUf.getSelectedItem().toString());
            modelCliente.setCliCep(this.txtCep.getText());

            if (controllerCliente.atualizarClienteController(modelCliente)) {
                JOptionPane.showMessageDialog(this, "Cliente Alterado Com Sucesso!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                carregarCliente();
                this.habilitarCampos(false);
                this.limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, " Erro ao Alterar Registro", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    private void excluirCliente() {
        int linha = tblCad.getSelectedRow();
        int codigoCliente = (int) tblCad.getValueAt(linha, 0);
        if (controllerCliente.excluirClienteController(codigoCliente)) {
            JOptionPane.showMessageDialog(this, "Cliente Excluído com Sucesso!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            this.carregarCliente();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao Excluir Cliente!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void alterarCliente() {
        int linha = tblCad.getSelectedRow();
        int codCliente = (int) tblCad.getValueAt(linha, 0);

        modelCliente = controllerCliente.getClienteController(codCliente);
        txtCod.setText(String.valueOf(modelCliente.getCliId()));
        txtNome.setText(modelCliente.getCliNome());
        txtFone.setText(modelCliente.getCliFone());
        txtEnd.setText(modelCliente.getCliEnd());
        txtBairro.setText(modelCliente.getCliBairro());
        txtCity.setText(modelCliente.getCliCidade());
        cboUf.setSelectedItem(modelCliente.getCliUF());
        txtCep.setText(modelCliente.getCliCep());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEnd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cboUf = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        txtCep = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFone = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCad = new javax.swing.JTable();
        btnCancel = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cliente");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Código:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 31, -1, -1));

        txtCod.setEnabled(false);
        jPanel1.add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 60, 56, -1));

        jLabel2.setText("Nome:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 31, -1, -1));
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 60, 437, -1));

        jLabel3.setText("Endereço:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 102, -1, -1));
        jPanel1.add(txtEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 131, 373, -1));

        jLabel4.setText("Bairro:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 102, -1, -1));
        jPanel1.add(txtBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 131, 362, -1));

        jLabel5.setText("Cidade:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 173, -1, -1));
        jPanel1.add(txtCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 202, 373, -1));

        jLabel6.setText("UF:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 173, -1, -1));

        cboUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jPanel1.add(cboUf, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 202, -1, -1));

        jLabel7.setText("CEP:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(644, 173, -1, -1));
        jPanel1.add(txtCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(644, 202, 143, -1));

        jLabel8.setText("Fone:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(639, 31, 48, -1));
        jPanel1.add(txtFone, new org.netbeans.lib.awtextra.AbsoluteConstraints(639, 60, 148, -1));

        tblCad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cód.", "Nome", "Cidade", "Fone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(tblCad);
        if (tblCad.getColumnModel().getColumnCount() > 0) {
            tblCad.getColumnModel().getColumn(0).setMinWidth(70);
            tblCad.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblCad.getColumnModel().getColumn(0).setMaxWidth(70);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 244, 761, 209));

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 529, -1, -1));

        btnNew.setText("Novo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel1.add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 529, 93, -1));

        btnSave.setText("Salvar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 529, 90, -1));

        btnEdit.setText("Alterar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(578, 529, 93, -1));

        btnDel.setText("Excluir");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });
        jPanel1.add(btnDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 530, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        salvarCliente();
        /*modelCliente.setCliNome(this.txtNome.getText());
         modelCliente.setCliFone(this.txtFone.getText());
         modelCliente.setCliEnd(this.txtEnd.getText());
         modelCliente.setCliBairro(this.txtBairro.getText());
         modelCliente.setCliCidade(this.txtCity.getText());
         modelCliente.setCliUF(this.cboUf.getSelectedItem().toString());
        
         if (controllerCliente.salvarClienteController(modelCliente)>0){
         JOptionPane.showMessageDialog(this, "Cliente Salvo Com Sucesso!","ATENÇÃO",JOptionPane.WARNING_MESSAGE);
         carregarCliente();
         }else{
         JOptionPane.showMessageDialog(this," Erro ao Salvar Registro","ERRO",JOptionPane.ERROR_MESSAGE);
         }*/

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        // chama método excluir
        excluirCliente();
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // chama método alterar, e prepara para o método salvar
        novoAlterar = "alterar";
        habilitarCampos(true);
        alterarCliente();
        
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // botão novo que limpa os campos e os habilitam para nova entrada de dados
        this.habilitarCampos(true);
        this.limparCampos();
        novoAlterar = "novo";
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // botão cancelar, que limpa os campos e desabilita-os
        habilitarCampos(false);
        limparCampos();
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cboUf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCad;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtEnd;
    private javax.swing.JTextField txtFone;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
