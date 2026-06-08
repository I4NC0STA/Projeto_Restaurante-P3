/*
create database bancobertis;
use bancobertis;

create table cliente(
    id_cliente int primary key auto_increment,
    nome varchar(50) not null,
    telefone varchar(15) not null,
    numero_da_mesa int not null
);

create table pedido(
    id_pedido int primary key auto_increment,
    item_pedido varchar(100) not null,
    valor decimal(10, 2) not null,
    status_pedido varchar(20) default 'Pendente', 
    id_cliente int, 
    foreign key (id_cliente) references cliente(id_cliente), 
    constraint chk_status check (status_pedido in ('Pendente', 'Em preparo', 'Pronto'))
);