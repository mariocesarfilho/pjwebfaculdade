package com.br.pjwebfaculdade.respository;

import com.br.pjwebfaculdade.model.Faculdade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaculdadeRepository extends JpaRepository<Faculdade, Long> {
}
