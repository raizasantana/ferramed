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
nome varchar(50),
metrica1_id int,
metrica2_id int,
operador varchar(1),
foreign key(metrica1_id) references metrica(id),
foreign key(metrica2_id) references metrica(id)
);

create table coleta(
id int primary key not null auto_increment,
id_metrica int not null,
valor int not null,
observacao varchar(200),
data date,
foreign key (id_metrica) references metrica(id));

create table relatorio(
id int primary key not null auto_increment,
data_geracao date,
mes_inicio int not null,
ano_inicio int not null,
mes_fim int not null,
ano_fim int not null);

create table relatorio_metrica(
id int primary key auto_increment,
id_relatorio int not null,
id_metrica int not null,
foreign key(id_relatorio) references relatorio(id),
foreign key(id_metrica) references metrica(id));