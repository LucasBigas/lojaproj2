package br.univille.lojaproj.service;

import java.util.List;

import br.univille.lojaproj.entity.ComissaoVenda;

public interface ComissaoVendaService {
    List<ComissaoVenda>getAll();
    ComissaoVenda save(ComissaoVenda comissaoVenda);
    ComissaoVenda findById(long id);
}
