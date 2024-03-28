package br.com.mrsoft.controleestoqueapi.domain.service.impl;

import br.com.mrsoft.controleestoqueapi.domain.exception.EntidadeNaoEncontradaException;
import br.com.mrsoft.controleestoqueapi.domain.exception.NegocioException;
import br.com.mrsoft.controleestoqueapi.domain.exception.UsuarioNaoEncontradoException;
import br.com.mrsoft.controleestoqueapi.domain.model.Usuario;
import br.com.mrsoft.controleestoqueapi.domain.repository.UsuarioRepository;
import br.com.mrsoft.controleestoqueapi.domain.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

//    private PasswordEncoder passwordEncoder;

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Transactional
    @Override
    public Usuario adicionar(Usuario usuario) {

//        if (usuario.isNovo()) {
//            usuario.setMatricula(passwordEncoder.encode(usuario.getMatricula()));
//        }

        boolean cpfJaCadastrado = usuarioRepository.findByCpf(usuario.getCpf())
                .filter(c -> !c.equals(usuario))
                .isPresent();

        if (cpfJaCadastrado) {
            throw new NegocioException("Já existe um usuário cadastrado com esse cpf");
        }

        preencherDadosAtualizacaoCriacao(null, null, usuario);
        return usuarioRepository.save(usuario);
    }

    @Transactional
    @Override
    public Usuario atualizar(Usuario usuario, Long usuarioId) {
        Usuario usuarioSalvo = buscarOuFalhar(usuarioId);

        if (usuarioSalvo == null) {
            throw new UsuarioNaoEncontradoException(usuarioId);
        }

        usuario.setId(usuarioId);
        preencherDadosAtualizacaoCriacao(usuarioSalvo, usuarioId, usuario);

        Usuario usuarioSalvar = usuarioRepository.save(usuario);
        usuarioRepository.flush();

        return usuarioSalvar;
    }

    @Override
    public Usuario buscarOuFalhar(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Usuário não encontrado"));
    }

    @Transactional
    @Override
    public void deletar(Long usuarioId) {
        Usuario usuarioSalvo = buscarOuFalhar(usuarioId);

        if (usuarioSalvo == null) {
            throw new UsuarioNaoEncontradoException(usuarioId);
        }
        usuarioRepository.deleteById(usuarioId);
        usuarioRepository.flush();

    }

    @Override
    public void preencherDadosAtualizacaoCriacao(Usuario usuarioSalvo, Long id, Usuario usuario) {

        if (id != null) {
            usuario.setAudAlteradoPor(usuarioSalvo.getMatricula());
            usuario.setAudDataHoraAlteracao(OffsetDateTime.now());
            usuario.setVersao(usuarioSalvo.getVersao() != null ? usuarioSalvo.getVersao() + 1 : 1);
            usuario.setAudCriadoPor(usuarioSalvo.getAudCriadoPor());
            usuario.setAudDataHoraCriacao(usuarioSalvo.getAudDataHoraCriacao());
        } else {
            usuario.setAudAlteradoPor(null);
            usuario.setAudCriadoPor(usuario.getMatricula());
            usuario.setAudDataHoraAlteracao(null);
            usuario.setAudDataHoraCriacao(OffsetDateTime.now());
            usuario.setVersao(1);
        }
    }

//    @Transactional
//    public void alterarSenha(Long usuarioId, String senhaAtual, String novaSenha) {
//        Usuario usuario = buscarOuFalhar(usuarioId);
//
//        if (!passwordEncoder.matches(senhaAtual, usuario.getSenha())) {
//            throw new NegocioException("Senha atual informada não coincide com a senha do usuário.");
//        }
//
//        usuario.setSenha(passwordEncoder.encode(novaSenha));
//    }

}
