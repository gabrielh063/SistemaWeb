create database cidade

use cidade

select * from cidades

create table cidades (
	idCidade int primary key auto_increment not null,
	nomeCidade varchar(255) not null,
	uf varchar(2) not null,
	cep varchar(8) not null,
	populacao varchar(255) not null
)

