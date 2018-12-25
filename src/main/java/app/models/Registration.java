package app.models;

import java.util.List;

import org.javalite.activejdbc.Model;

public class Registration extends Model {
	public static final String COL_EMAIL = "email";
	public static final String COL_PHONE = "phone";
	public static final String COL_REMARKS = "remarks";
	
	public static final int LEN_EMAIL = 100;
	public static final int LEN_PHONE = 20;
	public static final int LEN_REMARKS = 1000;
	
	public String getEmail() {
		return getString(COL_EMAIL);
	}
	
	public void setEmail(String email) {
		if (email.length() > LEN_EMAIL) {
			throw new IllegalArgumentException("Value '" + email + "' for field email exceeds maximum length " + LEN_EMAIL);
		}
		set(COL_EMAIL, email);
	}
	
	public String getPhone() {
		return getString(COL_PHONE);
	}
	
	public void setPhone(String phone) {
		if (phone.length() > LEN_PHONE) {
			throw new IllegalArgumentException("Value '" + phone + "' for field phone exceeds maximum length " + LEN_PHONE);
		}
		set(COL_PHONE, phone);
	}

	public String getRemarks() {
		return getString(COL_REMARKS);
	}
	
	public void setRemarks(String remarks) {
		if (remarks.length() > LEN_REMARKS) {
			throw new IllegalArgumentException("Value '" + remarks + "' for field remarks exceeds maximum length " + LEN_REMARKS);
		}
		set(COL_REMARKS, remarks);
	}
	
	public List<Person> getPersons() {
		return getAll(Person.class);
	}
}
