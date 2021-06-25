/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.directorioempresas;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author juan
 */
public class Reunion {
    private Empresa empresaInteresada;
    private Empresa empresaObjetivo;
    private String enlace;
    private LocalDate  fechaHora;
    private String motivoReunion;
    
    public Reunion(Empresa empresaInteresada, Empresa empresaObjetivo, String enlace, LocalDate fechaHora, String motivoReunion) {
        this.empresaInteresada = empresaInteresada;
        this.empresaObjetivo = empresaObjetivo;
        this.enlace = enlace;
        this.fechaHora = fechaHora;
        this.motivoReunion = motivoReunion;
    }
}
