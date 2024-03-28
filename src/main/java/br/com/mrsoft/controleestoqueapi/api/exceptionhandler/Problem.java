package br.com.mrsoft.controleestoqueapi.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Schema(name="Problema")
public class Problem {

    @Schema(example = "400")
    private Integer status;

    private OffsetDateTime dataHoraErro;

    @Schema(example = "https://mrsoft.com.br/dados-invalidos")
    private String tipo;

    @Schema(example = "Dados inválidos")
    private String titulo;

    @Schema(example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.")
    private String descricao;

    @Schema(example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.")
    private String usuarioMensagem;

    @Schema(description = "Lista de objetos ou campos que geraram o erro (opcional)")
    private List<Object> camposComErro;

    @Schema(name = "Objeto Problema")
    @Getter
    @Builder
    public static class Object{

        @Schema(example = "nome")
        private String campo;

        @Schema(example = "é obrigatório")
        private String descricaoErro;
    }
}
