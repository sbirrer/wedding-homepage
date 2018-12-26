<@content for="title">Neuen Wunsch erstellen</@>

<@form action="create" method="POST" enctype="multipart/form-data">
	<div class="labeled-input">
		<label for="title">Titel</label>
		<input type="text" name="title" id="title" required maxlength="100" />
	</div>
	<div class="labeled-input">
		<label for="description">Beschreibung</label>
		<textarea name="description" id="description" maxlength="1000" ></textarea>
	</div>
	<div class="labeled-input">
		<label for="image">Bild</label>
		<input type="file" name="image" id="image" accept="image/jpeg,image/png" />
	</div>

	<div class="submit-button">
		<button type="submit">Absenden</button>
	</div>
</@>