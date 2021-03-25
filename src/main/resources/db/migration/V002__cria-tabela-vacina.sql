create table vacina(
	id bigint not null auto_increment,
    nome varchar(60) not null,
	usuario_id bigint not null,
    data_aplicacao datetime not null,
    
    primary key(id)
);

alter table vacina add constraint fk_vacina_usuario
foreign key (usuario_id) references usuario (id);