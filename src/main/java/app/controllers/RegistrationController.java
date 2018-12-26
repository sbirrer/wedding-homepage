package app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.javalite.activeweb.annotations.POST;

import app.models.Deregistration;
import app.models.Person;
import app.models.Registration;

public class RegistrationController extends ExtendedController {
	protected static final String PARAM_PERSON_COUNT = "person_count";
	protected static final String PARAM_FIRST_NAME = "first_name_";
	protected static final String PARAM_LAST_NAME = "last_name_";
	protected static final String PARAM_EMAIL = "email";
	protected static final String PARAM_PHONE = "phone";
	protected static final String PARAM_REMARKS = "remarks";
	
	protected static final String PARAM_NAME = "name";
	
	public void index() {}
	
	public void registrationForm() {}
	
	public void deregistrationForm() {}
	
	@POST
	public void submitRegistration() {
		int personCount = getSingleIntParam(PARAM_PERSON_COUNT);
		
		List<Person> personList = new ArrayList<Person>();
		for (int i = 0; i < personCount; i++) {
			String firstName = getSingleStringParam(PARAM_FIRST_NAME + i, Person.LEN_FIRST_NAME);
			String lastName = getSingleStringParam(PARAM_LAST_NAME + i, Person.LEN_LAST_NAME);
			
			Person p = new Person();
			p.setFirstName(firstName);
			p.setLastName(lastName);
			
			personList.add(p);
		}
		

		String email = getSingleStringParam(PARAM_EMAIL, Registration.LEN_EMAIL);
		String phone = getSingleStringParam(PARAM_PHONE, Registration.LEN_PHONE);
		
		String remarks = null;
		if (params(PARAM_REMARKS).size() > 0) {
			remarks = getSingleStringParam(PARAM_REMARKS, Registration.LEN_REMARKS);
		}
				
		Registration r = new Registration();
		r.setEmail(email);
		r.setPhone(phone);
		if (remarks != null) {
			r.setRemarks(remarks);
		}
		
		r.saveIt();

		for (Person p: personList) {
			r.add(p);
		}
	}
	
	@POST
	public void submitDeregistration() {
		String name = getSingleStringParam(PARAM_NAME, Deregistration.LEN_NAME); 
		
		Deregistration d = new Deregistration();
		
		d.setName(name);
		
		d.saveIt();
	}
}
