/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelProdVendasProdutos;
import model.ModelProdutos;
import model.ModelVendasProdutos;

/**
 *
 * @author user
 */
public class DAOProdVendasProdutos extends ConexaoMySql{
    
    public ArrayList<ModelProdVendasProdutos> listarProdVendasProdutosDao(int codVenda){
        ArrayList<ModelProdVendasProdutos> listaModelProdVendasProdutos = new ArrayList<>();
        ModelProdVendasProdutos modelProdVendasProdutos = new ModelProdVendasProdutos();
        ModelProdutos modelProdutos = new ModelProdutos();
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "tbl_produto.prod_id, "
                    + "tbl_produto.prod_estoque, "
                    + "tbl_produto.prod_nome, "
                    + "tbl_produto.prod_valor, "        
                    + "tbl_vendas_produto.fk_produto, "
                    + "tbl_vendas_produto.fk_vendas, "
                    + "tbl_vendas_produto.ven_prod_id, "
                    + "tbl_vendas_produto.ven_prod_quant, "
                    + "tbl_vendas_produto.ven_prod_valor "   
                    + "FROM tbl_vendas_produto "
                    + "INNER JOIN tbl_produto "
                    + "ON tbl_produto.prod_id = tbl_vendas_produto.fk_produto "
                    + "WHERE tbl_vendas_produto.fk_vendas = '"+ codVenda + "';"
                );
            while (this.getResultSet().next()){
                modelProdVendasProdutos = new ModelProdVendasProdutos();
                modelProdutos = new ModelProdutos();
                modelVendasProdutos = new ModelVendasProdutos();
                
                modelProdutos.setProdId(this.getResultSet().getInt(1));
                modelProdutos.setProdEstoque(this.getResultSet().getInt(2));
                modelProdutos.setProdNome(this.getResultSet().getString(3));
                modelProdutos.setProdValor(this.getResultSet().getDouble(4));
                
                modelVendasProdutos.setProduto(this.getResultSet().getInt(5));
                modelVendasProdutos.setVendas(this.getResultSet().getInt(6));
                modelVendasProdutos.setVenProdId(this.getResultSet().getInt(7));
                modelVendasProdutos.setVenProdQuant(this.getResultSet().getInt(8));
                modelVendasProdutos.setVenProdValor(this.getResultSet().getDouble(9));
                
                modelProdVendasProdutos.setModelProdutos(modelProdutos);
                modelProdVendasProdutos.setModelVendasProdutos(modelVendasProdutos);
                
                listaModelProdVendasProdutos.add(modelProdVendasProdutos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listaModelProdVendasProdutos;
        
    }
    
}
