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

    public ArrayList<Producto> getListaDeProductos() {
        return listaDeProductos;
    }

    public Empresa(String razonSocial, String email) {
        this.razonSocial = razonSocial;
        this.email = email;
    }

    public String getRazonSocial() {
        return razonSocial;
    }
    
    public void AgregarProducto(Producto producto){
        this.listaDeProductos.add(producto);
    }
}
