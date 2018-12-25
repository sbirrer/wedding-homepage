package app.controllers;

import org.junit.Test;

public class HomeControllerSpec extends NavigationSpec {

	@Test
	public void testTitle() {
		request().get("index");
		
		a(responseContent()).shouldContain("<title>Home</title>");
	}
	
	@Test
	public void testNavigation() {
		request().get("index");
		
		verifyNavigation();
	}
}
