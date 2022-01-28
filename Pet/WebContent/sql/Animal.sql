create table Animal (
	animal_no number primary key,
	kind varchar2(10) not null,
	kg   number(6) not null,
	user_no number not null,
		CONSTRAINT animal_user FOREIGN KEY(user_no) REFERENCES UserData(user_no) ON DELETE CASCADE);
);

insert into animal(animal_no, kind, kg, user_no) 
	values(1, 'cat', 9, 1);