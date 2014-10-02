package org.dev_module.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "clente_name")
@PrimaryKeyJoinColumn(name = "id_endereco")
public class Cliente extends Endereco {

	private String tipoPessoa;
	private String cnpj;
	private String inscricaoEstadual;
	private String razaoSocial;
	private String fantasia;
	private String inscricaoMunicipal;
	private String nome;
	private String email;
	private String emailCobranca;
	private String rg;
	private String cpf;
	private String estadoCivel;
	private String profissao;
	private String telefone;
	private String celular;

	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User usuario = new User();

	@OneToOne
	@JoinColumn(name = "contato_id")
	private Contato contato;

	@OneToMany(mappedBy = "cliente")
	private List<EnderecoContato> endContatos = new ArrayList<EnderecoContato>();

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public List<EnderecoContato> getEndContatos() {
		return endContatos;
	}

	public void setEndContatos(List<EnderecoContato> endContatos) {
		this.endContatos = endContatos;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailCobranca() {
		return emailCobranca;
	}

	public void setEmailCobranca(String emailCobranca) {
		this.emailCobranca = emailCobranca;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEstadoCivel() {
		return estadoCivel;
	}

	public void setEstadoCivel(String estadoCivel) {
		this.estadoCivel = estadoCivel;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
}
