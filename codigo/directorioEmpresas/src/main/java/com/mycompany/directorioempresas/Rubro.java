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
public class Rubro {
    private String nombre;
    private ArrayList<Producto> productos = new ArrayList<Producto>();

    public ArrayList<Producto> ObtenerProductos() {
        return productos;
    }
    
    public Rubro(String nombre) {
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void AgregarProducto(Producto producto){
        productos.add(producto);
    }
    
   
}
