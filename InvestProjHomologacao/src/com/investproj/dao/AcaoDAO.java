package com.investproj.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.investproj.domain.Acao;
import com.investproj.util.HibernateUtil;

public class AcaoDAO{

	public void salvar(Acao acao) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.save(acao);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null)
				transacao.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Acao> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Acao> acoes = null;

		try {
			Query consulta = session.getNamedQuery("Acao.listar");
			acoes = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return acoes;
	}

	public Acao buscarPorCodigo(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Acao acao = null;

		try {
			Query consulta = session.getNamedQuery("Acao.buscarPorCodigo");
			consulta.setLong("id", id);

			acao = (Acao) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return acao;
	}

	public void excluir(Acao acao) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.delete(acao);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null)
				transacao.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	public void editar(Acao acao) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try {
			transacao = session.beginTransaction();
			session.update(acao);
			transacao.commit();
		} catch (Exception ex) {
			if(transacao != null)
				transacao.rollback();
		}finally{
			session.close();
		}
	}

}
