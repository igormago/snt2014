package labrinco.ifpb.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import labrinco.ifpb.dao.DAO;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;

public abstract class DAOImpl<T> implements Serializable, DAO<T> {

	protected Class<T> classe;

	@Inject
	protected EntityManager em;

	public DAOImpl() {
		this.classe = (Class<T>) getClass().getGenericInterfaces()[0];
	}

	@Override
	public T adiciona(T obj) {
		em.persist(obj);
		return obj;

	}

	@Override
	public void remove(T obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualiza(T obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<T> listaTodos(Order... ordenacoes) {

		List<T> results = null;
		try {
			Query query = em.createQuery("from " + classe.getName()
					+ adicionaOrdem(ordenacoes));
			results = query.getResultList();
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		return results;
	}

	@Override
	public T buscaPorId(Long id) {

		T instance = null;
		try {
			instance = em.find(classe, id);
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		return instance;
	}

	public List<T> busca(T entity) {
		T instance = null;
		Session session = (Session) em.getDelegate();

		Example exemplo = Example.create(entity).excludeZeroes();

		Criteria criteria = session.createCriteria(classe).add(exemplo);

		return criteria.list();

	}

	protected final static String adicionaOrdem(Order... ordenacoes) {

		String result = "";
		if (ordenacoes.length > 0) {
			StringBuilder builder = new StringBuilder(" order by ");
			for (int i = 0; i < ordenacoes.length - 1; i++) {
				builder.append(ordenacoes[i].toString());
				builder.append(", ");
			}
			builder.append(ordenacoes[ordenacoes.length - 1]);
			result = builder.toString();
		}

		return result;
	}

}
