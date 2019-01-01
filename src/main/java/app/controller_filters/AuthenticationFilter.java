package app.controller_filters;

import org.javalite.activeweb.controller_filters.HttpSupportFilter;

import app.controllers.LoginController;

public class AuthenticationFilter extends HttpSupportFilter {
	@Override
	public void before() {
		if (!sessionHas("user")) {
			session(LoginController.SESS_REDIRECT_URI, uri());
			redirect(LoginController.class);
		}
	}

}
