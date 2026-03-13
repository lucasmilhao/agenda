create database if not exists agenda;
use agenda;
create Table contato(
    contato_id BIGINT PRIMARY key not null AUTO_INCREMENT not null,
    nome varchar(60) not null,
    telefone varchar(12) not null,
    email varchar(60),
    data_nascimento DATE not null

)

