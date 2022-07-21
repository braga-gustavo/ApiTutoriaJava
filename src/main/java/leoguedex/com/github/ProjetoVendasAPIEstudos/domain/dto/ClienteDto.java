package leoguedex.com.github.ProjetoVendasAPIEstudos.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatorio.")
    @Length(min = 5, max = 120, message = "O tamanho deve estar entre 5 e 120 char.")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatorio.")
    @Email(message = "Email invalido! ")
    private String email;

    @NotEmpty(message = "Preenchimento obrigatorio.")
    @Length(min = 10, max = 15, message = "O tamanho deve estar entre 5 e 120 char.")
    private String telefone;

}
