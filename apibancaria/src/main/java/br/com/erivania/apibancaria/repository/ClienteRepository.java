package br.com.erivania.apibancaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.erivania.apibancaria.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
