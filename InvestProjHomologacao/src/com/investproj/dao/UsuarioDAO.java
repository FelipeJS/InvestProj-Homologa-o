package com.investproj.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.investproj.domain.Usuario;
import com.investproj.util.HibernateUtil;

public class UsuarioDAO {

	public void salvar(Usuario usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.save(usuario);
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
	public List<Usuario> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Usuario> usuarios = null;

		try {
			Query consulta = session.getNamedQuery("Usuario.listar");
			usuarios = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}

		return usuarios;
	}

	public Usuario buscarPorCodigo(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Usuario usuario = null;

		try {
			Query consulta = session.getNamedQuery("Usuario.buscarPorCodigo");
			consulta.setLong("id", id);

			usuario = (Usuario) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return usuario;
	}

	public void excluir(Usuario usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.delete(usuario);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null)
				transacao.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	public void editar(Usuario usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.update(usuario);
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
