package app.models;

import org.javalite.activejdbc.Model;

public class Deregistration extends Model {
	public static final String COL_NAME = "name";
	
	public static final int LEN_NAME = 100;
	
	public String getName() {
		return getString(COL_NAME);
	}
	
	public void setName(String name) {
		if (name.length() > LEN_NAME) {
			throw new IllegalArgumentException("Value '" + name + "' for field name exceeds maximum length " + LEN_NAME);
		}
		setString(COL_NAME, name);
	}

}
