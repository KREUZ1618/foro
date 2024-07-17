package com.foro.dto;


import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class TopicoDto {

   // @NotEmpty(message = "id no puede ser nulo o vacío")
    private String id;

    @NotEmpty(message = "no puede ser nulo o vacío")
    private String titulo;

    @NotEmpty(message = "no puede ser nulo o vacío")
    private String mensaje;
    
    @NotEmpty(message = "no puede ser nulo o vacío")
    private String fechaCreacion;
    
    @NotEmpty(message = "no puede ser nulo o vacío")
    private String status;
    
    @NotEmpty(message = "no puede ser nulo o vacío")
    private String autor;
    
    @NotEmpty(message = "no puede ser nulo o vacío")
    private String curso;
    
    
    

}