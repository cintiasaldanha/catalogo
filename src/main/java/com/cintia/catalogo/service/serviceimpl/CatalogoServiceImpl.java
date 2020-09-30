package com.cintia.catalogo.service.serviceimpl;

import java.util.List;

import com.cintia.catalogo.model.Musica;
import com.cintia.catalogo.repository.CatalogoRepository;
import com.cintia.catalogo.service.CatalogoService;

import org.hibernate.loader.plan.build.internal.CascadeStyleLoadPlanBuildingAssociationVisitationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogoServiceImpl implements CatalogoService {

    @Autowired 
    CatalogoRepository catalogoRepository;

    @Override
    public  List<Musica> findAll() {
        return catalogoRepository.findAll();
    }

    @Override
    public Musica findById(long id) {
        return catalogoRepository.findById(id).get();
    }

    @Override
    public Musica save(Musica musica) {
        return catalogoRepository.save(musica);
    }

    @Override
    public void excluir(long id) {
        catalogoRepository.deleteById(id);
    }
    
}