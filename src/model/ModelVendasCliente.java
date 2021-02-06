/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class ModelVendasCliente {
    private ModelVendas modelVendas;
    private ModelCliente modelCliente;
    private ArrayList <ModelVendasCliente> listaVendasCliente;

    /**
     * @return the modelVendas
     */
    public ModelVendas getModelVendas() {
        return modelVendas;
    }

    /**
     * @param modelVendas the modelVendas to set
     */
    public void setModelVendas(ModelVendas modelVendas) {
        this.modelVendas = modelVendas;
    }

    /**
     * @return the modelCliente
     */
    public ModelCliente getModelCliente() {
        return modelCliente;
    }

    /**
     * @param modelCliente the modelCliente to set
     */
    public void setModelCliente(ModelCliente modelCliente) {
        this.modelCliente = modelCliente;
    }

    /**
     * @return the listaVendasCliente
     */
    public ArrayList <ModelVendasCliente> getListaVendasCliente() {
        return listaVendasCliente;
    }

    /**
     * @param listaVendasCliente the listaVendasCliente to set
     */
    public void setListaVendasCliente(ArrayList <ModelVendasCliente> listaVendasCliente) {
        this.listaVendasCliente = listaVendasCliente;
    }
    
}
