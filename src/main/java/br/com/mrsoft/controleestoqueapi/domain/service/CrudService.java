package br.com.mrsoft.controleestoqueapi.domain.service;

import java.util.List;

public interface CrudService<T> {

    List<T> listar();

    T adicionar(T objeto);

    void deletar(Long id);

    T atualizar(T objeto, Long id);

    void preencherDadosAtualizacaoCriacao(T objetoOriginal, Long idObjetoOriginal, T novoObjeto);

    T buscarOuFalhar(Long id);

}
