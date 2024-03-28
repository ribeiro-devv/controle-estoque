package br.com.mrsoft.controleestoqueapi.api.openapi.controller;


import br.com.mrsoft.controleestoqueapi.api.model.UsuarioModel;
import br.com.mrsoft.controleestoqueapi.api.model.input.UsuarioInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Usuario")
public interface UsuarioControllerOpenApi {

    @Operation(summary = "Lista os Usuários")
    List<UsuarioModel> listar();

    @Operation(summary = "Busca um usuário por ID", responses = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado"
                    , content = @Content(schema = @Schema(ref = "Problema")))
    })
    UsuarioModel buscar(@Parameter(description = "ID de uma usuário", example = "1", required = true)
                        Long cidadeId);

    @Operation(summary = "Atualiza um usuário por ID", responses = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado"
                    , content = @Content(schema = @Schema(ref = "Problema")))
    })
    UsuarioModel atualizar(@Parameter(description = "ID de um usuário", example = "1", required = true)
                           Long cidadeId, @RequestBody(description = "Representação de um usuário com dados atualizados", required = true) UsuarioInput usuarioInput);

    @Operation(summary = "Cadastra um usuário", description = "Cadastro de um usuário")
    UsuarioModel adicionar(@RequestBody(description = "Representação de um novo usuário", required = true) UsuarioInput usuarioInput);

    @Operation(summary = "Excluir um usuário por ID", responses = {
            @ApiResponse(responseCode = "204", description = "Usuário excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado"
                    , content = @Content(schema = @Schema(ref = "Problema")))
    })
    ResponseEntity<Void> deletar(@Parameter(description = "ID de um usuário", example = "1", required = true)
                                 Long usuarioId);
}
