create database ferramed;

use ferramed;

create table indicador(
id int primary key auto_increment,
descricao varchar(50),
meta float);

create table metrica(
id int primary key not null auto_increment,
processo_coleta varchar(200),
processo_analise varchar(200),
valor float,
tipo varchar(50),
nome varchar(50));

create table formula(
id int primary key not null auto_increment,
nome varchar(50)
);

create table metrica_formula(
id int primary key not null auto_increment,
id_metrica int not null,
id_formula int not null,
foreign key(id_metrica) references metrica(id),
foreign key(id_formula) references formula(id));

create table periodo(
id int primary key auto_increment,
mes int not null,
ano int not null);

create table relatorio(
id int primary key not null auto_increment,
data_geracao date,
id_periodo_inicio int not null,
id_periodo_fim int not null,
foreign key(id_periodo_inicio) references periodo(id),
foreign key(id_periodo_fim) references periodo(id));

create table relatorio_metrica(
id int primary key auto_increment,
id_relatorio int not null,
id_metrica int not null,
foreign key(id_relatorio) references relatorio(id),
foreign key(id_metrica) references metrica(id));
