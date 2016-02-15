package com.investproj.test;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import com.investproj.dao.ProjetoDAO;
import com.investproj.dao.UsuarioDAO;
import com.investproj.domain.Projeto;
import com.investproj.domain.Usuario;

public class ProjetoDAOTest {
	
	@Ignore
	@Test
	public void salvar(){
		ProjetoDAO projetoDAO = new ProjetoDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Projeto projeto = new Projeto();
		Usuario usuario = usuarioDAO.buscarPorCodigo(7L);
		
		projeto.setId(3L);
		projeto.setUsuario(usuario);
		projeto.setNome("Predio");
		projeto.setStatus("Iniciado");
		projeto.setInicio(new Date());
		
		projetoDAO.salvar(projeto);
	}
	
	@Ignore
	@Test
	public void listar(){
		ProjetoDAO projetoDAO = new ProjetoDAO();
		System.out.println(projetoDAO.listar());
	}
	
	@Ignore
	@Test
	public void buscarPorCodigo(){
		ProjetoDAO projetoDAO = new ProjetoDAO();
		System.out.println(projetoDAO.buscarPorCodigo(2L));
	}
	
	@Ignore
	@Test
	public void excluir(){
		ProjetoDAO projetoDAO = new ProjetoDAO();
		Projeto projeto = projetoDAO.buscarPorCodigo(1L);
		projetoDAO.excluir(projeto);
	}
	
	@Ignore
	@Test
	public void editar(){
		ProjetoDAO projetoDAO = new ProjetoDAO();
		Projeto projeto = projetoDAO.buscarPorCodigo(2L);
		projeto.setNome("Novidade");
		projetoDAO.editar(projeto);
	}
}
