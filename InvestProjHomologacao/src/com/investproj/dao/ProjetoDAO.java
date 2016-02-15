package com.investproj.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.investproj.domain.Projeto;
import com.investproj.util.HibernateUtil;

public class ProjetoDAO{

	public void salvar(Projeto projeto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.save(projeto);
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
	public List<Projeto> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Projeto> projetos = null;

		try {
			Query consulta = session.getNamedQuery("Projeto.listar");
			projetos = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}

		return projetos;
	}

	public Projeto buscarPorCodigo(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Projeto projeto = null;

		try {
			Query consulta = session.getNamedQuery("Projeto.buscarPorCodigo");
			consulta.setLong("id", id);

			projeto = (Projeto) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return projeto;
	}

	public void excluir(Projeto projeto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.delete(projeto);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null)
				transacao.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	public void editar(Projeto projeto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.update(projeto);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null)
				transacao.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}
}
