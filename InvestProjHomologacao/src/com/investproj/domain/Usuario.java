package com.investproj.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_usuarios")
@NamedQueries({
		@NamedQuery(name = "Usuario.listar", query = "SELECT usuario FROM Usuario usuario"),
		@NamedQuery(name = "Usuario.buscarPorCodigo", query = "SELECT usuario FROM Usuario usuario WHERE usuario.id = :id") 
})
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usr_id")
	private Long id;

	@Column(name = "usr_nome", length = 60, nullable = false)
	private String nome;

	@Column(name = "usr_email", length = 100, nullable = false, unique = true)
	private String email;

	@Column(name = "usr_nascimento", nullable = false)
	@Temporal(value = TemporalType.DATE)
	private Date nascimento;

	@Column(name = "usr_senha", length = 32, nullable = false)
	private String senha;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email
				+ ", nascimento=" + nascimento + ", senha=" + senha + "]";
	}
}
