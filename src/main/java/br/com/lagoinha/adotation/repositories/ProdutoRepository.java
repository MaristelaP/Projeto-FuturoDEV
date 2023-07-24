package br.com.lagoinha.adotation.repositories;

import br.com.lagoinha.adotation.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {


    Optional<Produto> findById(Long id);

    @Query("SELECT CASE WHEN (count(*) > 0) THEN TRUE ELSE FALSE END FROM Produto p WHERE p.estoque.id = :idEstoque")
    boolean existsByEstoque(Long idEstoque);

    @Query("SELECT p.estoque FROM Produto p WHERE p.estoque.id = :estoqueId ORDER BY p.estoque.id DESC")
    Optional<Produto> findByEstoque(Long estoqueId);
}
