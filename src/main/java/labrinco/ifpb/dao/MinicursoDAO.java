package labrinco.ifpb.dao;

import java.util.List;

import labrinco.ifpb.model.Minicurso;

public interface MinicursoDAO extends DAO<Minicurso> {

	public List<Minicurso> buscaPorUsuario(long id);

}
