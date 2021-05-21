/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.directorioempresas;

import java.util.Scanner;

/**
 *
 * @author juan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Ingrese una opción");
        System.out.println("1 -  Registrar empresa");
        System.out.println("2 -  Registrar producto");
        System.out.println("3 -  Consultar producto de empresa");
        System.out.println("4 -  Dar de baja una empresa");
        
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        switch (opcion){
            case 1:
                RegistrarEmpresa();
            break;
                
            case 2:
                RegistrarEmpresa();
                RegistrarProducto();
            break;
                  
            case 3:
                RegistrarEmpresa();
                RegistrarProducto();
                RegistrarBajaEmpresa();
                ConsultarProductosEmpresa();
            case 4:
                RegistrarEmpresa();
                RegistrarBajaEmpresa();
            break;
        }
    }
    
    public static void RegistrarEmpresa(){
        RepositorioEmpresa listadoempresas= new RepositorioEmpresa();
       
        System.out.println("Ingrese razón social");
        Scanner scanner = new Scanner(System.in);
        String razonsocial = scanner.nextLine();
        
        System.out.println("Ingrese email");
        String email = scanner.nextLine();
        
        Empresa empresa1 = new Empresa(razonsocial,email);
        listadoempresas.AgregarEmpresa(empresa1);
        System.out.println("La empresa" + empresa1.getRazonSocial()+ " se creó correctamente");
        Empresa empresa2 = new Empresa("Nasdadsf","nuevoddfssa@gmail.com");
        listadoempresas.AgregarEmpresa(empresa2);
        System.out.println("La empresa" + empresa2.getRazonSocial()+ " se creó correctamente");
        Empresa empresa3 = new Empresa("asdf","adsfads@gmail.com");
        listadoempresas.AgregarEmpresa(empresa3);
        System.out.println("La empresa" + empresa3.getRazonSocial()+ " se creó correctamente");
        
        System.out.println("Total de empresas creadas:" + listadoempresas.CantidadEmpresas() );
    }
    
    public static void RegistrarProducto(){
        RepositorioEmpresa listadoempresas= new RepositorioEmpresa();
        
        System.out.println("Para registrar producto, primero ingrese razón social de la empresa");
        Scanner scanner = new Scanner(System.in);
        String razonsocial = scanner.nextLine();
        Empresa empresa = listadoempresas.ObtenerEmpresa(razonsocial);
        
        if(empresa==null){
            System.out.println("La empresa no existe");
        }
        else{
            boolean seguirAgregando=true;
            while (seguirAgregando){
                AgregarProducto(empresa);
                System.out.println("Seguir agregando?: S / N");
                String respuesta = scanner.nextLine();
                if (respuesta.compareToIgnoreCase("S")==0){
                    seguirAgregando=true;
                }
                else{
                    seguirAgregando=false;
                }
            }
        }
    }
       
    public static void AgregarProducto(Empresa empresa){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto");
        String productoNombre = scanner.nextLine();
        System.out.println("Ingrese la descripción del producto");
        String productoDescripcion = scanner.nextLine();

        Producto producto1 = new Producto(productoNombre,productoDescripcion);

        empresa.AgregarProducto(producto1);
        System.out.println("El producto se registró correctamente");
    }
    
    
    public static void ConsultarProductosEmpresa(){
        RepositorioEmpresa listadoempresas= new RepositorioEmpresa();
        System.out.println("Para consultar los producto, primero ingrese razón social de la empresa");
        Scanner scanner = new Scanner(System.in);
        String razonsocial = scanner.nextLine();
        Empresa empresa = listadoempresas.ObtenerEmpresa(razonsocial);
        
        if(empresa==null){
            System.out.println("La empresa no existe");
        }
        else{
            for (Producto productosEmpresa : empresa.getListaDeProductos()){
                System.out.println(productosEmpresa.getNombre());
            }
        }
    }
    
    public static void RegistrarBajaEmpresa(){
        RepositorioEmpresa listadoempresas= new RepositorioEmpresa();
        System.out.println("Para dar de baja una empresa ingrese razón social");
        Scanner scanner = new Scanner(System.in);
        String razonsocial = scanner.nextLine();
        Empresa empresa = listadoempresas.ObtenerEmpresa(razonsocial);
        
        if (empresa==null){
            System.out.println("La empresa no existe");
        }
        else{
            empresa.setHabilitada(false);
            System.out.println("Estado de la empresa"+ empresa.isHabilitada());
            }
        
    }
            
}
