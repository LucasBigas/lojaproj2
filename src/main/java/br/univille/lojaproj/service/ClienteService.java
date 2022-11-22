package br.univille.lojaproj.service;

import java.util.List;

import br.univille.lojaproj.entity.Cliente;

public interface ClienteService {
    List<Cliente> getAll();
    Cliente save(Cliente cliente);
    Cliente findById(long id);
    void delete(long id);

}
