package br.univille.lojaproj.service;

import java.util.List;
import br.univille.lojaproj.entity.Pagamento;

public interface PagamentoService {
    List<Pagamento> getall();
    Pagamento save(Pagamento pagamento);
    Pagamento findById(long id);
}