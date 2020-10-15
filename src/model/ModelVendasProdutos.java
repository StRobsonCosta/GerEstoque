package model;
/**
*
* @author Robson Costa
*/
public class ModelVendasProdutos {

    private int venProdId;
    private int produto;
    private int vendas;
    private double venProdValor;
    private int venProdQuant;

    /**
    * Construtor
    */
    public ModelVendasProdutos(){}

    /**
    * seta o valor de venProdId
    * @param pVenProdId
    */
    public void setVenProdId(int pVenProdId){
        this.venProdId = pVenProdId;
    }
    /**
    * @return pk_venProdId
    */
    public int getVenProdId(){
        return this.venProdId;
    }

    /**
    * seta o valor de produto
    * @param pProduto
    */
    public void setProduto(int pProduto){
        this.produto = pProduto;
    }
    /**
    * @return fk_produto
    */
    public int getProduto(){
        return this.produto;
    }

    /**
    * seta o valor de vendas
    * @param pVendas
    */
    public void setVendas(int pVendas){
        this.vendas = pVendas;
    }
    /**
    * @return fk_vendas
    */
    public int getVendas(){
        return this.vendas;
    }

    /**
    * seta o valor de venProdValor
    * @param pVenProdValor
    */
    public void setVenProdValor(double pVenProdValor){
        this.venProdValor = pVenProdValor;
    }
    /**
    * @return venProdValor
    */
    public double getVenProdValor(){
        return this.venProdValor;
    }

    /**
    * seta o valor de venProdQuant
    * @param pVenProdQuant
    */
    public void setVenProdQuant(int pVenProdQuant){
        this.venProdQuant = pVenProdQuant;
    }
    /**
    * @return venProdQuant
    */
    public int getVenProdQuant(){
        return this.venProdQuant;
    }

    @Override
    public String toString(){
        return "ModelVendasProdutos {" + "::venProdId = " + this.venProdId + "::produto = " + this.produto + "::vendas = " + this.vendas + "::venProdValor = " + this.venProdValor + "::venProdQuant = " + this.venProdQuant +  "}";
    }
}