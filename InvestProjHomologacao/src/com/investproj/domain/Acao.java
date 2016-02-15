package com.investproj.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "tbl_acoes")
@NamedQueries({
	@NamedQuery(name = "Acao.listar", query = "SELECT acao FROM Acao acao"),
	@NamedQuery(name = "Acao.buscarPorCodigo", query = "SELECT acao FROM Acao acao WHERE acao.id = :id") 
})
public class Acao implements Serializable {

	@Id
	@Column(name = "aco_id")
	private Long id;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "aco_usr_id", referencedColumnName = "usr_id")
	private Usuario usuario;
	
	@Column(name = "aco_nome", length = 60, nullable = false)
	private String nome;

	@Column(name = "aco_quantidade")
	private Integer quantidade;

	@Column(name = "aco_preco_medio", precision = 15, scale = 2)
	private BigDecimal preco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Acao [id=" + id + ", usuario=" + usuario + ", nome=" + nome
				+ ", quantidade=" + quantidade + ", preco=" + preco + "]";
	}
	
	
}
