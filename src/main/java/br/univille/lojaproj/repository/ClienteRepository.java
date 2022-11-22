package br.univille.lojaproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.lojaproj.entity.Cliente;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente,Long>{
    
}
