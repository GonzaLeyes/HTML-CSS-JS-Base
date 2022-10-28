/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.portfolioGLSP.Controller;

import com.portfolio.portfolioGLSP.Dto.dtoSkills;
import com.portfolio.portfolioGLSP.Entity.Skills;
import com.portfolio.portfolioGLSP.Security.Controller.Mensaje;
import com.portfolio.portfolioGLSP.Service.SSkills;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gonza
 */
@RestController
@RequestMapping("/skill")
@CrossOrigin(origins = "http://localhost:4200")

public class CSkills {
    
    @Autowired SSkills sSkills;

    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list() {
        List<Skills> list = sSkills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id) {
        if (!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        Skills skills = sSkills.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        sSkills.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskill) {
        if (StringUtils.isBlank(dtoskill.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sSkills.existsByNombre(dtoskill.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        Skills skills = new Skills(dtoskill.getNombre(), dtoskill.getPorcentaje());
        sSkills.save(skills);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskill) {
        //Validamos si existe el ID
        if (!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de skills
        if (sSkills.existsByNombre(dtoskill.getNombre()) && sSkills.getByNombre(dtoskill.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoskill.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        

        Skills skills = sSkills.getOne(id).get();
        skills.setNombre(dtoskill.getNombre());
        skills.setPorcentaje(dtoskill.getPorcentaje());

        sSkills.save(skills);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }
    
}
