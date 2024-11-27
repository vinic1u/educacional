CREATE TABLE  IF NOT EXISTS tb_matricula (
    id int not null primary key auto_increment,
    aluno_id int,
    turma_id int,
    foreign key (aluno_id) references tb_aluno(id),
    foreign key (turma_id) references tb_turma(id)
);