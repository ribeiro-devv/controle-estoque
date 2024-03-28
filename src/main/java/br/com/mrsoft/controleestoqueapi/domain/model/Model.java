package br.com.mrsoft.controleestoqueapi.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Getter
@Setter
@MappedSuperclass
public class Model implements Serializable {

    @Column(name = "aud_criado_por")
    private String audCriadoPor;

    @Column(name = "aud_alterado_por")
    private String audAlteradoPor;

    @Column(name = "aud_data_hora_criacao")
    private OffsetDateTime audDataHoraCriacao;

    @Column(name = "aud_data_hora_alteracao")
    private OffsetDateTime audDataHoraAlteracao;

    private Integer versao;
}
