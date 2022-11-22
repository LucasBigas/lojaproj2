package br.univille.lojaproj.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.lojaproj.entity.Venda;
import br.univille.lojaproj.repository.VendaRepository;
import br.univille.lojaproj.service.VendaService;

@Service
public class VendaServiceImpl implements VendaService {

    @Autowired
    private VendaRepository repositorio;

    @Override
    public List<Venda> getAll() {
        
        return repositorio.findAll();
    }

    @Override
    public Venda save(Venda venda) {
      
        return repositorio.save(venda);
    }

    @Override
    public Venda findByid(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Venda();
    }

    
    
}
