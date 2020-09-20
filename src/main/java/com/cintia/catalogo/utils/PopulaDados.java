package com.cintia.catalogo.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//import javax.annotation.PostConstruct;

import com.cintia.catalogo.model.Musica;
import com.cintia.catalogo.repository.CatalogoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PopulaDados {
    
    @Autowired
    CatalogoRepository catalogoRepository;

    //@PostConstruct   
    //Comentado para que o cadastro dos registros não seja executado mais de uma vez
    public void cadastrarMusica(){

    List<Musica> listaMusica = new ArrayList<>();

        Musica musica1 = new Musica();
        Musica musica2 = new Musica();
        
        musica1.setAutor("Renato Russo"); 
        musica1.setData(LocalDate.now());
        musica1.setTitulo("Serenissima");
        musica1.setLetra("Sou um animal sentimental Me apego facil mente a quem desperta meu desejo Tente me obrigar a fazer o que eu não quero E cê vai logo ver o que acontece Acho que entendo você quis me dizer Mas existem outras coisas Consegui meu equilí­brio cortejando a insanidade Tudo está perdido mas existem possibilidades Tí­nhamos a ideia, você mudou os planos Tí­nhamos um plano, você mudou de ideia Já passou, já passou - quem sabe outro dia Antes eu sonhava, agora já não durmo Quando foi que competimos pela primeira vez O que ninguém percebe é o que todo mundo sabe Não entendo terrorismo, falávamos de amizade Não estou mais interessado no que sinto.");

        musica2.setAutor("Robert Plant"); 
        musica2.setData(LocalDate.now());
        musica2.setTitulo("All My Love");
        musica2.setLetra("Should I fall out of love, my fire in the light To chase a feather in the wind  Within the glow that weaves a cloak of delight There moves a thread that has no end For many hours and days that pass ever soon The tides have caused the flame to dim At last the arm is straight, the hand to the loom Is this to end or just begin? All of my love, all of my love All of my love to you, oh All of my love, all of my love, oh All of my love to you. I get a little bit lonely");

        listaMusica.add(musica1);
        listaMusica.add(musica2);

        for (Musica musica : listaMusica) {
            Musica salvarMusica = catalogoRepository.save(musica);
            System.out.println(salvarMusica.getId());
        }

    }

}
