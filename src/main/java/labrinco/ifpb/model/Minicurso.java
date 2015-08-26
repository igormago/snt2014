package labrinco.ifpb.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "TB_MINICURSO")
public class Minicurso implements Serializable {

	@Id
	@GeneratedValue
	private long id;

	public String titulo;

	@Column(name = "publico_alvo")
	public String publicoAlvo;

	public String resumo;

	public int vagas;

	@Column(name = "carga_horaria")
	public int cargaHoraria;

	@Column(name = "recursos_didaticos")
	public String recursosDidaticos;

	public String observacoes;

	@ManyToOne
	@JoinColumn(name = "evento_id")
	public Evento evento;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	public Usuario usuario;

	@OneToMany(mappedBy = "minicurso")
	public Set<Ministrante> ministrantes;

	@ManyToMany
	@JoinTable(name = "TB_MINICURSO_HORARIO_DISPONIVEL", joinColumns = { @JoinColumn(name = "minicurso_id") }, inverseJoinColumns = { @JoinColumn(name = "horario_disponivel_id") })
	public Set<HorarioDisponivel> horariosDisponiveis;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPublicoAlvo() {
		return publicoAlvo;
	}

	public void setPublicoAlvo(String publicoAlvo) {
		this.publicoAlvo = publicoAlvo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getRecursosDidaticos() {
		return recursosDidaticos;
	}

	public void setRecursosDidaticos(String recursosDidaticos) {
		this.recursosDidaticos = recursosDidaticos;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Ministrante> getMinistrantes() {
		return ministrantes;
	}

	public void setMinistrantes(Set<Ministrante> ministrantes) {
		this.ministrantes = ministrantes;
	}
	
	

	public Set<HorarioDisponivel> getHorariosDisponiveis() {
		return horariosDisponiveis;
	}

	public void setHorariosDisponiveis(Set<HorarioDisponivel> horariosDisponiveis) {
		this.horariosDisponiveis = horariosDisponiveis;
	}

	@Override
	public String toString() {
		return "Minicurso [id=" + id + ", titulo=" + titulo + ", publicoAlvo="
				+ publicoAlvo + ", resumo=" + resumo + ", vagas=" + vagas
				+ ", cargaHoraria=" + cargaHoraria + ", recursosDidaticos="
				+ recursosDidaticos + ", observacoes=" + observacoes
				+ ", evento=" + evento + ", usuario=" + usuario + "]";
	}

}
