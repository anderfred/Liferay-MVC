create table vacancy (
	id_ INTEGER not null primary key,
	publishedDate VARCHAR(75) null,
	employer VARCHAR(75) null,
	text_ VARCHAR(75) null,
	salary VARCHAR(75) null
);

create table vacancyArea (
	id_ INTEGER not null primary key,
	name VARCHAR(75) null
);

create table vacancySpec (
	id_ INTEGER not null primary key,
	name VARCHAR(75) null
);