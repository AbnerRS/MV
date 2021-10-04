package br.com.desafioMv.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.desafioMv.entity.Cliente;
import br.com.desafioMv.repository.ClienteRepositorio;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepositorio clienteRepositorio;

	public ArrayList<Cliente> listarTodos() {

		return (ArrayList<Cliente>) clienteRepositorio.findAll();
	}

	public Optional<Cliente> getClientePorId(Integer id) {

		return clienteRepositorio.findById(id);
	}

	public Cliente atualizarCliente(Cliente cliente) {

		return clienteRepositorio.save(cliente);
	}

	public void deletarCliente(Cliente cliente) {

		clienteRepositorio.delete(cliente);
	}
	
	public Cliente inserirCliente(Cliente cliente) {

		return clienteRepositorio.save(cliente);
	}
}
