/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerProdutos;
import controller.ControllerVendas;
import controller.ControllerVendasProdutos;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelProdutos;
import model.ModelSessaoUsuario;
import model.ModelVendas;
import model.ModelVendasProdutos;
import util.BLDatas;

/**
 *
 * @author user
 */
public class ViewPDV extends javax.swing.JFrame {
    
    ControllerProdutos controllerProdutos = new ControllerProdutos();
    ControllerVendas controllerVendas = new ControllerVendas();
    ControllerVendasProdutos controllerVendasProdutos = new ControllerVendasProdutos();
    ModelProdutos modelProdutos = new ModelProdutos();
    ModelVendas modelVendas = new ModelVendas();
    ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
    ModelSessaoUsuario modelSessaoUsuario = new ModelSessaoUsuario();
    ArrayList<ModelProdutos> listaModelProdutos = new ArrayList<>();
    ArrayList<ModelVendasProdutos> listaModelVendasProdutos = new ArrayList<>();
    BLDatas bLDatas = new BLDatas();
    int quant;
    private ViewPagamentoPDV viewPagamentoPDV;
            
    

    /**
     * Creates new form ViewPDV
     */
    public ViewPDV() {
        initComponents();
        setLocationRelativeTo(null);
        quant=1;
        setarOperador();
        this.viewPagamentoPDV = new ViewPagamentoPDV();
    }
    
