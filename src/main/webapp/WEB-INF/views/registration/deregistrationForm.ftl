<@content for="title">Abmeldung</@>

<h1>Abmeldung</h1>

<@form action="submitDeregistration" method="POST">

	<div class="labeled-input">
		<label for="name">Name</label>
		<input type="text" name="name" id="name" required maxlength="100" />
	</div>
	
	<div class="submit-button">
		<button type="submit">Absenden</button>
	</div>
</@>