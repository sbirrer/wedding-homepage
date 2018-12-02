function addRemovePersonFields() {
	
	var personCount = document.getElementById("person_count").value;
	
	var container = document.getElementById("person_container");
	
	while(container.childElementCount < personCount) {
		var child = createPersonFields(container.childElementCount); 
		container.appendChild(child);
	}
	
	while(container.childElementCount > personCount) {
		var child = container.children[container.childElementCount - 1];
		container.removeChild(child);
	}
}

function createPersonFields(index) {
	var fieldset = document.createElement("fieldset");
	
	var legend = document.createElement("legend");
	legend.appendChild(document.createTextNode("Gast " + (index + 1)));
	
	fieldset.appendChild(legend);
	
	var div_firstname = document.createElement("div");
	div_firstname.className = "labeled-input";
	
	var label_firstname = document.createElement("label");
	label_firstname.for = "first_name_" + index;
	label_firstname.appendChild(document.createTextNode("Vorname"));
	
	div_firstname.appendChild(label_firstname);
	
	var input_firstname = document.createElement("input");
	input_firstname.type = "text";
	input_firstname.name = "first_name_" + index;
	input_firstname.id = "first_name_" + index;
	input_firstname.required = true;
	input_firstname.maxlength = 100;
	
	div_firstname.appendChild(input_firstname);
	
	fieldset.appendChild(div_firstname);
	
	var div_lastname = document.createElement("div");
	div_lastname.className = "labeled-input";
	
	var label_lastname = document.createElement("label");
	label_lastname.for = "last_name_" + index;
	label_lastname.appendChild(document.createTextNode("Nachname"));
	
	div_lastname.appendChild(label_lastname);
	
	var input_lastname = document.createElement("input");
	input_lastname.type = "text";
	input_lastname.name = "last_name_" + index;
	input_lastname.id = "last_name_" + index;
	input_lastname.required = true;
	input_lastname.maxlength = 100;
	
	div_lastname.appendChild(input_lastname);

	fieldset.appendChild(div_lastname);
	
	return fieldset;
}