
package labrinco.ifpb.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import labrinco.ifpb.dao.UsuarioDAO;
import labrinco.ifpb.model.Usuario;

public class UsuarioDAOImpl extends DAOImpl<Usuario> implements Serializable,
		UsuarioDAO {

	public UsuarioDAOImpl() {
		this.classe = Usuario.class;
	}

	@Override
	public Usuario buscaPorEmail(String email) {
		List<Usuario> resultado = null;

		Query query = em.createQuery(
				"SELECT u FROM TB_USUARIO u WHERE u.email = :email").setParameter(
				"email", email);
		resultado = query.getResultList();

		if (resultado != null && resultado.size() > 0) {
			return resultado.get(0);
		} else {
			return null;
		}
	}

}
