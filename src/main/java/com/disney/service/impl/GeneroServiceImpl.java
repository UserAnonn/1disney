package com.disney.service.impl;

import com.disney.dto.GeneroDTO;
import com.disney.entity.GeneroEntity;
import com.disney.mapper.GeneroMapper;
import com.disney.repository.IGeneroRepository;
import com.disney.service.IGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroServiceImpl implements IGeneroService {

    @Autowired
    private GeneroMapper generoMapper;
    @Autowired
    private IGeneroRepository iGeneroRepository;
    public GeneroDTO save(GeneroDTO dto)
    {
        GeneroEntity entity = generoMapper.generoDTO2Entity(dto);
        GeneroEntity entitySaved = iGeneroRepository.save(entity);
        GeneroDTO result = generoMapper.generoEntity2DTO(entitySaved);
        return result;
    }

    public List<GeneroDTO> getAllGeneros() {
        List<GeneroEntity> entities = iGeneroRepository.findAll();
        List<GeneroDTO> result = generoMapper.generoEntityList2DTO(entities);
        return result;
    }
}
