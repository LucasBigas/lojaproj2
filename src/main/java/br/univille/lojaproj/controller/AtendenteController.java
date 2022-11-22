package br.univille.lojaproj.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.lojaproj.entity.Atendente;
import br.univille.lojaproj.service.AtendenteService;

@Controller
@RequestMapping("/atendentes")
public class AtendenteController {

    @Autowired
    private AtendenteService service;

    @GetMapping
    public ModelAndView index(){
        var listaAtendentes = service.getAll();
        return new ModelAndView("atendente/index","listaAtendentes",listaAtendentes);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var atendente = new Atendente();
        return new ModelAndView("atendente/form","atendente",atendente);
    }

    @PostMapping(params = "form")
    public ModelAndView save(@Valid Atendente atendente, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ModelAndView("atendente/form","atendente",atendente);
        }
        service.save(atendente);
        return new ModelAndView("redirect:/atendentes");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var atendente = service.findById(id);
        return new ModelAndView("atendente/form","atendente",atendente);
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id")long id){
        service.delete(id);
        return new ModelAndView("redirect:/atendentes");
    }
    
}
