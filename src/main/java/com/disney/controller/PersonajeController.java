package com.disney.controller;

import com.disney.dto.PersonajeBasicDTO;
import com.disney.dto.PersonajeDTO;
import com.disney.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("personajes")
public class PersonajeController {

    @Autowired
    private IPersonajeService iPersonajeService;

    @GetMapping("/all")
    public ResponseEntity<List<PersonajeBasicDTO>> getAll()
    {
        List<PersonajeBasicDTO> personajes = this.iPersonajeService.getAll();
        return ResponseEntity.ok(personajes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonajeDTO> getDetailsById(@PathVariable Long id)
    {
        PersonajeDTO personaje = this.iPersonajeService.getDetailsById(id);
        return ResponseEntity.ok(personaje);
    }

    @GetMapping
    public ResponseEntity<List<PersonajeDTO>> getDetailsByFilters(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String edad,
            @RequestParam(required = false) Set<Long> pelicula,
            @RequestParam(required = false, defaultValue = "ASC") String orden
    ){
        List<PersonajeDTO> personajes = this.iPersonajeService.getDetailsByFilters(nombre, edad, pelicula, orden);
        return ResponseEntity.ok(personajes);
    }

    @PostMapping
    public ResponseEntity<PersonajeDTO> save(@RequestBody PersonajeDTO personaje)
    {
        PersonajeDTO result = this.iPersonajeService.save(personaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonajeDTO> update(@PathVariable Long id, @RequestBody PersonajeDTO personaje)
    {
        PersonajeDTO result = this.iPersonajeService.update(id, personaje);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonajeDTO> delete(@PathVariable Long id)
    {
        this.iPersonajeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{id}/pelicula/{idPelicula")
    public ResponseEntity<Void> addPelicula(@PathVariable Long id, @PathVariable Long idPelicula)
    {
        this.iPersonajeService.addPelicula(id, idPelicula);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}/pelicula/idPelicula")
    public ResponseEntity<Void> removePelicula(@PathVariable Long id, @PathVariable Long idPelicula)
    {
        this.iPersonajeService.removePelicula(id, idPelicula);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
