package labrinco.ifpb.controller;

import java.util.List;

import javax.inject.Inject;

import labrinco.ifpb.model.Evento;
import labrinco.ifpb.model.Minicurso;
import labrinco.ifpb.rules.LoggedHandler;
import labrinco.ifpb.rules.LoginRule;
import labrinco.ifpb.service.EventoService;
import labrinco.ifpb.service.MinicursoService;
import br.com.caelum.brutauth.auth.annotations.CustomBrutauthRules;
import br.com.caelum.brutauth.auth.annotations.HandledBy;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Controller
@HandledBy(LoggedHandler.class)
public class EventoController {

	@Inject
	private MinicursoService minicursoService;

	@Inject
	private EventoService eventoService;

	private Validator validator;
	private Result result;

	@Inject
	public EventoController(Result result, Validator validator,
			MinicursoService service) {
		this.result = result;
		this.validator = validator;
		this.minicursoService = service;
	}

	public EventoController() {
		this(null, null, null);
	}

	@Path("/evento/form")
	@CustomBrutauthRules(LoginRule.class)
	public void form() {


	}

	@Post("/evento")
	@CustomBrutauthRules(LoginRule.class)
	public void adiciona(Minicurso minicurso) {
		validator.onErrorForwardTo(this).form();
		System.out.println(minicurso);
		minicursoService.adiciona(minicurso);
		result.redirectTo(EventoController.class).form();
	}

	public List<Evento> lista() {
		return eventoService.listaTodos();
	}

}
