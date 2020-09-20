package com.cintia.catalogo.repository;

import com.cintia.catalogo.model.Musica;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  CatalogoRepository extends JpaRepository<Musica, Long> {
    
}