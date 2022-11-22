package br.univille.lojaproj.service;

import java.util.List;

import br.univille.lojaproj.entity.Venda;

public interface VendaService {
    List<Venda>getAll();
    Venda save(Venda venda);
    Venda findByid(long id);
}
