package controller;

import model.ModelFormaPagamento;
import DAO.DAOFormaPagamento;
import java.util.ArrayList;

/**
*
* @author Robson Costa
*/
public class ControllerFormaPagamento {

    private DAOFormaPagamento daoFormaPagamento = new DAOFormaPagamento();

    /**
    * grava FormaPagamento
    * @param pModelFormaPagamento
    * @return int
    */
    public int salvarFormaPagamentoController(ModelFormaPagamento pModelFormaPagamento){
        return this.daoFormaPagamento.salvarFormaPagamentoDAO(pModelFormaPagamento);
    }

    /**
    * recupera FormaPagamento
    * @param pFormPagId
    * @return ModelFormaPagamento
    */
    public ModelFormaPagamento getFormaPagamentoController(long pFormPagId){
        return this.daoFormaPagamento.getFormaPagamentoDAO(pFormPagId);
    }

    /**
    * recupera uma lista deFormaPagamento
    * @param pFormPagId
    * @return ArrayList
    */
    public ArrayList<ModelFormaPagamento> getListaFormaPagamentoController(){
        return this.daoFormaPagamento.getListaFormaPagamentoDAO();
    }

    /**
    * atualiza FormaPagamento
    * @param pModelFormaPagamento
    * @return boolean
    */
    public boolean atualizarFormaPagamentoController(ModelFormaPagamento pModelFormaPagamento){
        return this.daoFormaPagamento.atualizarFormaPagamentoDAO(pModelFormaPagamento);
    }

    /**
    * exclui FormaPagamento
    * @param pFormPagId
    * @return boolean
    */
    public boolean excluirFormaPagamentoController(long pFormPagId){
        return this.daoFormaPagamento.excluirFormaPagamentoDAO(pFormPagId);
    }
}