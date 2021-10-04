package br.com.desafioMv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="CONTA")
@PrimaryKeyJoinColumn(name="ID_CLIENTE")
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CONTA")
	private Integer idConta;
	
	@Column(name = "DATA_CRIACAO")
	private String data;
	
	@Column(name = "MOVIMENTACAO_CREDITO")
	private Integer movimentacaoCredito;
	
	@Column(name = "MOVIMENTACAO_DEBITO")
	private Integer movimentacaoDebito;
	
	@Column(name = "TOTAL_MOVIMENTACOES")
	private Integer totalMovimentacoes;
	
	@Column(name = "VALOR_MOVIMENTACOES")
	private double valorMovimentacoes;
	
	@Column(name = "SALDO_INICIAL")
	private double saldoInicial;
	
	@Column(name = "SALDO_ATUAL")
	private double saldoAtual;
	
	@Column(name = "ATIVA")
	private int ativa;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getMovimentacaoCredito() {
		return movimentacaoCredito;
	}
	public void setMovimentacaoCredito(int movimentacaoCredito) {
		this.movimentacaoCredito = movimentacaoCredito;
	}
	public int getMovimentacaoDebito() {
		return movimentacaoDebito;
	}
	public void setMovimentacaoDebito(int movimentacaoDebito) {
		this.movimentacaoDebito = movimentacaoDebito;
	}
	public int getTotalMovimentacoes() {
		return totalMovimentacoes;
	}
	public void setTotalMovimentacoes(int totalMovimentacoes) {
		this.totalMovimentacoes = totalMovimentacoes;
	}
	public double getValorMovimentacoes() {
		return valorMovimentacoes;
	}
	public void setValorMovimentacoes(double valorMovimentacoes) {
		this.valorMovimentacoes = valorMovimentacoes;
	}
	public double getSaldoInicial() {
		return saldoInicial;
	}
	public void setSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}
	public double getSaldoAtual() {
		return saldoAtual;
	}
	public void setSaldoAtual(double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getAtiva() {
		return ativa;
	}
	public void setAtiva(int ativa) {
		this.ativa = ativa;
	}
	public Integer getIdConta() {
		return idConta;
	}
	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}
	
	
	
}
