package com.disney.mapper;

import com.disney.dto.PeliculaDTO;
import com.disney.dto.PersonajeDTO;
import com.disney.entity.PersonajeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonajeMapper {

    @Autowired
    private PeliculaMapper peliculaMapper;

    public PersonajeEntity personajeDTO2Entity(PersonajeDTO dto)
    {
        PersonajeEntity personajeEntity = new PersonajeEntity();

        personajeEntity.setImagen(dto.getImagen());
        personajeEntity.setNombre(dto.getNombre());
        personajeEntity.setEdad(dto.getEdad());
        personajeEntity.setPeso(dto.getPeso());
        personajeEntity.setHistoria(dto.getHistoria());

        return personajeEntity;
    }

    public PersonajeDTO personajeEntity2DTO(PersonajeEntity entity, boolean loadPeliculas)
    {
        PersonajeDTO personajeDTO = new PersonajeDTO();

        personajeDTO.setImagen(entity.getImagen());
        personajeDTO.setNombre(entity.getNombre());
        personajeDTO.setEdad(entity.getEdad());
        personajeDTO.setPeso(entity.getPeso());
        personajeDTO.setHistoria(entity.getHistoria());

        if (loadPeliculas)
        {
            List<PeliculaDTO> peliculaDTOS = this.peliculaMapper.peliculaEntityList2DTOList(entity.getPeliculas(), false);
        }

        return personajeDTO;
    }

    public List<PersonajeDTO> personajeEntityList2DTOList(List<PersonajeEntity> entities, boolean loadPeliculas) {
        List<PersonajeDTO> dtos = new ArrayList<>();
        for (PersonajeEntity entity : entities) {
            dtos.add(this.personajeEntity2DTO(entity, loadPeliculas));
        }
        return dtos;
    }

}
