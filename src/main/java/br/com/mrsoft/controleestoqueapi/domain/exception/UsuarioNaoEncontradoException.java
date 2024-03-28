package br.com.mrsoft.controleestoqueapi.domain.exception;

import java.io.Serial;

public class UsuarioNaoEncontradoException extends EntidadeNaoEncontradaException{

    @Serial
    private static final long serialVersionUID = 1L;

    public UsuarioNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
    public UsuarioNaoEncontradoException(Long usuarioId) {
        this(String.format(MensagensException.MSG_USUARIO_NAO_ENCONTRADA, usuarioId));
    }
}
