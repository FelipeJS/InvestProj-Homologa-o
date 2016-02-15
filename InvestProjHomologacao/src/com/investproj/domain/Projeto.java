package com.investproj.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "tbl_projetos")
@NamedQueries({
	@NamedQuery(name = "Projeto.listar", query = "SELECT projeto FROM Projeto projeto"),
	@NamedQuery(name = "Projeto.buscarPorCodigo", query = "SELECT projeto FROM Projeto projeto WHERE projeto.id = :id") 
})
public class Projeto implements Serializable {

	@Id
	@Column(name = "prj_id")
	private Long id;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "prj_usr_id", referencedColumnName = "usr_id")
	private Usuario usuario;
	
	@Column(name = "prj_nome", length = 60, nullable = false)
	private String nome;

	@Column(name = "prj_descricao")
	private String descricao;

	@Column(name = "prj_inicio", nullable = false)
	@Temporal(value = TemporalType.DATE)
	private Date inicio;

	@Column(name = "prj_duracao")
	private Integer duracao;

	@Column(name = "prj_fim")
	@Temporal(value = TemporalType.DATE)
	private Date fim;

	@Column(name = "prj_status", length = 20, nullable = false)
	private String status;

	@Column(name = "prj_despesa", precision = 15, scale = 2)
	private BigDecimal despesa;

	@Column(name = "prj_ganho", precision = 15, scale = 2)
	private BigDecimal ganho;

	@Column(name = "prj_lucro", precision = 15, scale = 2)
	private BigDecimal lucro;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getDespesa() {
		return despesa;
	}

	public void setDespesa(BigDecimal despesa) {
		this.despesa = despesa;
	}

	public BigDecimal getGanho() {
		return ganho;
	}

	public void setGanho(BigDecimal ganho) {
		this.ganho = ganho;
	}

	public BigDecimal getLucro() {
		return lucro;
	}

	public void setLucro(BigDecimal lucro) {
		this.lucro = lucro;
	}

	@Override
	public String toString() {
		return "Projeto [id=" + id + ", usuario=" + usuario + ", nome=" + nome
				+ ", descricao=" + descricao + ", inicio=" + inicio
				+ ", duracao=" + duracao + ", fim=" + fim + ", status="
				+ status + ", despesa=" + despesa + ", ganho=" + ganho
				+ ", lucro=" + lucro + "]";
	}
}
