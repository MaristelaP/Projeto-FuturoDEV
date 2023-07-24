package br.com.lagoinha.adotation.dtos;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProdutoEditDTO {

    private Long id;

    private String produto;

    private Integer quantidade;

}
