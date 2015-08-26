package labrinco.ifpb.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import labrinco.ifpb.dao.DAO;
import labrinco.ifpb.service.Service;

public abstract class ServiceImpl<T> implements Serializable, Service<T> {

	protected Class<T> classe;

	@Inject
	protected DAO<T> dao;
	
	public ServiceImpl() {
		this.classe = (Class<T>) getClass().getGenericInterfaces()[0];
	}

	public void adiciona(T obj) {
		dao.adiciona(obj);
	}

	public void remove(T obj) {
		dao.remove(obj);
	}

	public void atualiza(T obj) {
		dao.atualiza(obj);
	}

	public List<T> listaTodos() {
		return dao.listaTodos();
	}

	public T buscaPorId(Long id) {
		return dao.buscaPorId(id);
	}
	
	public List<T> busca(T obj) {
		return dao.busca(obj);
	}

}