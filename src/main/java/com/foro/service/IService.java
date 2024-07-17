package com.foro.service;

import com.foro.dto.TopicoDto;
import com.foro.entity.Topico;

public interface IService {
	
    void createTopico(TopicoDto topicoDto);

	boolean deleteTopico(Long id);


	Topico getById(Long id);


}
