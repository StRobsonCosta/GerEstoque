/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user
 */
public class ModelProdutos {
    private int prodId;
    private String prodNome;
    private double prodValor;
    private int prodEstoque;

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdNome() {
        return prodNome;
    }

    public void setProdNome(String prodNome) {
        this.prodNome = prodNome;
    }

    public double getProdValor() {
        return prodValor;
    }

    public void setProdValor(double prodValor) {
        this.prodValor = prodValor;
    }

    public int getProdEstoque() {
        return prodEstoque;
    }

    public void setProdEstoque(int prodEstoque) {
        this.prodEstoque = prodEstoque;
    }
    
    
    
}
