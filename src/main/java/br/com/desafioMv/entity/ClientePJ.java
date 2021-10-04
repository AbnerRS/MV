package br.com.desafioMv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTE_PJ")
@PrimaryKeyJoinColumn(name="ID_CLIENTE")
public class ClientePJ extends Cliente{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "RAZAO")
	private String razao;
	
	@Column(name = "CNPJ")
	private String cnpj;
	
	@Column(name = "NIRE")
	private String nire;
	
	public String getRazao() {
		return razao;
	}

	public void setRazao(String razao) {
		this.razao = razao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNire() {
		return nire;
	}

	public void setNire(String nire) {
		this.nire = nire;
	}
	
}
