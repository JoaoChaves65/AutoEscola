package br.uespi.autoescola.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataDeNascimento;
    private String telefone;

    @ManyToMany
    @JoinTable(
        name = "Aluno_Aula",
        joinColumns = @JoinColumn(name = "fk_Aluno_ID"),
        inverseJoinColumns = @JoinColumn(name = "fk_Aula_ID")
    )
    private Set<Aula> aulas = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "Aluno_Turma",
        joinColumns = @JoinColumn(name = "fk_Aluno_ID"),
        inverseJoinColumns = @JoinColumn(name = "fk_Turma_ID")
    )
    private Set<Turma> turmas = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "Aluno_Prova",
        joinColumns = @JoinColumn(name = "fk_Aluno_ID"),
        inverseJoinColumns = @JoinColumn(name = "fk_Prova_ID")
    )
    private Set<Prova> provas = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Set<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(Set<Aula> aulas) {
        this.aulas = aulas;
    }

    public Set<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(Set<Turma> turmas) {
        this.turmas = turmas;
    }

    public Set<Prova> getProvas() {
        return provas;
    }

    public void setProvas(Set<Prova> provas) {
        this.provas = provas;
    }
}
