package com.disney.service.impl;

import com.disney.dto.PeliculaBasicDTO;
import com.disney.dto.PersonajeBasicDTO;
import com.disney.dto.PersonajeDTO;
import com.disney.service.IPersonajeService;
import com.disney.repository.IPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

    @Autowired
    private IPersonajeRepository iPersonajeRepository;

    public PersonajeDTO getDetailsById(Long id) {
        return null;
    }

    public List<PersonajeBasicDTO> getAll() {
        return null;
    }

    public List<PersonajeDTO> getDetailsByFilters(String nombre, String edad, Set<Long> pelicula, String orden) {
        return null;
    }

    public PersonajeDTO save(PersonajeDTO personajeDTO) {
        return null;
    }

    public PersonajeDTO update(Long id, PersonajeDTO personaje) {
        return null;
    }

    public void addPelicula(Long id, Long idPelicula) {

    }

    public void removePelicula(Long id, Long idPelicula) {

    }

    public void delete(Long id) {
        this.iPersonajeRepository.deleteById(id);
    }
}
