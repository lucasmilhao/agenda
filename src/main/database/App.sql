use agenda;
create database agenda;
create Table contato(
    contato_id BIGINT PRIMARY key not null AUTO_INCREMENT,
    nome varchar(60),
    telefone varchar(12),
    email varchar(60),
    data_nascimento DATE
)