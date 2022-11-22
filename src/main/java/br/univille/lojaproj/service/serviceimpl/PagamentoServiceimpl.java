package br.univille.lojaproj.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.lojaproj.entity.Pagamento;
import br.univille.lojaproj.repository.PagametoRepository;
import br.univille.lojaproj.service.PagamentoService;

@Service
public class PagamentoServiceimpl implements PagamentoService {
    @Autowired
    private PagametoRepository repository;

    @Override
    public List<Pagamento> getall() {
        return repository.findAll();
    }

    @Override
    public Pagamento save(Pagamento pagamento) {
        return repository.save(pagamento);
    }

    @Override
    public Pagamento findById(long id) {
        return null;
    }
    
}
