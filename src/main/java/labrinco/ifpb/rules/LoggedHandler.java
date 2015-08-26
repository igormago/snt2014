package labrinco.ifpb.rules;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import labrinco.ifpb.controller.LoginController;
import br.com.caelum.brutauth.auth.handlers.RuleHandler;
import br.com.caelum.vraptor.Result;

@RequestScoped
public class LoggedHandler implements RuleHandler{
    
	private final Result result;

    /**
     * @deprecated CDI eyes only
     */
    protected LoggedHandler() {
        this(null);
    }

    @Inject
    public LoggedHandler(Result result) {
        this.result = result;
    }

    @Override
    public void handle() {
        result.redirectTo(LoginController.class).form();
    }
}