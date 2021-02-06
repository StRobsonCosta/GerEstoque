/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import model.ModelCliente;
import model.ModelVendas;
import model.ModelVendasCliente;

/**
 *
 * @author user
 */
public class DAOVendasCliente extends conexoes.ConexaoMySql{
    
    public ArrayList<ModelVendasCliente> getListaVendasClienteDAO(){
    ArrayList<ModelVendasCliente> listamodelVendasCliente = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        ModelCliente modelCliente = new ModelCliente();
        ModelVendasCliente modelVendasCliente = new ModelVendasCliente();
        
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "tbl_vendas.ven_id,"
                    + "tbl_vendas.fk_cliente,"
                    + "tbl_vendas.ven_data_vendas,"
                    + "tbl_vendas.ven_valor_liq,"
                    + "tbl_vendas.ven_valor_bruto,"
                    + "tbl_vendas.ven_desc,"
                    + "tbl_cliente.cli_id,"
                    + "tbl_cliente.cli_nome,"
                    + "tbl_cliente.cli_end,"
                    + "tbl_cliente.cli_bairro,"
                    + "tbl_cliente.cli_city,"
                    + "tbl_cliente.cli_uf,"
                    + "tbl_cliente.cli_cep,"
                    + "tbl_cliente.cli_fone"    
                 + " FROM"
                     + " tbl_vendas INNER JOIN tbl_cliente "
                     + "ON tbl_cliente.cli_id = tbl_vendas.fk_cliente"   
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendas = new ModelVendas();
                modelCliente = new ModelCliente();
                modelVendasCliente = new ModelVendasCliente();
                
                modelVendas.setVenId(this.getResultSet().getInt(1));
                modelVendas.setCliente(this.getResultSet().getString(2));
                modelVendas.setVenDataVendas(this.getResultSet().getDate(3));
                modelVendas.setVenValorLiq(this.getResultSet().getDouble(4));
                modelVendas.setVenValorBrut(this.getResultSet().getDouble(5));
                modelVendas.setVenValorDesc(this.getResultSet().getDouble(6));
                
                modelCliente = new ModelCliente();
                modelCliente.setCliId(this.getResultSet().getInt(7));
                modelCliente.setCliNome(this.getResultSet().getString(8));
                modelCliente.setCliEnd(this.getResultSet().getString(9));
                modelCliente.setCliBairro(this.getResultSet().getString(10));
                modelCliente.setCliCidade(this.getResultSet().getString(11));
                modelCliente.setCliUF(this.getResultSet().getString(12));
                modelCliente.setCliCep(this.getResultSet().getString(13));
                modelCliente.setCliFone(this.getResultSet().getString(14));
                
                modelVendasCliente.setModelVendas(modelVendas);
                modelVendasCliente.setModelCliente(modelCliente);
                listamodelVendasCliente.add(modelVendasCliente);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelVendasCliente;
    }
}
