package controller;

import model.ModelUsuario;
import DAO.DAOUsuario;
import java.util.ArrayList;

/**
*
* @author Robson Costa
*/
public class ControllerUsuario {

    private DAOUsuario daoUsuario = new DAOUsuario();

    /**
    * grava Usuario
    * @param pModelUsuario
    * @return int
    */
    public int salvarUsuarioController(ModelUsuario pModelUsuario){
        return this.daoUsuario.salvarUsuarioDAO(pModelUsuario);
    }

    /**
    * recupera Usuario
    * @param pUsuId
    * @return ModelUsuario
    */
    public ModelUsuario getUsuarioController(int pUsuId){
        return this.daoUsuario.getUsuarioDAO(pUsuId);
    }

    /**
    * recupera uma lista deUsuario
    * @param pUsuId
    * @return ArrayList
    */
    public ArrayList<ModelUsuario> getListaUsuarioController(){
        return this.daoUsuario.getListaUsuarioDAO();
    }

    /**
    * atualiza Usuario
    * @param pModelUsuario
    * @return boolean
    */
    public boolean atualizarUsuarioController(ModelUsuario pModelUsuario){
        return this.daoUsuario.atualizarUsuarioDAO(pModelUsuario);
    }

    /**
    * exclui Usuario
    * @param pUsuId
    * @return boolean
    */
    public boolean excluirUsuarioController(int pUsuId){
        return this.daoUsuario.excluirUsuarioDAO(pUsuId);
    }
    
    public boolean validadorUsuario (ModelUsuario pModelUsuario){
        return this.daoUsuario.validadorUsuario(pModelUsuario);
    }
}