package org.dev_module.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.cassandra.thrift.cassandraConstants;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "fluxo_table")
public class Fluxo {

	@Id
	@GeneratedValue
	private Long id;
	private String descricao;
	private Boolean tpEntrada;
	private Boolean saida;
	private Double valor;

	@ManyToOne(targetEntity = Caixa.class)
	@JoinColumn(name = "caixa_id",nullable = true)
	private Caixa caixa;

	@ManyToOne
	@JoinColumn(name = "saldo_id")
	private Saldo saldo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	public Boolean getTpEntrada() {
		return tpEntrada;
	}

	public void setTpEntrada(Boolean tpEntrada) {
		this.tpEntrada = tpEntrada;
	}

	public Saldo getSaldo() {
		return saldo;
	}

	public void setSaldo(Saldo saldo) {
		this.saldo = saldo;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getSaida() {
		return saida;
	}

	public void setSaida(Boolean saida) {
		this.saida = saida;
	}

	public Double getValor() {
		return valor;
	}

	public void setValorEntrada(Double valor) {
		if (valor > 0) {
			this.valor = valor;
		}
	}

	public void setValorSaida(Double valor) {
		if (valor < 0) {
			this.valor = valor;
		}
	}

}
