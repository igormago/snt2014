package labrinco.ifpb.service;

import labrinco.ifpb.model.Usuario;

public interface UsuarioService extends Service<Usuario> {

	public Usuario buscaPorEmail(String email);
}
