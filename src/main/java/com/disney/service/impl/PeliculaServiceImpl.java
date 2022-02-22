package com.disney.service.impl;

import com.disney.dto.PeliculaBasicDTO;
import com.disney.dto.PeliculaDTO;
import com.disney.dto.PersonajeBasicDTO;
import com.disney.mapper.GeneroMapper;
import com.disney.mapper.PeliculaMapper;
import com.disney.repository.IGeneroRepository;
import com.disney.repository.IPeliculaRepository;
import com.disney.service.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class PeliculaServiceImpl implements IPeliculaService {

    @Autowired
    private PeliculaMapper peliculaMapper ;
    @Autowired
    private IPeliculaRepository iPeliculaRepository ;

    public PeliculaDTO getDetailsById(Long id) {
        return null;
    }

    public List<PeliculaBasicDTO> getAll() {
        return null;
    }


    public List<PeliculaDTO> getByFilters(String imagen, String titulo, LocalDate fechaCreacion, Set<Long> personaje, String orden) {
        return null;
    }


    public PeliculaDTO save(PeliculaDTO peliculaDTO) {
        return null;
    }


    public PeliculaDTO update(Long id, PeliculaDTO pelicula) {
        return null;
    }


    public void addPersonaje(Long id, Long idPersonaje) {

    }


    public void removePersonaje(Long id, Long idPersonaje) {

    }


    public void delete(Long id) {

    }
}
