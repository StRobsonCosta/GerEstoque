/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerCliente;
import controller.ControllerProdVendasProdutos;
import controller.ControllerProdutos;
import controller.ControllerVendas;
import controller.ControllerVendasCliente;
import controller.ControllerVendasProdutos;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelCliente;
import model.ModelProdVendasProdutos;
import model.ModelProdutos;
import model.ModelVendas;
import model.ModelVendasCliente;
import model.ModelVendasProdutos;
import util.BLDatas;
import util.ConvData;

/**
 *
 * @author user
 */
public class ViewVenda extends javax.swing.JInternalFrame {

    ModelCliente modelCliente = new ModelCliente();
    ControllerCliente controllerCliente = new ControllerCliente();
    ArrayList<ModelCliente> listarCliente = new ArrayList<>();
    ModelProdutos modelProdutos = new ModelProdutos();
    ControllerProdutos controllerProdutos = new ControllerProdutos();
    ArrayList<ModelProdutos> listarProdutos = new ArrayList<>();
    ArrayList<ModelVendasCliente> listaVendasCliente = new ArrayList<>();
    ControllerVendasCliente controllerVendasCliente = new ControllerVendasCliente();
    ControllerVendas controllerVendas = new ControllerVendas();
    ModelVendas modelVendas = new ModelVendas();
    ConvData convData = new ConvData();
    BLDatas bLDatas = new BLDatas();
    ControllerVendasProdutos controllerVendasProdutos = new ControllerVendasProdutos();
    ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
    ArrayList<ModelVendasProdutos> listaModelVendasProdutos = new ArrayList<>();
    ControllerProdVendasProdutos controllerProdVendasProdutos = new ControllerProdVendasProdutos();
    ModelProdVendasProdutos modelProdVendasProdutos = new ModelProdVendasProdutos();
    ArrayList<ModelProdVendasProdutos> listaModelProdVendasProdutos = new ArrayList<>();
    String novoAlterar;

    /**
     * Creates new form ViewVenda
     */
    /*java.awt.EventQueue.invokeLater(new Runnable(){
     public void run(){
     new ViewVenda().setVisible(true);
     }
     });
     }*/
    public ViewVenda() {
        initComponents();
        listarClientes();
        listarProdutos();
        carregarVendas();
        preencherCodCliente();
        preencherCodProd();
        txtDesc.setText("0");

    }

    private void preencherCodCliente() {
        modelCliente = controllerCliente.getClienteController(cboCliente.getSelectedItem().toString());
        txtCodCli.setText(String.valueOf(modelCliente.getCliId()));
    }

    private void preencherCodProd() {
        modelProdutos = controllerProdutos.getProdutoController(cboProd.getSelectedItem().toString());
        txtCodProd.setText(modelProdutos.getProdId() + "");
    }

    private void listarClientes() {
        listarCliente = controllerCliente.getListaClienteController();
        cboCliente.removeAllItems();
        for (int i = 0; i < listarCliente.size(); i++) {
            cboCliente.addItem(listarCliente.get(i).getCliNome());
        }
    }

    private void listarProdutos() {
        listarProdutos = controllerProdutos.retornarListaProdutoController();
        cboProd.removeAllItems();

        for (int i = 0; i < listarProdutos.size(); i++) {
            cboProd.addItem(listarProdutos.get(i).getProdNome());
        }
    }

