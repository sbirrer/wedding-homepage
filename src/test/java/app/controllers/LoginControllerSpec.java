package app.controllers;

import org.junit.Test;

public class LoginControllerSpec extends NavigationSpec {
	
	@Test
	public void testIndex() {
		request().get("index");
		
		verifyNavigation();
		
		a(text("div.labeled-input:nth-child(1)")).shouldEqual("Benutzername");
		a(text("div.labeled-input:nth-child(2)")).shouldEqual("Passwort");
		a(text("div.submit-button")).shouldEqual("Absenden");
	}
	
	@Test
	public void testLoginSuccess() {
		request()
			.param(LoginController.PARAM_USERNAME, "stefan")
			.param("password", "blabla")
			.post("login");
		
		a(header("Location")).shouldContain("/home");
		a(session().get(LoginController.SESS_USER)).shouldNotBeNull();
	}

	@Test
	public void testLoginFailure() {
		request()
			.param("username", "someone")
			.param("password", "incorrectPassword")
			.post("login");
		
		a(text("div.error-message")).shouldEqual("Benutzername oder Passwort ungültig");
	}
}
