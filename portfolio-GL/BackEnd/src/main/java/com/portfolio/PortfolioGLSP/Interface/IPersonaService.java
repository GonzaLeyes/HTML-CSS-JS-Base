/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.PortfolioGLSP.Interface;

import com.portfolio.PortfolioGLSP.Entity.Persona;
import java.util.List;

/**
 *
 * @author gonza
 */
public interface IPersonaService {
    //Traer Lista de personas
    public List<Persona> getPersona();
    
    //Guardar un objeto Persona
    public void savePersona(Persona persona);
    
    //Eliminar una Persona por id
    public void delete(Long id);
    
    //Buscar una Persona por id
    public Persona findPersona(Long id);
    
}
