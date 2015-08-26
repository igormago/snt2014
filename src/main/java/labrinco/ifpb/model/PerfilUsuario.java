package labrinco.ifpb.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="TB_PERFIL_USUARIO")
public class PerfilUsuario implements Serializable {

	public static final int ADMIN = 1;
	public static final int ORGANIZADOR = 2;
	public static final int MINISTRANTE = 3;
	public static final int ALUNO = 4;

	@Id
	private long id;

	public String perfil;

	@OneToMany(mappedBy = "perfil")
	public Set<Usuario> usuarios;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
}
