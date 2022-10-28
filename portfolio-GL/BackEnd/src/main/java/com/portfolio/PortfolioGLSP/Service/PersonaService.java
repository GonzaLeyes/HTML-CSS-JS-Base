/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.PortfolioGLSP.Service;

import com.portfolio.PortfolioGLSP.Entity.Persona;
import com.portfolio.PortfolioGLSP.Interface.IPersonaService;
import com.portfolio.PortfolioGLSP.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gonza
 */
@Service
public class PersonaService implements IPersonaService {
    //Inyeccion de dependencia
    @Autowired IPersonaRepository ipersonaRepository;
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> personas = ipersonaRepository.findAll();
        return personas;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    @Override
    public void delete(Long id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }
    
}
