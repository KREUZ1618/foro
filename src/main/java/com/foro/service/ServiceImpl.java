package com.foro.service;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.hibernate.exception.DataException;
import org.springframework.stereotype.Service;


import com.foro.dto.TopicoDto;
import com.foro.entity.Topico;
import com.foro.repository.RepositorioTopicos;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceImpl implements IService{

RepositorioTopicos repositorioTopicos;
	  @Override
	    public void createTopico(TopicoDto topicoDto) {
	      
		 Topico topico = new Topico();
		 
		 topico.setAutor(topicoDto.getAutor());
		 topico.setCurso(topicoDto.getCurso()); 
		 topico.setMensaje(topicoDto.getMensaje());
		 topico.setStatus(topicoDto.getStatus());
		 topico.setTitulo(topicoDto.getTitulo());
		 
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 
		 Date date;
		try {
			date = format.parse(topicoDto.getFechaCreacion());
			
			 java.sql.Date sQLDate= new  java.sql.Date(date.getTime());
			 
			
			 
			 
		     repositorioTopicos.save(topico);
		       
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	    }
	  
	  
	  @Override
	    public boolean deleteTopico(Long id) {
	        
		  repositorioTopicos.deleteById( id);
	       
	        return true;
	    }
	  
	  @Override
	    public Topico getById(Long id) {
	        
		
	       
	        return repositorioTopicos.getById(id);
	    }
	  
	  
	  
	  
	  
}