    private void carregarVendas() {
        DefaultTableModel modelo = (DefaultTableModel) tblClienteVenda.getModel();
        listaVendasCliente = controllerVendasCliente.getListaVendaCliente();
        int cont = listaVendasCliente.size();
        modelo.setNumRows(0);
        
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaVendasCliente.get(i).getModelVendas().getVenId(),
                listaVendasCliente.get(i).getModelCliente().getCliNome(),
                listaVendasCliente.get(i).getModelVendas().getVenDataVendas()
            });
        }
    }

    private void excluirVenda() {
        int linha = tblClienteVenda.getSelectedRow();
        int cod = (int) tblClienteVenda.getValueAt(linha, 0);
        listarProdutos = new ArrayList<>();
        listaModelProdVendasProdutos = controllerProdVendasProdutos.listarProdVendasProdutosController(cod);

        for (int i = 0; i < listaModelProdVendasProdutos.size(); i++) {
            modelProdutos = new ModelProdutos();
            modelProdutos.setProdId(listaModelProdVendasProdutos.get(i).getModelProdutos().getProdId());
            modelProdutos.setProdEstoque(
                    listaModelProdVendasProdutos.get(i).getModelProdutos().getProdEstoque()
                    + listaModelProdVendasProdutos.get(i).getModelVendasProdutos().getVenProdQuant());
            listarProdutos.add(modelProdutos);
        }

        if (controllerProdutos.alterarEstoqueProdutoController(listarProdutos)) {
            controllerVendasProdutos.excluirVendasProdutosController(cod);
            if (controllerVendas.excluirVendasController(cod)) {
                JOptionPane.showMessageDialog(this, "Venda Excluída com Sucesso", "ATENÇÃO!", JOptionPane.WARNING_MESSAGE);
                this.carregarVendas();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao Excluir a Venda", "ERRO!", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Erro ao Excluir a Venda", "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    private void adicionarVenda() {
        if (txtQnt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencha TODOS os Campos", "ATENÇÃO!", JOptionPane.WARNING_MESSAGE);

        } else {
            modelProdutos = controllerProdutos.retornarProdutoController(Integer.parseInt(txtCodProd.getText()));

            DefaultTableModel modelo = (DefaultTableModel) tblVendas.getModel();
            int cont = 0;
            double quant = 0;
            quant = Double.parseDouble(txtQnt.getText());
            for (int i = 0; i < cont; i++) {
                modelo.setNumRows(0);
            }

            modelo.addRow(new Object[]{
                modelProdutos.getProdId(),
                modelProdutos.getProdNome(),
                txtQnt.getText(),
                modelProdutos.getProdValor(),
                quant * modelProdutos.getProdValor()
            });
        }
    }

    private void aplicarDesc() {
        try {
            txtTotal.setText(String.valueOf(
                    Double.parseDouble(txtTotal.getText()) - Double.parseDouble(txtDesc.getText())));

        } catch (Exception e) {
        }

    }

    private void totalProdutos() {
        double soma = 0, valor;
        int cont = tblVendas.getRowCount();
        for (int i = 0; i < cont; i++) {
            valor = (double) tblVendas.getValueAt(i, 4);
            soma = soma + valor;
        }
        txtTotal.setText(String.valueOf(soma));
        aplicarDesc();
    }

    private void limparFormulario() {
        txtQnt.setText("");
        //txtDesc.setText("0");
        txtTotal.setText("");
        DefaultTableModel modelo = (DefaultTableModel) tblVendas.getModel();
        modelo.setNumRows(0);
    }

    private void salvarProduto() {
        
        int codVenda = 0, quant = 0, codProd = 0;
        double descont = 0;
        listaModelVendasProdutos = new ArrayList<>();

        if (txtDesc.getText().equals("")) {
            descont = 0;
        } else {
            descont = Double.parseDouble(txtDesc.getText());
        }
        
        if(!txtNumVenda.getText().equals("")){
        modelVendas.setVenId(Integer.parseInt(txtNumVenda.getText()));
        }
        modelVendas.setCliente(txtCodCli.getText());
        try {
            modelVendas.setVenDataVendas(bLDatas.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
        } catch (Exception e) {

        }
        modelVendas.setVenValorLiq(Double.parseDouble(txtTotal.getText()));
        modelVendas.setVenValorBrut(Double.parseDouble(txtTotal.getText()) + descont);
        modelVendas.setVenValorDesc(descont);
        
        if(novoAlterar.equals("novo")){

        codVenda = controllerVendas.salvarVendasController(modelVendas);
        if (codVenda > 0) {
            JOptionPane.showMessageDialog(this, "Venda Salva com Sucesso!", "AWERA!", JOptionPane.WARNING_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(this, "Erro ao Salvar a Venda", "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
//selecionar produtos na tabela
        int cont = tblVendas.getRowCount();
        for (int i = 0; i < cont; i++) {
            codProd = (int) tblVendas.getValueAt(i, 0);
            modelVendasProdutos = new ModelVendasProdutos();
            modelProdutos = new ModelProdutos();
            modelVendasProdutos.setProduto(codProd);
            modelVendasProdutos.setVendas(codVenda);
            modelVendasProdutos.setVenProdValor((double) tblVendas.getValueAt(i, 3));
            modelVendasProdutos.setVenProdQuant(Integer.parseInt(tblVendas.getValueAt(i, 2).toString()));

            modelProdutos.setProdId(codProd);
            modelProdutos.setProdEstoque(controllerProdutos.retornarProdutoController(codProd).getProdEstoque()
                    - Integer.parseInt(tblVendas.getValueAt(i, 2).toString()));
            listaModelVendasProdutos.add(modelVendasProdutos);
            listarProdutos.add(modelProdutos);
        }
//salvar os produtos da venda
        if (controllerVendasProdutos.salvarVendasProdutosController(listaModelVendasProdutos)) {
            controllerProdutos.alterarEstoqueProdutoController(listarProdutos);
            JOptionPane.showMessageDialog(this, "Produtos da Venda Salvos com Sucesso", "ATENÇÃO!", JOptionPane.WARNING_MESSAGE);
            this.carregarVendas();
            this.limparFormulario();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao Salvar Produtos", "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
        
        }else{
            
        int linha = tblClienteVenda.getSelectedRow();
        int cod = (int) tblClienteVenda.getValueAt(linha, 0);
        listarProdutos = new ArrayList<>();
        listaModelProdVendasProdutos = controllerProdVendasProdutos.listarProdVendasProdutosController(cod);

        for (int i = 0; i < listaModelProdVendasProdutos.size(); i++) {
            modelProdutos = new ModelProdutos();
            modelProdutos.setProdId(listaModelProdVendasProdutos.get(i).getModelProdutos().getProdId());
            modelProdutos.setProdEstoque(
                    listaModelProdVendasProdutos.get(i).getModelProdutos().getProdEstoque()
                    + listaModelProdVendasProdutos.get(i).getModelVendasProdutos().getVenProdQuant());
            listarProdutos.add(modelProdutos);
        }

        if (controllerProdutos.alterarEstoqueProdutoController(listarProdutos)) {
            
            if (controllerVendasProdutos.excluirVendasProdutosController(cod)) {
                JOptionPane.showMessageDialog(this, "Venda Excluída com Sucesso", "ATENÇÃO!", JOptionPane.WARNING_MESSAGE);
                this.carregarVendas();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao Excluir a Venda", "ERRO!", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Erro ao Excluir a Venda", "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
        
        //aki
        if(controllerVendas.atualizarVendasController(modelVendas)){
            JOptionPane.showMessageDialog(this, "Venda Alterada com Sucesso", "ATENÇÃO!", JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Erro ao Alterar a Venda", "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
//adicionar produtos na lista para salvar        
        int cont = tblVendas.getRowCount();
        for (int i = 0; i < cont; i++) {
            codProd = (int) tblVendas.getValueAt(i, 0);
            modelVendasProdutos = new ModelVendasProdutos();
            modelProdutos = new ModelProdutos();
            modelVendasProdutos.setProduto(codProd);
            modelVendasProdutos.setVendas(codVenda);
            modelVendasProdutos.setVenProdValor((double) tblVendas.getValueAt(i, 3));
            modelVendasProdutos.setVenProdQuant(Integer.parseInt(tblVendas.getValueAt(i, 2).toString()));

            modelProdutos.setProdId(codProd);
            modelProdutos.setProdEstoque(controllerProdutos.retornarProdutoController(codProd).getProdEstoque()
                    - Integer.parseInt(tblVendas.getValueAt(i, 2).toString()));
            listaModelVendasProdutos.add(modelVendasProdutos);
            listarProdutos.add(modelProdutos);
            
        }
        //salvar produtos da venda aki
        if(controllerVendasProdutos.salvarVendasProdutosController(listaModelVendasProdutos)){
             JOptionPane.showMessageDialog(this, "Venda Salva com Sucesso", "ATENÇÃO!", JOptionPane.WARNING_MESSAGE);
             carregarVendas();
             limparFormulario();
        }else{
            JOptionPane.showMessageDialog(this, "Erro ao Salvar a Venda", "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
        
            
        }



    }
    
    private void alterarProduto(){
        novoAlterar = "alterar";
        int linha = tblClienteVenda.getSelectedRow();
        int codVenda = (int) tblClienteVenda.getValueAt(linha, 0);
        listaModelProdVendasProdutos = controllerProdVendasProdutos.listarProdVendasProdutosController(codVenda);
        DefaultTableModel modelo = (DefaultTableModel) tblVendas.getModel();
        modelo.setNumRows(0);
        
        
        for (int i = 0; i< listaModelProdVendasProdutos.size(); i++){
            txtNumVenda.setText(String.valueOf(listaModelProdVendasProdutos.get(i).getModelVendasProdutos().getVendas()));
            modelo.addRow(new Object[]{
                listaModelProdVendasProdutos.get(i).getModelProdutos().getProdId(),
                listaModelProdVendasProdutos.get(i).getModelProdutos().getProdNome(),
                listaModelProdVendasProdutos.get(i).getModelVendasProdutos().getVenProdQuant(),
                listaModelProdVendasProdutos.get(i).getModelVendasProdutos().getVenProdValor(),
                listaModelProdVendasProdutos.get(i).getModelVendasProdutos().getVenProdQuant()
                * listaModelProdVendasProdutos.get(i).getModelVendasProdutos().getVenProdValor()
                
            });
            //cboCliente.addItem(listaVendasCliente.get(i).getModelCliente().getCliNome());
            cboCliente.setSelectedItem(listaVendasCliente.get(i).getModelCliente().getCliNome());
        }
        //cboCliente.addItem(listaVendasCliente.get(codVenda).getModelCliente().getCliNome());
        totalProdutos();
        jPainelGeral.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPainelGeral = new javax.swing.JTabbedPane();
        jPanelCadastro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodCli = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboCliente = new componentes.UJComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtNumVenda = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCodProd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboProd = new componentes.UJComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtQnt = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendas = new javax.swing.JTable();
        btnCancel = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnRemoveProd = new javax.swing.JButton();
        jPanelConsulta = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClienteVenda = new javax.swing.JTable();
        btnExclui = new javax.swing.JButton();
        btnAlt = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Menu de Vendas");

        jPanelCadastro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Cód.Cliente:");
        jPanelCadastro.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 26, -1, -1));

        txtCodCli.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodCliFocusLost(evt);
            }
        });
        jPanelCadastro.add(txtCodCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 55, 121, -1));

        jLabel2.setText("Nome Cliente:");
        jPanelCadastro.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 26, -1, -1));

        cboCliente.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboClientePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanelCadastro.add(cboCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 55, 548, -1));

        jLabel3.setText("Nº Venda:");
        jPanelCadastro.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(779, 26, -1, -1));
        jPanelCadastro.add(txtNumVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(779, 55, 144, -1));

        jLabel4.setText("Cód.Produto:");
        jPanelCadastro.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 116, -1, -1));

        txtCodProd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodProdFocusLost(evt);
            }
        });
        jPanelCadastro.add(txtCodProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 146, 121, -1));

        jLabel5.setText("Produto:");
        jPanelCadastro.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 116, -1, -1));

        cboProd.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboProdPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanelCadastro.add(cboProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 146, 529, -1));

        jLabel6.setText("Quantidade:");
        jPanelCadastro.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(757, 116, -1, -1));
        jPanelCadastro.add(txtQnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(757, 146, 97, -1));

        btnAdd.setText("Adicionar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanelCadastro.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 145, -1, -1));

        tblVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód. Prod", "Produto", "Quantia", "Valor Unitario", "Valor total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVendas);

        jPanelCadastro.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 231, 954, 214));

        btnCancel.setText("Cancelar");
        jPanelCadastro.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 549, -1, -1));

        btnNew.setText("Novo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanelCadastro.add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 549, -1, -1));

        btnSave.setText("Salvar");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanelCadastro.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 540, 150, 40));

        jLabel7.setText("Desconto:");
        jPanelCadastro.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(657, 476, -1, -1));

        txtDesc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescFocusLost(evt);
            }
        });
        jPanelCadastro.add(txtDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(657, 505, 93, -1));

        jLabel8.setText("Total:");
        jPanelCadastro.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(788, 476, -1, -1));
        jPanelCadastro.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(788, 505, 181, -1));

        btnRemoveProd.setText("Remover Produto");
        btnRemoveProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveProdActionPerformed(evt);
            }
        });
        jPanelCadastro.add(btnRemoveProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 550, -1, -1));

        jPainelGeral.addTab("Cadastro", jPanelCadastro);

        jPanelConsulta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setText("Pesquisar:");
        jPanelConsulta.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 16, -1, -1));
        jPanelConsulta.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 46, 547, -1));

        btnSearch.setText("Pesquisar");
        jPanelConsulta.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 45, -1, -1));

        tblClienteVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód.", "Nome Cliente", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblClienteVenda);
        if (tblClienteVenda.getColumnModel().getColumnCount() > 0) {
            tblClienteVenda.getColumnModel().getColumn(0).setMinWidth(110);
            tblClienteVenda.getColumnModel().getColumn(0).setPreferredWidth(110);
            tblClienteVenda.getColumnModel().getColumn(0).setMaxWidth(110);
            tblClienteVenda.getColumnModel().getColumn(2).setMinWidth(110);
            tblClienteVenda.getColumnModel().getColumn(2).setPreferredWidth(110);
            tblClienteVenda.getColumnModel().getColumn(2).setMaxWidth(110);
        }

        jPanelConsulta.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 83, 925, 289));

        btnExclui.setText("Excluir");
        btnExclui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluiActionPerformed(evt);
            }
        });
        jPanelConsulta.add(btnExclui, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 495, -1, -1));

        btnAlt.setText("Alterar");
        btnAlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltActionPerformed(evt);
            }
        });
        jPanelConsulta.add(btnAlt, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 495, -1, -1));

        jPainelGeral.addTab("Consulta", jPanelConsulta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelGeral)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelGeral)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodCliFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodCliFocusLost
        // TODO add your handling code here:
        modelCliente = controllerCliente.getClienteController(Integer.parseInt(txtCodCli.getText()));
        cboCliente.setSelectedItem(modelCliente.getCliNome());
    }//GEN-LAST:event_txtCodCliFocusLost

    private void cboClientePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboClientePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (cboCliente.isPopupVisible()) {
            preencherCodCliente();
        }
    }//GEN-LAST:event_cboClientePopupMenuWillBecomeInvisible

    private void txtCodProdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodProdFocusLost
        // TODO add your handling code here:
        modelProdutos = controllerProdutos.retornarProdutoController(Integer.parseInt(txtCodProd.getText()));
        cboProd.setSelectedItem(modelProdutos.getProdNome());
    }//GEN-LAST:event_txtCodProdFocusLost

    private void cboProdPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboProdPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (cboProd.isPopupVisible()) {
            preencherCodProd();
        }
    }//GEN-LAST:event_cboProdPopupMenuWillBecomeInvisible

    private void btnExcluiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluiActionPerformed
        // TODO add your handling code here:
        excluirVenda();
    }//GEN-LAST:event_btnExcluiActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        adicionarVenda();
        totalProdutos();
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtDescFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescFocusLost
        // TODO add your handling code here:
        totalProdutos();
    }//GEN-LAST:event_txtDescFocusLost

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        novoAlterar = "novo";
        btnSave.setEnabled(true);
        limparFormulario();


    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        salvarProduto();
        btnSave.setEnabled(false);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltActionPerformed
        // TODO add your handling code here:
        novoAlterar = "alterar";
        btnSave.setEnabled(true);
        alterarProduto();
    }//GEN-LAST:event_btnAltActionPerformed

    private void btnRemoveProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveProdActionPerformed
        // TODO add your handling code here:
        int linha = tblVendas.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) tblVendas.getModel();
        modelo.removeRow(linha);
        totalProdutos();
    }//GEN-LAST:event_btnRemoveProdActionPerformed

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
            java.util.logging.Logger.getLogger(ViewVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAlt;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnExclui;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnRemoveProd;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private componentes.UJComboBox cboCliente;
    private componentes.UJComboBox cboProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTabbedPane jPainelGeral;
    private javax.swing.JPanel jPanelCadastro;
    private javax.swing.JPanel jPanelConsulta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblClienteVenda;
    private javax.swing.JTable tblVendas;
    private javax.swing.JTextField txtCodCli;
    private javax.swing.JTextField txtCodProd;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtNumVenda;
    private javax.swing.JTextField txtQnt;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
