package com.disney.mapper;

import com.disney.dto.GeneroDTO;
import com.disney.entity.GeneroEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeneroMapper {

    public GeneroEntity generoDTO2Entity(GeneroDTO dto)
    {
        GeneroEntity generoEntity = new GeneroEntity();
        generoEntity.setNombre(dto.getNombre());
        generoEntity.setImagen(dto.getImagen());
        return generoEntity;
    }

    public GeneroDTO generoEntity2DTO(GeneroEntity entity)
    {
        GeneroDTO dto = new GeneroDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setImagen(entity.getImagen());
        return dto;
    }

    public List<GeneroDTO> generoEntityList2DTO(List<GeneroEntity> entities)
    {
        List<GeneroDTO> dtos = new ArrayList<>();
        for (GeneroEntity entity:entities)
        {
            dtos.add(generoEntity2DTO(entity));
        }
        return dtos;
    }
}
