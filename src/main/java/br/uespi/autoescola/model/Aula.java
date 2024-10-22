package br.uespi.autoescola.model;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;
    private LocalTime hora;
    private String local;

    @ManyToMany
    @JoinTable(
        name = "Aluno_Aula",
        joinColumns = @JoinColumn(name = "fk_Aula_ID"),
        inverseJoinColumns = @JoinColumn(name = "fk_Aluno_ID")
    )
    private Set<Aluno> alunos = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "Instrutor_Aula",
        joinColumns = @JoinColumn(name = "fk_Aula_ID"),
        inverseJoinColumns = @JoinColumn(name = "fk_Instrutor_ID")
    )
    private Set<Instrutor> instrutores = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Set<Instrutor> getInstrutores() {
        return instrutores;
    }

    public void setInstrutores(Set<Instrutor> instrutores) {
        this.instrutores = instrutores;
    }
}
