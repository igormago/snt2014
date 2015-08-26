package labrinco.ifpb.sessao;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import labrinco.ifpb.model.PerfilUsuario;
import labrinco.ifpb.model.Usuario;

@SessionScoped
@Named("sessao")
public class Sessao implements Serializable {

	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void loga(Usuario usuario) {
		this.usuario = usuario;
	}

	public void desloga() {
		this.usuario = null;
	}

	public boolean estaLogado() {
		return this.usuario != null;
	}

	public boolean ehMinistrante() {
		return estaLogado()
				&& (this.usuario.getPerfil().getId() == PerfilUsuario.MINISTRANTE);
	}

}