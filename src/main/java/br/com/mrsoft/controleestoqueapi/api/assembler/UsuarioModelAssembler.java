package br.com.mrsoft.controleestoqueapi.api.assembler;

import br.com.mrsoft.controleestoqueapi.api.model.UsuarioModel;
import br.com.mrsoft.controleestoqueapi.api.model.input.UsuarioInput;
import br.com.mrsoft.controleestoqueapi.domain.model.Usuario;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class UsuarioModelAssembler {

    private final ModelMapper modelMapper;

    public UsuarioModel toModel(Usuario usuario){
        return modelMapper.map(usuario, UsuarioModel.class);
    }

    public List<UsuarioModel> toCollectionModel(List<Usuario> usuario){
        return usuario.stream()
                .map(this::toModel)
                .toList();
    }

    public Usuario toEntity(UsuarioInput usuarioInput){
        return modelMapper.map(usuarioInput, Usuario.class);
    }
}
