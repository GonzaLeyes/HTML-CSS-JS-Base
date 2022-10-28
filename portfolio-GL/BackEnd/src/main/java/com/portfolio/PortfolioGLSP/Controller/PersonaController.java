package com.portfolio.portfolioGLSP.Controller;

import com.portfolio.portfolioGLSP.Dto.dtoPersona;
import com.portfolio.portfolioGLSP.Entity.Persona;
import com.portfolio.portfolioGLSP.Security.Controller.Mensaje;
import com.portfolio.portfolioGLSP.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    ImpPersonaService ipersonaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = ipersonaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!ipersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = ipersonaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
/*
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!ipersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        ipersonaService.delete(id);
        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
    }
*/
 /*
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona) {
        if (StringUtils.isBlank(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (ipersonaService.existsByNombre(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = new Persona(
                dtopersona.getNombre(),dtopersona.getApellido(), dtopersona.getImg(), dtopersona.getDescripcion()
        );
        ipersonaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona creada"), HttpStatus.OK);

    }
*/

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona) {
        if (!ipersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (ipersonaService.existsByNombre(dtopersona.getNombre()) && ipersonaService.getByNombre(dtopersona.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = ipersonaService.getOne(id).get();

        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setDescripcion(dtopersona.getDescripcion());
        persona.setImg(dtopersona.getImg());
        

        ipersonaService.save(persona);

        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
/*
    @GetMapping("/personas/traer")
    public List<Persona> getPersona() {
        return ipersonaService.getPersona();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("img") String nuevoImg) {
        Persona persona = ipersonaService.findPersona(id);

        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);

        ipersonaService.savePersona(persona);
        return persona;
    }

    @GetMapping("/personas/traer/perfil")
    public Persona findPersona() {
        return ipersonaService.findPersona((long) 1);
    }
*/
}
