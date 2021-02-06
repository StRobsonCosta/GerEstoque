package DAO;

import model.ModelCliente;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Robson Costa
*/
public class DAOCliente extends ConexaoMySql {

    /**
    * grava Cliente
    * @param pModelCliente
    * @return int
    */
    public int salvarClienteDAO(ModelCliente pModelCliente){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tbl_cliente ("
                    + "cli_nome,"
                    + "cli_end,"
                    + "cli_bairro,"
                    + "cli_city,"
                    + "cli_uf,"
                    + "cli_cep,"
                    + "cli_fone"
                + ") VALUES ("
                    + "'" + pModelCliente.getCliNome() + "',"
                    + "'" + pModelCliente.getCliEnd() + "',"
                    + "'" + pModelCliente.getCliBairro() + "',"
                    + "'" + pModelCliente.getCliCidade() + "',"
                    + "'" + pModelCliente.getCliUF() + "',"
                    + "'" + pModelCliente.getCliCep() + "',"
                    + "'" + pModelCliente.getCliFone() + "'"
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
    * recupera Cliente
    * @param pCliId
    * @return ModelCliente
    */
    public ModelCliente getClienteDAO(int pCliId){
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "cli_id,"
                    + "cli_nome,"
                    + "cli_end,"
                    + "cli_bairro,"
                    + "cli_city,"
                    + "cli_uf,"
                    + "cli_cep,"
                    + "cli_fone"
                 + " FROM"
                     + " tbl_cliente"
                 + " WHERE"
                     + " cli_id = '" + pCliId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCliente.setCliId(this.getResultSet().getInt(1));
                modelCliente.setCliNome(this.getResultSet().getString(2));
                modelCliente.setCliEnd(this.getResultSet().getString(3));
                modelCliente.setCliBairro(this.getResultSet().getString(4));
                modelCliente.setCliCidade(this.getResultSet().getString(5));
                modelCliente.setCliUF(this.getResultSet().getString(6));
                modelCliente.setCliCep(this.getResultSet().getString(7));
                modelCliente.setCliFone(this.getResultSet().getString(8));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelCliente;
    }
    /**
    * recupera Cliente
    * @param pCliNome
    * @return ModelCliente
    */
    public ModelCliente getClienteDAO(String pCliNome){
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "cli_id,"
                    + "cli_nome,"
                    + "cli_end,"
                    + "cli_bairro,"
                    + "cli_city,"
                    + "cli_uf,"
                    + "cli_cep,"
                    + "cli_fone"
                 + " FROM"
                     + " tbl_cliente"
                 + " WHERE"
                     + " cli_nome = '" + pCliNome + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCliente.setCliId(this.getResultSet().getInt(1));
                modelCliente.setCliNome(this.getResultSet().getString(2));
                modelCliente.setCliEnd(this.getResultSet().getString(3));
                modelCliente.setCliBairro(this.getResultSet().getString(4));
                modelCliente.setCliCidade(this.getResultSet().getString(5));
                modelCliente.setCliUF(this.getResultSet().getString(6));
                modelCliente.setCliCep(this.getResultSet().getString(7));
                modelCliente.setCliFone(this.getResultSet().getString(8));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelCliente;
    }

    /**
    * recupera uma lista de Cliente
        * @return ArrayList
    */
    public ArrayList<ModelCliente> getListaClienteDAO(){
        ArrayList<ModelCliente> listamodelCliente = new ArrayList();
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "cli_id,"
                    + "cli_nome,"
                    + "cli_end,"
                    + "cli_bairro,"
                    + "cli_city,"
                    + "cli_uf,"
                    + "cli_cep,"
                    + "cli_fone"
                 + " FROM"
                     + " tbl_cliente"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCliente = new ModelCliente();
                modelCliente.setCliId(this.getResultSet().getInt(1));
                modelCliente.setCliNome(this.getResultSet().getString(2));
                modelCliente.setCliEnd(this.getResultSet().getString(3));
                modelCliente.setCliBairro(this.getResultSet().getString(4));
                modelCliente.setCliCidade(this.getResultSet().getString(5));
                modelCliente.setCliUF(this.getResultSet().getString(6));
                modelCliente.setCliCep(this.getResultSet().getString(7));
                modelCliente.setCliFone(this.getResultSet().getString(8));
                listamodelCliente.add(modelCliente);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelCliente;
    }

    /**
    * atualiza Cliente
    * @param pModelCliente
    * @return boolean
    */
    public boolean atualizarClienteDAO(ModelCliente pModelCliente){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_cliente SET "
                    + "cli_id = '" + pModelCliente.getCliId() + "',"
                    + "cli_nome = '" + pModelCliente.getCliNome() + "',"
                    + "cli_end = '" + pModelCliente.getCliEnd() + "',"
                    + "cli_bairro = '" + pModelCliente.getCliBairro() + "',"
                    + "cli_city = '" + pModelCliente.getCliCidade() + "',"
                    + "cli_uf = '" + pModelCliente.getCliUF() + "',"
                    + "cli_cep = '" + pModelCliente.getCliCep() + "',"
                    + "cli_fone = '" + pModelCliente.getCliFone() + "'"
                + " WHERE "
                    + "cli_id = '" + pModelCliente.getCliId() + "'"
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
    * exclui Cliente
    * @param pCliId
    * @return boolean
    */
    public boolean excluirClienteDAO(int pCliId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_cliente "
                + " WHERE "
                    + "cli_id = '" + pCliId + "'"
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