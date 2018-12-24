<@content for="title">Anmeldung</@>

<@content for="js">
	<script src="/js/forms.js" ></script>
</@>

<h1>Anmeldung</h1>
<@form action="submitRegistration" method="POST">
	<div class="labeled-input">
		<label for="person_count">Anzahl Gäste</label>
		<input type="number" name="person_count" id="person_count" value="2" min="1" onchange="addRemovePersonFields()" onload="addRemovePersonFields()"/>
	</div>
	
	<div id="person_container" class=*register">
	</div>
	<script>
		addRemovePersonFields();
	</script>
			
	<div class="labeled-input">
		<label for="email">E-Mail</label>
		<input type="email" name="email" id="email" required maxlength="100" />
	</div>
	
	<div class="labeled-input">
		<label for="phone">Telefon</label>
		<input type="text" name="phone" id="phone" required maxlength="20" pattern="^[\+0][0-9\s]*$" />
	</div>

	<div class="labeled-input">
		<label for="remarks">Bemerkungen</label>
		<textarea name="remarks" id="remarks" maxlength="1000"></textarea>
		<br/>
		Bitte gib hier an, falls du ein vegetarisches Menü möchtest oder an Lebensmittelunverträglichkeiten leidest. 
	</div>
	
	<div class="submit-button">
		<button type="submit">Absenden</button>
	</div>
</@>