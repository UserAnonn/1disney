package com.disney.service;
import com.disney.dto.PeliculaBasicDTO;
import com.disney.dto.PeliculaDTO;
import com.disney.dto.PersonajeBasicDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IPeliculaService {

    PeliculaDTO getDetailsById(Long id);

    List<PeliculaBasicDTO> getAll();

    List<PeliculaDTO> getByFilters(String imagen, String titulo, LocalDate fechaCreacion, Set<Long> personaje, String orden);

    PeliculaDTO save(PeliculaDTO peliculaDTO);

    PeliculaDTO update(Long id, PeliculaDTO pelicula);

    void addPersonaje(Long id, Long idPersonaje);

    void removePersonaje(Long id, Long idPersonaje);

    void delete(Long id);
}
