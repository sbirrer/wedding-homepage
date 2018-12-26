package app.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.javalite.activeweb.FormItem;
import org.javalite.activeweb.annotations.POST;

import app.models.Wish;

public class WishController extends ExtendedController {
	
	protected static final String PARAM_ID = "id";
	protected static final String PARAM_TITLE = "title";
	protected static final String PARAM_DESCRIPTION = "description";
	protected static final String PARAM_IMAGE = "image";

	public void newForm() {}
	
	private byte[] readBytes(InputStream is, int maxLength) throws IOException {
		int totalBytes = 0;
		int bytesRead = 0;
		
		byte[] buffer = new byte[1024];
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		
		while ((bytesRead = is.read(buffer)) > 0) {
			if (totalBytes + bytesRead > maxLength) {
				throw new IllegalArgumentException("InputStream exceeds maximum length (" + maxLength + " bytes)");
			}
			os.write(buffer, 0, bytesRead);
			
			totalBytes += bytesRead;
		}
		
		return os.toByteArray();
	}
	
	@POST
	public void create() throws IOException {		
		Wish wish = new Wish();
				
		List<FormItem> items = multipartFormItems();
		for (FormItem item: items) {
			if (item.getFieldName().equals(PARAM_TITLE)) {
				if (!item.isFormField()) {
					throw new IllegalArgumentException("Field with name '" + PARAM_TITLE + "' is expected to be a form field, but it's not.");
				}
				wish.setTitle(item.getStreamAsString());
			}
			if (item.getFieldName().equals(PARAM_DESCRIPTION)) {
				if (!item.isFormField()) {
					throw new IllegalArgumentException("Field with name '" + PARAM_DESCRIPTION + "' is expected to be a form field, but it's not.");
				}
				wish.setDescription(item.getStreamAsString());
			}
			if (item.getFieldName().equals(PARAM_IMAGE)) {
				if (!item.isFile()) {
					throw new IllegalArgumentException("Field with name '" + PARAM_IMAGE + "' is expected to be a file, but it's not.");
				}
				String contentType = item.getContentType();
				if (!contentType.equals("image/jpeg") && !contentType.equals("image/png")) {
					throw new IllegalArgumentException("Unsupported content-type '" + contentType + "'");
				}
				byte[] imageBytes = readBytes(item.getInputStream(), 2 * 1024 * 1024 /* 2 MB */);
				wish.setImage(imageBytes);
				wish.setImageMimetype(contentType);
			}
		}

		if (wish.getTitle() == null) {
			throw new IllegalArgumentException("Mandatory form item '" + PARAM_TITLE + "' not found.");
		}
		if (wish.getDescription() == null) {
			throw new IllegalArgumentException("Mandatory form item '" + PARAM_DESCRIPTION + "' not found.");
		}
		wish.saveIt();
		
		view("id", wish.getLongId());
		view("title", wish.getTitle());
		view("description", wish.getDescription());
	}
	
	public void getImage() throws IOException {
	int id = getSingleIntParam(PARAM_ID);
		
		Wish wish = Wish.findById(id);
		if (wish == null) {
			render().status(404);
		}
		
		outputStream(wish.getImageMimetype()).write(wish.getImage());
	}
}