    private void pegarConteudo(java.awt.event.KeyEvent e){
        
        
        
        DefaultTableModel model = (DefaultTableModel) tblPDV.getModel();
        if (e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            try {
                modelProdutos = controllerProdutos.retornarProdutoController(Integer.parseInt(txtEnter.getText()));
            
            model.addRow(new Object[]{
                model.getRowCount()+1,
                modelProdutos.getProdId(),
                modelProdutos.getProdNome(),
                quant,
                modelProdutos.getProdValor(),
                modelProdutos.getProdValor() * quant
                    
            });
            txtValorTot.setText(somaValorTotal()+"");
            txtEnter.setText("");
            quant =1;
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(this, "DIGITE APENAS NÚMEROS!!!","ERRO!", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }
    
    private void finalizarVenda(){
        int cont;
        int codProd = 0, codVenda = 0;
        modelVendas = new ModelVendas();
        modelVendas.setClient(1);
        
        try {
            modelVendas.setVenDataVendas(bLDatas.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
        } catch (Exception ex) {
            Logger.getLogger(ViewPDV.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        modelVendas.setVenValorBrut(viewPagamentoPDV.getSubTotal());
        modelVendas.setVenValorDesc(viewPagamentoPDV.getDesconto());
        modelVendas.setVenValorLiq(Double.parseDouble(txtValorTot.getText()));
        
        codVenda = controllerVendas.salvarVendasController(modelVendas);
        
        cont = tblPDV.getRowCount();
        for (int i = 0; i < cont; i++) {
            
            codProd = (int) tblPDV.getValueAt(i, 1);
            modelVendasProdutos = new ModelVendasProdutos();
            modelProdutos = new ModelProdutos();
            modelVendasProdutos.setProduto(codProd);
            modelVendasProdutos.setVendas(codVenda);
            modelVendasProdutos.setVenProdValor((double) tblPDV.getValueAt(i, 4));
            modelVendasProdutos.setVenProdQuant(Integer.parseInt(tblPDV.getValueAt(i, 3).toString()));

            modelProdutos.setProdId(codProd);
            modelProdutos.setProdEstoque(controllerProdutos.retornarProdutoController(codProd).getProdEstoque()
                    - Integer.parseInt(tblPDV.getValueAt(i, 3).toString()));
            listaModelVendasProdutos.add(modelVendasProdutos);
            listaModelProdutos.add(modelProdutos);
            
        }
        if (controllerVendasProdutos.salvarVendasProdutosController(listaModelVendasProdutos)) {
            controllerProdutos.alterarEstoqueProdutoController(listaModelProdutos);
            JOptionPane.showMessageDialog(this, "Produtos da Venda Salvos com Sucesso", "ATENÇÃO!", JOptionPane.WARNING_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(this, "Erro ao Salvar Produtos", "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private float somaValorTotal(){
        float soma = 0, valor = 0;
        int count = tblPDV.getRowCount();
        
        for (int i = 0; i < count; i++) {
            valor = Float.parseFloat(String.valueOf(tblPDV.getValueAt(i, 5)));
            soma += valor;
            
        }
        return soma;
    }
    
    private void setarOperador(){
        lblOperador.setText(modelSessaoUsuario.nome);
    }
    
    private void excluirVenda(){
        int quantLinha = tblPDV.getRowCount();
        
        if(quantLinha<1){
            JOptionPane.showMessageDialog(this, "Não Existe Itens para Excluir!");
        }else{
        DefaultTableModel modelo = (DefaultTableModel)tblPDV.getModel();
        int linha = Integer.parseInt(JOptionPane.showInputDialog("Informe o item que deseja excluir"));
        modelo.removeRow(linha-1);
        txtValorTot.setText(somaValorTotal()+"");        
        
        for (int i = 0; i < quantLinha; i++) {
            modelo.setValueAt(i+1, i, 0);
                
            }
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCaixa = new javax.swing.JLabel();
        lblOperador = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPDV = new javax.swing.JTable();
        txtEnter = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtValorTot = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuSearch = new javax.swing.JMenuItem();
        menuQuantia = new javax.swing.JMenuItem();
        menuVenda = new javax.swing.JMenuItem();
        menuExcluir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PDV");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("CAIXA:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("OPERADOR:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("STATUS:");

        lblCaixa.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        lblCaixa.setText("....");

        lblOperador.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        lblOperador.setText("jLabel5  ");

        lblStatus.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        lblStatus.setText("Outro");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(lblCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblOperador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCaixa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOperador)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatus)
                .addGap(21, 21, 21))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(893, 0, 220, -1));

        tblPDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Cód.", "Nome", "Quant.", "Valor Unit.", "Valor Tot."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPDV);
        if (tblPDV.getColumnModel().getColumnCount() > 0) {
            tblPDV.getColumnModel().getColumn(0).setMinWidth(75);
            tblPDV.getColumnModel().getColumn(0).setPreferredWidth(75);
            tblPDV.getColumnModel().getColumn(0).setMaxWidth(75);
            tblPDV.getColumnModel().getColumn(1).setMinWidth(75);
            tblPDV.getColumnModel().getColumn(1).setPreferredWidth(75);
            tblPDV.getColumnModel().getColumn(1).setMaxWidth(75);
            tblPDV.getColumnModel().getColumn(3).setMinWidth(99);
            tblPDV.getColumnModel().getColumn(3).setPreferredWidth(99);
            tblPDV.getColumnModel().getColumn(3).setMaxWidth(99);
            tblPDV.getColumnModel().getColumn(4).setMinWidth(99);
            tblPDV.getColumnModel().getColumn(4).setPreferredWidth(99);
            tblPDV.getColumnModel().getColumn(4).setMaxWidth(99);
            tblPDV.getColumnModel().getColumn(5).setMinWidth(99);
            tblPDV.getColumnModel().getColumn(5).setPreferredWidth(99);
            tblPDV.getColumnModel().getColumn(5).setMaxWidth(99);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 206, -1, -1));

        txtEnter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEnterKeyReleased(evt);
            }
        });
        jPanel1.add(txtEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 576, 869, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("VALOR TOTAL");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel5.setText("ATALHOS");

        jLabel6.setText("F3 - Pesquisar Produtos");

        jLabel9.setText("F4 - Alterar Quantia");

        jLabel10.setText("F5 - Finalizar Venda");

        jLabel11.setText("F6 - Excluir Produto");

        jLabel12.setText("Alt+F4 - SAIR");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel7))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jLabel5)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtValorTot)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel11)))
                                .addGap(0, 22, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel7)
                .addGap(27, 27, 27)
                .addComponent(txtValorTot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(893, 236, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo.JPG"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));

        jLabel4.setText("Digite o Código do Produto:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, -1, -1));

        jMenu1.setText("Arquivo");

        menuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        jMenu1.add(menuSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Comandos");

        menuSearch.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        menuSearch.setText("Pesquisar Produtos");
        jMenu2.add(menuSearch);

        menuQuantia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        menuQuantia.setText("Alterar Quantia");
        menuQuantia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuQuantiaActionPerformed(evt);
            }
        });
        jMenu2.add(menuQuantia);

        menuVenda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        menuVenda.setText("Finalizar Venda");
        menuVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVendaActionPerformed(evt);
            }
        });
        jMenu2.add(menuVenda);

        menuExcluir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        menuExcluir.setText("Excluir");
        menuExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExcluirActionPerformed(evt);
            }
        });
        jMenu2.add(menuExcluir);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1128, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEnterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEnterKeyReleased
        // TODO add your handling code here:
        pegarConteudo(evt);
    }//GEN-LAST:event_txtEnterKeyReleased

    private void menuQuantiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuQuantiaActionPerformed
        // TODO add your handling code here:
        quant = Integer.parseInt(JOptionPane.showInputDialog("Informe a Quantidade!"));
    }//GEN-LAST:event_menuQuantiaActionPerformed

    private void menuVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVendaActionPerformed
        // TODO add your handling code here:
        viewPagamentoPDV.setValorTotal(Double.parseDouble(txtValorTot.getText()));
        viewPagamentoPDV.setTextFieldValorTotal();
        viewPagamentoPDV.setVisible(true);
        
        txtValorTot.setText(viewPagamentoPDV.getValorTotal()+"");
        
        System.out.println(viewPagamentoPDV.getValorTotal());
        System.out.println(viewPagamentoPDV.getDesconto());
        System.out.println(viewPagamentoPDV.getFormaPagamento());
        finalizarVenda();
    }//GEN-LAST:event_menuVendaActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExcluirActionPerformed
        // TODO add your handling code here:
        excluirVenda();
    }//GEN-LAST:event_menuExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(ViewPDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPDV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCaixa;
    private javax.swing.JLabel lblOperador;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JMenuItem menuExcluir;
    private javax.swing.JMenuItem menuQuantia;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JMenuItem menuSearch;
    private javax.swing.JMenuItem menuVenda;
    private javax.swing.JTable tblPDV;
    private javax.swing.JTextField txtEnter;
    private javax.swing.JTextField txtValorTot;
    // End of variables declaration//GEN-END:variables
}
