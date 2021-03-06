/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.directorioempresas;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;
import java. text. SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java. util. Date;
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
        System.out.println("5 -  Consultar productos de rubro");
        System.out.println("6 -  Concertar reunión");
        
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
            
            case 5:    
                RegistrarEmpresa();
                CargarRubros();
                RegistrarProducto();
                ConsultarProductoRubro();
            break;
            
            case 6:
                RegistrarEmpresa();
                ConcertarReunion();
        }
    }
    
    public static void RegistrarEmpresa(){
        RepositorioEmpresa listadoempresas= new RepositorioEmpresa();
       
        System.out.println("Ingrese razón social");
        Scanner scanner = new Scanner(System.in);
        String razonsocial = scanner.nextLine();
        
        System.out.println("Ingrese email");
        String email = scanner.nextLine();
        
        System.out.println("Ingrese el país");
        String pais = scanner.nextLine();
        
        System.out.println("Ingrese el huso horario"); //se podría a partir del país obtener automáticamente le huso horario??
        String husoHorario = scanner.nextLine();
        
        Empresa empresa1 = new Empresa(razonsocial,email,pais,husoHorario);
        listadoempresas.AgregarEmpresa(empresa1);
        System.out.println("La empresa" + empresa1.getRazonSocial()+ " se creó correctamente");
        Empresa empresa2 = new Empresa("NaSA","nuevoddfssa@gmail.com","MX","America/Mexico_City");
        listadoempresas.AgregarEmpresa(empresa2);
        System.out.println("La empresa" + empresa2.getRazonSocial()+ " se creó correctamente");
        Empresa empresa3 = new Empresa("AsdfSA","adsfads@gmail.com","Ar","America/Argentina/Buenos_Aires");
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
        
        RepositorioRubro rubros = new RepositorioRubro();
        
        System.out.println("Indique el rubro al que desea incorporar el producto");
        String nombrerubroingresado = scanner.nextLine();
        Rubro rubroIngresado= rubros.ObtenerRubro(nombrerubroingresado);
        rubroIngresado.AgregarProducto(producto1);
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
    
    public static void ConsultarProductoRubro(){
        RepositorioRubro rubros = new RepositorioRubro();
        
        for (Rubro item : rubros.ObtenerRubros()){
            System.out.println(item.getNombre());
        }
        System.out.println("Elegir rubro:");
        
        Scanner scanner = new Scanner(System.in);
        String eleccion = scanner.nextLine();
        
        Rubro rubroelegido = rubros.ObtenerRubro(eleccion);
        if (rubroelegido==null){
            System.out.println("El rubro no existe");
        }
        else{
            System.out.println("Los productos del rubro ingresado son:");
            for (Producto item : rubroelegido.ObtenerProductos()){
                System.out.println(item.getNombre());
            }
                
        }
        
    }
    public static void CargarRubros(){
        RepositorioRubro rubros = new RepositorioRubro();
        
        Rubro rubro1 = new Rubro("Muebles");
        Rubro rubro2 = new Rubro("Maquinarias");
        Rubro rubro3 = new Rubro("Ferreteria");
        
        rubros.AgregarRubro(rubro1);
        rubros.AgregarRubro(rubro2);
        rubros.AgregarRubro(rubro3);        
    }
    
    public static void ConcertarReunion(){
        RepositorioEmpresa listadoempresas= new RepositorioEmpresa();
        
        ZonedDateTime fecha = ZonedDateTime.of(2021, 06, 25, 20, 05, 00, 00, ZoneId.of("UTC"));
       
        System.out.printf("Horario de Buenos Aires:\t\t %s\n", fecha);
        System.out.printf("Horario de Mexico:\t %s\n", fecha.withZoneSameInstant(ZoneId.of("America/Mexico_City")));
        
        
        System.out.println("Para registrar una reunión, primero ingrese razón social de la empresa interesada");
        Scanner scanner = new Scanner(System.in);
        String razonsocial = scanner.nextLine();
        Empresa empresaInteresada = listadoempresas.ObtenerEmpresa(razonsocial);
        
        if(empresaInteresada==null){
            System.out.println("La empresa no existe");
        }
        else{
            System.out.println("Ingrese razón social de la empresa objetivo");
            String razonsocial1 = scanner.nextLine();
            Empresa empresaObjetivo = listadoempresas.ObtenerEmpresa(razonsocial1);
            
            System.out.println("Ingrese el motivo de la reunión");
            String motivoReunion = scanner.nextLine();
            
            System.out.println("Ingrese el enlace de la reunión");
            String enlaceReunion = scanner.nextLine();
            
            System.out.println("Ingrese la fecha y horar de la reunión: ejemplo 07/07/2021 18:07:00");
            String horaReunion = scanner.nextLine();
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime fechaHoraReunion = LocalDateTime.parse(horaReunion, dateFormat);
            ZonedDateTime fechaHoraInteresado = ZonedDateTime.of(fechaHoraReunion, ZoneId.of(empresaInteresada.getHusoHorario()));//la empresa interesada propone el horario de la reunión, por eso se toma en dicho huso horario
            System.out.println("Horario de la reunión convertido a huso horario de la empres interesada: "+fechaHoraInteresado.toString());
            ZonedDateTime fechaUTC = fechaHoraInteresado.withZoneSameInstant(ZoneId.of("UTC"));//convierto la fecha de la reunión a UTC para luego guardar
            System.out.println("Horario de la reunión convertido a UTC: "+fechaUTC.toString());
            Reunion reunion1= new Reunion(empresaInteresada,empresaObjetivo,enlaceReunion,fechaUTC.toLocalDate(),motivoReunion);
        }
        }
    }
}
