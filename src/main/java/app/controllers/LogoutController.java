package app.controllers;

import org.javalite.activeweb.AppController;

public class LogoutController extends AppController {
	
	public void index() {
		session().invalidate();
	}
}
