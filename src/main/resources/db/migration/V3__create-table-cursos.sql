CREATE TABLE IF NOT EXISTS tb_curso (
    id int not null primary key auto_increment,
    nome varchar(100),
    codigo varchar(20),
    carga_horaria int
);