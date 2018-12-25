package app.controllers;

import org.javalite.activeweb.DBControllerSpec;

public abstract class NavigationSpec extends DBControllerSpec {
	
	protected void verifyNavigation() {
		a(count("nav li")).shouldEqual(4);
		
		a(text("nav li:nth-child(1)")).shouldEqual("Home");
		a(text("nav li:nth-child(2)")).shouldEqual("Anmeldung");
	}

}
