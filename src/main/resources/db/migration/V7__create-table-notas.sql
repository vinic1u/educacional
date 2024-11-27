CREATE TABLE IF NOT EXISTS tb_nota (
    id int not null primary key auto_increment,
    matricula_id int,
    disciplina_id int,
    nota decimal(5,2),
    data_lancamento date,
    foreign key (matricula_id) references tb_matricula(id),
    foreign key (disciplina_id) references tb_disciplina(id)
);