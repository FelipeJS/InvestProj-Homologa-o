package com.investproj.test;

import org.junit.Ignore;
import org.junit.Test;

import com.investproj.dao.AcaoDAO;
import com.investproj.dao.UsuarioDAO;
import com.investproj.domain.Acao;
import com.investproj.domain.Usuario;

public class AcaoDAOTest {
	
	@Ignore
	@Test
	public void salvar(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorCodigo(6L);
		
		Acao acao = new Acao();
		acao.setId(3L);
		acao.setUsuario(usuario);
		acao.setNome("IBM");
		
		AcaoDAO acaoDAO = new AcaoDAO();
		acaoDAO.salvar(acao);
	}
	
	@Ignore
	@Test
	public void listar(){
		AcaoDAO dao = new AcaoDAO();
		System.out.println(dao.listar());
	}
	
	@Ignore
	@Test
	public void buscarPorCodigo(){
		AcaoDAO dao = new AcaoDAO();
		System.out.println(dao.buscarPorCodigo(1L));
	}
	
	@Ignore
	@Test
	public void excluir(){
		AcaoDAO dao = new AcaoDAO();
		Acao acao = dao.buscarPorCodigo(1L);
		dao.excluir(acao);
	}
	
	@Ignore
	@Test
	public void editar(){
		AcaoDAO acaoDAO = new AcaoDAO();
		Acao acao = acaoDAO.buscarPorCodigo(2L);
		
		acao.setNome("Petrobras");
		acaoDAO.editar(acao);
	}
}
