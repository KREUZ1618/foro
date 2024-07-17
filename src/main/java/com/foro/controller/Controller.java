package com.foro.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foro.constantes.Constantes;
import com.foro.dto.IdDto;
import com.foro.dto.ResponseDto;
import com.foro.dto.TopicoDto;
import com.foro.entity.Topico;
import com.foro.service.ServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class Controller {
		
	private ServiceImpl serviceI;
	
	
	  @GetMapping("/get")
	    public ResponseEntity<String> getAccount(@Validated @RequestBody IdDto idDto) throws Exception {
	    Topico	topico= serviceI.getById(Long.parseLong(idDto.getId()));
	    
	    TopicoDto topicoDto= new TopicoDto(); 
	    
	    topicoDto.setAutor(topico.getAutor());
	    
	    topicoDto.setTitulo(topico.getTitulo());
	    topicoDto.setMensaje(topico.getMensaje());
	    topicoDto.setCurso(topico.getCurso());
	   
	//    topicoDto.setFechaCreacion(String.parse(topico.getFechaCreacion()));
	    
	    
	   
	    ObjectMapper mapper = new ObjectMapper();
        String json;
		try {
			json = mapper.writeValueAsString(topicoDto);
			 return ResponseEntity
		                .status(HttpStatus.CREATED)
		                .body(json);
			
		} catch (JsonProcessingException ex) {
			ex.printStackTrace();
			throw new Exception("error al generar la respuesta");
			
		}
		
	       
	    }
	
	
	
	
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Validated @RequestBody TopicoDto topicoDto) {
    	serviceI.createTopico(topicoDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(Constantes.STATUS_201, Constantes.MESSAGE_201));
    }
	
	
	
	
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccountDetails( @Validated @RequestBody  IdDto id){  
      
    	
    	boolean isDeleted = serviceI.deleteTopico(Long.parseLong(id.getId()));
        
        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(Constantes.STATUS_200, Constantes.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(Constantes.STATUS_417, Constantes.MESSAGE_417_DELETE));
        }
    }
	
}


