package org.dev_module.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.cassandra.thrift.Cassandra.AsyncProcessor.cas;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "saldo_name")
public class Saldo {

	@Id
	@GeneratedValue
	private Long id;
	private Double saldoDisponivel;
	private Double saldoCredito;
	private Double saldoDebito;

	@OneToOne(mappedBy = "saldo", cascade = CascadeType.PERSIST)
	@JsonIgnore
	private Caixa caixa;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSaldoDisponivel() {
		return saldoDisponivel;
	}

	public void setSaldoDisponivel(Double saldoDisponivel) {
		this.saldoDisponivel = saldoDisponivel;
	}

	public Double getSaldoCredito() {
		return saldoCredito;
	}

	public void setSaldoCredito(Double saldoCredito) {
		this.saldoCredito = saldoCredito;
	}

	public Double getSaldoDebito() {
		return saldoDebito;
	}

	public void setSaldoDebito(Double saldoDebito) {
		this.saldoDebito = saldoDebito;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

}
