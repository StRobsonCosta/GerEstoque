package DAO;

import model.ModelUsuario;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Robson Costa
*/
public class DAOUsuario extends ConexaoMySql {

    /**
    * grava Usuario
    * @param pModelUsuario
    * @return int
    */
    public int salvarUsuarioDAO(ModelUsuario pModelUsuario){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tbl_usuario ("
                    + "usu_nome,"
                    + "usu_login,"
                    + "usu_senha"
                + ") VALUES ("
                    + "'" + pModelUsuario.getUsuNome() + "',"
                    + "'" + pModelUsuario.getUsuLogin() + "',"
                    + "'" + pModelUsuario.getUsuSenha() + "'"
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
    * recupera Usuario
    * @param pUsuId
    * @return ModelUsuario
    */
    public ModelUsuario getUsuarioDAO(int pUsuId){
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "usu_id,"
                    + "usu_nome,"
                    + "usu_login,"
                    + "usu_senha"
                 + " FROM"
                     + " tbl_usuario"
                 + " WHERE"
                     + " usu_id = '" + pUsuId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelUsuario.setUsuId(this.getResultSet().getInt(1));
                modelUsuario.setUsuNome(this.getResultSet().getString(2));
                modelUsuario.setUsuLogin(this.getResultSet().getString(3));
                modelUsuario.setUsuSenha(this.getResultSet().getString(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelUsuario;
    }

    /**
    * recupera uma lista de Usuario
        * @return ArrayList
    */
    public ArrayList<ModelUsuario> getListaUsuarioDAO(){
        ArrayList<ModelUsuario> listamodelUsuario = new ArrayList();
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "usu_id,"
                    + "usu_nome,"
                    + "usu_login,"
                    + "usu_senha"
                 + " FROM"
                     + " tbl_usuario"
                + ";"
            );

            while(this.getResultSet().next()){
                modelUsuario = new ModelUsuario();
                modelUsuario.setUsuId(this.getResultSet().getInt(1));
                modelUsuario.setUsuNome(this.getResultSet().getString(2));
                modelUsuario.setUsuLogin(this.getResultSet().getString(3));
                modelUsuario.setUsuSenha(this.getResultSet().getString(4));
                listamodelUsuario.add(modelUsuario);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelUsuario;
    }

    /**
    * atualiza Usuario
    * @param pModelUsuario
    * @return boolean
    */
    public boolean atualizarUsuarioDAO(ModelUsuario pModelUsuario){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_usuario SET "
                    + "usu_id = '" + pModelUsuario.getUsuId() + "',"
                    + "usu_nome = '" + pModelUsuario.getUsuNome() + "',"
                    + "usu_login = '" + pModelUsuario.getUsuLogin() + "',"
                    + "usu_senha = '" + pModelUsuario.getUsuSenha() + "'"
                + " WHERE "
                    + "usu_id = '" + pModelUsuario.getUsuId() + "'"
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
    * exclui Usuario
    * @param pUsuId
    * @return boolean
    */
    public boolean excluirUsuarioDAO(int pUsuId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_usuario "
                + " WHERE "
                    + "usu_id = '" + pUsuId + "'"
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