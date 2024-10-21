package br.uespi.autoescola.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.time.LocalTime;

@Entity
public class Prova {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoProva;

    private LocalTime hora;
    private LocalDate data;
    private String tipoProva;

    @ManyToMany
    @JoinTable(
        name = "Aluno_Prova",
        joinColumns = @JoinColumn(name = "fk_Aluno_ID"),
        inverseJoinColumns = @JoinColumn(name = "fk_Prova_ID")
    )
    private Set<Aluno> aluno;

    public Long getCodigoProva() {
        return codigoProva;
    }

    public void setCodigoProva(Long codigoProva) {
        this.codigoProva = codigoProva;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTipoProva() {
        return tipoProva;
    }

    public void setTipoProva(String tipoProva) {
        this.tipoProva = tipoProva;
    }

    public Set<Aluno> getAluno() {
        return aluno;
    }

    public void setAluno(Set<Aluno> aluno) {
        this.aluno = aluno;
    }
}
