package labrinco.ifpb.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import labrinco.ifpb.dao.MinicursoDAO;
import labrinco.ifpb.model.Minicurso;
import labrinco.ifpb.model.Usuario;

public class MinicursoDAOImpl extends DAOImpl<Minicurso> implements
		Serializable, MinicursoDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MinicursoDAOImpl() {
		this.classe = Minicurso.class;
	}

	@Override
	public List<Minicurso> buscaPorUsuario(long id) {
		Query query = em.createQuery(
				"SELECT m FROM TB_MINICURSO m WHERE m.usuario.id = :usuarioId")
				.setParameter("usuarioId", id);
		return query.getResultList();

	}

}
