package labrinco.ifpb.service.impl;

import java.io.Serializable;

import javax.inject.Inject;

import labrinco.ifpb.dao.PerfilUsuarioDAO;
import labrinco.ifpb.dao.UsuarioDAO;
import labrinco.ifpb.model.PerfilUsuario;
import labrinco.ifpb.model.Usuario;
import labrinco.ifpb.service.UsuarioService;

public class UsuarioServiceImpl extends ServiceImpl<Usuario> implements
		Serializable, UsuarioService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioDAO usuarioDAO;

	@Inject
	private PerfilUsuarioDAO perfilUsuarioDAO;

	public UsuarioServiceImpl() {
		this.classe = Usuario.class;
	}

	public Usuario buscaPorEmail(String email) {
		return usuarioDAO.buscaPorEmail(email);
	}

	

}