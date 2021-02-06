/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoProduto;
import java.util.ArrayList;
import model.ModelProdutos;

/**
 *
 * @author user
 */
public class ControllerProdutos {
    private DaoProduto daoProduto = new DaoProduto();
    
    public int salvarProdutoController (ModelProdutos pModelProdutos){
        return this.daoProduto.salvarProdutosDAO(pModelProdutos);
    }
    
    public boolean excluirProdutosController (int pCodigo){
        return this.daoProduto.excluirProdutoDAO(pCodigo);
    }
    
    public boolean alterarProdutoController (ModelProdutos pModelProduto){
        return this.daoProduto.alterarProdutoDAO(pModelProduto);
    }
    
    public ModelProdutos retornarProdutoController (int pCodigo){
        return this.daoProduto.retornarProdutoDAO(pCodigo);
    }
    
        /**
    * recupera Cliente
    * @param pCliId
    * @return ModelCliente
    */
    public ModelProdutos getProdutoController(String pProdNome){
        return this.daoProduto.retornarProdutoDAO(pProdNome);
    }
    
    public ArrayList <ModelProdutos> retornarListaProdutoController(){
        return this.daoProduto.retornarListaProdutoDAO();
    }

    public boolean alterarEstoqueProdutoController(ArrayList<ModelProdutos> listarProdutos) {
        return  this.daoProduto.alterarEstoqueProdutosDAO(listarProdutos);
    }
}
