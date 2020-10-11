/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import com.mysql.jdbc.*;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelProdutos;

/**
 *
 * @author user
 */
public class DaoProduto extends ConexaoMySql{
    
    public int salvarProdutosDAO(ModelProdutos pModelProdutos){
        try{
            this.conectar();
            return this.insertSQL("INSERT INTO tbl_produto ("
                    + "prod_nome,"
                    + "prod_valor,"
                    + "prod_estoque ) VALUES ("
                    + "'"+ pModelProdutos.getProdNome()+"',"
                    + " '"+ pModelProdutos.getProdValor()+"',"
                    + " '"+ pModelProdutos.getProdEstoque()+"');");
            
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            this.fecharConexao();
        }
    }
    
    public boolean excluirProdutoDAO (int pIdProduto){
        try {
            
        this.conectar();
        return this.executarUpdateDeleteSQL(
        "DELETE FROM `tbl_produto` WHERE `prod_id` = '"+pIdProduto+"'");
        } catch (Exception e) {
        e.printStackTrace();
            return false;
        }finally {
            this.fecharConexao();
        }
    }
    
    public boolean alterarProdutoDAO (ModelProdutos pModelProdutos ){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
            "UPDATE `tbl_produto` SET"
                    + "`prod_nome` = '"+ pModelProdutos.getProdNome()+"',"
                    + "`prod_valor` = '"+ pModelProdutos.getProdValor()+"',"
                    + "`prod_estoque` = '"+ pModelProdutos.getProdEstoque()+"'"
                    + "WHERE `prod_id` = '" + pModelProdutos.getProdId()+"'");
        } catch (Exception e) {
        e.printStackTrace();
            return false;
        }finally {
            this.fecharConexao();
        }
    }
    public ModelProdutos retornarProdutoDAO (int pIdProduto){
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT `prod_id`,"
                    + "`prod_nome`,"
                    + "`prod_valor`,"
                    + "`prod_estoque`"
                    + "FROM `tbl_produto` WHERE `prod_id` = '"+pIdProduto+"'");
            while(this.getResultSet().next()){
                modelProdutos.setProdId(this.getResultSet().getInt(1));
                modelProdutos.setProdNome(this.getResultSet().getString(2));
                modelProdutos.setProdValor(this.getResultSet().getDouble(3));
                modelProdutos.setProdEstoque(this.getResultSet().getInt(4));
            }
            
        } catch (Exception e) {
        e.printStackTrace();
            
        }finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }
    public ArrayList <ModelProdutos> retornarListaProdutoDAO(){
        ArrayList <ModelProdutos> listaModelProdutos = new ArrayList<>();
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT `prod_id`, `prod_nome`, `prod_valor`, `prod_estoque` FROM `tbl_produto`");
                   /* "SELECT prod_id, "
                    + "prod_nome,"
                    + "prod_valor"
                    + "prod_estoque"                    
                    + "FROM tbl_produto");*/
           // SELECT `prod_id`, `prod_nome`, `prod_valor`, `prod_estoque` FROM `tbl_produto` WHERE 1
            while (this.getResultSet().next()){
                modelProdutos = new ModelProdutos();
                modelProdutos.setProdId(this.getResultSet().getInt(1));
                modelProdutos.setProdNome(this.getResultSet().getString(2));
                modelProdutos.setProdValor(this.getResultSet().getDouble(3));
                modelProdutos.setProdEstoque(this.getResultSet().getInt(4));
                listaModelProdutos.add(modelProdutos);
                
            }
            
        } catch (Exception e) {
        e.printStackTrace();
            
        }finally {
            this.fecharConexao();
        }
        return listaModelProdutos;
    }
}
