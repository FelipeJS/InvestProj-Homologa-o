package com.investproj.test;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import com.investproj.dao.UsuarioDAO;
import com.investproj.domain.Usuario;

public class UsuarioDAOTest {

	@Ignore
	@Test
	public void salvar() {
		Usuario user1 = new Usuario();
		user1.setNome("Felipe Campos");
		user1.setEmail("tecnologiagrave@gmail.com");
		user1.setNascimento(new Date());
		user1.setSenha("123456789");

		UsuarioDAO dao = new UsuarioDAO();

		dao.salvar(user1);
	}

	@Ignore
	@Test
	public void listar() {
		UsuarioDAO dao = new UsuarioDAO();
		System.out.println(dao.listar());
	}

	@Ignore
	@Test
	public void buscarPorCodigo() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		System.out.println(usuarioDAO.buscarPorCodigo(6L));
		System.out.println(usuarioDAO.buscarPorCodigo(7L));
	}
	
	@Ignore
	@Test
	public void excluir() {
		 UsuarioDAO dao = new UsuarioDAO();
		 Usuario usuario = dao.buscarPorCodigo(5L);
		 dao.excluir(usuario);
	}
	
	@Ignore
	@Test
	public void editar() {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.buscarPorCodigo(7L);
		
		usuario.setNome("gatorate");
		usuario.setEmail("@@@@@");
		usuario.setSenha("teste");
		usuario.setNascimento(new Date());
		
		dao.editar(usuario);
	}
}
