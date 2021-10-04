package br.com.desafioMv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.desafioMv.entity.Conta;

@Repository
public interface ContaRepositorio  extends JpaRepository<Conta, Integer> { }
