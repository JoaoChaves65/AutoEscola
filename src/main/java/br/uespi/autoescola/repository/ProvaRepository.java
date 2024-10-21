package br.uespi.autoescola.repository;

import br.uespi.autoescola.model.Prova;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvaRepository extends JpaRepository<Prova, Long> {
    
}
