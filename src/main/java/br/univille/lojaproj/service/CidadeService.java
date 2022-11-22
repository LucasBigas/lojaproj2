package br.univille.lojaproj.service;

import java.util.List;
import br.univille.lojaproj.entity.Cidade;


public interface CidadeService {
    List<Cidade> getAll();
    Cidade save(Cidade cidade);
    Cidade findById(long id);
    void deleteById(long id);
    
    
}