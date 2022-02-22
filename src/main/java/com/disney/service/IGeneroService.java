package com.disney.service;

import com.disney.dto.GeneroDTO;
import net.bytebuddy.agent.builder.AgentBuilder;

import java.util.List;

public interface IGeneroService {

    GeneroDTO save(GeneroDTO dto);

    List<GeneroDTO> getAllGeneros();
}
