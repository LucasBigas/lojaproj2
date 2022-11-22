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

import br.univille.lojaproj.entity.ComissaoVenda;
import br.univille.lojaproj.service.ComissaoVendaService;

@Controller
@RequestMapping("/comissaovendas")
public class ComissaoVendaController {

    @Autowired
    private ComissaoVendaService service;

    @GetMapping
    public ModelAndView index(){
        var listaComissao = service.getAll();
        return new ModelAndView("comissao/index","listaComissao",listaComissao);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var comissao = new ComissaoVenda();
        return new ModelAndView("comissao/form","comissao",comissao);
    }

    @PostMapping(params = "form")
    public ModelAndView save(@Valid ComissaoVenda comissaoVenda, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ModelAndView("comissao/form","comissao",comissaoVenda);
        }
        
        service.save(comissaoVenda);
        return new ModelAndView("redirect:/comissaovendas");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var umaComissao = service.findById(id);
        return new ModelAndView("comissao/form","comissao",umaComissao);
    }
}
