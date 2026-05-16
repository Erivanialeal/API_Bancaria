package br.com.erivania.apibancaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.erivania.apibancaria.entity.Extrato;

public interface ExtratoRepository extends JpaRepository<Extrato, Long> {

}
