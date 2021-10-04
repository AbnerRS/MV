package br.com.desafioMv.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.desafioMv.entity.Cliente;
import br.com.desafioMv.entity.Conta;
import br.com.desafioMv.service.ContaService;

@Controller
@ResponseBody
public class ContaController {

	@Autowired
	private ContaService contaService;

	@RequestMapping(value = "/contas", method = RequestMethod.GET)
	private List<Conta> getContas() {

		return contaService.listarTodas();
	}

	@RequestMapping(value = "/contaById/{id_cliente}", method = RequestMethod.GET)
	private ResponseEntity<Conta> getContaPorId(@PathVariable(value = "id_cliente") Integer id) {

		Optional<Conta> conta = contaService.getContaPorId(id);

		if (conta.isPresent() && conta.get().getAtiva() == 1) {
			return new ResponseEntity<Conta>(conta.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Conta>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/atualizarConta", method = RequestMethod.PUT)
	public ResponseEntity<Conta> Put(@RequestBody Conta conta) {
		Optional<Conta> contaOpt = contaService.getContaPorId(conta.getIdConta());

		if (contaOpt.isPresent() && contaOpt.get().getAtiva() == 1) {
			Conta conta2 = contaService.atualizarConta(contaOpt.get());
			return new ResponseEntity<Conta>(conta2, HttpStatus.OK);

		} else {
			return new ResponseEntity<Conta>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/desativarConta/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "id") Integer id) {
		Optional<Conta> conta = contaService.getContaPorId(id);

		if (conta.isPresent() && conta.get().getAtiva() == 1) {
			contaService.desativarConta(conta.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/conta", method = RequestMethod.POST)
	public Conta Post(@RequestBody Conta conta) {
		return contaService.inserirConta(conta);
	}

	public String relatorioSaldoCliente(int id) {

		ClienteController clienteController = new ClienteController();
		Cliente cliente = clienteController.getClientePorID(id).getBody();

		String Mensagem = "Relatório de saldo do Cliente " + cliente.getNome() + ":" + "Cliente: " + cliente.getNome()
				+ " - Cliente desde: " + cliente.getDataInclusao() + ";" + "Endereço: " + cliente.getEndereco() + ";"
				+ "Movimentações de crédito: " + getContaPorId(id).getBody().getMovimentacaoCredito() + ";"
				+ "Movimentações de débito: " + getContaPorId(id).getBody().getMovimentacaoDebito() + ";"
				+ "Total de Movimentações: " + getContaPorId(id).getBody().getTotalMovimentacoes() + ";"
				+ "Valor pago pelas movimentações: " + getContaPorId(id).getBody().getTotalMovimentacoes() + ";"
				+ "Saldo inicial: " + getContaPorId(id).getBody().getSaldoInicial() 
				+ "Saldo atual: " + getContaPorId(id).getBody().getSaldoAtual();

		return Mensagem;
	}
}