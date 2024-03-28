package br.com.mrsoft.controleestoqueapi.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    CREDENCIAIS_INVALIDAS("/credenciais-invalidas", "Credenciais inválidas"),
    ACESSO_NEGADO("/acesso-negado", "Acesso negado"),
    DADOS_INVALIDOS("/dados-invalidos", "Dados inválidos"),
    ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de sistema"),
    PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro inválido"),
    RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
    ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
    ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio"),
    MENSAGEM_INCOMPREENSIVEL("/mensagem-incomoreensivel" , "Mensagem Imcompreensível" );

    private final String title;
    private final String uri;

    ProblemType(String path, String title){
        this.uri = "https://mrsoft.com.br" + path;
        this.title = title;
    }
}
