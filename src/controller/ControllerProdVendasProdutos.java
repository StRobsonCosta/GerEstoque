/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOProdVendasProdutos;
import java.util.ArrayList;
import model.ModelProdVendasProdutos;

/**
 *
 * @author user
 */
public class ControllerProdVendasProdutos {
    
    private DAOProdVendasProdutos dAOProdVendasProdutos = new DAOProdVendasProdutos();
    
    public ArrayList<ModelProdVendasProdutos> listarProdVendasProdutosController(int codVenda){
        return this.dAOProdVendasProdutos.listarProdVendasProdutosDao(codVenda);
        
    }
    
}
