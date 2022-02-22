package com.disney.mapper;

import com.disney.dto.GeneroDTO;
import com.disney.dto.PeliculaDTO;
import com.disney.dto.PersonajeDTO;
import com.disney.entity.GeneroEntity;
import com.disney.entity.PeliculaEntity;
import com.disney.entity.PersonajeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class PeliculaMapper {

    @Lazy
    @Autowired
    private PersonajeMapper personajeMapper;
    @Lazy
    @Autowired
    private GeneroMapper generoMapper;

    public PeliculaEntity peliculaDTO2Entity(PeliculaDTO dto)
    {
        PeliculaEntity peliculaEntity = new PeliculaEntity();

        peliculaEntity.setImagen(dto.getImagen());
        peliculaEntity.setTitulo(dto.getTitulo());
        peliculaEntity.setFechaCreacion(LocalDate.parse(dto.getFechaCreacion().toString()));
        peliculaEntity.setCalificacion(dto.getCalificacion());

        return peliculaEntity;
    }

    public PeliculaDTO peliculaEntity2DTO(PeliculaEntity entity, boolean loadPersonajes)
    {
        PeliculaDTO peliculaDTO = new PeliculaDTO();

        peliculaDTO.setImagen(entity.getImagen());
        peliculaDTO.setFechaCreacion(LocalDate.parse(entity.getFechaCreacion().toString()));
        peliculaDTO.setCalificacion(entity.getCalificacion());

        if (loadPersonajes)
        {
            List<PersonajeDTO> dtos = this.personajeMapper.personajeEntityList2DTOList((List<PersonajeEntity>) entity.getPersonajes(), false);
            peliculaDTO.setPersonajes((Set<PersonajeDTO>) dtos);
        }
        return peliculaDTO;
    }

    public List<PeliculaDTO> peliculaEntityList2DTOList(List<PeliculaEntity> entities, boolean loadPersonajes) {
        List<PeliculaDTO> dtos = new ArrayList<>();
        for (PeliculaEntity entity : entities) {
            dtos.add(this.peliculaEntity2DTO((PeliculaEntity) entity.getPersonajes(), false));
        }
        return dtos;
    }
}
