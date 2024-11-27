package com.pedrochagas.educacional.repositories;

import com.pedrochagas.educacional.entities.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota,Integer> {

}
