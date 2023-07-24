package br.com.lagoinha.adotation.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Usuario {

    @Id
    @Column(name = "usuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (length = 60, nullable = false)
    private String nome;

    @Column (length = 40, nullable = false)
    private String email;

    @Column (length = 8, nullable = false)
    private String senha;
}
