CREATE TABLE usuario (
    id serial PRIMARY KEY,
    nome varchar(60) NOT NULL,
    cpf varchar(11) NOT NULL,
    matricula varchar(20) NOT NULL,
    data_nascimento date NOT NULL,
    email varchar(80) NOT NULL,
    senha varchar(300) NOT NULL,
    telefone varchar(20),
    aud_criado_por varchar(20),
    aud_alterado_por varchar(20),
    aud_data_hora_criacao timestamp DEFAULT CURRENT_TIMESTAMP,
    aud_data_hora_alteracao timestamp DEFAULT CURRENT_TIMESTAMP,
    versao integer
);