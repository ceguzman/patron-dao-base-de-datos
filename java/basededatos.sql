create table tipo_documento(
	sigla varchar(40),
	nombre varchar(60) not null,
	estado varchar(20) not null,
	constraint pk_sigla primary key(sigla)
);

create table cliente(
	sigla varchar(40),
	numero_documento varchar(40),
	nombres varchar(100) not null,
	apellidos varchar(100) not null,
 	primary key(sigla,numero_documento)
);

alter table cliente add foreign key (sigla) references tipo_documento(sigla);

create table cliente(
	sigla varchar(40),
	numero_documento varchar(40),
	nombres varchar(100) not null,
	apellidos varchar(100) not null,
 	primary key(sigla,numero_documento),
	constraint fk_sig_tipo foreign key (sigla) references tipo_documento(sigla) on update cascade
);
