create table vacancy (
	id_ INTEGER not null primary key,
	publishedDate DATE null,
	employer VARCHAR(75) null,
	text_ VARCHAR(75) null,
	salary VARCHAR(75) null,
	area INTEGER,
	spec INTEGER
);