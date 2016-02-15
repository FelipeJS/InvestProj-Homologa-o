package com.investproj.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "tbl_investimentos")
@NamedQueries({
	@NamedQuery(name = "Investimento.listar", query = "SELECT investimento FROM Investimento investimento"),
	@NamedQuery(name = "Investimento.buscarPorCodigo", query = "SELECT investimento FROM Investimento investimento WHERE investimento.id = :id") 
})
public class Investimento implements Serializable {
	
	@Id
	@Column(name = "inv_id")
	private Long id;
	
	@Id 
	@ManyToOne(fetch = FetchType.EAGER)
	   @JoinColumns({
	      @JoinColumn(name="inv_aco_id", referencedColumnName="aco_id"),
	      @JoinColumn(name="inv_aco_usr_id", referencedColumnName="aco_usr_id")
	   })
	private Acao acao;

	@Column(name = "inv_data")
	@Temporal(value = TemporalType.DATE)
	private Date data;

	@Column(name = "inv_quantidade", nullable = false)
	private Integer quantidade;

	@Column(name = "inv_valor", nullable = false, precision = 15, scale = 2)
	private BigDecimal valor;

	@Column(name = "inv_custo", precision = 15, scale = 2)
	private BigDecimal custo;

	@Column(name = "inv_total", nullable = false, precision = 15, scale = 2)
	private BigDecimal total;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Acao getAcao() {
		return acao;
	}

	public void setAcao(Acao acao) {
		this.acao = acao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Investimento [id=" + id + ", acao=" + acao + ", data=" + data
				+ ", quantidade=" + quantidade + ", valor=" + valor
				+ ", custo=" + custo + ", total=" + total + "]";
	}
}
