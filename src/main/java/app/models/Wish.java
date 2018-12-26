package app.models;

import org.javalite.activejdbc.Model;

public class Wish extends Model {

	public static final String COL_ID = "id";
	public static final String COL_TITLE = "title";
	public static final String COL_DESCRIPTION = "description";
	public static final String COL_IMAGE = "image";
	public static final String COL_IMAGE_MIMETYPE = "image_mimetype";
	
	public static final int LEN_TITLE = 100; 
	public static final int LEN_DESCRIPTION = 1000;
	public static final int LEN_IMAGE_MIMETYPE = 100;
	
	
	public String getTitle() {
		return getString(COL_TITLE);
	}

	public void setTitle(String title) {
		if (title.length() > LEN_TITLE) {
			throw new IllegalArgumentException("Value '" + title + "' for field title exceeds maximum length " + LEN_TITLE);
		}
		set(COL_TITLE, title);
	}
	
	public String getDescription() {
		return getString(COL_DESCRIPTION);
	}
	
	public void setDescription(String description) {
		if (description.length() > LEN_DESCRIPTION) {
			throw new IllegalArgumentException("Value '" + description + "' for field description exceeds maximum length " + LEN_DESCRIPTION);
		}
		set(COL_DESCRIPTION, description);
	}
	
	public byte[] getImage() {
		return getBytes(COL_IMAGE);
	}
	
	public void setImage(byte[] image) {
		set(COL_IMAGE, image);
	}
	
	public String getImageMimetype() {
		return getString(COL_IMAGE_MIMETYPE);
	}
	
	public void setImageMimetype(String imageMimetype) {
		if (imageMimetype.length() > LEN_IMAGE_MIMETYPE) {
			throw new IllegalArgumentException("Value '" + imageMimetype + "' for field imageMimetype exceeds maximum length " + LEN_IMAGE_MIMETYPE);
		}
		set(COL_IMAGE_MIMETYPE, imageMimetype);
	}
}
