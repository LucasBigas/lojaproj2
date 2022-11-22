package br.univille.lojaproj.service;

import java.util.List;

import br.univille.lojaproj.entity.Produto;

public interface ProdutoService {
    List<Produto>getAll();
    Produto save(Produto produto);
    Produto findById(long id);
}