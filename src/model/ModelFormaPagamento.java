package model;
/**
*
* @author Robson Costa
*/
public class ModelFormaPagamento {

    private long formPagId;
    private String formPagDescricao;
    private double formPagDesconto;
    private int formPagParcela;
    private int formPagSituacao;

    /**
    * Construtor
    */
    public ModelFormaPagamento(){}

    /**
    * seta o valor de formPagId
    * @param pFormPagId
    */
    public void setFormPagId(long pFormPagId){
        this.formPagId = pFormPagId;
    }
    /**
    * @return formPagId
    */
    public long getFormPagId(){
        return this.formPagId;
    }

    /**
    * seta o valor de formPagDescricao
    * @param pFormPagDescricao
    */
    public void setFormPagDescricao(String pFormPagDescricao){
        this.formPagDescricao = pFormPagDescricao;
    }
    /**
    * @return formPagDescricao
    */
    public String getFormPagDescricao(){
        return this.formPagDescricao;
    }

    /**
    * seta o valor de formPagDesconto
    * @param pFormPagDesconto
    */
    public void setFormPagDesconto(double pFormPagDesconto){
        this.formPagDesconto = pFormPagDesconto;
    }
    /**
    * @return formPagDesconto
    */
    public double getFormPagDesconto(){
        return this.formPagDesconto;
    }

    /**
    * seta o valor de formPagParcela
    * @param pFormPagParcela
    */
    public void setFormPagParcela(int pFormPagParcela){
        this.formPagParcela = pFormPagParcela;
    }
    /**
    * @return formPagParcela
    */
    public int getFormPagParcela(){
        return this.formPagParcela;
    }

    /**
    * seta o valor de formPagSituacao
    * @param pFormPagSituacao
    */
    public void setFormPagSituacao(int pFormPagSituacao){
        this.formPagSituacao = pFormPagSituacao;
    }
    /**
    * @return formPagSituacao
    */
    public int getFormPagSituacao(){
        return this.formPagSituacao;
    }

    @Override
    public String toString(){
        return "ModelFormaPagamento {" + "::formPagId = " + this.formPagId + "::formPagDescricao = " + this.formPagDescricao + "::formPagDesconto = " + this.formPagDesconto + "::formPagParcela = " + this.formPagParcela + "::formPagSituacao = " + this.formPagSituacao +  "}";
    }
}