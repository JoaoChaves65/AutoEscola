package br.uespi.autoescola.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoTurma;
    private int quantidadeAlunos;
    private LocalDate prazoExpiracao;

    @ManyToMany
    @JoinTable(
        name = "Aluno_Turma",
        joinColumns = @JoinColumn(name = "fk_Turma_ID"),
        inverseJoinColumns = @JoinColumn(name = "fk_Aluno_ID")
    )
    private Set<Aluno> alunos = new HashSet<>();

    public Long getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(Long codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public int getQuantidadeAlunos() {
        return quantidadeAlunos;
    }

    public void setQuantidadeAlunos(int quantidadeAlunos) {
        this.quantidadeAlunos = quantidadeAlunos;
    }

    public LocalDate getPrazoExpiracao() {
        return prazoExpiracao;
    }

    public void setPrazoExpiracao(LocalDate prazoExpiracao) {
        this.prazoExpiracao = prazoExpiracao;
    }

    public Set<Aluno> getAluno() {
        return alunos;
    }

    public void setAluno(Set<Aluno> alunos) {
        this.alunos = alunos;
    }
}
