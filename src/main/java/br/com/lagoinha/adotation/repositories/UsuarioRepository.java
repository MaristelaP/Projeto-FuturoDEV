package br.com.lagoinha.adotation.repositories;

import br.com.lagoinha.adotation.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmail(String email);


    //consulta o email e senha da tabela usuário para fazer a comparação
    /*
    @Query("SELECT usuario"+
            " FROM Usuario usuario "+
            "WHERE usuario.email = ?1 AND usuario.senha = ?2"
    )
    */

    boolean existsByEmailAndSenha(String email, String senha);

}

