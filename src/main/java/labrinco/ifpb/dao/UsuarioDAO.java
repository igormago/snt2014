package labrinco.ifpb.dao;

import labrinco.ifpb.model.Usuario;

public interface UsuarioDAO extends DAO<Usuario>{

	public Usuario buscaPorEmail(String email);
	
}
