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
        
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        switch (opcion){
            case 1:
                RegistrarEmpresa();
            break;
            
            case 2:
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
}
