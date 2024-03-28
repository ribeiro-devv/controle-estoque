package br.com.mrsoft.controleestoqueapi.api.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Getter
@Setter
public class UsuarioInput {

    @Schema(example = "Fulado de Tal")
    @NotBlank
    @Size(min = 5,max = 60)
    private String nome;

    @Schema(example = "0000000000")
    @NotBlank
    @Size(max = 11)
    @CPF
    private String cpf;

    @Schema(example = "abc123")
    @NotBlank
    @Size(min = 5, max = 255)
    private String matricula;

    @NotNull
    @PastOrPresent
    private LocalDate dataNascimento;

    @Schema(example = "abc@example.com")
    @NotBlank
    @Size(max = 80)
    @Email
    private String email;

    @Schema(example = "99 999999999")
    @NotBlank
    @Size(max = 20)
    private String telefone;

    @Schema(example = "*********")
    @NotBlank
    private String senha;
}
