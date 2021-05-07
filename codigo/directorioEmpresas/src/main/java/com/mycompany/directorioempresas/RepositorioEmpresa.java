/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.directorioempresas;

import java.util.ArrayList;

/**
 *
 * @author juan
 */
public class RepositorioEmpresa {
    private static ArrayList<Empresa> listadoEmpresas = new ArrayList<Empresa>();
    
    public void AgregarEmpresa(Empresa nuevo){
        listadoEmpresas.add(nuevo);
    }
    
    public int CantidadEmpresas(){
        return listadoEmpresas.size();
    }
    
    public Empresa ObtenerEmpresa(String razonsocial){
        for (Empresa empresa : listadoEmpresas){
            if (empresa.getRazonSocial().equalsIgnoreCase(razonsocial)){
                return empresa;
            }
        }
        return null;
    }
          
}
