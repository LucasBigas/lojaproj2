package br.univille.lojaproj.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.lojaproj.entity.ItemVenda;
import br.univille.lojaproj.entity.Pagamento;
import br.univille.lojaproj.entity.Venda;
import br.univille.lojaproj.service.AtendenteService;
import br.univille.lojaproj.service.ClienteService;
import br.univille.lojaproj.service.ProdutoService;
import br.univille.lojaproj.service.VendaService;

@Controller
@RequestMapping("/vendas")
public class VendaController {
    
    @Autowired
    private VendaService service;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private AtendenteService atendenteService;

    @Autowired
    private ProdutoService produtoService;

  

    @GetMapping
    public ModelAndView index(){
        var listaVendas = service.getAll();
        return new ModelAndView("venda/index","listaVendas",listaVendas);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var venda = new Venda();
        var listaClientes = clienteService.getAll();
        var listaAtendentes = atendenteService.getAll();
        var listaProdutos = produtoService.getAll();
        HashMap<String,Object> dados =new HashMap<>();
        dados.put("venda", venda);
        dados.put("listaClientes", listaClientes);
        dados.put("listaAtendentes", listaAtendentes);
        dados.put("listaProdutos", listaProdutos);
        dados.put("novoItem", new ItemVenda());
        dados.put("novoPagamento", new Pagamento());
        return new ModelAndView("venda/form",dados);
    }

    @PostMapping(params = "save")
    public ModelAndView save(@Valid Venda venda, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            var listaAtendentes = atendenteService.getAll();
            var listaClientes = clienteService.getAll();
            HashMap<String,Object> dados = new HashMap<>();
            dados.put("venda", venda);
            dados.put("listaClientes", listaClientes);
            dados.put("listaAtendentes", listaAtendentes);
            return new ModelAndView("venda/form",dados);
        }
        service.save(venda);
        return new ModelAndView("redirect:/vendas");
    }

    @PostMapping(params = "incitem")
    public ModelAndView incluirItem(Venda venda, ItemVenda novoItem, Pagamento novoPagamento){
        venda.getColItens().add(novoItem);
        venda.getPagamentos().add(novoPagamento);
        var listaAtendentes = atendenteService.getAll();
        var listaClientes = clienteService.getAll();
        var listaProdutos = produtoService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("venda", venda);
        dados.put("listaClientes", listaClientes);
        dados.put("listaAtendentes", listaAtendentes);
        dados.put("listaProdutos", listaProdutos);
        dados.put("novoItem", new ItemVenda());
        dados.put("novoPagamento", new Pagamento());
        return new ModelAndView("venda/form",dados);
    }

    @PostMapping(params = "removeitem")
    public ModelAndView removerItem(@RequestParam("removeitem") int index, Venda venda, Pagamento novPagamento){
        venda.getColItens().remove(index);
        venda.getPagamentos().remove(index);
        var listaClientes = clienteService.getAll();
        var listaAtendentes = atendenteService.getAll();
        var listaProdutos = produtoService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("venda", venda);
        dados.put("listaClientes", listaClientes);
        dados.put("listaProdutos", listaProdutos);
        dados.put("listaAtendentes", listaAtendentes);
        dados.put("novoItem", new ItemVenda());
        dados.put("novoPagamento", new Pagamento());
        return new ModelAndView("venda/form",dados);
    }
    
}
