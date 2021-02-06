package DAO;

import model.ModelFormaPagamento;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Robson Costa
*/
public class DAOFormaPagamento extends ConexaoMySql {

    /**
    * grava FormaPagamento
    * @param pModelFormaPagamento
    * @return int
    */
    public int salvarFormaPagamentoDAO(ModelFormaPagamento pModelFormaPagamento){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tbl_forma_pagamento ("
                    + "form_pag_id,"
                    + "form_pag_descricao,"
                    + "form_pag_desconto,"
                    + "form_pag_parcela,"
                    + "form_pag_situacao"
                + ") VALUES ("
                    + "'" + pModelFormaPagamento.getFormPagId() + "',"
                    + "'" + pModelFormaPagamento.getFormPagDescricao() + "',"
                    + "'" + pModelFormaPagamento.getFormPagDesconto() + "',"
                    + "'" + pModelFormaPagamento.getFormPagParcela() + "',"
                    + "'" + pModelFormaPagamento.getFormPagSituacao() + "'"
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
    * recupera FormaPagamento
    * @param pFormPagId
    * @return ModelFormaPagamento
    */
    public ModelFormaPagamento getFormaPagamentoDAO(long pFormPagId){
        ModelFormaPagamento modelFormaPagamento = new ModelFormaPagamento();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "form_pag_id,"
                    + "form_pag_descricao,"
                    + "form_pag_desconto,"
                    + "form_pag_parcela,"
                    + "form_pag_situacao"
                 + " FROM"
                     + " tbl_forma_pagamento"
                 + " WHERE"
                     + " form_pag_id = '" + pFormPagId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelFormaPagamento.setFormPagId(this.getResultSet().getLong(1));
                modelFormaPagamento.setFormPagDescricao(this.getResultSet().getString(2));
                modelFormaPagamento.setFormPagDesconto(this.getResultSet().getDouble(3));
                modelFormaPagamento.setFormPagParcela(this.getResultSet().getInt(4));
                modelFormaPagamento.setFormPagSituacao(this.getResultSet().getInt(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelFormaPagamento;
    }

    /**
    * recupera uma lista de FormaPagamento
        * @return ArrayList
    */
    public ArrayList<ModelFormaPagamento> getListaFormaPagamentoDAO(){
        ArrayList<ModelFormaPagamento> listamodelFormaPagamento = new ArrayList();
        ModelFormaPagamento modelFormaPagamento = new ModelFormaPagamento();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "form_pag_id,"
                    + "form_pag_descricao,"
                    + "form_pag_desconto,"
                    + "form_pag_parcela,"
                    + "form_pag_situacao"
                 + " FROM"
                     + " tbl_forma_pagamento"
                + ";"
            );

            while(this.getResultSet().next()){
                modelFormaPagamento = new ModelFormaPagamento();
                modelFormaPagamento.setFormPagId(this.getResultSet().getLong(1));
                modelFormaPagamento.setFormPagDescricao(this.getResultSet().getString(2));
                modelFormaPagamento.setFormPagDesconto(this.getResultSet().getDouble(3));
                modelFormaPagamento.setFormPagParcela(this.getResultSet().getInt(4));
                modelFormaPagamento.setFormPagSituacao(this.getResultSet().getInt(5));
                listamodelFormaPagamento.add(modelFormaPagamento);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelFormaPagamento;
    }

    /**
    * atualiza FormaPagamento
    * @param pModelFormaPagamento
    * @return boolean
    */
    public boolean atualizarFormaPagamentoDAO(ModelFormaPagamento pModelFormaPagamento){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_forma_pagamento SET "
                    + "form_pag_id = '" + pModelFormaPagamento.getFormPagId() + "',"
                    + "form_pag_descricao = '" + pModelFormaPagamento.getFormPagDescricao() + "',"
                    + "form_pag_desconto = '" + pModelFormaPagamento.getFormPagDesconto() + "',"
                    + "form_pag_parcela = '" + pModelFormaPagamento.getFormPagParcela() + "',"
                    + "form_pag_situacao = '" + pModelFormaPagamento.getFormPagSituacao() + "'"
                + " WHERE "
                    + "form_pag_id = '" + pModelFormaPagamento.getFormPagId() + "'"
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
    * exclui FormaPagamento
    * @param pFormPagId
    * @return boolean
    */
    public boolean excluirFormaPagamentoDAO(long pFormPagId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_forma_pagamento "
                + " WHERE "
                    + "form_pag_id = '" + pFormPagId + "'"
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