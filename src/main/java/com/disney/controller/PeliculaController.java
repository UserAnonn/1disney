package com.disney.controller;

import com.disney.dto.PeliculaBasicDTO;
import com.disney.dto.PeliculaDTO;
import com.disney.dto.PersonajeBasicDTO;
import com.disney.dto.PersonajeDTO;
import com.disney.service.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private IPeliculaService iPeliculaService;

    @GetMapping("/all")
    public ResponseEntity<List<PeliculaBasicDTO>> getAll()
    {
        List<PeliculaBasicDTO> peliculas = this.iPeliculaService.getAll();
        return ResponseEntity.ok(peliculas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeliculaDTO> getDetailsById(@PathVariable Long id)
    {
        PeliculaDTO pelicula = this.iPeliculaService.getDetailsById(id);
        return ResponseEntity.ok(pelicula);
    }

    @GetMapping
    public ResponseEntity<List<PeliculaDTO>> getDetailsByFilters(
            @RequestParam(required = false) String imagen,
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) LocalDate fechaCreacion,
            @RequestParam(required = false) Set<Long> personaje,
            @RequestParam(required = false, defaultValue = "ASC") String orden
    ){
        List<PeliculaDTO> peliculas = this.iPeliculaService.getByFilters(imagen, titulo, fechaCreacion, personaje, orden);
        return ResponseEntity.ok(peliculas);
    }

    @PostMapping
    public ResponseEntity<PeliculaDTO> save(@RequestBody PeliculaDTO pelicula)
    {
        PeliculaDTO result = this.iPeliculaService.save(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculaDTO> update(@PathVariable Long id, @RequestBody PeliculaDTO pelicula)
    {
        PeliculaDTO result = this.iPeliculaService.update(id, pelicula);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PeliculaDTO> delete(@PathVariable Long id)
    {
        this.iPeliculaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{id}/personaje/{idPersonaje")
    public ResponseEntity<Void> addPersonaje(@PathVariable Long id, @PathVariable Long idPersonaje)
    {
        this.iPeliculaService.addPersonaje(id, idPersonaje);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}/personaje/idPersonaje")
    public ResponseEntity<Void> removePersonaje(@PathVariable Long id, @PathVariable Long idPersonaje)
    {
        this.iPeliculaService.removePersonaje(id, idPersonaje);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
