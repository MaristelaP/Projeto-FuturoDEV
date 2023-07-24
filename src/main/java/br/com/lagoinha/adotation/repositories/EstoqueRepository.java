package br.com.lagoinha.adotation.repositories;

import br.com.lagoinha.adotation.entities.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    Optional<Estoque> findById(Long id);



}
