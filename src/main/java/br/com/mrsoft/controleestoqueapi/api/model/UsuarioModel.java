package br.com.mrsoft.controleestoqueapi.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Getter
@Setter
public class UsuarioModel {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "Fulado de Tal")
    private String nome;

    @Schema(example = "0000000000")
    private String cpf;

    @Schema(example = "abc123")
    private String matricula;

    private LocalDate dataNascimento;

    @Schema(example = "abc@example.com")
    private String email;

    @Schema(example = "99 999999999")
    private String telefone;

    @Schema(example = "abc123")
    private String criadoPor;

    @Schema(example = "abc123")
    private String alteradoPor;

    private OffsetDateTime dataHoraCriacao;
    private OffsetDateTime dataHoraAlteracao;

    @Schema(example = "1")
    private Integer versao;
}
