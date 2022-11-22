package br.univille.lojaproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.lojaproj.entity.Atendente;

@Repository
public interface AtendenteRepository extends JpaRepository<Atendente,Long> {
    
}
