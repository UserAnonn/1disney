package com.disney.service;
import com.disney.dto.PeliculaBasicDTO;
import com.disney.dto.PersonajeBasicDTO;
import com.disney.dto.PersonajeDTO;

import java.util.List;
import java.util.Set;

public interface IPersonajeService {

    PersonajeDTO getDetailsById(Long id);

    List<PersonajeBasicDTO> getAll();

    List<PersonajeDTO> getDetailsByFilters(String nombre, String edad, Set<Long> pelicula, String orden);

    PersonajeDTO save(PersonajeDTO personajeDTO);

    PersonajeDTO update(Long id, PersonajeDTO personaje);

    void addPelicula(Long id, Long idPelicula);

    void removePelicula(Long id, Long idPelicula);

    void delete(Long id);
}
