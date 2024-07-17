package com.foro.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foro.entity.Topico;

import jakarta.persistence.*;
import lombok.*;


@Repository
public interface RepositorioTopicos extends JpaRepository<Topico, Long> {



}
