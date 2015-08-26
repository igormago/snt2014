package labrinco.ifpb.controller;

import javax.inject.Inject;

import labrinco.ifpb.model.PerfilUsuario;
import labrinco.ifpb.model.Usuario;
import labrinco.ifpb.rules.LoggedHandler;
import labrinco.ifpb.rules.LoginRule;
import labrinco.ifpb.service.UsuarioService;
import br.com.caelum.brutauth.auth.annotations.CustomBrutauthRules;
import br.com.caelum.brutauth.auth.annotations.HandledBy;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
@HandledBy(LoggedHandler.class)
public class UsuarioController {

	@Inject
	private UsuarioService service;
	
	private Validator validator;
	private Result result;

	@Inject
	public UsuarioController(Result result, Validator validator) {
		this.result = result;
		this.validator = validator;
	}

	public UsuarioController() {
		this(null,null);
	}

	@Path("/usuario/novo")
	@CustomBrutauthRules(LoginRule.class)
	public void form() {
		
	}

	@Post("/usuario")
	public void cadastra(Usuario usuario, String confirmarSenha) {
		
		Usuario usuarioResposta = service.buscaPorEmail(usuario.getEmail());
		
		if (usuarioResposta == null) {
		
			if (!usuario.getSenha().equals(confirmarSenha)) {
				validator.add(new SimpleMessage("erro.cadastra",
				        "Senhas não estão iguais"));
			}
			
		} else {
			
			validator.add(new SimpleMessage("erro.cadastra",
			        "Este e-mail já está cadastrado"));
		}
		
		
		validator.onErrorForwardTo(LoginController.class).form();
		service.adiciona(usuario);
		
		result.include("mensagem","Usuário Cadastrado com sucesso!!!");
		result.redirectTo(UsuarioController.class).form();
		
	}
	

}
