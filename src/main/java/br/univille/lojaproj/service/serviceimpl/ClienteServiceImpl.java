package br.univille.lojaproj.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.lojaproj.entity.Cliente;
import br.univille.lojaproj.repository.ClienteRepository;
import br.univille.lojaproj.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteRepository repositorio;


    @Override
    public List<Cliente> getAll() {
    
        return repositorio.findAll();
    }

    @Override
    public Cliente save(Cliente cliente) {
        
        return repositorio.save(cliente);
    }

    @Override
    public Cliente findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Cliente();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    
        
    }


    
}
