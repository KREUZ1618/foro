package com.foro.entity;
import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "topicos")
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Topico  {
    
	
	@Id
    @Column(name="ID_TOPICO")
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="TITULO")
    private String titulo;

    @Column(name="MENSAJE")
    private String mensaje;

    @Column(name="FECHA_CREACION")
    private Date fechaCreacion;
    
    @Column(name="STATUS") 
    private String status;
    
    @Column(name="AUTOR")
    private String autor;
    
    @Column(name="CURSO")
    private String curso;
    

}
