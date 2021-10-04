package br.com.desafioMv.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioMv.controller.ClienteController;
import br.com.desafioMv.entity.Cliente;
import br.com.desafioMv.entity.Conta;
import br.com.desafioMv.repository.ContaRepositorio;

@Service
public class ContaService {

	@Autowired
	private ContaRepositorio contaRepositorio;

	public ArrayList<Conta> listarTodas() {

		return (ArrayList<Conta>) contaRepositorio.findAll();
	}

	public Optional<Conta> getContaPorId(Integer id) {

		return contaRepositorio.findById(id);
	}

	public Conta atualizarConta(Conta conta) {

		return contaRepositorio.save(conta);
	}

	public void desativarConta(Conta conta) {

		contaRepositorio.delete(conta);
	}

	public Conta inserirConta(Conta conta) {

		return contaRepositorio.save(conta);
	}

	public String relatorioSaldoCliente(int id) {

		ClienteController clienteController = new ClienteController();
		Cliente cliente = clienteController.getClientePorID(id).getBody();

		String Mensagem = "Relatório de saldo do Cliente " + cliente.getNome() + ":" + "Cliente: " + cliente.getNome()
				+ " - Cliente desde: " + cliente.getDataInclusao() + ";" + "Endereço: " + cliente.getEndereco() + ";"
				+ "Movimentações de crédito: " + getContaPorId(id).get().getMovimentacaoCredito() + ";"
				+ "Movimentações de débito: " + getContaPorId(id).get().getMovimentacaoDebito() + ";"
				+ "Total de Movimentações: " + getContaPorId(id).get().getTotalMovimentacoes() + ";"
				+ "Valor pago pelas movimentações: " + getContaPorId(id).get().getTotalMovimentacoes() + ";"
				+ "Saldo inicial: " + getContaPorId(id).get().getSaldoInicial() + "Saldo atual: "
				+ getContaPorId(id).get().getSaldoAtual();

		return Mensagem;
	}

	public String relatorioSaldoTodosClientes() {

		ClienteService clienteService = new ClienteService();
		ArrayList<Cliente> listaClientes = new ArrayList();
		listaClientes = clienteService.listarTodos();
		String mensagem = null;

		for (Cliente cliente : listaClientes) {
			mensagem = "Cliente: " + cliente.getNome() + "desde: " + cliente.getDataInclusao() + " - Saldo em "
					+ getContaPorId(cliente.getId()).get().getSaldoAtual();
		}
		return mensagem;
	}
}
