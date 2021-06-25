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
public class Empresa {
    private String razonSocial;
    private String email;
    private String telefono;
    private ArrayList<Producto> listaDeProductos = new ArrayList();
    private boolean habilitada;
    private String pais;
    private String husoHorario;

    public boolean isHabilitada() {
        return habilitada;
    }

    public void setHabilitada(boolean habilitada) {
        this.habilitada = habilitada;
    }

    public ArrayList<Producto> getListaDeProductos() {
        return listaDeProductos;
    }

    public Empresa(String razonSocial, String email,String pais, String husoHorario) {
        this.razonSocial = razonSocial;
        this.email = email;
        this.pais=pais;
        this.husoHorario=husoHorario;
    }

    public String getRazonSocial() {
        return razonSocial;
    }
    
    public void AgregarProducto(Producto producto){
        this.listaDeProductos.add(producto);
    }
    
    public String getHusoHorario(){
        return husoHorario;
    }
}
