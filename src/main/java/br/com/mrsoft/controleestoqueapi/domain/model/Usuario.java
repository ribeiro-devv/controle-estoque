package br.com.mrsoft.controleestoqueapi.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Getter
@Setter
public class Usuario extends Model implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "usuario_id_seq", allocationSize = 1)
    private Long id;

    @Size(min = 5,max = 60)
    private String nome;

    @NotBlank
    @Size(max = 11)
    @CPF
    private String cpf;

    @NotBlank
    @Size(min = 5, max = 255)
    private String matricula;

    @NotNull
    @PastOrPresent
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @NotBlank
    @Size(max = 80)
    @Email
    private String email;

    @Size(max = 20)
    private String telefone;

    @NotBlank
    private String senha;

//    @ManyToMany
//    @JoinTable(name = "usuario_grupo", joinColumns = @JoinColumn(name = "usuario_id"),
//            inverseJoinColumns = @JoinColumn(name = "grupo_id"))
//    private Set<Grupo> grupos = new HashSet<>();
//
//    public boolean senhaCoincideCom(String senha) {
//        return getSenha().equals(senha);
//    }
//
//    public boolean senhaNaoCoincideCom(String senha) {
//        return !senhaCoincideCom(senha);
//    }
//
//    public boolean removerGrupo(Grupo grupo) {
//        return getGrupos().remove(grupo);
//    }
//
//    public boolean adicionarGrupo(Grupo grupo) {
//        return getGrupos().add(grupo);
//    }
//
//    public boolean isNovo() {
//        return getId() == null;
//    }
}
