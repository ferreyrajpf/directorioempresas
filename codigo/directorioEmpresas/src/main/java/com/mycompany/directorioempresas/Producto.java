/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.directorioempresas;

import java.math.BigDecimal;

/**
 *
 * @author juan
 */
public class Producto {

    public Producto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    private String nombre;
    private String descripcion;
    private BigDecimal precio = new BigDecimal(0.0);
}
