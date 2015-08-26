package labrinco.ifpb.dao.impl;

import java.io.Serializable;

import labrinco.ifpb.dao.PerfilUsuarioDAO;
import labrinco.ifpb.model.PerfilUsuario;

public class PerfilUsuarioDAOImpl extends DAOImpl<PerfilUsuario> implements
		Serializable, PerfilUsuarioDAO {

	public PerfilUsuarioDAOImpl() {
		this.classe = PerfilUsuario.class;
	}

}
