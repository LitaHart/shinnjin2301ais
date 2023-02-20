create table shainn_table (
	shainn_number varchar(12) primary key,
	shainn_name varchar(50) not null	
);

create table daily_table (
	shainn_number varchar(12) not null,
	hiduke date not null,
	touroku_kadaisuu integer not null,
	tassei_kadaisuu integer not null,
	tasseiritu integer not null,
	primary key(shainn_number,hiduke)
);

create table kadai_table (
	kadaikannri_number varchar(5) not null,
	shainn_number varchar(12) not null,
	tassei_yoteibi date not null,
	kadai_naiyou varchar(500) not null,
	tassei_kahi integer not null,
	kadai_tourokubi date not null,
	tassei_hiduke timestamp,
	primary key(shainn_number,tassei_yoteibi,kadaikannri_number)
);


select * from shainn_table;


