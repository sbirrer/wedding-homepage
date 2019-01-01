package app.controllers;

import java.util.HashMap;
import java.util.Map;

import org.javalite.activeweb.annotations.POST;

public class LoginController extends ExtendedController {
	public static final String PARAM_USERNAME = "username";
	public static final String PARAM_PASSWORD = "password";
	
	public static final String SESS_REDIRECT_URI = "redirectUri";
	public static final String SESS_USER = "user";

	private static final Map<String, String> users;
	static {
		users = new HashMap<String, String>();
		users.put("stefan", "blabla");
	}

	public void index() {
	}

	@POST
	public void login() {
		String username = getSingleStringParam(PARAM_USERNAME);
		String password = getSingleStringParam(PARAM_PASSWORD);

		if (!users.containsKey(username) || !users.get(username).equals(password)) {
			return;
		}
		
		String redirectUri = null;
		if (session().containsKey(SESS_REDIRECT_URI)) {
			redirectUri = (String) session().get(SESS_REDIRECT_URI);
		}

		session().setTimeToLive(600);
		session(SESS_USER, username);

		redirect(redirectUri != null ? redirectUri : "/home");
	}
}
