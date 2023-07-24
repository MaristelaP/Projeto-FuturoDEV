package br.com.lagoinha.adotation.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estoque_id")
    private Long id;

    @Column( name = "nome_estoque", length = 15, nullable = false)
    private String nome;

    @Column(length = 10, nullable = false)
    private String animal;

    private Boolean situacao = true;
}
