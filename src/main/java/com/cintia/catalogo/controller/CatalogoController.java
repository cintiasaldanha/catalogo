package com.cintia.catalogo.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import com.cintia.catalogo.model.Musica;
import com.cintia.catalogo.service.CatalogoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class CatalogoController {

    @Autowired
    CatalogoService catalogoService;

    @RequestMapping(value = "/musicas", method = RequestMethod.GET)
    public ModelAndView getMusicas() {
        ModelAndView mv = new ModelAndView("musicas");

        List<Musica> musicas = catalogoService.findAll();
        mv.addObject("musicas", musicas);
        return mv;
    }

    @RequestMapping(value = "/musicas/{id}", method = RequestMethod.GET)
    public ModelAndView getMusicaDetalhes(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("musicaDetalhes");
        Musica musica = catalogoService.findById(id);
        mv.addObject("musica", musica);
        return mv;
    }

    @RequestMapping(value = "/addMusica", method = RequestMethod.POST)
    public String salvarMusica(@Valid Musica musica, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
        attributes.addFlashAttribute("mensagem", "Campos obrigatórios não preenchidos!!!");
        return "redirect:/addMusica";
        }
        musica.setData(LocalDate.now());
        catalogoService.save(musica);
        return "redirect:/addMusica";
    }

    @RequestMapping(value = "/addMusica", method = RequestMethod.GET)
    public String getMusicaForm() {
        return "musicaForm";
    }

    //Cintia
    @RequestMapping(value = "/excluirmusica/{id}", method=RequestMethod.GET)
    public String excluirMusica(@PathVariable("id") Long id) {
        
        //Exclui música selecionada
        catalogoService.excluir(id);
        
         //Redireciona para lista de músicas 
         return "redirect:/musicas";
    }

   //Cintia
    @RequestMapping(value = "/editarMusica/{id}", method = RequestMethod.POST)
    public String editarMusica(@Valid Musica musica, BindingResult result, RedirectAttributes attributes,@PathVariable("id") long id) {
    //@RequestMapping(value = "/editarMusica",  method = RequestMethod.POST)
    //public String editarMusica(@Valid Musica musica, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Campos obrigatórios não preenchidos!!!");
            return "redirect:/addMusica";
        }
        musica.setData(LocalDate.now());
        musica.setId(id);
        catalogoService.save(musica);
        return "redirect:/musicas";
    }

        //Cintia
        @RequestMapping(value = "/editarmusica/{id}", method = RequestMethod.GET)
        public ModelAndView getMusicaDetalhesParaEdicao(@PathVariable("id") long id) {
            ModelAndView mv = new ModelAndView("musicaEdicaoForm");
            Musica musica = catalogoService.findById(id);
            mv.addObject("musica", musica);
            return mv;
        }

}
