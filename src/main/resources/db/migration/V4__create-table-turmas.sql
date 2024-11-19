CREATE TABLE IF NOT EXISTS tb_turma (
    id int not null primary key auto_increment,
    ano int,
    semestre int,
    curso_id int,
    FOREIGN KEY (curso_id) REFERENCES tb_curso(id)
);