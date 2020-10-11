package model;
/**
*
* @author Robson Costa
*/
public class ModelUsuario {

    private int usuId;
    private String usuNome;
    private String usuLogin;
    private String usuSenha;

    /**
    * Construtor
    */
    public ModelUsuario(){}

    /**
    * seta o valor de usuId
    * @param pUsuId
    */
    public void setUsuId(int pUsuId){
        this.usuId = pUsuId;
    }
    /**
    * @return pk_usuId
    */
    public int getUsuId(){
        return this.usuId;
    }

    /**
    * seta o valor de usuNome
    * @param pUsuNome
    */
    public void setUsuNome(String pUsuNome){
        this.usuNome = pUsuNome;
    }
    /**
    * @return usuNome
    */
    public String getUsuNome(){
        return this.usuNome;
    }

    /**
    * seta o valor de usuLogin
    * @param pUsuLogin
    */
    public void setUsuLogin(String pUsuLogin){
        this.usuLogin = pUsuLogin;
    }
    /**
    * @return usuLogin
    */
    public String getUsuLogin(){
        return this.usuLogin;
    }

    /**
    * seta o valor de usuSenha
    * @param pUsuSenha
    */
    public void setUsuSenha(String pUsuSenha){
        this.usuSenha = pUsuSenha;
    }
    /**
    * @return usuSenha
    */
    public String getUsuSenha(){
        return this.usuSenha;
    }

    @Override
    public String toString(){
        return "ModelUsuario {" + "::usuId = " + this.usuId + "::usuNome = " + this.usuNome + "::usuLogin = " + this.usuLogin + "::usuSenha = " + this.usuSenha +  "}";
    }
}