package controller;

import model.ModelCliente;
import DAO.DAOCliente;
import java.util.ArrayList;

/**
*
* @author Robson Costa
*/
public class ControllerCliente {

    private DAOCliente daoCliente = new DAOCliente();

    /**
    * grava Cliente
    * @param pModelCliente
    * @return int
    */
    public int salvarClienteController(ModelCliente pModelCliente){
        return this.daoCliente.salvarClienteDAO(pModelCliente);
    }

    /**
    * recupera Cliente
    * @param pCliId
    * @return ModelCliente
    */
    public ModelCliente getClienteController(int pCliId){
        return this.daoCliente.getClienteDAO(pCliId);
    }
    /**
    * recupera Cliente
    * @param pCliId
    * @return ModelCliente
    */
    public ModelCliente getClienteController(String pCliNome){
        return this.daoCliente.getClienteDAO(pCliNome);
    }

    /**
    * recupera uma lista deCliente
    * @param pCliId
    * @return ArrayList
    */
    public ArrayList<ModelCliente> getListaClienteController(){
        return this.daoCliente.getListaClienteDAO();
    }

    /**
    * atualiza Cliente
    * @param pModelCliente
    * @return boolean
    */
    public boolean atualizarClienteController(ModelCliente pModelCliente){
        return this.daoCliente.atualizarClienteDAO(pModelCliente);
    }

    /**
    * exclui Cliente
    * @param pCliId
    * @return boolean
    */
    public boolean excluirClienteController(int pCliId){
        return this.daoCliente.excluirClienteDAO(pCliId);
    }
}