package br.com.erivania.apibancaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.erivania.apibancaria.entity.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
