package labrinco.ifpb.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "TB_EVENTO")
public class Evento implements Serializable{

	@Id
	@GeneratedValue
	private long id;

	public String nome;
	
	@OneToMany(mappedBy = "evento")
	public Set<Minicurso> minicursos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Minicurso> getMinicursos() {
		return minicursos;
	}

	public void setMinicursos(Set<Minicurso> minicursos) {
		this.minicursos = minicursos;
	}
	
	
}
