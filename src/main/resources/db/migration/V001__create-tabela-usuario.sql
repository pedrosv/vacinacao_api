create table usuario(
	id bigint not null auto_increment,
    nome varchar(60) not null,
    email varchar(255) not null,
    cpf varchar(15),
    data_nascimento datetime not null,
    
    primary key(id)
);