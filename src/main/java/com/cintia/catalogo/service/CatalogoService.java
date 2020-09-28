package com.cintia.catalogo.service;

import java.util.List;
import com.cintia.catalogo.model.Musica;

public interface CatalogoService {
    List<Musica> findAll();
    Musica findById(long id);
    Musica save(Musica musica);
    void excluir(long id); 
    Musica saveById(Musica musica);   
}