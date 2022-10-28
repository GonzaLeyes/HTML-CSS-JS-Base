/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.portfolioGLSP.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author gonza
 */
public class dtoExperiencia {
    
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
}
