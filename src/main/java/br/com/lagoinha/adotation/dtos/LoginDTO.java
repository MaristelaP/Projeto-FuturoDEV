package br.com.lagoinha.adotation.dtos;

import jakarta.persistence.Column;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginDTO {

    private Long id;
    private String email;
    private String senha;
}
