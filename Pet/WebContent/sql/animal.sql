drop table animal;

create table Animal (
	animal_no number primary key,
	kind varchar2(10),
	kg   number(6),
	user_no number
	 ,CONSTRAINT user_no foreign key(user_no) references userdata (user_no) ON DELETE CASCADE
);

