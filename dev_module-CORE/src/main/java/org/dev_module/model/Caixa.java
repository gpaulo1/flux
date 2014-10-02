package org.dev_module.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "caixa_name")
public class Caixa {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private Boolean enabled;
	private String numAgencia;
	private String numConta;
	private String numDigito;
	private String nomeAgencia;
	private String urlIcone;
	private Double saldoInicial;

	@OneToMany
	@JoinColumn(name = "user_id")
	private List<User> users = new ArrayList<User>();

	@OneToMany(mappedBy = "caixa", targetEntity = Fluxo.class, cascade = {CascadeType.ALL})
	private List<Fluxo> fluxos = new ArrayList<Fluxo>();

	@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "saldo_id")
	private Saldo saldo;

	public Saldo getSaldo() {
		return saldo;
	}

	public void setSaldo(Saldo saldo) {
		this.saldo = saldo;
	}

	public Double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public String getUrlIcone() {
		return urlIcone;
	}

	public void setUrlIcone(String urlIcone) {
		this.urlIcone = urlIcone;
	}

	public String getNumAgencia() {
		return numAgencia;
	}

	public void setNumAgencia(String numAgencia) {
		this.numAgencia = numAgencia;
	}

	public String getNumConta() {
		return numConta;
	}

	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}

	public String getNumDigito() {
		return numDigito;
	}

	public void setNumDigito(String numDigito) {
		this.numDigito = numDigito;
	}

	public String getNomeAgencia() {
		return nomeAgencia;
	}

	public void setNomeAgencia(String nomeAgencia) {
		this.nomeAgencia = nomeAgencia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Fluxo> getFluxos() {
		return fluxos;
	}

	public void setFluxos(List<Fluxo> fluxos) {
		this.fluxos = fluxos;
	}

}
