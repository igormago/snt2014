package labrinco.ifpb.controller;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.inject.Inject;

import labrinco.ifpb.model.Usuario;
import labrinco.ifpb.rules.LoggedHandler;
import labrinco.ifpb.service.UsuarioService;
import labrinco.ifpb.sessao.Sessao;
import br.com.caelum.brutauth.auth.annotations.HandledBy;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
@HandledBy(LoggedHandler.class)
public class LoginController {

	@Inject
	private UsuarioService usuarioService;

	private Result result;

	@Inject
	private Sessao sessao;
	private Validator validator;

	@Inject
	public LoginController(Result result, Validator validator) {
		this.result = result;
		this.validator = validator;
	}

	public LoginController() {
		this(null, null);
	}

	@Path("/")
	public void index() {

	}

	@Path("/login")
	public void form() {

	}

	@Post("/login/loga")
	public void loga(Usuario usuario) {
		try {
			this.createPdf("teste.pdf");
			System.out.println("CIROU");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Usuario usuarioResposta = usuarioService.buscaPorEmail(usuario
				.getEmail());

		if (usuarioResposta != null) {
			Usuario usuarioLogado = usuarioResposta;
			if (usuario.getSenha().equals(usuarioResposta.getSenha())) {
				sessao.loga(usuarioLogado);
				result.redirectTo(MinicursoController.class).form();
			} else {
				validator.add(new SimpleMessage("erro.loga",
						"Senha inválida. Tente Novamente"));
			}
		} else {
			validator.add(new SimpleMessage("erro.loga",
					"E-mail não cadastrado"));
		}
		validator.onErrorForwardTo(this).form();
	}

	@Path("/logout")
	public void logout() {

		sessao.desloga();

		result.redirectTo(LoginController.class).index();

	}

	public void createPdf(String filename) throws DocumentException,
			IOException {
		// step 1
		Document document = new Document();
		// step 2
		PdfWriter.getInstance(document, new FileOutputStream(filename));
		// step 3
		document.open();
		// step 4
		document.add(new Paragraph("Hello World!"));
		// step 5
		document.close();
	}

}
