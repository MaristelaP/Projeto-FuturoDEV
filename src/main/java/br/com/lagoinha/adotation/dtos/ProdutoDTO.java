package br.com.lagoinha.adotation.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class ProdutoDTO {

    private Long id;

    private Long estoque;

    private String animal;

    private String produto;

    private Integer quantidade;

    private String categoria;

}
