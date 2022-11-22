package br.univille.lojaproj.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.lojaproj.entity.ComissaoVenda;
import br.univille.lojaproj.repository.ComissaoVendaRepository;
import br.univille.lojaproj.service.ComissaoVendaService;

@Service
public class ComissaoVendaImpl implements ComissaoVendaService {

    @Autowired
    private ComissaoVendaRepository repositorio;

    @Override
    public List<ComissaoVenda> getAll() {
        
        return repositorio.findAll();
    }

    @Override
    public ComissaoVenda save(ComissaoVenda comissaoVenda) {
        
        return repositorio.save(comissaoVenda);
    }

    @Override
    public ComissaoVenda findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new ComissaoVenda();
    }
    
}
