package app.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;;

public class WishControllerSpec extends NavigationSpec {

	@Test
	public void testNewForm() {
		request().get("newForm");
		
		a(text("div.labeled-input:nth-child(1)")).shouldEqual("Titel");
		a(text("div.labeled-input:nth-child(2)")).shouldEqual("Beschreibung");
		a(text("div.labeled-input:nth-child(3)")).shouldEqual("Bild");
		
		a(text("button")).shouldEqual("Absenden");
	}
	
	private byte[] readResourceBytes(String name) throws IOException {
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(name);
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		
		byte[] buffer = new byte[1024];
		
		int bytesRead = 0;
		while((bytesRead = is.read(buffer)) > 0) {
			os.write(buffer, 0, bytesRead);
		}
		
		return os.toByteArray();
	}
	
	@Test
	public void testCreate() throws IOException {
		final String TEST_TITLE = "Mein Test Titel";
		final String TEST_DESCRIPTION = "Meine Test Beschreibung";
		byte[] imageBytes = readResourceBytes("wish1.png");
		
		request().contentType("multipart/form-data")
			.formItem("title", TEST_TITLE)
			.formItem("description",  TEST_DESCRIPTION)
			.formItem("wish1.png", "image", true, "image/png", imageBytes)
			.post("create");
		
		a(responseContent()).shouldContain("Wunsch erfolgreich erstellt");
		
		a(text("dt:nth-of-type(1)")).shouldEqual("ID");
		a(text("dt:nth-of-type(2)")).shouldEqual("Titel");
		a(text("dd:nth-of-type(2)")).shouldEqual(TEST_TITLE);
		a(text("dt:nth-of-type(3)")).shouldEqual("Beschreibung");
		a(text("dd:nth-of-type(3)")).shouldEqual(TEST_DESCRIPTION);
		a(text("dt:nth-of-type(4)")).shouldEqual("Bild");
	}
	
	@Test
	public void testGetImage() throws IOException {
		final String TEST_TITLE = "Mein Test Titel";
		final String TEST_DESCRIPTION = "Meine Test Beschreibung";
		byte[] imageBytes = readResourceBytes("wish1.png");
		
		request().contentType("multipart/form-data")
		.formItem("title", TEST_TITLE)
		.formItem("description",  TEST_DESCRIPTION)
		.formItem("wish1.png", "image", true, "image/png", imageBytes)
		.post("create");
		
		String id = text("dd:first-of-type");
		
		request().params("id", id).get("getImage");
		
		a(statusCode()).shouldEqual(200);
		a(contentType()).shouldEqual("image/png");
		byte[] receivedData = bytesContent();
		
		a(receivedData.length).shouldEqual(imageBytes.length);
		for (int i = 0; i < receivedData.length; i++) {
			a(receivedData[i]).shouldEqual(imageBytes[i]);
		}
	}
}
