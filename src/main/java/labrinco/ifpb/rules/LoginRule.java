package labrinco.ifpb.rules;

import javax.inject.Inject;

import labrinco.ifpb.sessao.Sessao;
import br.com.caelum.brutauth.auth.rules.CustomBrutauthRule;

public class LoginRule implements CustomBrutauthRule {

	@Inject
	private Sessao sessao;

	public boolean isAllowed() {
		return sessao.estaLogado();
	}

}
