CREATE TABLE IF NOT EXISTS tb_professor (

    id int not null primary key auto_increment,
    nome varchar(100),
    email varchar(100),
    telefone varchar(15),
    especialidade varchar(100)
);