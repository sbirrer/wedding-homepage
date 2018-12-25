package app.controllers;

import org.junit.Test;

public class RegistrationControllerSpec extends NavigationSpec {
	
	@Test
	public void testIndex() {
		request().get("index");
		a(responseContent()).shouldContain("<title>Anmeldung</title>");
		
		verifyNavigation();
		
		a(text("div.link-button:first-child")).shouldEqual("Wir nehmen gerne teil");
		a(text("div.link-button:last-child")).shouldEqual("Wir sind leider verhindert");
	}

	@Test
	public void testRegistrationForm() {
		request().get("registrationForm");
		a(responseContent()).shouldContain("<title>Anmeldung</title>");
		
		verifyNavigation();
		
		a(text("h1")).shouldContain("Anmeldung"); 
	}
	
	@Test
	public void testDeregistrationForm() {
		request().get("deregistrationForm");
		a(responseContent()).shouldContain("<title>Abmeldung</title>");
		
		verifyNavigation();
	}
	
	
}
