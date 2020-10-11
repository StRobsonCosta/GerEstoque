package model;
/**
*
* @author Robson Costa
*/
public class ModelCliente {

    private int cliId;
    private String cliNome;
    private String cliEnd;
    private String cliBairro;
    private String cliCidade;
    private String cliUF;
    private String cliCep;
    private String cliFone;

    /**
    * Construtor
    */
    public ModelCliente(){}

    /**
    * seta o valor de cliId
    * @param pCliId
    */
    public void setCliId(int pCliId){
        this.cliId = pCliId;
    }
    /**
    * @return cliId
    */
    public int getCliId(){
        return this.cliId;
    }

    /**
    * seta o valor de cliNome
    * @param pCliNome
    */
    public void setCliNome(String pCliNome){
        this.cliNome = pCliNome;
    }
    /**
    * @return cliNome
    */
    public String getCliNome(){
        return this.cliNome;
    }

    /**
    * seta o valor de cliEnd
    * @param pCliEnd
    */
    public void setCliEnd(String pCliEnd){
        this.cliEnd = pCliEnd;
    }
    /**
    * @return cliEnd
    */
    public String getCliEnd(){
        return this.cliEnd;
    }

    /**
    * seta o valor de cliBairro
    * @param pCliBairro
    */
    public void setCliBairro(String pCliBairro){
        this.cliBairro = pCliBairro;
    }
    /**
    * @return cliBairro
    */
    public String getCliBairro(){
        return this.cliBairro;
    }

    /**
    * seta o valor de cliCidade
    * @param pCliCidade
    */
    public void setCliCidade(String pCliCidade){
        this.cliCidade = pCliCidade;
    }
    /**
    * @return cliCidade
    */
    public String getCliCidade(){
        return this.cliCidade;
    }

    /**
    * seta o valor de cliUF
    * @param pCliUF
    */
    public void setCliUF(String pCliUF){
        this.cliUF = pCliUF;
    }
    /**
    * @return cliUF
    */
    public String getCliUF(){
        return this.cliUF;
    }

    /**
    * seta o valor de cliCep
    * @param pCliCep
    */
    public void setCliCep(String pCliCep){
        this.cliCep = pCliCep;
    }
    /**
    * @return cliCep
    */
    public String getCliCep(){
        return this.cliCep;
    }

    /**
    * seta o valor de cliFone
    * @param pCliFone
    */
    public void setCliFone(String pCliFone){
        this.cliFone = pCliFone;
    }
    /**
    * @return cliFone
    */
    public String getCliFone(){
        return this.cliFone;
    }

    @Override
    public String toString(){
        return "ModelCliente {" + "::cliId = " + this.cliId + "::cliNome = " + this.cliNome + "::cliEnd = " + this.cliEnd + "::cliBairro = " + this.cliBairro + "::cliCidade = " + this.cliCidade + "::cliUF = " + this.cliUF + "::cliCep = " + this.cliCep + "::cliFone = " + this.cliFone +  "}";
    }
}