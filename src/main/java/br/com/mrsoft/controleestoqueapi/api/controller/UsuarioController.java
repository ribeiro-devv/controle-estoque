package br.com.mrsoft.controleestoqueapi.api.controller;

import br.com.mrsoft.controleestoqueapi.api.assembler.UsuarioModelAssembler;
import br.com.mrsoft.controleestoqueapi.api.model.UsuarioModel;
import br.com.mrsoft.controleestoqueapi.api.model.input.UsuarioInput;
import br.com.mrsoft.controleestoqueapi.api.openapi.controller.UsuarioControllerOpenApi;
import br.com.mrsoft.controleestoqueapi.domain.model.Usuario;
import br.com.mrsoft.controleestoqueapi.domain.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController implements UsuarioControllerOpenApi {

    private final UsuarioService usuarioService;

    private final UsuarioModelAssembler usuarioAssembler;

    @GetMapping("/{usuarioId}")
    public UsuarioModel buscar(@PathVariable Long usuarioId) {
        Usuario usuario = usuarioService.buscarOuFalhar(usuarioId);
        return usuarioAssembler.toModel(usuario);
    }

    @GetMapping
    public List<UsuarioModel> listar() {
        return usuarioAssembler.toCollectionModel(usuarioService.listar());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UsuarioModel adicionar(@Valid @RequestBody UsuarioInput usuarioInput) {

        Usuario novoUsuario = usuarioAssembler.toEntity(usuarioInput);
        Usuario usuarioCadastrado = usuarioService.adicionar(novoUsuario);

        return usuarioAssembler.toModel(usuarioCadastrado);
    }

    @PutMapping("/{usuarioId}")
    public UsuarioModel atualizar(@PathVariable Long usuarioId, @Valid @RequestBody UsuarioInput usuarioInput) {

        Usuario usuario = usuarioAssembler.toEntity(usuarioInput);
        Usuario usuarioAtualizado = usuarioService.atualizar(usuario, usuarioId);
        return usuarioAssembler.toModel(usuarioAtualizado);
    }

    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<Void> deletar(@PathVariable Long usuarioId) {
        usuarioService.deletar(usuarioId);
        return ResponseEntity.noContent().build();
    }
}
