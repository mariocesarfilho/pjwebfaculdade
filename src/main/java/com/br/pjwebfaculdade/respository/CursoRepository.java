package com.br.pjwebfaculdade.respository;

import com.br.pjwebfaculdade.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
