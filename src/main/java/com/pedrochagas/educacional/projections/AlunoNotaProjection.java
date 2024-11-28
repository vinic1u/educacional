package com.pedrochagas.educacional.projections;

import java.time.LocalDate;

public interface AlunoNotaProjection {

    Double getNota();
    LocalDate getDataLancamento();
    String getAluno();
    String getDisciplina();

}
