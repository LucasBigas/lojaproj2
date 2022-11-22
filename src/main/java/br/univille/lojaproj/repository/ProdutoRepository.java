package br.univille.lojaproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.lojaproj.entity.Produto;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto,Long>{
    
}