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
public class RepositorioRubro {
    public static ArrayList<Rubro> listadoRubros = new ArrayList<Rubro>();

    public  ArrayList<Rubro> ObtenerRubros() {
        return listadoRubros;
    }
    
    public void AgregarRubro(Rubro nuevo){
        listadoRubros.add(nuevo);
    }
    
    public Rubro ObtenerRubro(String nombre){
        for (Rubro rubro : listadoRubros){
            if (rubro.getNombre().equalsIgnoreCase(nombre)){
                return rubro;
            }
        }
        return null;
    }
      
}
