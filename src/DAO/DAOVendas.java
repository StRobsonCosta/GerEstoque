package DAO;

import model.ModelVendas;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Robson Costa
*/
public class DAOVendas extends ConexaoMySql {

    /**
    * grava Vendas
    * @param pModelVendas
    * @return int
    */
    public int salvarVendasDAO(ModelVendas pModelVendas){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tbl_vendas ("
                    + "fk_cliente,"
                    + "ven_data_vendas,"
                    + "ven_valor_liq,"
                    + "ven_valor_bruto,"
                    + "ven_desc"
                + ") VALUES ("                    
                    + "'" + pModelVendas.getCliente() + "',"
                    + "'" + pModelVendas.getVenDataVendas() + "',"
                    + "'" + pModelVendas.getVenValorLiq() + "',"
                    + "'" + pModelVendas.getVenValorBrut() + "',"
                    + "'" + pModelVendas.getVenValorDesc() + "'"
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
    * recupera Vendas
    * @param pVenId
    * @return ModelVendas
    */
    public ModelVendas getVendasDAO(int pVenId){
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "ven_id,"
                    + "fk_cliente,"
                    + "ven_data_vendas,"
                    + "ven_valor_liq,"
                    + "ven_valor_bruto,"
                    + "ven_desc"
                 + " FROM"
                     + " tbl_vendas"
                 + " WHERE"
                     + " ven_id = '" + pVenId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendas.setVenId(this.getResultSet().getInt(1));
                modelVendas.setCliente(this.getResultSet().getString(2));
                modelVendas.setVenDataVendas(this.getResultSet().getDate(3));
                modelVendas.setVenValorLiq(this.getResultSet().getDouble(4));
                modelVendas.setVenValorBrut(this.getResultSet().getDouble(5));
                modelVendas.setVenValorDesc(this.getResultSet().getDouble(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelVendas;
    }

    /**
    * recupera uma lista de Vendas
        * @return ArrayList
    */
    public ArrayList<ModelVendas> getListaVendasDAO(){
        ArrayList<ModelVendas> listamodelVendas = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "ven_id,"
                    + "fk_cliente,"
                    + "ven_data_vendas,"
                    + "ven_valor_liq,"
                    + "ven_valor_bruto,"
                    + "ven_desc"
                 + " FROM"
                     + " tbl_vendas"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendas = new ModelVendas();
                modelVendas.setVenId(this.getResultSet().getInt(1));
                modelVendas.setCliente(this.getResultSet().getString(2));
                modelVendas.setVenDataVendas(this.getResultSet().getDate(3));
                modelVendas.setVenValorLiq(this.getResultSet().getDouble(4));
                modelVendas.setVenValorBrut(this.getResultSet().getDouble(5));
                modelVendas.setVenValorDesc(this.getResultSet().getDouble(6));
                listamodelVendas.add(modelVendas);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelVendas;
    }

    /**
    * atualiza Vendas
    * @param pModelVendas
    * @return boolean
    */
    public boolean atualizarVendasDAO(ModelVendas pModelVendas){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_vendas SET "
                    + "ven_id = '" + pModelVendas.getVenId() + "',"
                    + "fk_cliente = '" + pModelVendas.getCliente() + "',"
                    + "ven_data_vendas = '" + pModelVendas.getVenDataVendas() + "',"
                    + "ven_valor_liq = '" + pModelVendas.getVenValorLiq() + "',"
                    + "ven_valor_bruto = '" + pModelVendas.getVenValorBrut() + "',"
                    + "ven_desc = '" + pModelVendas.getVenValorDesc() + "'"
                + " WHERE "
                    + "ven_id = '" + pModelVendas.getVenId() + "'"
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
    * exclui Vendas
    * @param pVenId
    * @return boolean
    */
    public boolean excluirVendasDAO(int pVenId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_vendas "
                + " WHERE "
                    + "ven_id = '" + pVenId + "'"
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