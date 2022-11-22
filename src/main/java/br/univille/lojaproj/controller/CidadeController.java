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

import br.univille.lojaproj.entity.Cidade;
import br.univille.lojaproj.service.CidadeService;

@Controller
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService service;
    
    @GetMapping
    public ModelAndView index(){
        var listaCidades = service.getAll(); 
        return new ModelAndView("cidade/index","listaCidades",listaCidades);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var cidade = new Cidade();
        return new ModelAndView("cidade/form","cidade",cidade);
    }
    
    @PostMapping(params = "form")
    public ModelAndView save(@Valid Cidade cidade, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ModelAndView("cidade/form","cidade",cidade);
        }
        service.save(cidade);
        return new ModelAndView("redirect:/cidades");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id")long id){
        var cidade = service.findById(id);
        return new ModelAndView("cidade/form","cidade",cidade);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id")long id){
        service.deleteById(id);
        return new ModelAndView("redirect:/cidades");
    }
}
