package labrinco.ifpb.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;

public interface Service<T> {

	public void adiciona(T obj);

	public void remove(T obj);

	public void atualiza(T obj);

	public List<T> listaTodos();

	public T buscaPorId(Long id);

	public List<T> busca(T obj);

}
