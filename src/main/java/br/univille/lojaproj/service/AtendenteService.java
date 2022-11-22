package br.univille.lojaproj.service;

import java.util.List;

import br.univille.lojaproj.entity.Atendente;

public interface AtendenteService {
    List<Atendente>getAll();
    Atendente save(Atendente atendente);
    Atendente findById(long id);
    void delete(long id);
}
