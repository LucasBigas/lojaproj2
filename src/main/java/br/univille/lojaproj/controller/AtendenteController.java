package br.univille.lojaproj.controller;

import java.util.HashMap;

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
import br.univille.lojaproj.service.CidadeService;

@Controller
@RequestMapping("/atendentes")
public class AtendenteController {

    @Autowired
    private AtendenteService service;

    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public ModelAndView index(){
        var listaAtendentes = service.getAll();
        return new ModelAndView("atendente/index","listaAtendentes",listaAtendentes);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var atendente = new Atendente();
        var listaCidades = cidadeService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("atendente", atendente);
        dados.put("listaCidades", listaCidades);
        return new ModelAndView("atendente/form",dados);
    }

    @PostMapping(params = "form")
    public ModelAndView save(@Valid Atendente atendente, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            var listaCidades = cidadeService.getAll();
            HashMap<String,Object> dados = new HashMap<>();
            dados.put("atendente", atendente);
            dados.put("listaCidades", listaCidades);
            return new ModelAndView("atendente/form",dados);
        }
        service.save(atendente);
        return new ModelAndView("redirect:/atendentes");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var atendente = service.findById(id);
        var listaCidades = cidadeService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("atendente", atendente);
        dados.put("listaCidades", listaCidades);
        return new ModelAndView("atendente/form",dados);
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id")long id){
        service.delete(id);
        return new ModelAndView("redirect:/atendentes");
    }
    
}
