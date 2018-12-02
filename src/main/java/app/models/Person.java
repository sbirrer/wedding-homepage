package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

@Table("persons")
public class Person extends Model {
	public static final String COL_FIRST_NAME = "first_name";
	public static final String COL_LAST_NAME = "last_name";
	public static final String COL_REGISTRATION_ID = "registration_id";
	
	public static final int LEN_FIRST_NAME = 100;
	public static final int LEN_LAST_NAME = 100;
	
	public String getFirstName() {
		return getString(COL_FIRST_NAME);
	}
	
	public String getLastName() {
		return getString(COL_LAST_NAME);
	}
	
	public void setFirstName(String firstName) {
		setString(COL_FIRST_NAME, firstName);
	}
	
	public void setLastName(String lastName) {
		setString(COL_LAST_NAME, lastName);
	}
}
