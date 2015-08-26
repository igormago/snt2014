package labrinco.ifpb.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "TB_USUARIO")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue
	private long id;

	public String email;

	public String senha;

	public String nome;

	@ManyToOne
	@JoinColumn(name = "perfil_id")
	public PerfilUsuario perfil;

	@OneToMany(mappedBy = "usuario")
	public Set<Minicurso> minicursos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public PerfilUsuario getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilUsuario perfil) {
		this.perfil = perfil;
	}

	public Set<Minicurso> getMinicursos() {
		return minicursos;
	}

	public void setMinicursos(Set<Minicurso> minicursos) {
		this.minicursos = minicursos;
	}

}
