package br.univille.lojaproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.lojaproj.entity.Cidade;

@Repository
public interface CidadeRepository 
        extends JpaRepository<Cidade,Long>{
    
}