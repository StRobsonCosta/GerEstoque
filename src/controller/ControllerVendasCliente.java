/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOVendasCliente;
import java.util.ArrayList;
import model.ModelVendasCliente;

/**
 *
 * @author user
 */
public class ControllerVendasCliente {
    
    private DAOVendasCliente dAOVendasCliente = new DAOVendasCliente();

    public ArrayList<ModelVendasCliente> getListaVendaCliente() {
        return this.dAOVendasCliente.getListaVendasClienteDAO();
        
    }
    
}
