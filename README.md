
# Projeto Educacional

Sistema backend educacional, como uma plataforma de gerenciamento de cursos e alunos para uma faculdade. Esse sistema poderia atender às necessidades de gerenciamento de alunos, cursos, turmas, professores e notas.

# Modelagem de Dados

![Modelagem de Dados](https://github.com/vinic1u/educacional/blob/main/readme_imgs/MER.png?raw=true)

# Relacionamentos

- Cursos possui várias Disciplinas (OneToMany).
- Cursos possui várias Turmas (OneToMany).
- Professores lecionam várias Disciplinas (OneToMany).
- Turmas têm vários Alunos por meio de Matriculas (ManyToMany).
- Matriculas relacionam Alunos e Turmas.
- Disciplinas têm várias Notas (OneToMany), associadas por Matriculas dos alunos.

# Funcionalidades do Backend

- Gerenciamento de Alunos: Cadastro, atualização, listagem e exclusão de alunos.
- Gerenciamento de Professores: Cadastro, atualização, listagem e exclusão de professores.
- Gerenciamento de Cursos e Disciplinas: Cadastro e manutenção de cursos e suas respectivas disciplinas.
- Gerenciamento de Turmas: Criação e gerenciamento das turmas por curso e semestre.
- Matrículas de Alunos: Inscrição dos alunos nas turmas, com validação de pré-requisitos e disponibilidade.
- Lançamento de Notas: Cadastro e atualização de notas de acordo com disciplinas e matrículas dos alunos.
- Relatórios de Desempenho Acadêmico: Consulta de boletins e desempenho por aluno, turma e disciplina.

# Etapas para Execução do Projeto

- Clonar o repositório
```bash
git clone https://github.com/vinic1u/educacional.git
```

- Criar um banco chamado educacional no mysql
- Rodar o mysql na porta 3306
- Iniciar a aplicação spring


# Documentação da API

Este repositório contém a documentação da API, gerada automaticamente pelo Swagger. A API oferece endpoints para realizar diversas operações.

Apos executar a aplicação com sucesso acesse o link para visualizar a documentação

http://localhost:8080/swagger-ui/index.html
