package model;

import java.sql.Date;

/**
*
* @author Robson Costa
*/
public class ModelVendas {

    private int venId;
    private String cliente;
    private int client;
    private Date venDataVendas;
    private double venValorLiq;
    private double venValorBrut;
    private double venValorDesc;

    /**
    * Construtor
    */
    public ModelVendas(){}

    /**
    * seta o valor de venId
    * @param pVenId
    */
    public void setVenId(int pVenId){
        this.venId = pVenId;
    }
    /**
    * @return pk_venId
    */
    public int getVenId(){
        return this.venId;
    }

    /**
    * seta o valor de cliente
    * @param pCliente
    */
    public void setCliente(String pCliente){
        this.cliente = pCliente;
    }
        
    public void setClient(int cliente){
        this.client = cliente;
    }
    /**
    * @return fk_cliente
    */
    public String getCliente(){
        return this.cliente;
    }
    
    public int getClient(){
        return this.client;
    }

    /**
    * seta o valor de venDataVendas
    * @param pVenDataVendas
    */
    public void setVenDataVendas(Date pVenDataVendas){
        this.venDataVendas = pVenDataVendas;
    }
    /**
    * @return venDataVendas
    */
    public Date getVenDataVendas(){
        return this.venDataVendas;
    }

    /**
    * seta o valor de venValorLiq
    * @param pVenValorLiq
    */
    public void setVenValorLiq(double pVenValorLiq){
        this.venValorLiq = pVenValorLiq;
    }
    /**
    * @return venValorLiq
    */
    public double getVenValorLiq(){
        return this.venValorLiq;
    }

    /**
    * seta o valor de venValorBrut
    * @param pVenValorBrut
    */
    public void setVenValorBrut(double pVenValorBrut){
        this.venValorBrut = pVenValorBrut;
    }
    /**
    * @return venValorBrut
    */
    public double getVenValorBrut(){
        return this.venValorBrut;
    }

    /**
    * seta o valor de venValorDesc
    * @param pVenValorDesc
    */
    public void setVenValorDesc(double pVenValorDesc){
        this.venValorDesc = pVenValorDesc;
    }
    /**
    * @return venValorDesc
    */
    public double getVenValorDesc(){
        return this.venValorDesc;
    }

    @Override
    public String toString(){
        return "ModelVendas {" + "::venId = " + this.venId + "::cliente = " + this.cliente + "::venDataVendas = " + this.venDataVendas + "::venValorLiq = " + this.venValorLiq + "::venValorBruto = " + this.venValorBrut + "::venDesc = " + this.venValorDesc +  "}";
    }
}