package DAO;

import model.ModelVendasProdutos;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Robson Costa
*/
public class DAOVendasProdutos extends ConexaoMySql {

    /**
    * grava VendasProdutos
    * @param pModelVendasProdutos
    * @return int
    */
    public int salvarVendasProdutosDAO(ModelVendasProdutos pModelVendasProdutos){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tbl_vendas_produto ("                    
                    + "fk_produto,"
                    + "fk_vendas,"
                    + "ven_prod_valor,"
                    + "ven_prod_quant"
                + ") VALUES ("                    
                    + "'" + pModelVendasProdutos.getProduto() + "',"
                    + "'" + pModelVendasProdutos.getVendas() + "',"
                    + "'" + pModelVendasProdutos.getVenProdValor() + "',"
                    + "'" + pModelVendasProdutos.getVenProdQuant() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera VendasProdutos
    * @param pVenProdId
    * @return ModelVendasProdutos
    */
    public ModelVendasProdutos getVendasProdutosDAO(int pVenProdId){
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "ven_prod_id,"
                    + "fk_produto,"
                    + "fk_vendas,"
                    + "ven_prod_valor,"
                    + "ven_prod_quant"
                 + " FROM"
                     + " tbl_vendas_produto"
                 + " WHERE"
                     + " ven_prod_id = '" + pVenProdId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendasProdutos.setVenProdId(this.getResultSet().getInt(1));
                modelVendasProdutos.setProduto(this.getResultSet().getInt(2));
                modelVendasProdutos.setVendas(this.getResultSet().getInt(3));
                modelVendasProdutos.setVenProdValor(this.getResultSet().getDouble(4));
                modelVendasProdutos.setVenProdQuant(this.getResultSet().getInt(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelVendasProdutos;
    }

    /**
    * recupera uma lista de VendasProdutos
        * @return ArrayList
    */
    public ArrayList<ModelVendasProdutos> getListaVendasProdutosDAO(){
        ArrayList<ModelVendasProdutos> listamodelVendasProdutos = new ArrayList();
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "ven_prod_id,"
                    + "fk_produto,"
                    + "fk_vendas,"
                    + "ven_prod_valor,"
                    + "ven_prod_quant"
                 + " FROM"
                     + " tbl_vendas_produto"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendasProdutos = new ModelVendasProdutos();
                modelVendasProdutos.setVenProdId(this.getResultSet().getInt(1));
                modelVendasProdutos.setProduto(this.getResultSet().getInt(2));
                modelVendasProdutos.setVendas(this.getResultSet().getInt(3));
                modelVendasProdutos.setVenProdValor(this.getResultSet().getDouble(4));
                modelVendasProdutos.setVenProdQuant(this.getResultSet().getInt(5));
                listamodelVendasProdutos.add(modelVendasProdutos);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelVendasProdutos;
    }

    /**
    * atualiza VendasProdutos
    * @param pModelVendasProdutos
    * @return boolean
    */
    public boolean atualizarVendasProdutosDAO(ModelVendasProdutos pModelVendasProdutos){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_vendas_produto SET "
                    + "ven_prod_id = '" + pModelVendasProdutos.getVenProdId() + "',"
                    + "fk_produto = '" + pModelVendasProdutos.getProduto() + "',"
                    + "fk_vendas = '" + pModelVendasProdutos.getVendas() + "',"
                    + "ven_prod_valor = '" + pModelVendasProdutos.getVenProdValor() + "',"
                    + "ven_prod_quant = '" + pModelVendasProdutos.getVenProdQuant() + "'"
                + " WHERE "
                    + "ven_prod_id = '" + pModelVendasProdutos.getVenProdId() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui VendasProdutos
    * @param pVenProdId
    * @return boolean
    */
    public boolean excluirVendasProdutosDAO(int pVenProdId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_vendas_produto "
                + " WHERE "
                    + "ven_prod_id = '" + pVenProdId + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
}