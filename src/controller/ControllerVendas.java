package controller;

import model.ModelVendas;
import DAO.DAOVendas;
import java.util.ArrayList;

/**
*
* @author Robson Costa
*/
public class ControllerVendas {

    private DAOVendas daoVendas = new DAOVendas();

    /**
    * grava Vendas
    * @param pModelVendas
    * @return int
    */
    public int salvarVendasController(ModelVendas pModelVendas){
        return this.daoVendas.salvarVendasDAO(pModelVendas);
    }

    /**
    * recupera Vendas
    * @param pVenId
    * @return ModelVendas
    */
    public ModelVendas getVendasController(int pVenId){
        return this.daoVendas.getVendasDAO(pVenId);
    }

    /**
    * recupera uma lista deVendas
    * @param pVenId
    * @return ArrayList
    */
    public ArrayList<ModelVendas> getListaVendasController(){
        return this.daoVendas.getListaVendasDAO();
    }

    /**
    * atualiza Vendas
    * @param pModelVendas
    * @return boolean
    */
    public boolean atualizarVendasController(ModelVendas pModelVendas){
        return this.daoVendas.atualizarVendasDAO(pModelVendas);
    }

    /**
    * exclui Vendas
    * @param pVenId
    * @return boolean
    */
    public boolean excluirVendasController(int pVenId){
        return this.daoVendas.excluirVendasDAO(pVenId);
    }
}