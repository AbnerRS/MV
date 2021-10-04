package br.com.desafioMv.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioMv.entity.Conta;
import br.com.desafioMv.repository.ContaRepositorio;

@Service
public class ContaService {

	@Autowired
	private ContaRepositorio contaRepositorio;

	public ArrayList<Conta> listarTodos() {

		return (ArrayList<Conta>) contaRepositorio.findAll();
	}

	public Conta getContaPorId(Integer id) {

		return contaRepositorio.getById(id);
	}

	public Conta atualizarConta(Conta conta) {

		return contaRepositorio.save(conta);
	}

	public void deletarConta(Conta conta) {

		contaRepositorio.delete(conta);
	}
}
