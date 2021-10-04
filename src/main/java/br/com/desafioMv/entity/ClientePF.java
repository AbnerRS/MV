package br.com.desafioMv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTE_PF")
@PrimaryKeyJoinColumn(name="ID_CLIENTE")
public class ClientePF extends Cliente{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "CPF")
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
