package br.com.desafioMv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.desafioMv.entity.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> { }
