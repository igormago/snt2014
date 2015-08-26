package labrinco.ifpb.controller;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import labrinco.ifpb.model.Evento;
import labrinco.ifpb.model.HorarioDisponivel;
import labrinco.ifpb.model.Minicurso;
import labrinco.ifpb.rules.LoggedHandler;
import labrinco.ifpb.rules.LoginRule;
import labrinco.ifpb.service.EventoService;
import labrinco.ifpb.service.HorarioDisponivelService;
import labrinco.ifpb.service.MinicursoService;
import labrinco.ifpb.sessao.Sessao;
import br.com.caelum.brutauth.auth.annotations.CustomBrutauthRules;
import br.com.caelum.brutauth.auth.annotations.HandledBy;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Controller
@HandledBy(LoggedHandler.class)
public class MinicursoController {

	@Inject
	private MinicursoService minicursoService;

	@Inject
	private EventoService eventoService;

	@Inject
	private HorarioDisponivelService horarioDisponivelService;

	private int qtdMinistrantes;

	private Validator validator;
	private Result result;

	@Inject
	private Sessao sessao;

	@Inject
	public MinicursoController(Result result, Validator validator,
			MinicursoService service) {
		this.result = result;
		this.validator = validator;
		this.minicursoService = service;
		qtdMinistrantes = 1;
	}

	public MinicursoController() {
		this(null, null, null);
	}

	@Path("/minicurso/form")
	@CustomBrutauthRules(LoginRule.class)
	public void form() {
		List<Evento> eventos = eventoService.listaTodos();
		List<HorarioDisponivel> horariosDisponiveis = horarioDisponivelService
				.listaTodos();
		result.include("eventos", eventos);
		result.include("horariosDisponiveis", horariosDisponiveis);
		result.include("qtdMinistrantes", 1);
		
	}

	@Post("/minicurso")
	@CustomBrutauthRules(LoginRule.class)
	public void adiciona(Minicurso minicurso) {

		validator.onErrorForwardTo(this).form();
		System.out.println(minicurso);
		minicursoService.adiciona(minicurso);

		result.include("mensagem", "Minicurso Cadastrado com sucesso!!!");
		result.redirectTo(MinicursoController.class).form();
	}

	@Get("/minicurso")
	@CustomBrutauthRules(LoginRule.class)
	public void lista() {
		System.out.println(sessao.getUsuario().getId());
		List<Minicurso> minicursos = minicursoService.buscaPorUsuario(sessao
				.getUsuario().getId());
		result.include("minicursos", minicursos);
	}

	@Get("/minicurso/adicionaministrante")
	public void adicionaMinistrante() {
		System.out.println(qtdMinistrantes);
		qtdMinistrantes = 8;
		result.include("qtdMinistrantes", qtdMinistrantes);
		System.out.println(qtdMinistrantes);
		result.redirectTo(MinicursoController.class).form();
	}

	@Delete("/minicurso")
	@CustomBrutauthRules(LoginRule.class)
	public void remove(Minicurso minicurso) {
		System.out.println("ei: " + sessao.getUsuario().getId());
		System.out.println("Minicursoo: " + minicurso.getId());
		result.redirectTo(MinicursoController.class).lista();
	}

}
