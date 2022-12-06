package br.univille.lojaproj.service.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.lojaproj.entity.ComissaoVenda;
import br.univille.lojaproj.entity.Venda;
import br.univille.lojaproj.repository.ComissaoVendaRepository;
import br.univille.lojaproj.repository.VendaRepository;
import br.univille.lojaproj.service.VendaService;

@Service
public class VendaServiceImpl implements VendaService {

    @Autowired
    private VendaRepository repositorio;
    @Autowired
    private ComissaoVendaRepository comissaoRepository;

    @Override
    public List<Venda> getAll() {
        
        return repositorio.findAll();
    }

    @Override
    public Venda save(Venda venda) {
      
        ComissaoVenda comissao = new ComissaoVenda();
        comissao.setData(new Date());
        comissao.setVendedor(venda.getVendedor());

        float total = 0;
        for(var umPagto : venda.getPagamentos()){
            total += umPagto.getValorTotal();
        }

        comissao.setValor(total * 0.08f);
        comissao.setVenda(venda);

        var novaVenda = repositorio.save(venda);
        comissaoRepository.save(comissao);

        return novaVenda;
        
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
