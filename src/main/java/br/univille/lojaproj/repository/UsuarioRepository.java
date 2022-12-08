package br.univille.lojaproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.lojaproj.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Usuario findByNome(String nome);
    
}
