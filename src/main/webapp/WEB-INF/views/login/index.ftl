<@content for="title">Login</@>

<@form action="login" method="POST">
	<div class="labeled-input">
		<label for="username">Benutzername</label>
		<input type="text" name="username" id="username" required maxlength="100" />
	</div>
	<div class="labeled-input">
		<label for="password">Passwort</label>
		<input type="password" name="password" id="password" maxlength="100" required />
	</div>

	<div class="submit-button">
		<button type="submit">Absenden</button>
	</div>
</@>