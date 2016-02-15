package com.investproj.test;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;

import com.investproj.dao.AcaoDAO;
import com.investproj.dao.InvestimentoDAO;
import com.investproj.domain.Acao;
import com.investproj.domain.Investimento;

public class InvestimentoDAOTest {
	
	@Ignore
	@Test
	public void salvar(){
		InvestimentoDAO investimentoDAO = new InvestimentoDAO();
		AcaoDAO acaoDAO = new AcaoDAO();
		Investimento investimento = new Investimento();
		
		Acao acao = acaoDAO.buscarPorCodigo(2L); 
		
		investimento.setId(2L);
		investimento.setAcao(acao);
		investimento.setValor(new BigDecimal(100D));
		investimento.setQuantidade(2);
		investimento.setTotal(new BigDecimal(200D));
		
		investimentoDAO.salvar(investimento);
	}
	
	@Ignore
	@Test
	public void listar(){
		InvestimentoDAO investimentoDAO = new InvestimentoDAO();
		System.out.println(investimentoDAO.listar());
	}
	
	@Ignore
	@Test
	public void buscarPorCodigo(){
		InvestimentoDAO investimentoDAO = new InvestimentoDAO();
		Investimento investimento = investimentoDAO.buscarPorCodigo(2L);
		
		System.out.println(investimento);
	}
	
	@Ignore
	@Test
	public void excluir(){
		InvestimentoDAO investimentoDAO = new InvestimentoDAO();
		Investimento investimento = investimentoDAO.buscarPorCodigo(1L);
		investimentoDAO.excluir(investimento);
	}
	
	@Ignore
	@Test
	public void editar(){
		InvestimentoDAO investimentoDAO = new InvestimentoDAO();
		Investimento investimento = investimentoDAO.buscarPorCodigo(2L);
		investimento.setQuantidade(4);
		investimento.setTotal(new BigDecimal(400D));
		
		investimentoDAO.editar(investimento);
	}
}
