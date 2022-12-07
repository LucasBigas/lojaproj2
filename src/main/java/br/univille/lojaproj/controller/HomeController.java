package br.univille.lojaproj.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.lojaproj.entity.Cliente;
import br.univille.lojaproj.service.CidadeService;
import br.univille.lojaproj.service.ClienteService;

@Controller
@RequestMapping("/home")
public class HomeController {
    
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public ModelAndView index(){
        return new ModelAndView("home/index");
    }

    @GetMapping("/produto")
    public ModelAndView prod(){
        return new ModelAndView("home/produto");
    }
    
    @GetMapping("/cadastro")
    public ModelAndView cadastro(){
        var listaClientes = clienteService.getAll();
        var listaCidades = cidadeService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("listaClientes", listaClientes);
        dados.put("cliente", new Cliente());
        dados.put("listaCidades", listaCidades);
        return new ModelAndView("home/form",dados);
    }

    @PostMapping(params = "form")
    public ModelAndView save(Cliente cliente){
        clienteService.save(cliente);
        return new ModelAndView("home/index");
    }
}
