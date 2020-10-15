package controller;

import model.ModelVendasProdutos;
import DAO.DAOVendasProdutos;
import java.util.ArrayList;

/**
*
* @author Robson Costa
*/
public class ControllerVendasProdutos {

    private DAOVendasProdutos daoVendasProdutos = new DAOVendasProdutos();

    /**
    * grava VendasProdutos
    * @param pModelVendasProdutos
    * @return int
    */
    public int salvarVendasProdutosController(ModelVendasProdutos pModelVendasProdutos){
        return this.daoVendasProdutos.salvarVendasProdutosDAO(pModelVendasProdutos);
    }

    /**
    * recupera VendasProdutos
    * @param pVenProdId
    * @return ModelVendasProdutos
    */
    public ModelVendasProdutos getVendasProdutosController(int pVenProdId){
        return this.daoVendasProdutos.getVendasProdutosDAO(pVenProdId);
    }

    /**
    * recupera uma lista deVendasProdutos
    * @param pVenProdId
    * @return ArrayList
    */
    public ArrayList<ModelVendasProdutos> getListaVendasProdutosController(){
        return this.daoVendasProdutos.getListaVendasProdutosDAO();
    }

    /**
    * atualiza VendasProdutos
    * @param pModelVendasProdutos
    * @return boolean
    */
    public boolean atualizarVendasProdutosController(ModelVendasProdutos pModelVendasProdutos){
        return this.daoVendasProdutos.atualizarVendasProdutosDAO(pModelVendasProdutos);
    }

    /**
    * exclui VendasProdutos
    * @param pVenProdId
    * @return boolean
    */
    public boolean excluirVendasProdutosController(int pVenProdId){
        return this.daoVendasProdutos.excluirVendasProdutosDAO(pVenProdId);
    }
}