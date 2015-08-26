package labrinco.ifpb.dao;

import java.util.List;

import org.hibernate.criterion.Order;

public interface DAO<T> {

	public T adiciona(T obj);

	public void remove(T obj);

	public void atualiza(T obj);

	public List<T> listaTodos(Order... ordenacoes);

	public T buscaPorId(Long id);
	
	public List<T> busca (T obj);

}
