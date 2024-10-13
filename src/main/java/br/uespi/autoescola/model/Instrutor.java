package br.uespi.autoescola.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Instrutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String telefone;
    private String cpf;
    private String nome;
    private Date dataDeNascimento;

    @ManyToMany
    @JoinTable(
        name = "Instrutor_Aula",
        joinColumns = @JoinColumn(name = "fk_Instrutor_ID"),
        inverseJoinColumns = @JoinColumn(name = "fk_Aula_ID")
    )
    private Set<Aula> aula;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Set<Aula> getAula() {
        return aula;
    }

    public void setAula(Set<Aula> aula) {
        this.aula = aula;
    }
}
