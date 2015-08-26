package labrinco.ifpb.service;

import java.util.List;

import labrinco.ifpb.model.Minicurso;

public interface MinicursoService extends Service<Minicurso> {

	public List<Minicurso> buscaPorUsuario(long id);

}
