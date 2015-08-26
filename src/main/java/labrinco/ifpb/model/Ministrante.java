package labrinco.ifpb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "TB_MINISTRANTE")
public class Ministrante implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	public String nome;

	public String email;

	public String titulacao;

	public String biodata;

	@ManyToOne
	@JoinColumn(name = "minicurso_id")
	public Minicurso minicurso;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	public String getBiodata() {
		return biodata;
	}

	public void setBiodata(String biodata) {
		this.biodata = biodata;
	}

	public Minicurso getMinicurso() {
		return minicurso;
	}

	public void setMinicurso(Minicurso minicurso) {
		this.minicurso = minicurso;
	}

	@Override
	public String toString() {
		return "Ministrante [id=" + id + ", nome=" + nome + ", email=" + email
				+ ", titulacao=" + titulacao + ", biodata=" + biodata
				+ ", minicurso=" + minicurso + "]";
	}

}
