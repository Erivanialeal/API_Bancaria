package br.com.erivania.apibancaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.erivania.apibancaria.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    String findByEmail(String email);

    boolean existsByEmail(String email);
}
