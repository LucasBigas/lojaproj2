package br.univille.lojaproj.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.lojaproj.entity.Cidade;
import br.univille.lojaproj.repository.CidadeRepository;
import br.univille.lojaproj.service.CidadeService;


@Service
public class CidadeServiceimpl implements CidadeService{
    @Autowired
    private CidadeRepository repositorio;

    @Override
    public List<Cidade> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Cidade save(Cidade cidade) {
        return repositorio.save(cidade);
    }

    @Override
    public Cidade findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Cidade();
    }

    @Override
    public void deleteById(long id) {
        repositorio.deleteById(id);
        
    }
    
}