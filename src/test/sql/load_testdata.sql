insert into registrations 
	(
		email,
		phone,
		remarks
	) 
	values 
	(
		'hans.muster@email.com',
		'0791234567', 
		NULL
	);

insert into persons
	(
		registration_id,
		first_name,
		last_name
	)
	select regs.id, 'Hans', 'Muster' 
	from registrations regs
	where regs.email='hans.muster@email.com';