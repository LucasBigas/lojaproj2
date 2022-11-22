package br.univille.lojaproj.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.lojaproj.entity.Produto;
import br.univille.lojaproj.repository.ProdutoRepository;
import br.univille.lojaproj.service.ProdutoService;

@Service
public class ProdutoServiceimpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repositorio;

    @Override
    public List<Produto> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Produto save(Produto produto) {
        return repositorio.save(produto);
    }

    @Override
    public Produto findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Produto();
    }
    
}
